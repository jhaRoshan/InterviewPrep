package test;

public class Child extends Parent{

    public void walk(){
        System.out.println("child walk");
        super.walk();
    }


    public void run(){
        System.out.println("child run");
        super.run();
    }
}
