package com.roshan.other;

import java.util.Arrays;

/**
 * https://leetcode.com/explore/challenge/card/september-leetcoding-challenge-2021/637/week-2-september-8th-september-14th/3968/
 */
public class ShiftingLetter {


    public String shiftingLetters(String s, int[] shifts) {
        int previous = 0;
        for(int i=shifts.length-1; i>=0; i--){
            shifts[i] = (shifts[i] + previous) % 26;
            previous = shifts[i];
        }

        char[] chars = s.toCharArray();
        for(int i=0; i<chars.length; i++){
            chars[i] = (char)('a' + (((int)chars[i] + shifts[i]) % 'a') % 26);
        }
        return String.valueOf(chars);

    }



    public static void main(String[] args){
        ShiftingLetter sl = new ShiftingLetter();
        int[] i = {26,9,17};
        sl.shiftingLetters("ruu", i);
    }

}
