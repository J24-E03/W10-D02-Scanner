package org.lab;

import java.util.ArrayList;

public class Main {
    public static ArrayList<Book> books = new ArrayList<>();


    public static void main(String[] args) {
        initializeBooks();
        displayMenu();
        viewAvailableBooks();

        System.out.println(borrowBookByTitle("Dune"));
        viewAvailableBooks();

        System.out.println(borrowBookByTitle("Fahrenheit 451"));
        System.out.println(returnBook("Dune"));
        System.out.println(returnBook("Dune"));
        viewAvailableBooks();
    }

    public static void displayMenu() {
        System.out.println("1. View Available Books");
        System.out.println("2. Borrow a Book");
        System.out.println("3. Return a Book");
        System.out.println("4. Exit");
    };

    public static void initializeBooks() {
        books.add(new Book("Dune", 658, "Frank Herbert", true, true));
        books.add(new Book("The Hitchhiker’s Guide to the Galaxy", 193, "Douglas Adams", true, true));
        books.add(new Book("Hyperion", 500, "Dan Simmons", true, true));
        books.add(new Book("Neuromancer", 288, "William Gibson", true, true));
    }

    public static void viewAvailableBooks() {
        for(Book book : books) {
            if(book.isAvailable()) {
                System.out.println(book.toString());
            }
        }
    }

    public static String borrowBookByTitle(String title) {
        for(Book book : books) {
            if(book.getTitle().equals(title)) {
                if(book.isAvailable()) {
                    book.setAvailable(false);
                    return "You have checked out " + book.toString();
                }
            }
        }
        return title + " is not available at the moment!";
    }

    public static String returnBook(String title){
        for(Book book : books) {
            if(book.getTitle().equals(title)) {
                if(!book.isAvailable()) {
                    book.setAvailable(true);
                    return "You have returned " + book.toString();
                }
            }
        }
        return title + " was not found or is already returned!";
    }
}