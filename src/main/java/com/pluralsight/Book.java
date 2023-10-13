package com.pluralsight;

public class Book {
    private int id;
    private String isbn = "", title = "", checkedOutTo = "";
    private boolean isCheckedOut = false;

     public Book(){
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.checkedOutTo = checkedOutTo;
        this.isCheckedOut = isCheckedOut;
    }
    public Book(int id, String isbn, String title, String checkedOutTo, boolean isCheckedOut) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.checkedOutTo = checkedOutTo;
        this.isCheckedOut = isCheckedOut;
    }
//getters
    public int getId() {
        return this.id;
    }
    public String getIsbn(){
        return this.isbn;
    }
    public String getTitle(){
        return this.title;
    }
    public String getCheckedOutTo(){
        return this.checkedOutTo;
    }
    public boolean getIsCheckedOut() {
        return this.isCheckedOut;
    }

    //setters
    public void setId(int id) {
        this.id = id;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public void setCheckedOutTo(String checkedOutTo){
        this.checkedOutTo = checkedOutTo;
    }
    public void setCheckedOut(boolean checkedOut) {
       this.isCheckedOut = checkedOut;
    }
    public void checkOut(String person){
        this.checkedOutTo = person;
        this.isCheckedOut = true;
    }
    public void checkIn(){
        this.checkedOutTo = "";
        this.isCheckedOut = false;
    }
    public String toStringCheckedOut(){
        return "Book ID: " + this.id +
                "; Book isbn : " + this.isbn +
                "; Book Title: " + this.title;
    }
}

