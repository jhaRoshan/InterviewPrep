package com.roshan.java8;

import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.function.*;
import java.util.stream.Collectors;

public class Test {

    public static void main(String[] args) {

        List<String> myList = Arrays.asList("India", "AUStralia", "englAND");

        myList.stream().map( Test2.toUpperCase().andThen( e-> e+e))
                .map(e-> e.toLowerCase())
                .forEach(System.out :: println);



      /* Predicate<Integer> p = s1-> s1 % 2 == 0;
        Predicate<Integer> p1 = s1-> s1 > 10;
        Predicate<Integer> pf = p.and(p1);

        System.out.println(p.or(p1).test(8));
        System.out.println(p.negate().test(7));
        System.out.println(pf.test(16));*/

/*
        Function<Integer,Integer> f1  = n -> n*n;
        System.out.println(f1.apply(2));

        Function<Integer,String> f2  = n -> "String:"+n;
        System.out.println(f2.apply(2));

        System.out.println(f1.andThen(f2).apply(2));*/


      /* Consumer<String> c = c1-> System.out.println(c1);
        c.accept("test");
        System.out.println("----------");
        Consumer<String> cs1 = c1-> System.out.println(c1+","+c1);
        c.andThen(cs1).accept("test");
*/
        /*Supplier<String>  s = ()-> "Supplier test";
        System.out.println(s.get());
        */

       /* List<List<Integer>> lists = new ArrayList<>();
        lists.add(new ArrayList<>(){{add(1);add(2);add(3);}});
        lists.add(new ArrayList<>(){{add(23);add(12);add(15);}});
        lists.add(new ArrayList<>(){{add(11);add(62);add(35);}});


        List<Integer> c = lists.stream().flatMap(l-> l.stream()).collect(Collectors.toList());
        System.out.println(c);
        List<Integer> c1 = lists.stream().reduce(new ArrayList<>() , (a,b)-> {a.addAll(b); return a;});
        System.out.println(c1);

        System.out.println(lists.stream().flatMap(l-> l.stream()).mapToInt(e-> e).min().getAsInt());

        List<List<Integer>> s = lists.stream().filter(e-> e.contains(1)).collect(Collectors.toList());
        System.out.println(s);*/

       /* Map<String, String> filterCondition = new HashMap<>();
        filterCondition.put("dept", "IT");
        filterCondition.put("sex", "M");
        Predicate<Map<String, String>> allConditions = filterCondition
                .entrySet()
                .stream()
                .map(Test::getAsPredicate)
                .reduce( (p)->true, Predicate::and);*/

      Map<Integer,String> map = new HashMap<>();
        map.put(1,"one");
        map.put(2,"two");
        map.put(3,"three");

 /*
        map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(System.out::println);

        System.out.println("-----");

        map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .forEach(System.out::println);

        System.out.println("-------");*/

       /* Map<Integer,String> m= map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(
                        e-> e.getKey(),
                        e-> e.getValue()
                        ));
        System.out.println(m);*/



    }

    private static Predicate<Map<String, String>> getAsPredicate(Map.Entry<String, String> filter) {
        return (Map<String, String> employee) -> employee.get(filter.getKey()).equals(filter.getValue());
    }





}
