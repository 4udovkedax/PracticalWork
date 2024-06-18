package ru.practicalwork.task3;

import java.lang.reflect.Proxy;

public class Utils {
    public static <T> T cache(T obj) {
        return (T) Proxy.newProxyInstance(
                obj.getClass().getClassLoader(),
                obj.getClass().getInterfaces(),
                new MakeCache<>(obj)
        );
    }

}
