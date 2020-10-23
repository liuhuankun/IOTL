package com.wulianwang.iotl.DataBase;

import com.wulianwang.iotl.Bean.Push;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author lhk
 * @description
 * @create 2020-09-15 20:29
 */
@Mapper
@Repository
public interface PushDao {
    @Select("call getPushList()")
    List<Push> getPushList();
}
