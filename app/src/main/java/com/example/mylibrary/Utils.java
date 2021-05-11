package com.example.mylibrary;

import java.util.ArrayList;

public class Utils {

    private static Utils instance;

    private static ArrayList<Book> allBooks;
    private static ArrayList<Book> alreadyReadBooks;
    private static ArrayList<Book> wantToReadBooks;
    private static ArrayList<Book> currentlyReadingBooks;
    private static ArrayList<Book> favouriteBooks;

//    This is Constructor
    private Utils() {
        if (null== allBooks){
            allBooks = new ArrayList<>();
            initData();
        }
        if (null== alreadyReadBooks){
            alreadyReadBooks = new ArrayList<>();
        }
        if (null== wantToReadBooks){
            wantToReadBooks = new ArrayList<>();
        }
        if (null== currentlyReadingBooks){
            currentlyReadingBooks = new ArrayList<>();
        }
        if (null== favouriteBooks){
            favouriteBooks = new ArrayList<>();
        }
    }

    private void initData() {
        allBooks.add(new Book(1,"1q84 ", "Murakami  ", 200,  "https://images-na.ssl-images-amazon.com/images/I/519EBmsHg2L._SX321_BO1,204,203,200_.jpg",
                "A work of Maddening Brilliance","Long Description" ));
        allBooks.add(new Book(2,"Step 1  ", "Me   ", 290,  "https://www.thebookdesigner.com/wp-content/uploads/2018/11/The-book-of-chaos.jpg",
                "A work of Maddening Brilliance","Long Description" ));    }

//Logic for making singleTon
    public static Utils getInstance() {
        if (null!= instance){
            return instance;
        }else{
            instance = new Utils();
            return instance;
        }
    }

    public static ArrayList<Book> getAllBooks() {
        return allBooks;
    }

    public static ArrayList<Book> getAlreadyReadBooks() {
        return alreadyReadBooks;
    }

    public static ArrayList<Book> getWantToReadBooks() {
        return wantToReadBooks;
    }

    public static ArrayList<Book> getCurrentlyReadingBooks() {
        return currentlyReadingBooks;
    }

    public static ArrayList<Book> getFavouriteBooks() {
        return favouriteBooks;
    }

    public Book getBookBytId (int id){
        for (Book b : allBooks){
            if (b.getId() == id){
                return b;
            }
        }
        return null;
    }

    public boolean addToAlreadyRead(Book book){
        return alreadyReadBooks.add(book);
    }

    public boolean addToWantToRead (Book book){
        return wantToReadBooks.add(book);
    }

    public boolean addToFavouriteBooks(Book book ){
        return  favouriteBooks.add( book);
    }

    public boolean addToCurrentlyReadingBooks(Book book){
        return currentlyReadingBooks.add(book);
    }
}
