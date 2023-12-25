package com;

import com.entity.IdenCard;
import com.entity.Person;
import com.mapper.IdenCardMapper;
import com.mapper.PersonMapper;
import com.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;

public class PersonMapperTest {
    private SqlSession sqlSession;
    private PersonMapper personMapper;

    @Before
    public void init() {
        sqlSession = MybatisUtils.getSqlSession();
        personMapper = sqlSession.getMapper(PersonMapper.class);
    }

    @Test
    public void  getPersonById() {
        Person person = personMapper.getPersonById(1);
        System.out.println("person=" + person);
        if (sqlSession!=null) {
            sqlSession.commit();
            sqlSession.close();
        }
    }
}
