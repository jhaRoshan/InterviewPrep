package com.roshan.test;

public class DecimlToBse62 {

    public static void main(String[] args){

        long s = 3500110902376L;
        System.out.println(genarateBase62(s));
    }

    public static String genarateBase62(long num){
        String s = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        char[] cArr = s.toCharArray();
        String result = "";

        while(num >0){
            result = cArr[(int) (num%62)]+result;
            num/=62;
        }
        return result;
    }
}
