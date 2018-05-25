package com.boot.security.server.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.boot.security.server.model.FormInstance;

@Mapper
public interface FormInstanceDao {

    @Select("select * from form_instance t where t.id = #{id}")
    FormInstance getById(Long id);

    @Delete("delete from form_instance where id = #{id}")
    int delete(Long id);

    int update(FormInstance formInstance);
    
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into form_instance(ID, FORM_ID, INSTANCE_ID, INSTANCE_NAME, RESPONDENT_ID, START_DATE, END_DATE, CREATE_BY, CREATE_DATE, UPDATE_BY, UPDATE_DATE) values(#{ID}, #{FORMID}, #{INSTANCEID}, #{INSTANCENAME}, #{RESPONDENTID}, #{STARTDATE}, #{ENDDATE}, #{CREATEBY}, #{CREATEDATE}, #{UPDATEBY}, #{UPDATEDATE})")
    int save(FormInstance formInstance);
    
    int count(@Param("params") Map<String, Object> params);

    List<FormInstance> list(@Param("params") Map<String, Object> params, @Param("offset") Integer offset, @Param("limit") Integer limit);
}
