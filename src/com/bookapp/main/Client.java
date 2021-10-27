package com.bookapp.main;

import java.util.List;
import java.util.Scanner;

import com.bookapp.bean.Book;
import com.bookapp.execution.AuthorNotFoundException;
import com.bookapp.execution.CategoryNotFoundException;
import com.bookapp.service.BookImpl;
import com.bookapp.service.BookInter;

public class Client {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter your choice :\n1.Show All Books \n2.Show Books by Author \n3.how Book by Category ");
		int choice = scanner.nextInt();

		BookInter bookService = new BookImpl();

		bookService.addBook(new Book("Data Structure", "Sharma", "latest", 001, 200));
		bookService.addBook(new Book("oops", "Agarval", "Current", 002, 150));
		bookService.addBook(new Book("Developers logic", "RohitSharma", "latestEdition", 003, 250));

		switch (choice) {

		case 1:

			List<Book> bookList = bookService.getAllBooks();
			for (Book book : bookList) {
				System.out.println(book);
			}
			break;

		case 2:

			System.out.println("Enter the author name:");
			String authorName = scanner.next();

			try {
				System.out.println(bookService.getBookbyAuthor(authorName));
			} catch (AuthorNotFoundException e) {
				System.out.println(e.getMessage());
			}
			break;

		case 3:

			System.out.println("Enter the category:");
			String category = scanner.next();

			try {
				System.out.println(bookService.getBookbycategory(category));
			} catch (CategoryNotFoundException e) {
				System.out.println(e.getMessage());
			}
			break;

		default:
			System.exit(0);

		}
		scanner.close();
	}

}
