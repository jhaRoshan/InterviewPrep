package com.roshan.assigment;

public class Test {

    public static void main(String[] args) {

        Book book1 = new Book(1, "Author1" , "Book1");
        Book book2 = new Book(1, "Author1" , "Book1");
//        Book book3 = new Book(1, "Author1" , "Book1");
//        Book book4 = new Book(2, "Author2" , "Book2");

        Library library = new Library();
        System.out.println("ISEmpty:"+library.isEmpty());

        library.addBook(book1);
        library.addBook(book2);

        System.out.println("ISEmpty:"+library.isEmpty());

        System.out.println("Book1 Count"+library.getCountOfBooks("Book1"));
        System.out.println("Book2 Count"+library.getCountOfBooks("Book2"));


        System.out.println("AllBook:"+library.viewAllBook());
        System.out.println("AllBook:"+library.viewByAuthor("Author1"));
        System.out.println("AllBook:"+library.viewByAuthor("Author2"));


    }
}
