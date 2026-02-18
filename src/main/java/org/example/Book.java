package org.example;

import lombok.Data;
import java.util.concurrent.atomic.AtomicLong;

@Data
public class Book {
    private final long id;
    private final String title;
    private final String author;
    private boolean avail;
    public static final AtomicLong autoIncreId = new AtomicLong(1);

    public Book(String title, String author){
        this.id = autoIncreId.getAndIncrement();
        this.title = title;
        this.author = author;
        this.avail = true;
    }
}
