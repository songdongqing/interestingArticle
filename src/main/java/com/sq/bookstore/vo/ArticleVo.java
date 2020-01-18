package com.sq.bookstore.vo;

import com.sq.bookstore.entity.Article;
import com.sq.bookstore.entity.Category;
import com.sq.bookstore.entity.Paragraph;
import com.sq.bookstore.entity.Photo;
import lombok.Data;

import java.util.List;

/**
 * Author:   chenfeiliang
 * Description:
 */

@Data
public class ArticleVo {
    private Article article;

    private List<Paragraph> paragraphs;

    private List<Photo> photos;

}