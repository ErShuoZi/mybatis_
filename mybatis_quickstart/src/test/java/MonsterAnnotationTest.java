import com.entity.Monster;
import com.mapper.MonsterAnnotation;
import com.mapper.MonsterMapper;
import com.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

public class MonsterAnnotationTest {
    //属性
    private SqlSession sqlSession;
    private MonsterAnnotation monsterAnnotation;

    //完成初始化
    //@Before：当方法标注了@Before表示在执行目标测试方法前会先执行该方法
    @Before
    public void init() {
        //获取到sqlSession
        sqlSession = MybatisUtils.getSqlSession();
        monsterAnnotation = sqlSession.getMapper(MonsterAnnotation.class);
        System.out.println(monsterAnnotation.getClass());
    }


    @Test
    public void addMonster() {
        Monster monster = new Monster();
        monster.setAge(40);
        monster.setBirthday(new Date());
        monster.setEmail("kate@aa.com");
        monster.setGender(1);
        monster.setName("yaya");
        monster.setSalary(9000);
        monsterAnnotation.addMonster(monster);
        System.out.println("添加后monster的id="  + monster.getId());
        if (sqlSession != null) {
            sqlSession.commit();
            sqlSession.close();
        }
        System.out.println("bao cun chenggong");

    }
}
