package com.sq.bookstore.service;

import com.sq.bookstore.entity.*;
import com.sq.bookstore.mapper.ArticleMapper;
import com.sq.bookstore.mapper.CategoryMapper;
import com.sq.bookstore.mapper.ParagraphMapper;
import com.sq.bookstore.mapper.PhotoMapper;
import com.sq.bookstore.util.UuidUtil;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author:   chenfeiliang
 * Description:
 */
@Service
public class ArticleService {

   Logger logger = LoggerFactory.getLogger(ArticleService.class);

    @Autowired
    ArticleMapper articleMapper;

    @Autowired
    ParagraphMapper paragraphMapper;

    @Autowired
    PhotoMapper photoMapper;

    @Autowired
    CategoryMapper categoryMapper;


    //查询所有的类别
    public List<Article> list(){
        return articleMapper.list();
    }

    public ArticleDTO getArticleById(String id){


        ArticleDTO articleDTO = new ArticleDTO();

        Article article = articleMapper.getArticleById(id);

        Category category =categoryMapper.getCategoryById(article.getCategoryId());

        ParagraphExample paragraphExample = new ParagraphExample();
        ParagraphExample.Criteria criteria = paragraphExample.createCriteria();
        criteria.andArticleIdEqualTo(id);
        List<Paragraph> paragraphs = paragraphMapper.selectByExampleWithBLOBs(paragraphExample);

        PhotoExample photoExample = new PhotoExample();
        PhotoExample.Criteria criteria1 = photoExample.createCriteria();
        criteria.andArticleIdEqualTo(id);
        List<Photo> photos = photoMapper.selectByExample(photoExample);

        articleDTO.setTypeName(category.getTypeName());
        articleDTO.setArticle(article);
        articleDTO.setParagraphs(paragraphs);
        articleDTO.setPhotos(photos);


        return articleDTO;
    }

    public boolean deleteArticleById(String id){
        return articleMapper.deleteArticleById(id);
    }

    public boolean insertArticle(Article article){
        article.setArticleId(UuidUtil.getUUID32());
        return articleMapper.insertArticle(article);
    }

    public boolean updateArticle(Article article){
        return articleMapper.updateArticle(article);
    }
}