package com.roshan.multi.threading.sequenceprint;

import java.util.concurrent.atomic.AtomicInteger;

public class MainTest {

    public static void main(String[] args){
        Object monitor = new Object();
        AtomicInteger atomicInteger = new AtomicInteger(1);
        int numberOfThread = 5;

        for(int i=1 ; i <= numberOfThread ; i++){
            new Thread(new NumberPrinter(i,numberOfThread,atomicInteger,monitor)).start();
        }

    }
}
