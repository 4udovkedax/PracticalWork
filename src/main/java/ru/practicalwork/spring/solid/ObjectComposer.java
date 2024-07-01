package ru.practicalwork.spring.solid;

import org.springframework.stereotype.Component;

import java.io.File;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ObjectComposer {
    private Map<String, Object> objects = new HashMap<>();

    public ObjectComposer(String packageName) {
        try {
            String filePackageName = '/' + packageName.replace('.', '/');
            File f = new File("E:/java/PracticalWork/tasks/target/classes" + filePackageName);

            for (File file : f.listFiles()) {
                if (!file.getName().endsWith("class"))
                    continue;
                String clzName = file.getName().split("\\.")[0];
                Class clz = Class.forName(packageName + "." + clzName);
                if (!clz.isAnnotationPresent(Component.class))
                    continue;
                Component component = (Component) clz.getAnnotation(Component.class);
                if (!component.value().equals(""))
                    clzName = component.value();
                objects.put(clzName, clz.newInstance());
            }
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
    }

    public Object getObjectByName(String name) {
        return objects.get(name);
    }

    public <T> T getObjectByNameAndType(String name, Class<T> clz) {
        return (T) objects.get(name);
    }
}
