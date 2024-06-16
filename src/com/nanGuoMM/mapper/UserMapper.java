package com.nanGuoMM.mapper;

import com.nanGuoMM.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    User selectUser(@Param("username") String username,@Param("password") String password);

    User selectUserByName(String username);

    void addUser(User user);
}
