package com.sq.bookstore.entity;

import lombok.Data;

/**
 * Author:   chenfeiliang
 * Description:
 */
@Data
public class Article {

    private String articleId;
    //多对一关系
    private Category category;
    private String categoryId;
    private String title;
    private String content;
    private Integer lookNum;
    private Integer loveNum;
    private String ext1;
    private String ext2;
    private String ext3;
}