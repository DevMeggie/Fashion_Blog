package com.devmeggie.blog_app.pagination_criteria;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class PostPage {
    private Integer pageNumber = 0;
    private Integer pageSize = 2;
    private Sort.Direction sortDirection = Sort.Direction.ASC;
    private String sortBy = "id";

}
