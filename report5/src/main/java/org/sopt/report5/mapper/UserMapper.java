package org.sopt.report5.mapper;

import org.apache.ibatis.annotations.*;
import org.sopt.report5.dto.User;
import org.sopt.report5.model.SignUpReq;

import java.util.List;

/**
 * Created by bomi on 2018-11-23.
 */

@Mapper
public interface UserMapper {
    @Select("SELECT * FROM user_rp")
    List<User> findAll();

    @Select("SELECT * FROM user_rp WHERE idx = #{idx}")
    User findByUserIdx(@Param("idx")final int idx);

    @Select("SELECT * FROM user_rp WHERE name = #{name}")
    List<User> findUserByName(@Param("name")final String name);

    @Select("SELECT * FROM user_rp WHERE part = #{part}")
    List<User> findUserByPart(@Param("part")final String part);

    @Insert("INSERT INTO user_rp(idx, name, part, profileUrl) VALUES(#{signUpReq.name}, #{signUpReq.part}, #{signUpReq.profileUrl})")
    void save(@Param("signUpReq")final SignUpReq signUpReq);

    @Update("UPDATE user_rp SET name = #{signUpReq.name}, part = #{signUpReq.part}, profileUrl = #{signUpReq.profileUrl} WHERE idx = #{idx}")
    void update(@Param("idx")final int idx, @Param("signUpReq")final SignUpReq signUpReq);

    @Delete("DELETE FROM user_rp WHERE idx = #{idx}")
    void delete(@Param("idx")final int idx);
}
