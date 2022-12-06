package com.devmeggie.blog_app.pojos;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Data
public class ApiResponse {
    private String message;
    private Integer status;
    private HttpStatus httpStatus;
}
