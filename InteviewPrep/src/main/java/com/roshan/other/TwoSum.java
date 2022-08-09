package com.roshan.other;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/two-sum/
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {

        int[] retval = new int[2];
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length;i++){
            int otherNum = target - nums[i];
            if(map.containsKey(otherNum)){
                retval[0] = map.get(otherNum);
                retval[1] = i;
            }else{
                map.put(nums[i] , i);

            }
        }
        return retval;
    }
}
