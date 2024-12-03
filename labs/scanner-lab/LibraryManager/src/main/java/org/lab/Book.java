package org.lab;

public class Book {
    private String title;
    private int numberOfPages;
    private String author;
    private boolean isBestSeller;
    private boolean isAvailable;

    public Book(String title, int numberOfPages, String author, boolean isBestSeller, boolean isAvailable) {
        this.title = title;
        this.numberOfPages = numberOfPages;
        this.author = author;
        this.isBestSeller = isBestSeller;
        this.isAvailable = isAvailable;
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
      return "Title: " + title + " Author: " + author + " Pages: " + numberOfPages;
    };
}
