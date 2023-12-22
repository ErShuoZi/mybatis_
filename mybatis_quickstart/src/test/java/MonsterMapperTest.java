import com.entity.Monster;
import com.mapper.MonsterMapper;
import com.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

public class MonsterMapperTest {
    //属性
    private SqlSession sqlSession;
    private MonsterMapper monsterMapper;

    //完成初始化
    //@Before：当方法标注了@Before表示在执行目标测试方法前会先执行该方法
    @Before
    public void init() {
        //获取到sqlSession
        sqlSession = MybatisUtils.getSqlSession();
        //获取到MonsterMapper对象
        monsterMapper = sqlSession.getMapper(MonsterMapper.class);
    }


    @Test
    public void addMonster() {
        for (int i = 0; i < 2; i++) {
            Monster monster = new Monster();
            monster.setAge(10 + i);
            monster.setBirthday(new Date());
            monster.setEmail("kate@qq.com");
            monster.setGender(1);
            monster.setName("哈ha" + i);
            monster.setSalary(1000 + i * 10);
            monsterMapper.addMonster(monster);
            System.out.println("添加对象--" + monster);
            System.out.println("添加到表后自增长id=" + monster.getId());
        }
        //如果是增删改，则需要提交事务
        if (sqlSession != null){
            sqlSession.commit();
            sqlSession.close();
        }
    }
    @Test
    public void delMonster() {
       monsterMapper.delMonster(10);
       if (sqlSession != null) {
           sqlSession.commit();
           sqlSession.close();
       }
        System.out.println("删除成功");

    }

    @Test
    public void updateMonster() {
        Monster monster = new Monster();
        monster.setAge(50);
        monster.setBirthday(new Date());
        monster.setEmail("xxx@qq.com");
        monster.setGender(0);
        monster.setName("wawa");
        monster.setSalary(2000);
        monster.setId(15);
        monsterMapper.updateMonster(monster);
        if (sqlSession != null) {
            sqlSession.commit();
            sqlSession.close();
        }
        System.out.println("修改成功");

    }
}
