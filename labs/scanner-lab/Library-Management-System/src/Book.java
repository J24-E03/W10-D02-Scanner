public class Book {
    private String title;
    private int numberOfPages;
    private String author;
    private boolean isBestSeller;
    private boolean isAvailable;

    public Book(String title, int numberOfPages, String author, boolean isBestSeller, boolean isAvailable) {
       setTitle(title);
       setAuthor(author);
       setNumberOfPages(numberOfPages);
       setAvailable(isAvailable);
       setBestSeller(isBestSeller);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title.isBlank()) {
            System.out.println("Blank Title. Please input a valid title.");
            this.title = "Unknown";
        }
        this.title = title;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        if (numberOfPages <= 0) {
            System.out.println("Invalid number of pages!");
            this.numberOfPages = 100;  // default value
            return;
        }
        this.numberOfPages = numberOfPages;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        if (author.isBlank()) {
            System.out.println("Author is balnk! Please input a valid author name!");
            this.author = "Unknown";
            return;
        }
        this.author = author;
    }

    public boolean isBestSeller() {
        return isBestSeller;
    }

    public void setBestSeller(boolean bestSeller) {
        isBestSeller = bestSeller;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", numberOfPages=" + numberOfPages +
                ", author='" + author + '\'' +
                ", isBestSeller=" + isBestSeller +
                ", isAvailable=" + isAvailable +
                '}';
    }
}
