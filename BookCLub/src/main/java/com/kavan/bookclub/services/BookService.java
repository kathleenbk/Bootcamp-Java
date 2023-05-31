package com.kavan.bookclub.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.kavan.bookclub.models.Book;
import com.kavan.bookclub.repositories.BookRepository;

@Service
public class BookService {
//	Member Variable is the Repository
	private final BookRepository bookRepository;

//	Constructor
	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

//	Create
	public Book createBook(Book book) {
		return bookRepository.save(book);
	}

//	Read All
	public List<Book> allBooks() {
		return bookRepository.findAll();
	}

//	Read One
	public Book oneBook(Long id) {
		Optional<Book> book = bookRepository.findById(id);
		if (book.isPresent()) {
			return book.get();
		} else {
			return null;
		}
	}

//	Read All By User
	public List<Book> userBooks(Long userId) {
		return bookRepository.findByUserId(userId);
	}

//	Update
	public Book updateBook(Book book) {
		return bookRepository.save(book);
	}

//	Delete
	public void deleteBook(Book book) {
		bookRepository.delete(book);
	}
}
