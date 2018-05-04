package com.boot.security.server.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.boot.security.server.model.BCrud;

@Mapper
public interface BCrudDao {

    @Select("select * from b_crud t where t.id = #{id}")
    BCrud getById(Long id);

    @Delete("delete from b_crud where id = #{id}")
    int delete(Long id);

    int update(BCrud bCrud);
    
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into b_crud(bname, bdate) values(#{bname}, #{bdate})")
    int save(BCrud bCrud);
    
    int count(@Param("params") Map<String, Object> params);

    List<BCrud> list(@Param("params") Map<String, Object> params, @Param("offset") Integer offset, @Param("limit") Integer limit);
}
