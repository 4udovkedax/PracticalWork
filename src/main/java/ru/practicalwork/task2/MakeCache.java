package ru.practicalwork.task2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MakeCache implements InvocationHandler {
    private Object obj;
    private Map<String, Object> ret = new HashMap<>();

    public MakeCache(Object obj) {
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Class classObj = obj.getClass();
        String key = method.getName() + method.getGenericReturnType() + Arrays.toString(method.getGenericParameterTypes());

        if (ret.containsKey(key))
            return ret.get(key);

        for (Method met : classObj.getDeclaredMethods()) {
            if ((met.getName() + met.getGenericReturnType() + Arrays.toString(met.getGenericParameterTypes())).equals(key)) {
                if (met.isAnnotationPresent(Cache.class)) {
                    ret.put(key, met.invoke(obj, args));
                    return ret.get(key);
                } else if (met.isAnnotationPresent(Mutator.class))
                    ret.clear();
            }
        }

        return method.invoke(obj, args);
    }
}
