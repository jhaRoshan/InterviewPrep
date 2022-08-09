package com.roshan.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {

    public static int getAllPossibleWay(String pattern) {
        return getAllPossibleWay(pattern , pattern.length()-1);
    }

    private static int getAllPossibleWay(String pattern, int i) {

        if (isValid(pattern)) {
            System.out.println(pattern);
            return 1;
        }

        if (i == 0) {
            return 0;
        }


        return getAllPossibleWay(pattern, i - 1) + getAllPossibleWay(pattern.substring(0, i) + pattern.substring(i + 1, pattern.length()), i - 1);

    }

    private static boolean isValid(String str) {
        int cnt = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(')
                cnt++;
            else if (str.charAt(i) == ')')
                cnt--;
            if (cnt < 0)
                return false;
        }
        return (cnt == 0);
    }

    public static void main(String[] args) {

        System.out.println(getAllPossibleWay("()())()"));
    }

}
