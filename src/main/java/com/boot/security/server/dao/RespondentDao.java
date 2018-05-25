package com.boot.security.server.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.boot.security.server.model.Respondent;

@Mapper
public interface RespondentDao {

    @Select("select * from respondent t where t.id = #{id}")
    Respondent getById(Long id);

    @Delete("delete from respondent where id = #{id}")
    int delete(Long id);

    int update(Respondent respondent);
    
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into respondent(ID, INSTANCE_ID, RESPONDENT_ID, USER_ID, RESPONSE_STATUS, CREATE_BY, CREATE_DATE, UPDATE_BY, UPDATE_DATE) values(#{ID}, #{INSTANCEID}, #{RESPONDENTID}, #{USERID}, #{RESPONSESTATUS}, #{CREATEBY}, #{CREATEDATE}, #{UPDATEBY}, #{UPDATEDATE})")
    int save(Respondent respondent);
    
    int count(@Param("params") Map<String, Object> params);

    List<Respondent> list(@Param("params") Map<String, Object> params, @Param("offset") Integer offset, @Param("limit") Integer limit);
}
