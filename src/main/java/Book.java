public class Book {
    String title;
    int numberOfPages;
    String author;
    boolean isBestSeller;
    boolean isAvailable;

    public Book(String title, int numberOfPages, boolean isAvailable, String author, boolean isBestSeller) {
        this.title = title;
        this.numberOfPages = numberOfPages;
        this.isAvailable = isAvailable;
        this.author = author;
        this.isBestSeller = isBestSeller;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public boolean isBestSeller() {
        return isBestSeller;
    }

    public void setBestSeller(boolean isBestSeller) {
        isBestSeller = isBestSeller;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public String toString() {
        return "Title: " + title + "\n" +
                "Author: " + author + "\n" +
                "Pages: " + numberOfPages + "\n" +
                "Best Seller: " + (isBestSeller ? "Yes" : "No") + "\n" +
                "Available: " + (isAvailable ? "Yes" : "No");
    }



}
