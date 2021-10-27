package com.bookapp.service;

import java.util.List;

import com.bookapp.bean.Book;
import com.bookapp.execution.AuthorNotFoundException;
import com.bookapp.execution.CategoryNotFoundException;

public interface BookInter {
	
	void addBook(Book book);
	List<Book> getAllBooks();
	List<Book> getBookbycategory(String category)throws CategoryNotFoundException;
	List<Book> getBookbyAuthor(String author) throws AuthorNotFoundException;


}
