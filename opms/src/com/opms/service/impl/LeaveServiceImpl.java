package com.opms.service.impl;

import com.opms.entity.PmsLeaves;
import com.opms.mappers.PmsLeavesMapper;
import com.opms.service.LeaveService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LeaveServiceImpl implements LeaveService {
	@Autowired
	private PmsLeavesMapper pmsLeavesMapper;

	// private PmsLeaves pmsLeaves;
	// private PmsLeavesApprover pmsLeavesApprover;
	public List<PmsLeaves> listLeave(PmsLeaves pmsLeaves) {
		return pmsLeavesMapper.listselectAllLeave(pmsLeaves);
	}

	// 插入请假信息
	@Override
	public int insertLeave(PmsLeaves pmsLeaves) {
		int flag = pmsLeavesMapper.insertSelective(pmsLeaves);
		return 0;
	}

	@Override
	public PmsLeaves getleaveInfo(Long leaveid) {

		return pmsLeavesMapper.selectByPrimaryKey(leaveid);
	}

	// 根据条件搜索请假信息
	@Override
	public List<PmsLeaves> listSearchLeave(PmsLeaves pmsLeaves) {
		return pmsLeavesMapper.selectLeavesInfo(pmsLeaves);
	}

	/**
	 * 修改请假信息
	 */
	@Override
	public int updateLeaveInfo(PmsLeaves pmsleaves) {
		return pmsLeavesMapper.updateByPrimaryKeySelective(pmsleaves);
	}

	/**
	 * 获取未审批的请假信息
	 */
	public List<PmsLeaves> getApprovalLeave(PmsLeaves pmsLeaves) {

		return pmsLeavesMapper.listSelectUnApproval( pmsLeaves);
	}

	//删除请假信息
	@Override
	public int deleteLeave(long leaveid) {
		
		return pmsLeavesMapper.deleteByPrimaryKey(leaveid);
	}
//更改请假状态为正常
	@Override
	public int updateStatus(long leaveid) {
		
		return pmsLeavesMapper.updateStatusbyid(leaveid);
	}
   //获取请假信息详情
	@Override
	public PmsLeaves getLeaveDetail(long leaveid) {
		
		return pmsLeavesMapper.selectByPrimaryKey(leaveid);
	}

}
