package com.lohithpuvvala.Online_Books_Store.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.support.SimpleTriggerContext;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/book-store")
public class BookController {

    @GetMapping("/{bookId}")
    public ResponseEntity<String> getBook(@PathVariable String bookId){
        return new ResponseEntity<>("Book Found " + bookId, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<String>> getAllBooks(){
        List<String> books = new ArrayList();
        books.add("Java book");
        books.add("Python book");
        books.add("C# book");
        books.add("C++ book");
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<String> createBook(String book){
        return new ResponseEntity<>("Book Created", HttpStatus.OK);
    }

    @PutMapping("/")
    public ResponseEntity<String> updateBook(String book){
        return new ResponseEntity<>("Book Updated Succesfully: ", HttpStatus.OK);
    }

    @DeleteMapping("/{bookId}")
    public ResponseEntity<String> deleteBook(@PathVariable String bookId){
        return new ResponseEntity<>("Book Deleted Successfully: "+bookId, HttpStatus.OK);
    }
}
