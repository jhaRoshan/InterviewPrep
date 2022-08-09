package test;

import com.roshan.test.Parent;

public class MyArray {

    private int arraySize;
    private int index = 0;
    private int[] arr;

    public MyArray(int size) {
        arraySize = size;
        arr = new int[size];
    }

    public void insert(int data) {

        arr[index] = data;
        index++;

        if (index >= arraySize) {
            int[] newArray = new int[arr.length * 2];
            for (int j = 0; j < arr.length; j++) {
                newArray[j] = arr[j];
            }
            arr = newArray;
        }
    }

    public int[] getData() {
        return arr;
    }


}
