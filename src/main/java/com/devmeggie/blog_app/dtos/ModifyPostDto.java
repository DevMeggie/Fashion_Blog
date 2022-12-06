package com.devmeggie.blog_app.dtos;

import lombok.*;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ModifyPostDto {
    private String title;
    private String imageUrl;
    private String content;

}
