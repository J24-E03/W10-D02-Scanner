import java.util.ArrayList;
import java.util.Scanner;

public class Tasks {
    private static final ArrayList<Book> books = new ArrayList<>();

    public static void main(String[] args) {
        initializeBooks();

        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            displayMenu();
            System.out.print("Please select an option (1-4): ");
            option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1:
                    viewAvailableBooks();
                    break;
                case 2:
                    System.out.print("Enter the book title: ");
                    borrowBookByTitle(scanner.nextLine());
                    break;
                case 3:
                    System.out.print("Enter the book title: ");
                    returnBook(scanner.nextLine());
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid option!");
            }
        } while (true);
    }

    private static void displayMenu() {
        System.out.println("""
                
                1. View Available Books
                2. Borrow a Book
                3. Return a book
                4. Exit""");
    }

    private static void initializeBooks() {
        books.add(new Book("James", 690, "Percival Everett", false, true));
        books.add(new Book("Martyr!", 1023, "Kaveh Akbar", true, true));
        books.add(new Book("Funny Story", 876, "Salma Rushdie", false, true));
        books.add(new Book("Colored Television", 1034, "Danzy Senna", true, true));
        books.add(new Book("Rocket man", 1531, "Tom Freiburg", true, true));
    }

    private static void viewAvailableBooks() {
        for (Book book : books) {
            if (book.isAvailable()) {
                System.out.println(book);
            }
        }
    }

    private static void borrowBookByTitle(String title) {
        Book book = findBookByTitle(title);
        if (book != null && book.isAvailable()) {
            book.setAvailable(false);
            System.out.println("You have checked out " + book.getTitle());
            return;
        }
        System.out.println("Sorry, the book " + title + " is currently unavailable.");
    }

    private static void returnBook(String title) {
        Book book = findBookByTitle(title);
        if (book != null) {
            book.setAvailable(true);
            System.out.println("You have successfully returned the book. Thank you!");
        } else {
            System.out.println("The book " + title + " was not found in our records.");
        }
    }

    private static Book findBookByTitle(String title) {
        return books.stream().filter(book -> title.equals(book.getTitle())).findFirst().orElse(null);
    }

    private static Book findBookByAuthor(String author) {
        return books.stream().filter(book -> author.equals(book.getAuthor())).findFirst().orElse(null);
    }

    private static void displayAllBooks() {
        System.out.println(books);
    }

    private static void filterBooks() {
        System.out.println(books.stream().filter(Book::isBestSeller).toList());
    }
}
