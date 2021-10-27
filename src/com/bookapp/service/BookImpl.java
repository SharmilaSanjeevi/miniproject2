package com.bookapp.service;

import java.util.*;

import com.bookapp.bean.Book;
import com.bookapp.execution.AuthorNotFoundException;
import com.bookapp.execution.CategoryNotFoundException;

public class BookImpl implements BookInter {

    List<Book> bookList = new ArrayList<>();

    @Override
    public void addBook(Book book) {
        // TODO Auto-generated method stub

        bookList.add(book);
    }

    @Override
    public List<Book> getAllBooks() {

        // TODO Auto-generated method stub
    	
        Collections.sort(bookList, Comparator.comparing(Book::getAuthor));

        return bookList;

    }

    @Override
    public List<Book> getBookbyAuthor(String author) throws AuthorNotFoundException {
        // TODO Auto-generated method stub

        List<Book> result = new ArrayList<>();

        for (Book book : bookList) {
        	
            if (author.equals(book.getAuthor())) {
                result.add(book);
            }
        }

        if(result.isEmpty()) throw new AuthorNotFoundException();

        return result;
    }

//    public List<Book> allBooks() {
//        // TODO Auto-generated method stub
//        return Arrays.asList(new Book("Data Structure", "Sharma", "latest", 3546, 121),
//                new Book("oops", "Agarval", "Current", 1546, 131),
//                new Book("Developers Hint", "RohitSharma", "latestEdition", 2346, 161));
//
//    }

    @Override
    public List<Book> getBookbycategory(String category) throws CategoryNotFoundException {
        // TODO Auto-generated method stub

        List<Book> result = new ArrayList<>();

        for (Book book : bookList) {
        	
            if (category.equals(book.getCategory())) {
                result.add(book);
            }
        }

        if(result.isEmpty()) throw new CategoryNotFoundException();

        return result;

    }

    

}
