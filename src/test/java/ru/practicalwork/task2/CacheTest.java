package ru.practicalwork.task2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.practicalwork.task2.fraction.Fraction;
import ru.practicalwork.task2.fraction.Fractionable;

public class CacheTest {
    @Test
    @DisplayName("Проверка кэша")
    public void testCashe() {
        Fraction fr= new Fraction(2,3);
        Fractionable num =Utils.cache(fr);
        double ret;
        ret = num.doubleValue();// sout сработал
        System.out.println(ret);
        ret = num.doubleValue();// sout молчит
        System.out.println(ret);
        ret = num.doubleValue();// sout молчит
        System.out.println(ret);
        num.setNum(5);
        System.out.println(ret);
        ret = num.doubleValue();// sout сработал
        System.out.println(ret);
        ret = num.doubleValue();// sout молчит
        System.out.println(ret);

    }
}
