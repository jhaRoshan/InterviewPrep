package com.roshan.backtracking;


import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://leetcode.com/problems/letter-combinations-of-a-phone-number/
public class PhoneLetterCombination {

    static Map<Integer , String > map = new HashMap<>();

    public static void getAllString(List<Integer> numbers){
        setMap();
        getAllString( "" ,numbers,0);
    }

    public static void getAllString(String ans , List<Integer> numbers , int index){

        if(ans.length() == numbers.size()){
            System.out.println(ans);
            return;
        }

        String s = map.get(numbers.get(index));
        for(int i = 0;i< s.length();i++){
            getAllString(ans+s.charAt(i), numbers, index+1);
        }

    }

    private static void setMap(){
        map.put(2,"abc");
        map.put(3,"def");
        map.put(4,"ghi");
        map.put(5,"jkl");
        map.put(6,"mno");
        map.put(7,"pqrs");
        map.put(8,"tuv");
        map.put(9,"wxyz");

        String digit = "";
    }


    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(2,3);
        getAllString(list);
    }

}
