package ru.practicalwork.task3;

import ru.practicalwork.task2.Cache;
import ru.practicalwork.task2.Mutator;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

public class MakeCache<T> implements InvocationHandler {
    private final T obj;
    private static final CacheValues<Object> cacheValues = new CacheValues<>();
    private String currentState;

    public MakeCache(T obj) {
        this.obj = obj;
        //получим состояние объекта
        this.currentState = "0";

        if (!cacheValues.isAlive())
            cacheValues.start();
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Class classObj = obj.getClass();
        Object ret;
        String key = classObj.getMethod(method.getName(), method.getParameterTypes()) + Arrays.toString(args);

        ret = cacheValues.getRetValue(this.currentState + key);
        if (ret != null) {
            return ret;
        }

        for (Method met : classObj.getDeclaredMethods()) {
            if ((met + Arrays.toString(args)).equals(key)) {
                if (met.isAnnotationPresent(Mutator.class)) {
                    currentState = key;
                    //cacheValues.clearCache();
                }
                if (met.isAnnotationPresent(Cache.class)) {
                    ret = met.invoke(obj, args);
                    cacheValues.setRetValue(this.currentState + key, ret);
                    return ret;
                }
            }
        }

        return method.invoke(obj, args);
    }
}
