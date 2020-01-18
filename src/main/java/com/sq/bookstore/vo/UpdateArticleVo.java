package com.sq.bookstore.vo;

import com.sq.bookstore.entity.Article;
import com.sq.bookstore.entity.Paragraph;
import com.sq.bookstore.entity.Photo;
import lombok.Data;

import java.util.List;

/**
 * Author:   chenfeiliang
 * Description: Vo是接收前端传过来的数据类
 */
@Data
public class UpdateArticleVo {

    private Article article;

    private List<Paragraph> paragraphs;

    private List<Photo> photos;

}