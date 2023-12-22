package com;

import com.entity.User;
import com.mapper.UserMapper;
import com.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class UserMapperTest {
    private SqlSession sqlSession;
    private UserMapper userMapper;
    @Before
    public void init() {
        sqlSession = MybatisUtils.getSqlSession();
        userMapper = sqlSession.getMapper(UserMapper.class);
    }


    @Test
    public void addUser() {
        User user = new User();
        user.setUseremail("haha.com");
        user.setUsername("zhangsan");
        userMapper.addUser(user);
        if (sqlSession != null) {
            sqlSession.commit();
            sqlSession.close();
        }
        System.out.println("操作成功");
    }


    @Test
    public void findAllUser() {

        List<User> allUser = userMapper.findAllUser();
        for (User user : allUser) {
            System.out.println(user);
        }
        if (sqlSession != null) {
            sqlSession.commit();
            sqlSession.close();
        }
        System.out.println("操作成功");
    }
}
