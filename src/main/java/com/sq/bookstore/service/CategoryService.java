package com.sq.bookstore.service;

import com.sq.bookstore.entity.Category;
import com.sq.bookstore.mapper.CategoryMapper;
import com.sq.bookstore.util.UuidUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

/**
 * Author:   chenfeiliang
 * Description:
 */
@Service
public class CategoryService {

    @Autowired
    CategoryMapper categoryMapper;

    //查询所有的类别
    public List<Category> list(){
        return categoryMapper.list();
    }

    //根据ID查询单条记录
    public Category getCategoryById(String categoryId){
        return categoryMapper.getCategoryById(categoryId);
    }

    //插入类别记录
    public boolean insertCategory(Category category){
        category.setCategoryId(UuidUtil.getUUID32());
        return categoryMapper.insertCategory(category.getCategoryId(),category.getTypeName(),category.getRemark(),
                category.getExt1(),category.getExt2(),category.getExt3());
    }

    //根据ID删除类别，如果删除成功，返回true
    public boolean deleteCategoryById(String id){
        boolean b = categoryMapper.deleteCategoryById(id);
        if(b){
            return true;
        }
        return false;
    }

    //根据ID更新类别记录
    public boolean updateCategoryById(Category category){
        boolean b = categoryMapper.updateByID(category.getCategoryId(), category.getTypeName(), category.getRemark(),
                category.getExt1(), category.getExt2(), category.getExt3());
        if(b){
            return true;
        }else{
            return false;
        }
    }
}