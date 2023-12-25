package com;

import com.entity.IdenCard;
import com.mapper.IdenCardMapper;
import com.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;

public class IdenCardMapperTest {

    private SqlSession sqlSession;
    private IdenCardMapper idenCardMapper;

    @Before
    public void init() {
        sqlSession = MybatisUtils.getSqlSession();
        idenCardMapper = sqlSession.getMapper(IdenCardMapper.class);
    }

    @Test
    public void  getIdenCardById() {
        IdenCard idenCard = idenCardMapper.getIdenCardById(1);
        System.out.println("idenCard=" + idenCard);
        if (sqlSession!=null) {
            sqlSession.commit();
            sqlSession.close();
        }
    }
}
