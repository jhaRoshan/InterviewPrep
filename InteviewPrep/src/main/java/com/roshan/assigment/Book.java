package com.roshan.assigment;

public class Book {

    private int isbnNumber;
    private String author;
    private String  bookName;

    public Book(){}

    public Book(int isbnNumber , String author ,String bookName){
        this.isbnNumber = isbnNumber;
        this.bookName = bookName;
        this.author = author;
    }

    public int getIsbnNumber() {
        return isbnNumber;
    }

    public String getAuthor() {
        return author;
    }

    public String getBookName() {
        return bookName;
    }

    public void setIsbnNumber(int isbnNumber) {
        this.isbnNumber = isbnNumber;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    @Override
    public String toString() {
        return "Book{" +
                "isbnNumber=" + isbnNumber +
                ", author='" + author + '\'' +
                ", bookName='" + bookName + '\'' +
                '}';
    }


}
