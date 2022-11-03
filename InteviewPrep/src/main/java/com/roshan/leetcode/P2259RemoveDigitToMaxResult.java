package com.roshan.leetcode;

public class P2259RemoveDigitToMaxResult {


    public String removeDigit(String number, char digit) {

        int index = -1;

        for(int i = 0 ; i< number.length() ; i++){

            if(number.charAt(i) == digit){
                index = i;
                if(i+1 < number.length() && number.charAt(i) < number.charAt(i+1)) break;
            }
        }
        if(index == -1) return number;
        return number.substring(0, index) + number.substring(index+1);
    }

    public static void main(String[] args) {
        P2259RemoveDigitToMaxResult p = new P2259RemoveDigitToMaxResult();
        System.out.println(p.removeDigit("123" , '3'));
    }
}
