package com.sq.bookstore.controller;

import com.sq.bookstore.entity.Article;
import com.sq.bookstore.entity.ArticleDTO;
import com.sq.bookstore.entity.Category;
import com.sq.bookstore.service.ArticleService;
import com.sq.bookstore.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Author:   chenfeiliang
 * Description:
 */
@Controller
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    ArticleService articleService;
    @Autowired
    CategoryService categoryService;
    @Autowired
    StringRedisTemplate stringRedisTemplate;


    //查询 List
    @RequestMapping("/list")
    @ResponseBody
    public List<Article> list(){
        return articleService.list();
    }

    //根据ID删除记录
    @ResponseBody
    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id") String id){
        boolean b = articleService.deleteArticleById(id);
        if(b){
            return "删除成功";
        }else {
            return "删除失败";
        }
    }

    //根据ID查询单个记录
    @ResponseBody
    @RequestMapping("/{id}")
    public ArticleDTO getArticleById(@PathVariable("id") String id){
        //用户每次访问文章的详情页面，计数器就+1,以文章的ID作为主键

//        if(stringRedisTemplate.opsForValue().get(id)==null){
//            stringRedisTemplate.opsForValue().set(id,"1");
//        }else{
//            stringRedisTemplate.opsForValue().increment(id);
//
//        }
//        String count = (String) stringRedisTemplate.opsForValue().get(id);
//
//        ArticleDTO articleDTO =  articleService.getArticleById(id);
//
//        articleDTO.getArticle().setLookNum(Integer.parseInt(count));

        /*
         * 功能描述:
         * 注意命名的问题，不能重复，因为redis有缓存
         *
         * @param:   [id]
         * @return : com.sq.bookstore.entity.ArticleDTO
         * @author : chenfeiliang
         */
         if(stringRedisTemplate.opsForHash().get("num",id)==null){
             stringRedisTemplate.opsForHash().put("num",id,"1");
         }else{
             stringRedisTemplate.opsForHash().increment("num",id,1);
         }
        String count = (String) stringRedisTemplate.opsForHash().get("num",id);

        ArticleDTO articleDTO =  articleService.getArticleById(id);

         articleDTO.getArticle().setLookNum(Integer.parseInt(count));
        return articleDTO;
    }

    //添加记录
    @RequestMapping("/insert")
    @ResponseBody
    public String insertArticle(Article article){

        Category category = categoryService.getCategoryById(article.getCategoryId());
        if(category==null){
            return "无该类别";
        }
        boolean b = articleService.insertArticle(article);
        if(b){
            return "添加成功";
        }else{
            return "添加失败";
        }
    }

    //根据ID更新记录
    @RequestMapping("/update")
    @ResponseBody
    public String updateArticle(Article article){
        boolean b = articleService.updateArticle(article);
        if(b){
            return "更新成功";
        }else {
            return "更新失败";
        }
    }

}