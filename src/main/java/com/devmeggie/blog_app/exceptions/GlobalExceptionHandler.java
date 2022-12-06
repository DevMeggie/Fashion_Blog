package com.devmeggie.blog_app.exceptions;

import com.devmeggie.blog_app.pojos.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@RequiredArgsConstructor
public class GlobalExceptionHandler {
    //private final ApiResponse apiResponse;

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ApiResponse handleNotFoundException(NotFoundException ex){
        return new ApiResponse(ex.getMessage(),HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(AlreadyExistException.class)
    @ResponseStatus(HttpStatus.ALREADY_REPORTED)
    @ResponseBody
    public ApiResponse handlerAlreadyExistException(NotFoundException ex){
        return new ApiResponse(ex.getMessage(),HttpStatus.NOT_FOUND.value(), HttpStatus.ALREADY_REPORTED);
    }

    @ExceptionHandler(UnauthorizedException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ResponseBody
    public ApiResponse handlerAlreadyExistException(UnauthorizedException ex){
        return new ApiResponse(ex.getMessage(),HttpStatus.UNAUTHORIZED.value(), HttpStatus.UNAUTHORIZED);
    }


}
