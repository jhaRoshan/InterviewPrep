package com.roshan.multi.threading.test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class Test extends Thread{


    public Test(){
        super("in test");
        start();
        System.out.println(this);
    }



    public static void main(String[] args) {
        Test t1 = new Test();


    }


}
