import com.entity.Monster;

import com.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;
import java.util.List;

public class MybatisNativeTest {
    private SqlSession sqlSession;
    @Before
    public void init() {
        //获取到sqlSession
        sqlSession = MybatisUtils.getSqlSession();
    }


    @Test
    public void myBatisNativeCrudTest(){
        //添加
//        Monster monster = new Monster();
//        monster.setAge(100);
//        monster.setBirthday(new Date());
//        monster.setEmail("kate@aa.com");
//        monster.setGender(0);
//        monster.setName("xx");
//        monster.setSalary(1000);
//        /**
//         * insert(接口声明的方法，对象)
//         */
//        sqlSession.insert("com.mapper.MonsterMapper.addMonster", monster);
//        if(sqlSession != null) {
//            sqlSession.commit();
//            sqlSession.close();
//        }
//        System.out.println("操作成功");


        //删除
//        int delete = sqlSession.delete("com.mapper.MonsterMapper.delMonster", 23);
//        System.out.println("delete.." + delete);
//        if (sqlSession!=null) {
//            sqlSession.commit();
//            sqlSession.close();
//        }


        //修改

//        Monster monster = new Monster();
//        monster.setAge(30);
//        monster.setBirthday(new Date());
//        monster.setEmail("kate@cc.com");
//        monster.setGender(1);
//        monster.setName("bb");
//        monster.setSalary(2000);
//        monster.setId(22);
//        int update = sqlSession.update("com.mapper.MonsterMapper.updateMonster", monster);
//        if (sqlSession!=null) {
//            sqlSession.commit();
//            sqlSession.close();
//        }
//        System.out.println("update.." + update);


        //查询

        List<Monster> monsters = sqlSession.selectList("com.mapper.MonsterMapper.findAllMonster");
        for (Monster monster : monsters) {
            System.out.println(monster);
        }

    }
}
