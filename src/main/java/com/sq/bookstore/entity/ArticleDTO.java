package com.sq.bookstore.entity;

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