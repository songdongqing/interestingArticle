package com.sq.bookstore.mapper;

import com.sq.bookstore.entity.Paragraph;
import com.sq.bookstore.entity.ParagraphExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ParagraphMapper {
    long countByExample(ParagraphExample example);

    int deleteByExample(ParagraphExample example);

    int deleteByPrimaryKey(String paragraphId);

    int insert(Paragraph record);

    int insertSelective(Paragraph record);

    List<Paragraph> selectByExampleWithBLOBs(ParagraphExample example);

    List<Paragraph> selectByExample(ParagraphExample example);

    Paragraph selectByPrimaryKey(String paragraphId);

    int updateByExampleSelective(@Param("record") Paragraph record, @Param("example") ParagraphExample example);

    int updateByExampleWithBLOBs(@Param("record") Paragraph record, @Param("example") ParagraphExample example);

    int updateByExample(@Param("record") Paragraph record, @Param("example") ParagraphExample example);

    int updateByPrimaryKeySelective(Paragraph record);

    int updateByPrimaryKeyWithBLOBs(Paragraph record);

    int updateByPrimaryKey(Paragraph record);
}