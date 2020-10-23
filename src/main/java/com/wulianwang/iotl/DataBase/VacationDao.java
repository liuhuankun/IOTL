package com.wulianwang.iotl.DataBase;

import com.wulianwang.iotl.Bean.Vacation;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author lhk
 * @description
 * @create 2020-09-15 20:54
 */
@Mapper
@Repository
public interface VacationDao {
@Select("call getVacationList()")
List<Vacation> getVacationList();

}
