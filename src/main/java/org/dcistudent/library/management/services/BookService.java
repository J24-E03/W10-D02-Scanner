package org.dcistudent.library.management.services;

import org.dcistudent.library.management.models.Book;

import java.util.*;

public class BookService {
    private Scanner scanner;
    private List<Book> books;

    public BookService() {
        this.scanner = new Scanner(System.in).useDelimiter("\n");
        this.books = new ArrayList<>(Arrays.asList(
                new Book("The Alchemist", "Paulo Coelho", 208, true, false),
                new Book("The Da Vinci Code", "Dan Brown", 454, true, true),
                new Book("The Great Gatsby", "F. Scott Fitzgerald", 180, false, true),
                new Book("The Catcher in the Rye", "J.D. Salinger", 214, false, true),
                new Book("The Hobbit", "J.R.R. Tolkien", 310, true, true)
        ));
    }

    public BookService displayMenu() {
        System.out.println("Select an option:");
        System.out.println("1. View available books");
        System.out.println("2. Search books by author");
        System.out.println("3. View bestseller books");
        System.out.println("4. Borrow a book");
        System.out.println("5. Return a book");
        System.out.println("6. Exit");

        return this;
    }

    public void processMenu() {
        Integer option = this.scanner.nextInt();

        switch (option) {
            case 1:
                this.getAvailableBooks();
                break;
            case 2:
                this.findBooksByAuthor();
                break;
            case 3:
                this.findBooksByBestSeller();
                break;
            case 4:
                this.borrowBook();
                break;
            case 5:
                this.handBackBook();
                break;
            case 6:
                System.out.println("Bye, bye. :)");
                return;
            default:
                System.out.println("Invalid option. :( Try again.");
        }

        this
                .displayMenu()
                .processMenu()
        ;
    }

    private Boolean getAllBooks() {
        // no books available
        if (this.books.isEmpty() == true) {
            System.out.println("No books available. :(");
            return false;
        }

        // display all books
        System.out.println();
        System.out.println("All books:");
        this.books.forEach(System.out::println);
        System.out.println();

        return true;
    }

    private Boolean getAvailableBooks() {
        // no books available
        if (this.books.isEmpty() == true) {
            System.out.println("No books available. :(");
            return false;
        }

        // display available books
        System.out.println();
        System.out.println("Available books:");
        this.books
                .stream()
                .filter(Book::getIsAvailable)
                .forEach(System.out::println);
        System.out.println();

        return true;
    }

    private Boolean findBooksByAuthor() {
        if (this.books.isEmpty() == true) {
            return false;
        }

        System.out.println("Enter the author of the book you want to search:");
        String author = this.scanner.next();

        List<Book> books = this.books
                .stream()
                .filter(b -> b.getAuthor().toLowerCase().contains(author.toLowerCase()))
                .toList();

        if (books.isEmpty() == true) {
            System.out.println("No books found. :(");
            return false;
        }

        System.out.println();
        System.out.println("Books by " + author + ":");
        books.forEach(System.out::println);
        System.out.println();

        return true;
    }

    public Boolean findBooksByBestSeller() {
        if (this.books.isEmpty() == true) {
            return false;
        }

        List<Book> books = this.books
                .stream()
                .filter(Book::getIsBestSeller)
                .toList();

        if (books.isEmpty() == true) {
            System.out.println("No bestseller books found. :(");
            return false;
        }

        System.out.println();
        System.out.println("Bestseller books:");
        books.forEach(System.out::println);
        System.out.println();

        return true;
    }

    private Boolean borrowBook() {
        if (this.books.isEmpty() == true) {
            return false;
        }

        System.out.println("Enter the title of the book you want to borrow:");
        String title = this.scanner.next();

        Book book;
        try {
            book = this.books
                    .stream()
                    .filter(b -> b.getTitle().equalsIgnoreCase(title))
                    .findFirst()
                    .orElseThrow();
        } catch (NoSuchElementException e) {
            System.out.println("Book not found. :(");
            System.out.println();
            return false;
        }

        book.borrow(title);
        System.out.println("Book borrowed successfully. :)");
        System.out.println();

        return true;
    }

    private Boolean handBackBook() {
        if (this.books.isEmpty() == true) {
            return false;
        }

        System.out.println("Enter the title of the book you want to return:");
        String title = this.scanner.next();

        Book book;
        try {
            book = this.books
                    .stream()
                    .filter(b -> b.getTitle().equalsIgnoreCase(title))
                    .findFirst()
                    .orElseThrow();
        } catch (NoSuchElementException e) {
            System.out.println("Book not found. :(");
            System.out.println();
            return false;
        }

        if (book.getIsAvailable() == true) {
            System.out.println("Book does not seem to be ours. :)");
            System.out.println();
            return false;
        }

        book.handBack(title);
        System.out.println("Book returned successfully. :)");
        System.out.println();

        return true;
    }
}
