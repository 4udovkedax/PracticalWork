package ru.practicalwork.task2.fraction;

import ru.practicalwork.task2.Cache;
import ru.practicalwork.task2.Mutator;

public class FractionCopy implements Fractionable{
    private int num;
    private int denum;
    public int count1 = 0;
    public int count2 = 0;
    public int count3 = 0;

    public FractionCopy(int num, int denum) {
        this.num = num;
        this.denum = denum;
    }

    @Mutator
    public void setNum(int num) {
        this.num = num;
    }

    @Mutator
    public void setDenum(int denum) {
        this.denum = denum;
    }

    @Override
    @Cache
    public double doubleValue() {
        count1++;
        return (double) num/denum;
    }

    @Override
    @Cache
    public int doubleValue(int x) {
        count2++;
        return (num/denum + x) * 100 ;
    }

    @Override
    @Cache
    @Mutator
    public int doubleValue(int x, int y) {
        count3++;
        this.num = x;
        return x * y;
    }
}
