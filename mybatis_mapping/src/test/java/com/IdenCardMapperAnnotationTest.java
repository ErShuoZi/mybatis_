package com;

import com.entity.IdenCard;
import com.mapper.IdenCardMapperAnnotation;
import com.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;

public class IdenCardMapperAnnotationTest {

    private SqlSession sqlSession;
    private IdenCardMapperAnnotation idenCardMapperAnnotation;

    @Before
    public void init() {
        sqlSession = MybatisUtils.getSqlSession();
        idenCardMapperAnnotation = sqlSession.getMapper(IdenCardMapperAnnotation.class);
    }
    @Test
    public void getIdenCardByIdAnnotation() {
        IdenCard idenCard = idenCardMapperAnnotation.getIdenCardByIdAnnotation(1);
        System.out.println("idenCardAnnotation=" + idenCard);
    }
}
