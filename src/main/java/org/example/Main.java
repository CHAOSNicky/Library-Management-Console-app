package org.example;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException{
        List<Book> books = List.of(
                new Book("Book 1", "Author A"),
                new Book("Book 2", "Author B"),
                new Book("Book 3", "Author C"),
                new Book("Book 4", "Author D"),
                new Book("Book 5", "Author E"),
                new Book("Book 6", "Author F"),
                new Book("Book 7", "Author G"),
                new Book("Book 8", "Author H"),
                new Book("Book 9", "Author I"),
                new Book("Book 10", "Author J"),
                new Book("Book 11", "Author K"),
                new Book("Book 12", "Author L"),
                new Book("Book 13", "Author M"),
                new Book("Book 14", "Author N"),
                new Book("Book 15", "Author O"),
                new Book("Book 16", "Author P"),
                new Book("Book 17", "Author Q"),
                new Book("Book 18", "Author R"),
                new Book("Book 19", "Author S"),
                new Book("Book 20", "Author T")
        );

        List<Student> students = List.of(
                new Student("Student 1", "1111111111", new HashMap<>()),
                new Student("Student 2", "2222222222", new HashMap<>()),
                new Student("Student 3", "3333333333", new HashMap<>()),
                new Student("Student 4", "4444444444", new HashMap<>()),
                new Student("Student 5", "5555555555", new HashMap<>()),
                new Student("Student 6", "6666666666", new HashMap<>()),
                new Student("Student 7", "7777777777", new HashMap<>()),
                new Student("Student 8", "8888888888", new HashMap<>())
        );

        LibraryManagement lm = new LibraryManagement(books, students);
        boolean running = true;
        Scanner sc = new Scanner(System.in);

        while(running) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Take a Book");
            System.out.println("2. Return a Book");
            System.out.println("3. Exit");
            System.out.print("> ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter the Book ID");
                    long bIdTake = sc.nextLong();
                    System.out.println("Enter the Student ID");
                    long sIdTake = sc.nextLong();
                    System.out.println(lm.takeBook(sIdTake, bIdTake));
                    break;

                case 2:
                    System.out.println("Enter the Book ID");
                    long bIdReturn = sc.nextLong();
                    System.out.println("Enter the Student ID");
                    long sIdReturn = sc.nextLong();
                    System.out.println(lm.returnBook(sIdReturn, bIdReturn));
                    break;

                case 3:
                    System.out.println("Please Visit Again");
                    running = false;
                    break;

                default:
                    System.out.println("Enter the Valid Number");
                    break;
            }
        }
        sc.close();
    }
}
