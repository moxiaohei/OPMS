package com.opms.mappers;

import com.opms.entity.PmsLeaves;
import java.util.List;
public interface PmsLeavesMapper {


    int deleteByPrimaryKey(Long leaveid);

    int insert(PmsLeaves record);

    int insertSelective(PmsLeaves record);


    PmsLeaves selectByPrimaryKey(Long leaveid);



    int updateByPrimaryKeySelective(PmsLeaves record);

    int updateByPrimaryKey(PmsLeaves record);
    
    List<PmsLeaves> selectLeavesInfo(PmsLeaves record);
    //查询所有请假信息
    List<PmsLeaves> listselectAllLeave(PmsLeaves pmsLeaves);
    //查询未审批请假信息
    List<PmsLeaves> listSelectUnApproval(PmsLeaves pmsLeaves);
    //修改案件状态
    int updateStatusbyid(long leaveid);
}