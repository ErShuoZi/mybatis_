package com;

import com.entity.IdenCard;
import com.entity.Person;
import com.mapper.IdenCardMapperAnnotation;
import com.mapper.PersonMapper;
import com.mapper.PersonMapperAnnotation;
import com.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;

public class PersonMapperAnnotationTest {
    private SqlSession sqlSession;
    private PersonMapperAnnotation personMapperAnnotation;

    @Before
    public void init() {
        sqlSession = MybatisUtils.getSqlSession();
        personMapperAnnotation = sqlSession.getMapper(PersonMapperAnnotation.class);
    }

    @Test
    public void getPersonByIdAnnotation() {
        Person person= personMapperAnnotation.getPersonByIdAnnotation(1);
        System.out.println("personAnnotation=" + person);
    }
}
