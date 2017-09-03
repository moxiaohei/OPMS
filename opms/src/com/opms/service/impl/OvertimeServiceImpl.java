package com.opms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.opms.entity.PmsOvertimes;
import com.opms.mappers.PmsOvertimesMapper;
import com.opms.service.OvertimeService;

@Service
public class OvertimeServiceImpl implements OvertimeService {
	@Autowired
	private PmsOvertimesMapper pmsOvertimeMapper;

	// 获取所有加班信息
	@Override
	public List<PmsOvertimes> listOvertimeInfo(PmsOvertimes pmsOvertimes) {
		return pmsOvertimeMapper.selectOvertimeInfo(pmsOvertimes);
	}

	// 获取加班信息详情
	@Override
	public PmsOvertimes getOvertimeInfo(long overtimeid) {
		return pmsOvertimeMapper.selectByPrimaryKey(overtimeid);
	}

	// 添加加班信息
	@Override
	public int insertOvertimeInfo(PmsOvertimes pmsOvertimes) {
		return pmsOvertimeMapper.insertSelective(pmsOvertimes);
	}

	// 修改加班信息状态为正常
	@Override
	public int updateStatusInfo(long overtimeid) {
		return pmsOvertimeMapper.updateStatusInfo(overtimeid);
	}

	// 搜索加班信息
	@Override
	public List<PmsOvertimes> searchOvertimeInfo(PmsOvertimes pmsOvertimes) {
		return pmsOvertimeMapper.searchOvertimeInfo(pmsOvertimes);
	}
   //获取未审批的加班信息
	@Override
	public List<PmsOvertimes> listUnApprovalOvertime() {
		
		return pmsOvertimeMapper.listUnApprovalOvertime();
	}
  //删除加班信息
	@Override
	public int deleteOvertimeInfo(long overtimeid) {
		// TODO Auto-generated method stub
		return pmsOvertimeMapper.deleteByPrimaryKey(overtimeid);
	}
//更新修改加班信息
	@Override
	public int updateOvertime(PmsOvertimes pmsOvertimes) {
		
		return pmsOvertimeMapper.updateByPrimaryKey(pmsOvertimes);
	}

}
