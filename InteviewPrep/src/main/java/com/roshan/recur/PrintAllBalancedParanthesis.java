package com.roshan.recur;// Java program to print all
// combinations of balanced parentheses

import java.io.*;
import java.util.Arrays;

class PrintAllBalancedParanthesis {
    static void printParenthesis(char str[], int pos,
                                 int n, int open,
                                 int close) {


    	if(close == n){
			System.out.println(Arrays.toString(str));
		}else{
			if(close < open){
				str[pos] = '}';
				printParenthesis(str, pos+1, n, open, close+1);
			}

			if(open < n){
				str[pos] = '{';
				printParenthesis(str, pos+1, n, open+1, close);
			}
		}


    }

    static void printParenthesis(char str[], int n) {
        if (n > 0)
            printParenthesis(str, 0, n, 0, 0);
        return;
    }

    // driver program
    public static void main(String[] args) {
        int n = 3;
        char[] str = new char[2 * n];
        printParenthesis(str, n);
    }
}

