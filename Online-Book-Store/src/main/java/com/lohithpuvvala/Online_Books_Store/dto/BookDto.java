package com.lohithpuvvala.Online_Books_Store.dto;

public record BookDto(
        String bookId,
        String name,
        String price,
        String author,
        String description
) {
}
