package com.devmeggie.blog_app.exceptions;

public class UnauthorizedException extends RuntimeException {
    private String message;

    public UnauthorizedException() {
        super("Unauthorized ");
        this.message = "Unauthorized";

    }

    public UnauthorizedException(String msg) {
        super(msg);
        this.message = msg;
    }
}

