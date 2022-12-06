package com.devmeggie.blog_app.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name ="post")
public class Post extends BaseClass{

    @Column(nullable = false,unique = true,length = 50)
    private String title;

    @Column(nullable = false,length = 200)
    private String content;

    private String imageUrl;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "category_category_id",referencedColumnName = "category_id")
    private Category category;


    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Comment> comment = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "post",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Like> like;

}
