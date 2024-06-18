package ru.practicalwork.task3;

import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;

public class CacheValues <T> extends Thread{
    private ConcurrentHashMap<T, CacheValue> arrayValues = new ConcurrentHashMap<>();

    public Object getRetValue(T key) {
        CacheValue value = arrayValues.get(key);
        if (value != null) {
            return value.getRetValue();
        }
        return null;
    }

    public void setRetValue(T key, Object value) {
        arrayValues.put(key, new CacheValue(value));
    }

    public void  clearCache() {
        arrayValues.clear();
    }

    @Override
    public void run() {
        while (this.isAlive()) {
            System.out.println("run");
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private static class CacheValue{
        private Object retValue;
        private Date date;

        public CacheValue(Object retValue) {
            this.retValue = retValue;
        }

        public Object getRetValue() {
            return this.retValue;
        }

        public void setDate(Date dDate) {
            this.date = dDate;
        }
    }
}
