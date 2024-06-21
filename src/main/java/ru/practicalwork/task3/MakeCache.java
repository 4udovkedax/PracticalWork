package ru.practicalwork.task3;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MakeCache<T> implements InvocationHandler {
    private final T obj;
    private static final CacheValues<Object> cacheValues = new CacheValues<>();
    private String  currentState;
    private long offsetTime;

    public MakeCache(T obj) {
        this.obj = obj;
        this.currentState = getObjectState();
    }

    private String getObjectState() {
        List<Object> objectState = new ArrayList<>();

        for (Field f : this.obj.getClass().getDeclaredFields()) {
            try {
                f.setAccessible(true);
                objectState.add(f.get(this.obj));
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
        return objectState.toString();
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Class classObj = this.obj.getClass();
        Object ret;
        String key = this.currentState + classObj.getMethod(method.getName(), method.getParameterTypes()) + Arrays.toString(args);

        ret = cacheValues.getRetValue(key, System.currentTimeMillis() + this.offsetTime);
        if (ret != null) {
            return ret;
        }

        for (Method met : classObj.getDeclaredMethods()) {
            if ((this.currentState + met + Arrays.toString(args)).equals(key)) {
                if (met.isAnnotationPresent(Mutator.class)) {
                    this.currentState = method.getName() + Arrays.toString(args);
                    //this.currentState = getObjectState();
                    this.offsetTime = met.getAnnotation(Mutator.class).Value();
                }
                if (met.isAnnotationPresent(Cache.class)) {
                    ret = met.invoke(this.obj, args);
                    cacheValues.setRetValue(key, ret, System.currentTimeMillis() + this.offsetTime);
                    return ret;
                }
            }
        }

        return method.invoke(this.obj, args);
    }
}
