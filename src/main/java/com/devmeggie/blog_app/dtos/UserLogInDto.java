package com.devmeggie.blog_app.dtos;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UserLogInDto {
    private String email;
    private String password;
}
