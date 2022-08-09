package com.roshan.segmenttree;


//return index of array where minimin element is present
public class MinSegTree {

    private int[] segmentTree;
    private int[] arr;
    private int inputSize;



    public void construct(int[] arr){
        inputSize = arr.length;
        int h = (int) Math.ceil(Math.log(inputSize)/Math.log(2));
        this.arr = arr;
        segmentTree = new int[2* (int)Math.pow(2, h)-1];
        constructUtil(arr,0 , inputSize-1 , 0);
    }

    public int findMin(int start , int end){
       return findMeanUtil(0 , inputSize-1 , start ,  end , 0);
    }


    private int findMeanUtil(int start, int end, int startInd, int endInd, int segIndex) {

        if(start >= startInd && end <= endInd){
            return segmentTree[segIndex];
        }

        if(end < startInd || start > endInd){
            return -1;
        }
        int mid = start + (end-start)/2;

        return minValueIndex(arr,
                findMeanUtil(start , mid , startInd ,endInd, 2*segIndex+1),
                findMeanUtil(mid+1 , end , startInd ,endInd, 2*segIndex+2)
        );


    }


    private int constructUtil(int[] arr , int start, int end, int segIndex) {

        if(start == end){
            return segmentTree[segIndex] = start;
        }

        int mid = start + (end-start)/2;

        segmentTree[segIndex] = minValueIndex(arr,
                constructUtil(arr , start , mid , 2*segIndex+1),
                constructUtil(arr , mid+1 , end , 2*segIndex+2)
                );
        return segmentTree[segIndex];
    }

    private int minValueIndex(int[] arr , int index1, int index2) {

        if(index1 ==-1 ) return index2;
        if(index2 ==-1 ) return index1;


        if(arr[index1] < arr[index2]){
            return index1;
        }
        return index2;
    }


}
