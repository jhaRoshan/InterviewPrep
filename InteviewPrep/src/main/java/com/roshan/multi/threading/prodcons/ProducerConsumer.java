package com.roshan.multi.threading.prodcons;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

public class ProducerConsumer {

    private final int size;
    private volatile int v = 0;
    private final  LinkedList<Integer> data = new LinkedList<Integer>();

    public ProducerConsumer(int size) {
        this.size = size;
    }

    public void produce() {
        while (true) {
            try {
                synchronized (this) {
                    while (data.size() == size) {
                        wait();
                    }
                    Thread.sleep(1000);
                    data.add(v++);
                    notifyAll();
                    System.out.println(Thread.currentThread().getName() + " Produced Num:" + (v - 1));
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public void consume() {
        while (true) {
            try {
                synchronized (this) {
                    while (data.size() == 0) {
                        wait();
                    }
                    int v = data.removeFirst();
                    System.out.println(Thread.currentThread().getName() + " Consumed Num:" + v);
                    notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) {
        ProducerConsumer pd = new ProducerConsumer(5);

        Runnable r1 = ()-> pd.produce();
        Runnable c1 = ()-> pd.consume();

        new Thread(r1).start();
        new Thread(r1).start();

        new Thread(c1).start();

    }
}
