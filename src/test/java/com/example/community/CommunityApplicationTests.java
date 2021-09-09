package com.example.community;


import com.example.community.Mapper.DiscussPostMapper;
import com.example.community.Mapper.UserMapper;
import com.example.community.entity.DiscussPost;
import com.example.community.entity.User;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
class CommunityApplicationTests {


    @Autowired
    private UserMapper userMapper;

    @Autowired
    private DiscussPostMapper discussPostMapper;



    @Test
    void testSelectPost(){
        List<DiscussPost> list = discussPostMapper.selectDiscussPosts(149, 0, 10);
        for (DiscussPost discussPost : list){
            System.out.println(discussPost);
        }

        int rows = discussPostMapper.selectDiscussPostsRows(0);

        System.out.println(rows);
    }


    @Test
    void testSelectUserById(){
        User user = userMapper.selectById(11);
        System.out.println(user);
    }

    public static Logger logger = LoggerFactory.getLogger(CommunityApplicationTests.class);

    @Test
    public void testLogger(){
        System.out.println(logger.getName());

        logger.debug("debug log");
        logger.error("error log");
        logger.info("info log");
        logger.warn("warn log");
    }



}
