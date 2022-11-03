package com.roshan.leetcode;

import java.util.Stack;

public class P402RemoveKDigit {
    public String removeKdigits(String num, int k) {

        Stack<Character> stack = new Stack<>();
        stack.push(num.charAt(0));
        char[] arr = num.toCharArray();

        for(int i = 1 ; i< arr.length ; i++){

            while(!stack.isEmpty() && arr[i] < stack.peek() && k > 0){
                stack.pop();
                k--;
            }

            if(stack.isEmpty() && arr[i] == '0') continue;

            stack.push(arr[i]);
        }

        while(k > 0 && !stack.isEmpty()){
            stack.pop(); k--;
        }

        String result = "";

        while(!stack.isEmpty()){
            result=   stack.pop()+ result;
        }

        return result.length() == 0 ? "0":result;
    }

    public static void main(String[] args) {
        P402RemoveKDigit p = new P402RemoveKDigit();
        System.out.println(p.removeKdigits("1432219" , 3));
        System.out.println(p.removeKdigits("100001" , 3));
    }

}
