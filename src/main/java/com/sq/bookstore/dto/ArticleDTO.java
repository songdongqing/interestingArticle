package com.sq.bookstore.dto;

import com.sq.bookstore.entity.Article;
import com.sq.bookstore.entity.Paragraph;
import com.sq.bookstore.entity.Photo;
import lombok.Data;

import java.util.List;

/**
 * Author:   chenfeiliang
 * Description:
 */

@Data
public class ArticleDTO {
    private String typeName;

    private Article article;

    private List<Paragraph> paragraphs;

    private List<Photo> photos;

}