public class Book {
    private String title;
    private int numOfPages;
    private String author;
    private boolean isBestSeller;
    private boolean isAvailable;

    public Book(String title, int numOfPages, String author, boolean isBestSeller, boolean isAvailable) {
        this.title = title;
        this.numOfPages = numOfPages;
        this.author = author;
        this.isBestSeller = isBestSeller;
        this.isAvailable = isAvailable;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", numOfPages=" + numOfPages +
                ", author='" + author + '\'' +
                ", isBestSeller=" + isBestSeller +
                ", isAvailable=" + isAvailable +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNumOfPages() {
        return numOfPages;
    }

    public void setNumOfPages(int numOfPages) {
        this.numOfPages = numOfPages;
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

    public void setBestSeller(boolean bestSeller) {
        isBestSeller = bestSeller;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
