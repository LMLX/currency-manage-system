package com.lmlx.app.dao.base;

import com.lmlx.app.model.so.InterfaceModelInfoSo;
import org.apache.ibatis.annotations.Insert;

public interface TestAMapper {

    @Insert("insert into a values (#{id})")
    void save(int id);
}
