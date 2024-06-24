package ru.practicalwork.task3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.practicalwork.task3.fraction.Fraction;
import ru.practicalwork.task3.fraction.FractionCopy;
import ru.practicalwork.task3.fraction.Fractionable;

import java.util.Set;

public class CacheTest {
    @Test
    @DisplayName("Проверка вызова очистки кэша")
    public void testCashe() throws InterruptedException {
        Fraction fr = new Fraction(10,2);
        FractionCopy frCopy = new FractionCopy(10,2);
        Fractionable num = Utils.cache(fr);
        Fractionable num2 = Utils.cache(frCopy);

        num.doubleValue();
        num.doubleValue();
        num.doubleValue();
        Assertions.assertEquals(fr.count, 1);

        num.setNum(5);
        num.doubleValue();
        num.doubleValue();
        Assertions.assertEquals(fr.count, 2);

        num2.doubleValue();
        num2.setNum(2);
        num2.doubleValue();
        num2.setNum(3);
        num2.doubleValue();
        num2.setNum(2);
        num2.doubleValue();
        Assertions.assertEquals(frCopy.count1, 3);

        Thread.sleep(3000);
        num2.setNum(5);
        num.doubleValue();
        Assertions.assertEquals(fr.count, 3);
        num2.doubleValue();
        Assertions.assertEquals(frCopy.count1, 4);

        Thread.sleep(500);
        num.doubleValue();
        Assertions.assertEquals(fr.count, 3);
        num2.doubleValue();
        Assertions.assertEquals(frCopy.count1, 4);
    }

    @Test
    @DisplayName("Проверка полученных значений")
    public void testCacheValues() {
        FractionCopy frCopy = new FractionCopy(10,2);
        Fractionable num = Utils.cache(frCopy);

        Assertions.assertEquals(num.doubleValue(), 5);
        num.setNum(20);
        Assertions.assertEquals(num.doubleValue(), 10);
        Assertions.assertEquals(num.doubleValue(), 10);
        num.doubleValue(30, 2);
        Assertions.assertEquals(num.doubleValue(), 15);

        num.setNum(10);
        num.setDenum(5);
        Assertions.assertEquals(num.doubleValue(20), (10/5+20)*100);
        Assertions.assertEquals(num.doubleValue(10), (10/5+10)*100);
        num.setDenum(2);
        Assertions.assertEquals(num.doubleValue(10), (10/2+10)*100);

        Assertions.assertEquals(num.doubleValue(5, 5), 5*5);
        Assertions.assertEquals(num.doubleValue(), (double) 5/2);
    }

    @Test
    @DisplayName("Проверка выполнения по потокам")
    public  void testCacheThread() throws InterruptedException {
        Fraction fr = new Fraction(10,2);
        FractionCopy frCopy = new FractionCopy(10,2);
        Fractionable num = Utils.cache(fr);
        Fractionable num2 = Utils.cache(frCopy);

        Set<Thread> threads = Thread.getAllStackTraces().keySet();
        Assertions.assertEquals(threads.stream().filter(x->!x.isDaemon()).count(), 1);

        num.setNum(2);
        num2.setNum(3);
        Thread.sleep(500);

        num2.doubleValue();
        Thread.sleep(600);
        threads = Thread.getAllStackTraces().keySet();
        Assertions.assertEquals(threads.stream().filter(x->!x.isDaemon()).count(), 2);

        Thread.sleep(600);
        threads = Thread.getAllStackTraces().keySet();
        Assertions.assertEquals(threads.stream().filter(x->!x.isDaemon()).count(), 1);
    }
}
