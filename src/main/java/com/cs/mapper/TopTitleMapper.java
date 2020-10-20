package com.cs.mapper;

import com.cs.entity.TopTitle;

import java.util.List;

public interface TopTitleMapper {

    //查询标题表所有记录 select * from toptitle
    public List<TopTitle> findAllTopTitle() throws Exception;

}
