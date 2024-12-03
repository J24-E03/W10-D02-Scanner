package org.dcistudent.library.management.models;

import lombok.*;

@Getter @Setter
public class Book {
    private String title;
    private String author;
    private Integer pages;
    private Boolean isBestSeller = false;
    private Boolean isAvailable = true;

    public Book(String title, String author, Integer pages, Boolean isBestSeller, Boolean isAvailable) {
        this.setTitle(title);
        this.setAuthor(author);
        this.setPages(pages);
        this.setIsBestSeller(isBestSeller);
        this.setIsAvailable(isAvailable);
    }

    @Override
    public String toString() {
        return this.getTitle() + " (Author: " + this.getAuthor() + ", Pages: " + this.getPages() + " pages, Bestseller: " + this.getIsBestSeller() + ")";
    }

    public Boolean borrow(String name) {
        if (this.getIsAvailable()) {
            this.setIsAvailable(false);
            return true;
        }

        return false;
    }

    public Boolean handBack(String name) {
        if (!this.getIsAvailable()) {
            this.setIsAvailable(true);
            return true;
        }

        return false;
    }
}
