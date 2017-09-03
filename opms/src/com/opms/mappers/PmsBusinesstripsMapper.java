package com.opms.mappers;

import com.opms.entity.PmsBusinesstrips;
import java.util.List;

public interface PmsBusinesstripsMapper {

    int deleteByPrimaryKey(Long businesstripid);

    int insert(PmsBusinesstrips record);

    int insertSelective(PmsBusinesstrips record);


    PmsBusinesstrips selectByPrimaryKey(Long businesstripid);



    int updateByPrimaryKeySelective(PmsBusinesstrips record);

    int updateByPrimaryKey(PmsBusinesstrips record);
    //查询所有出差信息
    List<PmsBusinesstrips> listBusinesstrip(long userid);
    //按条件搜索出差信息
    List<PmsBusinesstrips> listSearchBusinesstrip(PmsBusinesstrips pmsBusinesstrips);
    //修改出差事件状态
    int updateBusinesstripStatus(long bussinesstripid);
    //查询需要待登录人员审批的出差事件
    List<PmsBusinesstrips> listApprovalBusinesstrip(long userid);
    
}