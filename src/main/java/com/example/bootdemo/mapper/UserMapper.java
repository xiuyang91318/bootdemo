package com.example.bootdemo.mapper;

import com.example.bootdemo.model.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface UserMapper {
    @Delete({
            "delete from t_user",
            "where user_id = #{userId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer userId);

    @Insert({
            "insert into t_user (user_id, user_name, ",
            "password, phone)",
            "values (#{userId,jdbcType=INTEGER}, #{userName,jdbcType=VARCHAR}, ",
            "#{password,jdbcType=VARCHAR}, #{phone,jdbcType=VARCHAR})"
    })
    int insert(User record);

    @InsertProvider(type=UserSqlProvider.class, method="insertSelective")
    int insertSelective(User record);

    @Select({
            "select",
            "user_id, user_name, password, phone",
            "from t_user",
            "where user_id = #{userId,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="user_name", property="userName", jdbcType=JdbcType.VARCHAR),
            @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
            @Result(column="phone", property="phone", jdbcType=JdbcType.VARCHAR)
    })
    User selectByPrimaryKey(Integer userId);


    @Select({
            "select",
            "user_id, user_name, password, phone",
            "from t_user"
    })
    @Results({
            @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="user_name", property="userName", jdbcType=JdbcType.VARCHAR),
            @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
            @Result(column="phone", property="phone", jdbcType=JdbcType.VARCHAR)
    })
    public List<User> selectAllUser();

    @UpdateProvider(type= UserSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(User record);

    @Update({
            "update t_user",
            "set user_name = #{userName,jdbcType=VARCHAR},",
            "password = #{password,jdbcType=VARCHAR},",
            "phone = #{phone,jdbcType=VARCHAR}",
            "where user_id = #{userId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(User record);
}
