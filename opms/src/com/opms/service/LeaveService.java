package com.opms.service;

import java.util.List;

import com.opms.entity.PmsLeaves;

public interface LeaveService {

	//获取请假列表信息
	List<PmsLeaves> listLeave(PmsLeaves pmsLeaves);
	//添加请假信息
	int  insertLeave(PmsLeaves pmsLeaves);
	//获取需要修改的请假信息
	PmsLeaves getleaveInfo(Long leaveid);
    //根据条件搜索请假信息
	List<PmsLeaves> listSearchLeave(PmsLeaves pmsLeaves);
	//更新请假信息
	int updateLeaveInfo(PmsLeaves pmsleaves);
	//获取未审批的请假案件
	List<PmsLeaves> getApprovalLeave(PmsLeaves pmsleaves);
	//删除案件信息
	int deleteLeave( long leaveid);
	//更改案件状态为正常
	int updateStatus(long leaveid);
	//查看案件详情
	PmsLeaves getLeaveDetail(long leaveid);
}
