package com.rest.javacrudmysqlrest.exception;

public class PostNotFoundException extends Exception  {
    private long book_id;
    public PostNotFoundException(long post_id) {
        super(String.format("Post is not found with id : '%s'", post_id));
    }
}
