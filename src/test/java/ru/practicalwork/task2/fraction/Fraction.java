package ru.practicalwork.task2.fraction;

import ru.practicalwork.task2.Cache;
import ru.practicalwork.task2.Mutator;

public class Fraction implements Fractionable{
    private int num;
    private int denum;
    public int count = 0;

    public Fraction(int num, int denum) {
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
        count++;
        System.out.println("invoke double value");
        return (double) num/denum;
    }

    @Override
    public int doubleValue(int x) {
        return 0;
    }

    @Override
    public int doubleValue(int x, int y) {
        return 0;
    }
}
