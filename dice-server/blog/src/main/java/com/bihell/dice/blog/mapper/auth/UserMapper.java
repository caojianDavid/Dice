package com.bihell.dice.blog.mapper.auth;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bihell.dice.blog.model.auth.User;
import com.bihell.dice.blog.model.params.QueryParam;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * User Mapper
 *
 * @author bihell
 * @since 2017/7/12 21:34
 */
public interface UserMapper extends BaseMapper<User> {

    IPage<User> queryByParam(@Param("pg") Page<User> page, @Param("queryParam") QueryParam queryParam);

    @Insert("INSERT INTO USER(username, password_md5) VALUES(#{username}, #{passwdMd5})")
    int insert(@Param("username") String username, @Param("passwdMd5") String passwdMd5);

    @Insert("INSERT INTO USER(username, password_md5) VALUES(#{username,jdbcType=VARCHAR}, #{passwdMd5,jdbcType=VARCHAR})")
    int insertByMap(Map<String, Object> map);

    @Insert("INSERT INTO USER(username, password_md5) VALUES(#{username}, #{passwordMd5})")
    int insertByObject(User user);
}
