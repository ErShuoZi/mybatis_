package com.mapper;

import com.entity.Monster;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 使用注解的方式配置接口方法
 */
public interface MonsterAnnotation {
    /**
     * 使用注解方式配置接口方法addMonster
     *  <insert
     *             id="addMonster"
     *             parameterType="com.entity.Monster"
     *             useGeneratedKeys="true"
     *             keyProperty="id"
     *     >
     *         INSERT INTO `monster`
     *         (`age`, `birthday`, `email`, `gender`, `name`, `salary`)
     *         VALUES (#{age}, #{birthday}, #{email}, #{gender}, #{name}, #{salary});
     *     </insert>
     * @param monster
     */
    //添加Monster
    @Insert(value = "INSERT INTO `monster` (`age`, `birthday`, `email`, `gender`, `name`, `salary`) VALUES (#{age}, #{birthday}, #{email}, #{gender}, #{name}, #{salary});")
    /**
     * useGeneratedKeys:可以返回自增的值
     * keyProperty:自增值对应的对象的属性是哪个
     * keyColumn:自增值对应表的字段
     */
    @Options(useGeneratedKeys = true,keyProperty = "id",keyColumn = "id")
    public void addMonster(Monster monster);

    //删除Monster
    @Delete(value = "DELETE FROM `monster` WHERE id = #{id};")
    public void delMonster(Integer id);

    //修改
    @Update(value = "  UPDATE  `monster`  SET `age` = #{age},`birthday` = #{birthday},`email` = #{email},`gender` = #{gender},\n" +
            "        `name`=#{name},`salary`= #{salary} WHERE id = #{id};")
    public void updateMonster(Monster monster);

    @Select(value = " SELECT * FROM `monster` WHERE id = #{id};")
    public Monster getMonsterById(Integer id);
    @Select(value = "SELECT * FROM `monster`;")
    public List<Monster> findAllMonster();
}
