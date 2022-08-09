package com.roshan.test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class testGenerics {

    public void p1(List<String> ...l){
        System.out.println("in list of String");
    }

    public <E> void p1(E... l){
        System.out.println("In E");
    }
    public static void merge(List<String>... stringList)
    {
        // Here we are an array of type Object holds
        // reference of an array of type List<String>
        Object[] arr = stringList;
        List<Integer> temp = new ArrayList<Integer>();
        temp.add(420);

        // Here we are trying to assign temp
        // of type List<Integer> into arr[0]
        // which is of type List<String>

        // Here ClassCastException will be thrown
        arr[0] = temp;
        String firstEle = stringList[0].get(0);
        System.out.println(firstEle);
    }

    public static void main(String[] args) {

        List<String> li = new ArrayList<>();
        List<String> li2 = new ArrayList<>();
        testGenerics t1 = new testGenerics();
        t1.p1(li);
        t1.p1(li,li2);


        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        List<String> list3 = new ArrayList<>();
        list1.add("Geeks");
        list2.add("for");
        list3.add("geeks");

        merge(list1, list2, list3);

        List<Parent>  o = new ArrayList<>();
        o.add(new Child());
        o.add(new Parent());

        List<Child>  o1 = new ArrayList<>();
        o1.add(new Child());
//        o1.add(new Parent());


        LinkedBlockingDeque<Integer> i = new LinkedBlockingDeque<Integer>();
        i.add(1);
        i.offer(1);

    }


   /* public void add(List<? extends Parent> o ){
        //not possible
//        o.add(new Child());
//        o.add(new Parent());
//        o.add(new Object());
//        Child d = o.get(1);

        Parent p = o.get(1);
        Object op = o.get(1);
    }*/

    public void add(List<? super Child> o ){

//        o.add(new Parent());
//        o.add(new Object());
//        Parent p = o.get(1);
//        Child c = o.get(1);
//        o.add(new Parent());

        Object op  = o.get(1);
        o.add(new Child());
    }
}
