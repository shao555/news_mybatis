package com.cs.test;

import com.cs.entity.News;
import com.cs.entity.TopTitle;
import com.cs.entity.UserInfo;
import com.cs.mapper.NewsMapper;
import com.cs.mapper.TopTitleMapper;
import com.cs.mapper.UserInfoMapper;
import com.cs.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class MybatisTest {

    public static void main(String[] args) throws Exception {

        //查询新闻表所有记录
//        findAllNews();

        //查询标题表所有记录
//        findAllTopTitle();

        //查询用户表所有记录
//        findAllUserInfo();

        //查询新闻表所有信息的总记录数
//        findByNewsCount();

        //修改新闻ID为XX的新闻标题和新闻内容

        //修改新闻ID为XX的新闻标题和新闻内容
//        updateNews();

        //删除新闻ID为XX的新闻
        deleteNews();
    }

    private static void deleteNews() throws Exception {
        SqlSession sqlSession = MybatisUtil.createSqlSession();
        int i = sqlSession.getMapper(NewsMapper.class).deleteNews(7);
        if (i > 0) {
            System.out.println("删除成功!");
        } else {
            System.out.println("删除失败");
        }
    }

    private static void updateNews() throws Exception {
        SqlSession sqlSession = MybatisUtil.createSqlSession();
        News news = new News();
        news.setNewTitle("孙笑川暴打乔尔狗头");
        news.setNewsContent("肖战出售高尔夫球杆");
        news.setNewsID(5);
        int i = sqlSession.getMapper(NewsMapper.class).updateNews(news);
        if (i > 0) {
            System.out.println("修改成功!");
        } else {
            System.out.println("修改失败");
        }
    }

    private static void findByNewsCount() throws Exception {
        SqlSession sqlSession = MybatisUtil.createSqlSession();
        int i = sqlSession.getMapper(NewsMapper.class).findByNewsCount();
        System.out.println("总记录数: " + i);
    }

    private static void findAllUserInfo() throws Exception {
        SqlSession sqlSession = MybatisUtil.createSqlSession();
        List<UserInfo> ulist = sqlSession.getMapper(UserInfoMapper.class).findAllUserInfo();
        for (UserInfo u : ulist) {
            System.out.println(
                    u.getUserID() + " " + u.getUserName() + " " + u.getUserPass()
                    + " " + u.getSex() + " " + u.getAge() + " " + u.getEmail()
            );
        }
    }

    private static void findAllTopTitle() throws Exception {
        SqlSession sqlSession = MybatisUtil.createSqlSession();
        List<TopTitle> tlist = sqlSession.getMapper(TopTitleMapper.class).findAllTopTitle();
        for (TopTitle t : tlist) {
            System.out.println(
                    t.getTopID() + " " + t.getTopTitle() + " " + t.getSendDate()
                    + " " + t.getUserID()
            );
        }
    }

    private static void findAllNews() throws Exception {
        SqlSession sqlSession = MybatisUtil.createSqlSession();
        List<News> nlist = sqlSession.getMapper(NewsMapper.class).findAllNews();
        for (News n : nlist) {
            System.out.println(
                    n.getNewsID() + " " + n.getNewTitle() + " " + n.getNewsContent()
                    + " " + n.getSendDate() + " " + n.getUserID() + " " + n.getTopID()
            );
        }
    }
}
