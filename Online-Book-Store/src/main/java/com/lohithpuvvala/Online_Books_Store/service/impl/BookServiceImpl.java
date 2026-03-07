package com.lohithpuvvala.Online_Books_Store.service.impl;

import com.lohithpuvvala.Online_Books_Store.dto.BookDto;
import com.lohithpuvvala.Online_Books_Store.entity.Book;
import com.lohithpuvvala.Online_Books_Store.mapper.BookMapper;
import com.lohithpuvvala.Online_Books_Store.repository.BookRepository;
import com.lohithpuvvala.Online_Books_Store.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class BookServiceImpl implements BookService {

    @Autowired
    BookRepository bookRepository;

    @Override
    public BookDto getBook(String bookId) {
        Book book = bookRepository.findByBookId(bookId);
        BookDto bookDto = BookMapper.toDto(book);
        return bookDto;
    }

    @Override
    public List<BookDto> getAllBooks() {
        List<Book> books = bookRepository.findAll();
        List<BookDto> bookDtoList = new ArrayList<>();
        for (Book book : books) {
            bookDtoList.add(BookMapper.toDto(book));
        }
        return bookDtoList;
    }

    @Override
    public BookDto createBook(BookDto bookDto) {
        Book book = bookRepository.insert(BookMapper.toEntity(bookDto));
        return BookMapper.toDto(book);
    }

    @Override
    public BookDto updateBookName(BookDto bookDto) {
        bookRepository.updateBookNameByBookId(bookDto.bookId(), bookDto.name());
        Book book = bookRepository.findByBookId(bookDto.bookId());
        return BookMapper.toDto(book);
    }

    @Override
    public void deleteBookByBookId(String bookId) {
        bookRepository.deleteBookByBookId(bookId);
    }
}
