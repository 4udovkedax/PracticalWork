package ru.practicalwork.task3;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class CacheValues <T>{
    private ConcurrentHashMap<T, CacheValue> arrayValues = new ConcurrentHashMap<>();
    //ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
    private AtomicInteger scheduleOn = new AtomicInteger();
    private AtomicLong deadline = new AtomicLong();

    public Object getRetValue(T key, long timeLife) {
        CacheValue value = arrayValues.get(key);
        if (value != null) {
            deadline.set(timeLife);
            value.setTimeLife(timeLife);
            return value.getRetValue();
        }
        return null;
    }

    public void setRetValue(T key, Object value, long timeLife) {
        deadline.set(timeLife);
        arrayValues.put(key, new CacheValue(value, timeLife));
        startScheduleService(timeLife - System.currentTimeMillis() + 100);
    }

    public void  clearCache() {
        arrayValues.clear();
    }

    private void startScheduleService(long offsetTime) {
        if (scheduleOn.get() == 0) {
            ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
            scheduleOn.set(1);

            //ScheduledFuture<?> sched = service.schedule(() -> {
            ScheduledFuture<?> sched = service.scheduleWithFixedDelay(() -> {
                if (removeCacheValues()) {
                    service.shutdown();
                    scheduleOn.set(0);
                }
                //добавить запуск интевалов по времени
            }, 1000, 1000, TimeUnit.MILLISECONDS);
        }
    }

    private boolean removeCacheValues() {
        if (deadline.get() < System.currentTimeMillis() || arrayValues.isEmpty()) {
            clearCache();
            return true;
        }

        for (T key : arrayValues.keySet()) {
            CacheValue value = arrayValues.get(key);
            if (value.timeLife < System.currentTimeMillis()) {
                arrayValues.remove(key);
            }
        }
        return false;
    }


    private static class CacheValue{
        private Object retValue;
        private long timeLife;

        public CacheValue(Object retValue, long timeLife) {
            this.retValue = retValue;
            this.timeLife = timeLife;
        }

        public Object getRetValue() {
            return this.retValue;
        }

        public long getTimeLife() {
            return timeLife;
        }

        public void setTimeLife(long timeLife) {
            this.timeLife = timeLife;
        }
    }
}
