package com.opms.mappers;

import com.opms.entity.PmsGoouts;
import java.util.List;
public interface PmsGooutsMapper {


    int deleteByPrimaryKey(Long gooutid);

    int insert(PmsGoouts record);

    int insertSelective(PmsGoouts record);


    PmsGoouts selectByPrimaryKey(Long gooutid);



    int updateByPrimaryKeySelective(PmsGoouts record);

    int updateByPrimaryKey(PmsGoouts record);
    //查询所有外信息
    List<PmsGoouts> listGooutmanage(long userid);
    //根据条件搜索外出信息
    List<PmsGoouts> listSearchGooutManage(PmsGoouts pmsGoouts);
    //修改外出事件状态
    int uodateGooutStatus(Long gooutid);
    
}