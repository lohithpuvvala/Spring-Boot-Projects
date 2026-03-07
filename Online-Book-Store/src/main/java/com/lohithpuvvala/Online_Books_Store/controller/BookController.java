package com.lohithpuvvala.Online_Books_Store.controller;

import com.lohithpuvvala.Online_Books_Store.dto.BookDto;
import com.lohithpuvvala.Online_Books_Store.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.support.SimpleTriggerContext;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/book-store")
public class BookController {

    @Autowired
    BookService  bookService;

    @GetMapping("/welcome")
    public ResponseEntity<String> welcome(){
        return new ResponseEntity<>("<h1>Welcome to the Book Store</h1>",HttpStatus.OK);
    }

    @GetMapping("/{bookId}")
    public ResponseEntity<BookDto> getBook(@PathVariable String bookId){
        BookDto bookDto = bookService.getBook(bookId);
        return new ResponseEntity<>(bookDto, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<BookDto>> getAllBooks(){
        List<BookDto> bookDtoList = bookService.getAllBooks();
        return new ResponseEntity<>(bookDtoList, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<BookDto> createBook(@RequestBody BookDto bookDto){
        BookDto CreateBookDto = bookService.createBook(bookDto);
        return new ResponseEntity<>(CreateBookDto, HttpStatus.OK);
    }

    @PutMapping("/")
    public ResponseEntity<BookDto> updateBook(BookDto bookDto){
        BookDto updateBookDto = bookService.updateBookName(bookDto);
        return new ResponseEntity<>(updateBookDto, HttpStatus.OK);
    }

    @DeleteMapping("/{bookId}")
    public ResponseEntity<String> deleteBook(@PathVariable String bookId){
        bookService.deleteBookByBookId(bookId);
        return new ResponseEntity<>("Book Deleted Successfully: "+bookId, HttpStatus.OK);
    }
}
