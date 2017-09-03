package com.opms.service;

import java.util.List;

import com.opms.entity.PmsOvertimes;


public interface OvertimeService {

	//获取所有请假信息
	List<PmsOvertimes> listOvertimeInfo(PmsOvertimes pmsOvertimes);
	//获取一个请加信息详情
	PmsOvertimes getOvertimeInfo(long overtimeid);
	//添加加班信息
	int insertOvertimeInfo(PmsOvertimes pmsOvertimes);
	//更改加班信息的状态为正常
	int updateStatusInfo(long overtimeid);
	//搜索加班信息
	List<PmsOvertimes> searchOvertimeInfo(PmsOvertimes pmsOvertimes);
	//查询未审加班的信息
	List<PmsOvertimes> listUnApprovalOvertime();
	//删除加班信息
	int deleteOvertimeInfo(long overtimeid);
	//更新修改加班信息
	int updateOvertime(PmsOvertimes pmsOvertimes);
}
