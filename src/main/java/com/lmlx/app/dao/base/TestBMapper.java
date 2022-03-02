package com.lmlx.app.dao.base;

import org.apache.ibatis.annotations.Insert;

public interface TestBMapper {

    @Insert("insert into b values (#{id})")
    void save(int id);
}
