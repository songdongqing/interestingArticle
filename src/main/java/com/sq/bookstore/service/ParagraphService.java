package com.sq.bookstore.service;

import com.sq.bookstore.entity.Paragraph;
import com.sq.bookstore.mapper.ArticleMapper;
import com.sq.bookstore.mapper.ParagraphMapper;
import com.sq.bookstore.util.UuidUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author:   chenfeiliang
 * Description:
 */
@Service
public class ParagraphService {

    @Autowired
    ParagraphMapper paragraphMapper;
    @Autowired
    ArticleMapper articleMapper;

    public int insert(List<Paragraph> paragraphs,String articleId){
        for(Paragraph paragraph:paragraphs){
            paragraph.setArticleId(articleId);
            paragraph.setParagraphId(UuidUtil.getUUID32());
            int i = paragraphMapper.insert(paragraph);
        }
        return 0;
    }

    public int updateByPrimaryKey(List<Paragraph> paragraphs){
        for(Paragraph paragraph:paragraphs){
            paragraphMapper.updateByPrimaryKeySelective(paragraph);
        }
        return 0;
    }
}