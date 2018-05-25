package com.boot.security.server.dao;


import org.apache.ibatis.annotations.*;



@Mapper
public interface MultiTableDao {

    int updatecount();

    int updatecountbyid(Long id);
}
