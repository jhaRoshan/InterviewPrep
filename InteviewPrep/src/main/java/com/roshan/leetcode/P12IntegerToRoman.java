package com.roshan.leetcode;

public class P12IntegerToRoman {

    private int[] value =    {1000 , 900 , 500 , 400 , 100 , 90 , 50 , 40 , 10 , 9 , 5 , 4 , 1};
    private String[] roman = {"M" , "CM" , "D" , "CD" , "C" ,"XC" ,"L" ,"XL" ,"X" , "IX" , "V" , "IV" , "I"};

    public String intToRoman(int num) {

        StringBuilder sb = new StringBuilder("");
        for(int i = 0 ; i < value.length ; i++ ){
            while(num >= value[i]){
                sb.append(roman[i]);
                num = num-value[i];
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        P12IntegerToRoman p = new P12IntegerToRoman();
        System.out.println(p.intToRoman(1994));
    }
}
