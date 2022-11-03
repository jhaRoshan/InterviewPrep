package com.roshan.leetcode;

public class P2320NumberOfWaysForHouse {

    int mod = (int) (1e9+7);

    public int countHousePlacements(int n) {

        long ans = compute(n);
        return (int)((ans * ans ) % mod);

    }

    private long compute(int n){
        if(n == 0) return 1;
        if(n == 1) return 2;

        long last2 = 1;
        long last = 2;

        for(int i = 2 ; i <= n ;i++){

            long temp = last;
            last = (last+ last2)%mod;
            last2 = temp;
        }

        return last;
    }

    public static void main(String[] args) {
        P2320NumberOfWaysForHouse p = new P2320NumberOfWaysForHouse();
        System.out.println(p.countHousePlacements(4));
    }
}
