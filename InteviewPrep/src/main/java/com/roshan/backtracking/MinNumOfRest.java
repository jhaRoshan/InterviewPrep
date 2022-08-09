package com.roshan.backtracking;

import java.util.*;

public class MinNumOfRest {

   private static Map<Integer , List<String>> map = new HashMap<>();


    public static void getAllPossibility(List<Integer> numbers){
        setMap();
        getAllString( "" ,numbers,0);
    }

    private static void getAllString(String ans, List<Integer> numbers, int index ) {

        if(ans.length() == numbers.size()){
            System.out.println(ans);
            return;
        }


        List<String> s = map.get(numbers.get(index));
        for(int i = 0;i< s.size();i++){

            if(ans == null || ans.isEmpty()){
                getAllString(ans+s.get(i), numbers, index+1);
            }else{

                String lastChar = String.valueOf(ans.charAt(ans.length()-1));
                if(!lastChar.equals(s.get(i))){
                    getAllString(ans+s.get(i), numbers, index+1);
                }else{
                    getAllString(ans+"R", numbers, index+1);
                }
            }
        }

    }


    private static void setMap(){
        map.put(0,new ArrayList<>());
        map.put(1, List.of("M"));
        map.put(2,List.of("G"));
        map.put(3,List.of("M","G"));
   }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(3,3,1);
        getAllPossibility(list);
    }




}


