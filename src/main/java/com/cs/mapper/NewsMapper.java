package com.cs.mapper;

import com.cs.entity.News;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface NewsMapper {

    //查询新闻表所有记录 select * from news
    public List<News> findAllNews() throws Exception;

    //查询新闻表所有信息的总记录数 select count(*) from news
    public int findByNewsCount() throws Exception;

    //修改新闻ID为XX的新闻标题和新闻内容
    public int updateNews(News news) throws Exception;

    //删除新闻ID为XX的新闻
    public int deleteNews(int newsID) throws Exception;

}
