package com.roshan.segmenttree;

public class TestSegmentTree {

    public static void main(String[] args) {
        int arr[] = {13,6,14,7,3,5};
        MinSegTree st = new MinSegTree();
        st.construct(arr);
        System.out.println(st.findMin( 2,4));
        System.out.println(st.findMin( 1,3));
    }
}
