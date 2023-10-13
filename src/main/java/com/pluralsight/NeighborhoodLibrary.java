package com.pluralsight;
import java.util.*;

public class NeighborhoodLibrary {
   public static Scanner myScanner = new Scanner(System.in);
    public static void main(String[] args) {
        Book[] book = new Book[20];
        int userInput = 0;

        book[0] = new Book(1, "456", "Why Dominican Republic needs to be helped", "", false);
        book[1] = new Book(2, "234","The Elegance of the Hedgehog", "", false);
        book[2] = new Book(3, "224","The Unbearable Lightness of Being", "", false);
        book[3] = new Book(4, "563","How to die alone", "", true);
        book[4] = new Book(5, "256","How to be happy", "", false);
        book[5] = new Book(6, "356","Mommy wants to be happy", "", true);
        book[6] = new Book(7, "268","How to be mad at everything", "", true);
        book[7] = new Book(8, "260","Why am I alone", "", true);
        book[8] = new Book(9, "098","How to be a fairy", "", true);
        book[9] = new Book(10, "891","Becoming a furry 101", "", false);
        book[10] = new Book(11, "954","Spider-man if he was paralyzed", "", false);
        book[11] = new Book(12, "704","ABC in Japanese", "", true);
        book[12] = new Book(13, "896","Is America Number One", "", false);
        book[13] = new Book(14, "563","South Korea Adventures", "", false);
        book[14] = new Book(15, "556","The North Korea Conflict", "", true);
        book[15] = new Book(16, "458","Terrorist in America", "", false);
        book[16] = new Book(17, "963","Youth of America", "", true);
        book[17] = new Book(18, "999","Swedish Meatballs", "", false);
        book[18] = new Book(19, "266","If then Why not", "", true);
        book[19] = new Book(20, "666","Youth Group Of Baptist Church", "", false);


        do{
            System.out.println("You have to come to the right place for books!\n" +
                    " What would you like to do?\n See our available books (1)\n" +
                    " check out books?(2)\n" +
                    " Please input the number associated with your choice and or choose 3 to exit!");
            userInput = myScanner.nextInt();
          switch(userInput){
              case 1 :
                  availableBooks(book);
                  break;
              case 2 :
                  checkOutBooks(book);
                  break;
              case 3 :
                  System.exit(0);
              default:
                  System.out.println("WRONG INPUT! Please enter 1,2,3 !");
          }
        }
        while(userInput >= 0 && userInput <= 2);
    }
    public static void availableBooks(Book[] book){
        int userInput = 1, id = 0;
        String userName = "";
        do{
            System.out.println("These are the ones that are available!");
            for(int i = 0; i < book.length;i++){
                if(!book[i].getIsCheckedOut()){
                    System.out.println(book[i].toStringCheckedOut());
                }
            }
            System.out.println("What would you like to do? Check out a book(1) or Go back to HomeScreen (2) ");
               userInput = myScanner.nextInt();
                switch(userInput){
                    case 1 :
                        System.out.println("What is your name:");
                        myScanner.nextLine();
                        userName = myScanner.nextLine();
                        System.out.println("Please input the id number of the book: ");
                        id = myScanner.nextInt();
                        for(int i = 0; i < book.length; i++){
                            if(book[i].getId() == id){
                                book[i].checkOut(userName);
                            }
                        }
                        break;
                    case 2 :
                        break;
                    default:
                        System.out.println("WRONG INPUT! Choose 1 or 2");
                        userInput = 1;
                }
        }
        while(userInput!= 2);
    }
    public static void checkOutBooks(Book[] book){
        int userInput = 1, id = 0;

        do{
            System.out.println("There are the ones are checked out! ");
            for(int i = 0; i < book.length; i++){
                if(book[i].getIsCheckedOut() == true){
                    System.out.println(book[i].toStringCheckedOut());
                }
            }
            System.out.println("What do you want to do ? Check in (1) Return to Home Screen (2)");
            userInput = myScanner.nextInt();
            switch(userInput){
                case 1 :
                    System.out.println("Enter the id of the book you're checking in ");
                    userInput = myScanner.nextInt();
                    for(int i = 0; i < book.length; i++){
                        if(book[i].getId() == id){
                            book[i].checkIn();
                        }
                    }
                    break;
                case 2:
                    break;
                default:
                    System.out.println("WRONG WHY DO YOU DISOBEY! Choose 1 or 2!");
                    userInput = 1;
            }

        }
        while(userInput!=2);

    }

}
