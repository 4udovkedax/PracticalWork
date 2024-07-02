package ru.practicalwork.task4.log;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

@Component
@Aspect
public class SaveLogTransformation {

    @Around("execution(public * *(..))")
    public Object aroundOperation(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Date date = new Date();
        String logText;
        Object obj = proceedingJoinPoint.proceed();
        Class cls = proceedingJoinPoint.getTarget().getClass();

        if (cls.isAnnotationPresent(LogTransformation.class)) {
            logText = date.toString() + " класс:" + cls.getName() + " входные параметры:" + proceedingJoinPoint.getArgs() + " результат: " + obj.toString();
            logTransformation("E:\\java\\PracticalWork\\tasks\\src\\main\\resources\\task4\\log_operations.log", logText);
        }
        return obj;
    }

    public void logTransformation(String nameFile, String text) {
        File file = new File(nameFile);
        try {
            FileWriter writer = new FileWriter(file, true);
            BufferedWriter bufferWriter = new BufferedWriter(writer);
            bufferWriter.write(text);
            bufferWriter.newLine();
            bufferWriter.close();
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
