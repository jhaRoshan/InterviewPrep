package com.roshan.leetcode;

import java.util.Stack;

public class P316RemoveDuplicate {

    public String removeDuplicateLetters(String s) {
        int[] count = new int[26];
        boolean[] visited = new boolean[26];
        char[] arr = s.toCharArray();
        Stack<Character> stack = new Stack<>();

        for(int i = 0 ; i < arr.length ; i++){
            count[arr[i]-'a']++;
        }

        for(int i = 0 ; i < arr.length ; i++){
            int v = arr[i]-'a';
            count[v]--;
            if(visited[v]) continue;

            while(!stack.isEmpty() && arr[i] < stack.peek() && count[stack.peek()-'a'] !=0){
                char p = stack.pop();
                visited[p-'a'] = false;
            }

            stack.push(arr[i]);
            visited[v]=true;
        }
        System.out.println(stack);
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.insert(0 , stack.pop());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        P316RemoveDuplicate p = new P316RemoveDuplicate();
        System.out.println(p.removeDuplicateLetters("bcabc"));
    }
}
