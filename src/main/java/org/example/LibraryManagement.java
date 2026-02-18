package org.example;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class LibraryManagement {
     private Map<Long, Book> books = new HashMap<>();
     private Map<Long, Student> students = new HashMap<>();
     private static final long fine = 100;
     private static final long fineDueTime = 2;
     private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

     public LibraryManagement(List<Book> books, List<Student> students){
         for(Book b : books){
             this.books.put(b.getId(), b);
         }
         for(Student s : students){
             this.students.put(s.getId(), s);
         }
     }

     public String takeBook(long studId, long bookId){
         if(!books.get(bookId).isAvail()){
             return "The requested book is not available";
         };

         LocalDateTime currentDateTime = LocalDateTime.now();
         String formattedDateTime = currentDateTime.format(formatter);
         students.get(studId).getBorrBooks().put(bookId, currentDateTime);
         books.get(bookId).setAvail(false);
         return "Book titled " +
                 books.get(bookId).getTitle() +
                 " has taken by " +
                 students.get(studId).getName() +
                 " at " + formattedDateTime;
     }

     public String returnBook(long studId, long bookId){
        long fineSec = 0;
        books.get(bookId).setAvail(true);
        LocalDateTime takeTime = students.get(studId).getBorrBooks().get(bookId);
        students.get(studId).getBorrBooks().remove(bookId);
        LocalDateTime returnTime = LocalDateTime.now();
        Duration totalTime = Duration.between(takeTime, returnTime);
        long sec = totalTime.toSeconds();
        fineSec = sec - fineDueTime;
        if(fineSec > 0){
            return "Book titled " +
                    books.get(bookId).getTitle() +
                    " has returned by " +
                    students.get(studId).getName() +
                    " after the " + fineSec + " Seconds than due date, The fine amount is " + (fineSec * fine);
        }
        return "Book titled " +
                books.get(bookId).getTitle() +
                " has returned by " +
                students.get(studId).getName();
     }

}
