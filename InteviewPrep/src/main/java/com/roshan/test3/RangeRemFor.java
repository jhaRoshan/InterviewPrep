package com.roshan.test3;

import java.util.HashSet;

public class RangeRemFor {


    private HashSet<Integer> hashSet = new HashSet<>();

    public void remember(int offSet , int len){
        for(int i = offSet ; i < offSet+len-1 ; i++){
            hashSet.add(i);
        }
    }


    public void forget(int offSet , int len){
        for(int i = offSet ; i < offSet+len-1 ; i++){
            hashSet.remove(i);
        }
    }



}
