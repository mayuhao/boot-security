package com.boot.security.server.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.boot.security.server.model.ElementDefinition;

@Mapper
public interface ElementDefinitionDao {

    @Select("select * from element_definition t where t.id = #{id}")
    ElementDefinition getById(Long id);

    @Delete("delete from element_definition where id = #{id}")
    int delete(Long id);

    int update(ElementDefinition elementDefinition);
    
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into element_definition(form_id, element_id, element_key, element_value, create_by, create_date, update_by, update_date) values(#{formId}, #{elementId}, #{elementKey}, #{elementValue}, #{createBy}, #{createDate}, #{updateBy}, #{updateDate})")
    int save(ElementDefinition elementDefinition);
    
    int count(@Param("params") Map<String, Object> params);

    List<ElementDefinition> list(@Param("params") Map<String, Object> params, @Param("offset") Integer offset, @Param("limit") Integer limit);
}
