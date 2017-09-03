package com.opms.mappers;

import com.opms.entity.PmsOvertimes;
import java.util.List;

public interface PmsOvertimesMapper {


    int deleteByPrimaryKey(Long overtimeid);

    int insert(PmsOvertimes record);

    int insertSelective(PmsOvertimes record);


    PmsOvertimes selectByPrimaryKey(Long overtimeid);



    int updateByPrimaryKeySelective(PmsOvertimes record);

    int updateByPrimaryKey(PmsOvertimes record);
    //获取所有加班信息
    List<PmsOvertimes> selectOvertimeInfo(PmsOvertimes pmsOvertimes);
    //修改申请加班信息为正常
    int updateStatusInfo(long overtimeid);
    //搜索加班信息
    List<PmsOvertimes> searchOvertimeInfo(PmsOvertimes pmsOvertimes);
    //搜索未审核加班信息
    List<PmsOvertimes> listUnApprovalOvertime();
    //修改加班信息
    int  updatePmsOvertime(PmsOvertimes record);
    
}