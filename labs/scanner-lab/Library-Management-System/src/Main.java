import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static List<Book> books = new ArrayList<>();

    public static void main(String[] args) {
        initializeBooks();
        displayMenu();
    }

    private static void initializeBooks() {
        books.addAll(Arrays.asList(
                new Book("The Great Gatsby", 180, "F. Scott Fitzgerald", true, true),
                new Book("To Kill a Mockingbird", 281, "Harper Lee", true, false),
                new Book("1984", 328, "George Orwell", true, true),
                new Book("Pride and Prejudice", 432, "Jane Austen", false, true),
                new Book("Moby Dick", 585, "Herman Melville", false, true),
                new Book("The Catcher in the Rye", 277, "J.D. Salinger", true, false),
                new Book("Brave New World", 311, "Aldous Huxley", true, true),
                new Book("War and Peace", 1225, "Leo Tolstoy", false, false),
                new Book("The Odyssey", 541, "Homer", false, true),
                new Book("The Alchemist", 208, "Paulo Coelho", true, true),
                new Book("The Book Thief", 552, "Markus Zusak", true, true),
                new Book("The Hobbit", 310, "J.R.R. Tolkien", true, true),
                new Book("Crime and Punishment", 671, "Fyodor Dostoevsky", false, true),
                new Book("The Road", 287, "Cormac McCarthy", false, false),
                new Book("Frankenstein", 280, "Mary Shelley", false, true)
        ));
    }

    private static void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;
        System.out.println("Welcome to our Library Management System!");
        while (isRunning) {
            System.out.println("\nLibrary Management System Menu:");
            System.out.println("1. View All Books");
            System.out.println("2. View Available Books");
            System.out.println("3. View Bestseller Books");
            System.out.println("4. Borrow a Book");
            System.out.println("5. Return a Book");
            System.out.println("6. Search Books by Author");
            System.out.println("7. Exit");
            System.out.print("Please Enter Your Choice: ");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1:
                        viewAllBooks();
                        break;
                    case 2:
                        viewAvailableBooks();
                        break;
                    case 3:
                        viewBestSellerBooks();
                        break;

                    case 4:
                        System.out.print("Enter the title of the book you want to borrow: ");
                        System.out.println(borrowBookByTitle(scanner.nextLine().trim()));
                        break;

                    case 5:
                        System.out.print("Enter the title of the book you want to return: ");
                        System.out.println(returnBook(scanner.nextLine().trim()));
                        break;
                    case 6:
                        System.out.print("Enter the author's name: ");
                        searchBookByAuthor(scanner.nextLine().trim());
                        break;
                    case 7:
                        isRunning = false;
                        System.out.println("Thank you and Goodbye!");
                        break;
                    default:
                        System.out.println("Please enter a valid choice (1–7).");
                        break;
                }
            } catch (Exception ex) {
                System.out.println("Invalid input! Please enter a number between 1 and 7.");
                scanner.nextLine();
            }

        }
        scanner.close();
    }

    private static void viewAvailableBooks() {
        System.out.println("\nAvailable Books:");
        books.stream()
                .filter(Book::isAvailable)
                .forEach(System.out::println);
    }

    private static void viewAllBooks() {
        System.out.println("\nAll Books in the Library:");
        books.forEach(System.out::println);
    }

    private static void viewBestSellerBooks() {
        System.out.println("\nBestseller Books:");
        books.stream()
                .filter(Book::isBestSeller)
                .forEach(System.out::println);
    }


    private static void searchBookByAuthor(String author) {
        System.out.println("\nBooks by " + author + ":");
        boolean found = false;
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                found = true;
                System.out.println(book);
            }
        }
        if (! found) {
            System.out.println("No books found by this author.");
        }
    }

    private static String borrowBookByTitle(String title) {
        if (title.isBlank()) {
            return "Invalid input. Book title cannot be empty.";
        }

        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                if (book.isAvailable()) {
                    book.setAvailable(false);
                    return "You have Checked out " + book.getTitle();
                }
                return "Sorry, the book " + book.getTitle() + " is currently unavailable";
            }
        }
        return "The book " + title + " was not found in our records.";
    }

    private static String returnBook(String title) {
        if (title.isBlank()) {
            return "Invalid input. Book title cannot be empty.";
        }
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                if (!book.isAvailable()) {
                    book.setAvailable(true);
                    return "You have successfully returned " + book.getTitle() + ". Thank you!";
                }
                return "The book " + book.getTitle() + " is already available in the library.";
            }
        }
        return "The book " + title + " was not found in our records.";
    }
}