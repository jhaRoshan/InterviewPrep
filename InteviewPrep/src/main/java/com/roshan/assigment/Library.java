package com.roshan.assigment;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Library {

    private List<Book> bookList = new ArrayList<>();

    public void addBook(Book book){
        bookList.add(book);
    }

    public boolean isEmpty(){
        return bookList.isEmpty();
    }

    public List<Book> viewAllBook(){
        return this.bookList;
    }

    public List<Book> viewByAuthor(String authorName){
        List<Book> retVal = new ArrayList<>();
        for(Book b: bookList){
            if(b.getAuthor().equalsIgnoreCase(authorName)){
                retVal.add(b);
            }
        }
        return retVal;
    }

    public int getCountOfBooks(String bookName){
        int count = 0;
        for(Book b: bookList){
            if(b.getBookName().equalsIgnoreCase(bookName)){
                count++;
            }
        }
        return count;
    }






}
