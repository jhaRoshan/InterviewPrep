package com.roshan.java8;

import java.util.Locale;
import java.util.function.Consumer;
import java.util.function.Function;

public class Test2 {

     public Consumer<Integer> print(){
        return e-> System.out.println(e);
    }

    public Function<Integer,Integer> process(){
        return (a)-> 2*a;
    }

    public static String toUpperCase(String s) {
        return s.toUpperCase();
    }

    public static Function<String,String> toUpperCase(){
        return (a)-> a.toUpperCase();
    }


    public static Function<String,String> toLowerCase(){
        return (a)-> a.toLowerCase();
    }
}
