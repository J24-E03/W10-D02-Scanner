import java.util.ArrayList;
import java.util.Scanner;


public class Main {


    static ArrayList<Book> books = new ArrayList<>();

    public static void initializeBooks() {
        Book book1 = new Book("Animal Farm", 200, true, "George Orwell", true);
        Book book2 = new Book("The Kite Runner", 300, true, "Khaled Hosseini", true);
        Book book3 = new Book("The White Tiger", 300, false, "Arundhati Roy", false);
        Book book4 = new Book("2 States", 500, true, "Chetan Bhagat", true);

        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);
    }

    //5. View Available Books
    public static void viewAvailableBooks() {
        System.out.println("Available Books: ");
        for (Book b : books) {
            if (b.isAvailable()) {
                System.out.println(b);
                System.out.println();
            }
        }
    }

    //6. Borrow Book by Title
    public static String borrowBookByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                if (book.isAvailable()) {
                    book.setAvailable(false);
                    return "You have checked out " + title + ".";
                } else {
                    return "Sorry, the book " + title + " is currently unavailable.";
                }
            }
        }
        return "Sorry, the book " + title + " was not found in our records.";
    }

    public static String returnBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                book.setAvailable(true);
                return "You have successfully returned the book. Thank you!";
            } else {
                return "The book " + title + "was not found in our records.";
            }
        }
        return "The book \"" + title + "\" was not found in our records.";
    }
    public static void displayAllBooks() {
        for (Book book : books) {
            System.out.println(book);
            System.out.println();
        }
    }

    // Optional: Search books by author
    public static void searchBooksByAuthor(String author) {
        boolean found = false;
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                System.out.println(book);
                System.out.println();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No books found by author " + author + ".");
        }
    }

    // Optional: Filter books by bestseller status
    public static void filterBooksByBestSeller(boolean isBestSeller) {
        for (Book book : books) {
            if (book.isBestSeller == isBestSeller) {
                System.out.println(book);
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        initializeBooks();

        while(true){
            System.out.println("Welcome to the Book Library System!");
            System.out.println("1. View Available Books");
            System.out.println("2. Borrow a Book");
            System.out.println("3. Return a Book");
            System.out.println("4. Display All Books");
            System.out.println("5. Search Books by Author");
            System.out.println("6. Filter Books by Bestseller");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            if(choice == 1) {
                viewAvailableBooks();
            }
            else if(choice == 2) {
                System.out.print("Enter the title of the book you want to borrow: ");
                scanner.nextLine();
                String borrowTitle = scanner.nextLine();
                System.out.println(borrowBookByTitle(borrowTitle));
            }
            else if(choice == 3) {
                System.out.print("Enter the title of the book you want to return: ");
                scanner.nextLine();
                String returnTitle = scanner.nextLine();
                System.out.println(returnBook(returnTitle));
            }
            else if(choice == 4) {
                displayAllBooks();
            }
            else if(choice == 5) {
                System.out.print("Enter the author's name: ");
                scanner.nextLine();
                String author = scanner.nextLine();
                searchBooksByAuthor(author);
            }
            else if(choice == 6) {
                System.out.print("Do you want to see bestsellers? (yes/no): ");
                scanner.nextLine();
                String filterChoice = scanner.nextLine();
                filterBooksByBestSeller(filterChoice.equalsIgnoreCase("yes"));
            }
            else if(choice == 7) {
                System.out.println("Goodbye!");
                return;// Exit the program
            }
                else {
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}




