package com.roshan.queue;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOrangeProblem {


    public static int getNoOfDaysToRotAllOrange(int[][] arr){


        int count = 0;
        Queue<Item> rottenItem = new LinkedList<>();

        for(int i = 0; i < arr.length ; i++){
            for(int j = 0 ; j < arr[0].length ; j++){
                if(arr[i][j] == 2){
                    rottenItem.add(new Item(i,j));
                }
            }
        }

        if(rottenItem.isEmpty()){
            return -1;
        }
        //delimeter
        rottenItem.add(new Item(-1,-1));

        while(!rottenItem.isEmpty()){

            while(!rottenItem.peek().isDelimiter() ){

                Item item = rottenItem.peek();
                if(isSafe(item.x,item.y+1 , arr.length , arr[0].length) && arr[item.x][item.y+1] == 1){
                    arr[item.x][item.y+1] = 2;
                    rottenItem.add(new Item(item.x,item.y+1));
                }

                if(isSafe(item.x,item.y-1 , arr.length , arr[0].length) && arr[item.x][item.y-1] == 1){
                    arr[item.x][item.y-1] = 2;
                    rottenItem.add(new Item(item.x,item.y-1));
                }

                if(isSafe(item.x+1,item.y , arr.length , arr[0].length) && arr[item.x+1][item.y] == 1){
                    arr[item.x+1][item.y] = 2;
                    rottenItem.add(new Item(item.x+1,item.y));
                }

                if(isSafe(item.x-11,item.y , arr.length , arr[0].length) && arr[item.x-1][item.y] == 1){
                    arr[item.x-11][item.y] = 2;
                    rottenItem.add(new Item(item.x-1,item.y));
                }
                rottenItem.remove();
            }
            rottenItem.remove();

            if(!rottenItem.isEmpty()){
                count++;
                rottenItem.add(new Item(-1,-1));
            }
        }



        return checkAll(arr) ? -1: count;
    }

    private static boolean isSafe(int i, int j , int R , int C) {
        return (i >= 0 && j >= 0 && i < R && j < C);
    }


    static boolean checkAll(int arr[][])
    {
        for (int i=0; i<arr.length; i++)
            for (int j=0; j< arr[0].length; j++)
                if (arr[i][j] == 1)
                    return true;
        return false;
    }


    public static void main(String[] args) {
        int arr[][] = { {2, 1, 0, 2, 1},
                {1, 0, 1, 2, 1},
                {1, 0, 0, 2, 1}};
        int ans = getNoOfDaysToRotAllOrange(arr);
        if(ans == -1)
            System.out.println("All oranges cannot rot");
        else
            System.out.println("Time required for all oranges to rot = " + ans);
    }
}


class Item{

    int x;
    int y;

    Item(int x, int y){
        this.x = x;
        this.y = y;
    }

    boolean isDelimiter(){
        return x == -1 && y==-1;
    }
}
