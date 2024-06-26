package ru.practicalwork.spring.solid;

import org.springframework.stereotype.Component;

import java.util.function.BinaryOperator;

@Component("-")
public class MinusOperation implements BinaryOperator<Integer> {
    @Override
    public Integer apply(Integer x, Integer y) {
        return x - y;
    }
}
