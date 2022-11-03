package com.roshan.leetcode;

public class P13RomanToInt {

    public int romanToInt(String s) {
        int total = 0;
        int len = s.length();
        for(int i = 0 ; i < len ; i++){
            int s1 = value(s.charAt(i));
            if(i+1 < len){
                int s2 = value(s.charAt(i+1));
                total = (s1 >=s2) ? total+s1:total-s1;
            }else{
                total = total+s1;
            }
        }
        return total;
    }

    private int value(char r){

        if(r == 'I') return 1;
        if(r == 'V') return 5;
        if(r == 'X') return 10;
        if(r == 'L') return 50;
        if(r == 'C') return 100;
        if(r == 'D') return 500;
        if(r == 'M') return 10000;
        return -1;
    }

    public static void main(String[] args) {
        P13RomanToInt p = new P13RomanToInt();
        System.out.println(p.romanToInt("MCMXCIV"));
    }
}
