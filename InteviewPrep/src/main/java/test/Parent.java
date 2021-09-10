package test;

public class Parent {

    public void walk(){
        System.out.println("parent walk");
    }


    public void run(){
        System.out.println("parent run");
        this.walk();
    }
}
