package com.roshan.leetcode;

import java.util.Map;
import java.util.TreeMap;

class P729MyCalendar1 {
    TreeMap<Integer,Integer> calendar = new TreeMap<>();
    public P729MyCalendar1() {
        calendar.put(Integer.MAX_VALUE, Integer.MAX_VALUE);
    }
    public boolean book(int start, int end) {
        Map.Entry<Integer,Integer> pair = calendar.higherEntry(start);
        boolean res = end <= pair.getValue();
        if (res) calendar.put(end, start);
        return res;
    }

    public static void main(String[] args) {
        P729MyCalendar1 c = new P729MyCalendar1();
        System.out.println(c.book(1,5));
        System.out.println(c.book(9,10));
        System.out.println(c.book(12,20));
    }
}