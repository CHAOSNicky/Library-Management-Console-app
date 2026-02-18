package org.example;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Data
public class Student {
    private final long id;
    private final String name;
    private String contact;
    Map<Long, LocalDateTime> borrBooks;
    private static final AtomicLong autoIncreId = new AtomicLong(1);

    public Student(String name, String contact, Map<Long, LocalDateTime> books){
        this.id = autoIncreId.getAndIncrement();
        this.name = name;
        this.contact = contact;
        this.borrBooks = books;
    }
}
