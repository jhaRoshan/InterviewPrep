package com.roshan.segmenttree;

import java.util.Arrays;

public class SumSegmentTree {


    private int[] segmentTree;
    private int[] nums;


    public SumSegmentTree(int[] nums) {
        this.nums = nums;
        int height = (int) (Math.ceil((Math.log(nums.length) / Math.log(2))));
        int segmentTreeSize = (int) (2 * Math.pow(2, height)) - 1;
        segmentTree = new int[segmentTreeSize];
        constructSegmentTree(0, nums.length - 1, 0);
        System.out.println(Arrays.toString(segmentTree));
    }

    private int constructSegmentTree(int left, int right, int segIndex) {
        if (left == right) {
            segmentTree[segIndex] = nums[left];
            return nums[left];
        }

        int mid = left + (right - left) / 2;
        segmentTree[segIndex] = constructSegmentTree(left, mid, 2 * segIndex + 1) +
                constructSegmentTree(mid + 1, right, 2 * segIndex + 2);

        return segmentTree[segIndex];
    }

    public void update(int index, int val) {
        int diff = val - nums[index];
        nums[index] = val;
        updateUtil(0, nums.length - 1, 0, index, diff);
        System.out.println(Arrays.toString(segmentTree));
    }

    private void updateUtil(int left, int right, int segIndex, int updatedIndex, int diff) {

        if (updatedIndex < left || updatedIndex > right) {
            return;
        }
        segmentTree[segIndex] += diff;

        if (left == right) return;

        int mid = left + (right - left) / 2;
        updateUtil(left, mid, 2 * segIndex + 1, updatedIndex, diff);
        updateUtil(mid + 1, right, 2 * segIndex + 2, updatedIndex, diff);

    }

    public int sumRange(int left, int right) {
       return sumRangeUtil(0 , nums.length-1 , left , right , 0);
    }

    private int sumRangeUtil(int start, int end, int left, int right, int segInd) {

        if(start >= left && end <= right ) return segmentTree[segInd];

        if( start > right || left > end) return 0;

        int mid = start + (end-start)/2;

        return sumRangeUtil(start , mid , left ,right , 2*segInd+1) +
                sumRangeUtil(mid+1 , end , left,right , 2*segInd+2);

    }


    public static void main(String[] args) {
        int arr[] = {7,2,7,2,0};
        SumSegmentTree s = new SumSegmentTree(arr);
        s.update(4,6);
        s.update(0,2);
        s.update(0,9);
    }
}
