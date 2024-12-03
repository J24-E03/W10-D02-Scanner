package org.dcistudent;

import org.dcistudent.library.management.services.BookService;

public class Main {
    public static void main(String[] args) { new Main(); }

    public Main() {
        BookService service = new BookService();
        service
                .displayMenu()
                .processMenu()
        ;
    }
}