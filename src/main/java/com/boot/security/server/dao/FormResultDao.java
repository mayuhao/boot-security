package com.boot.security.server.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.boot.security.server.model.FormResult;

@Mapper
public interface FormResultDao {

    @Select("select * from form_result t where t.id = #{id}")
    FormResult getById(Long id);

    @Delete("delete from form_result where id = #{id}")
    int delete(Long id);

    int update(FormResult formResult);
    
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into form_result(instanceId, userId, elementId, elementAnswer, createBy, createDate, updateBy, updateDate) values(#{instanceId}, #{userId}, #{elementId}, #{elementAnswer}, #{createBy}, #{createDate}, #{updateBy}, #{updateDate})")
    int save(FormResult formResult);
    
    int count(@Param("params") Map<String, Object> params);

    List<FormResult> list(@Param("params") Map<String, Object> params, @Param("offset") Integer offset, @Param("limit") Integer limit);
}
