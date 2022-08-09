package com.roshan.multi.threading.sequenceprint;

import java.util.concurrent.atomic.AtomicInteger;

public class NumberPrinter implements Runnable{

    private Object monitor;
    private int threadId;
    private int numberOfThread;
    private AtomicInteger atomicInteger;


    public NumberPrinter(int threadId , int numberOfThread , AtomicInteger atomicInteger , Object monitor){
        this.threadId = threadId;
        this.numberOfThread = numberOfThread;
        this.atomicInteger = atomicInteger;
        this.monitor = monitor;
    }

    @Override
    public void run() {

        while(atomicInteger.get() < 100){
            synchronized (monitor){
                if(atomicInteger.get() % numberOfThread == threadId% numberOfThread){
                    System.out.println("Thread Id:"+threadId +" , Number:"+atomicInteger.getAndIncrement());
                    monitor.notifyAll();
                }else{
                    try {
                        monitor.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
