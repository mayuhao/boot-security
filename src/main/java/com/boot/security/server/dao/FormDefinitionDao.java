package com.boot.security.server.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.boot.security.server.model.FormDefinition;

@Mapper
public interface FormDefinitionDao {

    @Select("select * from form_definition t where t.id = #{id}")
    FormDefinition getById(Long id);

    @Delete("delete from form_definition where id = #{id}")
    int delete(Long id);

    int update(FormDefinition formDefinition);
    
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into form_definition(formId, formName, elementId, elementSeq, elementType, createBy, createDate, updateBy, updateDate) values(#{formId}, #{formName}, #{elementId}, #{elementSeq}, #{elementType}, #{createBy}, #{createDate}, #{updateBy}, #{updateDate})")
    int save(FormDefinition formDefinition);
    
    int count(@Param("params") Map<String, Object> params);

    List<FormDefinition> list(@Param("params") Map<String, Object> params, @Param("offset") Integer offset, @Param("limit") Integer limit);
}
