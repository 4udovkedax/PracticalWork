package ru.practicalwork;

import ru.practicalwork.task1.*;
import ru.practicalwork.task2.Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args){
        List<Integer> list= new ArrayList<>();
        list = Utils.cache(list);
        list.add(21);
        list.add(2);
        list.add(3);
        System.out.println(list);
    }
}
