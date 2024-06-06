package ru.practicalwork.task2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.practicalwork.task2.fraction.Fraction;
import ru.practicalwork.task2.fraction.FractionCopy;
import ru.practicalwork.task2.fraction.Fractionable;

public class CacheTest {
    @Test
    @DisplayName("Проверка вызова кэша")
    public void testCashe() {
        Fraction fr = new Fraction(10,2);
        Fractionable num = Utils.cache(fr);
        num.doubleValue();// sout сработал
        num.doubleValue();// sout молчит
        num.doubleValue();// sout молчит
        Assertions.assertEquals(fr.count, 1);

        num.setNum(5);
        num.doubleValue();// sout сработал
        num.doubleValue();// sout молчит
        Assertions.assertEquals(fr.count, 2);

        FractionCopy frCopy = new FractionCopy(10,2);
        Fractionable num2 = Utils.cache(frCopy);
        num2.doubleValue();
        num2.setNum(2);
        num2.doubleValue();
        num2.setNum(3);
        num2.doubleValue();
        num2.setNum(4);
        num2.doubleValue();
        Assertions.assertEquals(frCopy.count1, 4);

    }
    @Test
    @DisplayName("Проверка кэша по методам с перегрузкой")
    public void testOverload() {
        FractionCopy frCopy = new FractionCopy(10,2);
        Fractionable num = Utils.cache(frCopy);
        Object ret;

        ret = num.doubleValue();
        ret = num.doubleValue();
        Assertions.assertEquals(frCopy.count1, 1);
        Assertions.assertEquals(ret.getClass(), Double.class);

        ret = num.doubleValue(1);
        ret = num.doubleValue(2);
        ret = num.doubleValue(1);
        ret = num.doubleValue(2);
        Assertions.assertEquals(frCopy.count2, 2);
        Assertions.assertEquals(ret.getClass(), Integer.class);

        ret = num.doubleValue(1, 3);
        ret = num.doubleValue(1, 3);
        Assertions.assertEquals(frCopy.count3, 1);
        Assertions.assertEquals(ret.getClass(), Integer.class);

        ret = num.doubleValue(3, 1);
        ret = num.doubleValue(3, 3);
        Assertions.assertEquals(frCopy.count3, 3);
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
    @DisplayName("Проверка метода с аннтотациями Cache и Mutator")
    public void testCacheMutator() {
        FractionCopy frCopy = new FractionCopy(10,2);
        Fractionable num = Utils.cache(frCopy);

        num.doubleValue();
        num.doubleValue();
        Assertions.assertEquals(frCopy.count1, 1);
        num.doubleValue(1, 2);
        num.doubleValue(1, 2);
        Assertions.assertEquals(frCopy.count3, 1);
        num.doubleValue();
        num.doubleValue();
        Assertions.assertEquals(frCopy.count1, 2);
        num.doubleValue(3, 2);
        num.doubleValue(4, 2);
        Assertions.assertEquals(frCopy.count3, 3);
        num.doubleValue();
        Assertions.assertEquals(frCopy.count1, 3);

    }
}
