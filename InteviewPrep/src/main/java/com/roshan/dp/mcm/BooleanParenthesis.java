//package com.roshan.dp.mcm;
//
//public class BooleanParenthesis {
//
//
//
//
//    public static int getNumOfWays(boolean[] arr , String[] ops , int i , int j , boolean toFind){
//
//
//        if(i == j && arr[i] == toFind){
//            return 1;
//        }
//
//        if(toFind && isTrue(arr[i] , arr[j] , ops[i])){
//            return 1;
//        }
//
//        if(!toFind && !isTrue(arr[i] , arr[j] , ops[i])){
//            return 1;
//        }
//
//
//        int min = Integer.MAX_VALUE;
//
//        for(int k=i ; k < j;k++){
//            int count = getNumOfWays(arr, ops, i, k) +
//                    getNumOfWays(arr, ops, k+1, j);
//
//            min = Math.min(min,count);
//        }
//
//        return min;
//    }
//
//
//
//
//
//
//    private static boolean isTrue(boolean a , boolean b , String ops){
//
//        if(ops == "^"){
//            return a ^ b;
//        }
//
//        if(ops == "&"){
//            return a & b;
//        }
//
//        if(ops == "|"){
//            return a | b;
//        }
//        return false;
//    }
//
//
//
//    public static void main(String[] args) {
//        boolean arr[] = {true,false,true};
//        String ops[] = {"^","&"};
//        System.out.println(getNumOfWays(arr,ops,0,arr.length-1));
//
////        arr = new boolean[]{true, true, false, true};
////        ops = new String[]{"|" , "&", "&"};
////        System.out.println(getNumOfWays(arr,ops,0,arr.length-1));
//
//    }
//}
