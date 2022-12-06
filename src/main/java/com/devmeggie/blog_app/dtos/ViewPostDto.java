package com.devmeggie.blog_app.dtos;

import lombok.*;

@Getter
@Setter
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ViewPostDto {
    private String title;
    private String imageUrl;
    private String content;
    private Integer likes;
    private Integer comments;
}
