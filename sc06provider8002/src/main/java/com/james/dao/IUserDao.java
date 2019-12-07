package com.james.dao;

import com.james.pojo.Users;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface IUserDao {

    @Select("select * from users")
    List<Users> getALlUsers();

    @Insert("insert into users values(null, #{username}, #{password}, #{tel}, #{addr})")
    int saveUsers(Users u);

    @Select("select * from users where uid= #{uid}")
    Users getUserByUid(int uid);
}
