package com.lohithpuvvala.Online_Books_Store.mapper;

import com.lohithpuvvala.Online_Books_Store.dto.BookDto;
import com.lohithpuvvala.Online_Books_Store.entity.Book;

public class BookMapper {

    public static BookDto toDto(Book book){
        BookDto bookDto = new BookDto(
                            book.bookId(),
                            book.name(),
                            book.price(),
                            book.author(),
                            book.description()
                        );
        return bookDto;
    }

    public static Book toBook(BookDto bookDto){
        Book book = new Book(
                    bookDto.bookId(),
                    bookDto.name(),
                    bookDto.price(),
                    bookDto.author(),
                    bookDto.description()
                );
        return book;
    }
}
