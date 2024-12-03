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
        Book book1 = new Book("The Great Gatsby", 180, "F. Scott Fitzgerald", true, true);
        Book book2 = new Book("To Kill a Mockingbird", 281, "Harper Lee", true, false);
        Book book3 = new Book("1984", 328, "George Orwell", true, true);
        Book book4 = new Book("Pride and Prejudice", 432, "Jane Austen", false, true);

        books.addAll(Arrays.asList(book1, book2, book3, book4));
    }

    private static void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;
        String title;
        System.out.println("Welcome to our Library Management System!");
        while (isRunning) {
            System.out.println("You have this Options: ");
            System.out.println("1. View Available Books");
            System.out.println("2. Borrow a Book");
            System.out.println("3. Return a Book");
            System.out.println("4. Exit");
            System.out.println("Please Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1 :
                    viewAvailableBooks();
                    break;
                case 2 :
                    System.out.println("Please Enter the name of the book you want to borrow: ");
                    title = scanner.nextLine();
                    System.out.println(borrowBookByTitle(title));
                    break;
                case 3 :
                    System.out.println("Please enter the name of the book you want to return: ");
                    title = scanner.nextLine();
                    System.out.println(returnBook(title));
                    break;
                case 4:
                    isRunning = false;
                    System.out.println("Thank you and Good Bye!");
                    break;
                default:
                    System.out.println("Please enter a choice bewteen 1-4!");
                    break;
            }

        }
    }

    private static void viewAvailableBooks() {
        System.out.println("All Available Books in Library:");
        for (Book book : books) {
            if (book.isAvailable()) {
                System.out.println(book);
            }
        }
    }

    private static String borrowBookByTitle(String title) {
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
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                book.setAvailable(true);
                return "You have successfully returned the book. Thank you!";
            }
        }
        return "The book " + title + " was not found in our records.";
    }
}