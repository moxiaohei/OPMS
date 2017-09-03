package com.opms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.opms.entity.PmsGoouts;
import com.opms.mappers.PmsGooutsMapper;
import com.opms.service.GooutService;
@Service
public class GooutServiceImpl implements GooutService {
	@Autowired
	private PmsGooutsMapper pmsGooutsMapper;
	
	
	//查询所有外出信息并返回数据
	@Override
	public List<PmsGoouts> listGooutmanage(long userid) {
		
		return pmsGooutsMapper.listGooutmanage( userid);
	}

//添加外出申请信息
	@Override
	public int insertGooutmanage(PmsGoouts pmsGoouts) {
		return pmsGooutsMapper.insertSelective(pmsGoouts);
	}
//按条件搜索外出申请信息
	@Override
	public List<PmsGoouts> listSearchGooutManage(PmsGoouts pmsGoouts) {
		
		return pmsGooutsMapper.listSearchGooutManage(pmsGoouts);
	}
//根据出差事件id查找详情
	@Override
	public PmsGoouts getGooutInfo(long gooutid) {
		
		return pmsGooutsMapper.selectByPrimaryKey(gooutid);
	}
   //修改更新外出信息
	@Override
	public int updateGooutInfo(PmsGoouts pmsGoouts) {
		return pmsGooutsMapper.updateByPrimaryKeySelective(pmsGoouts);
	}
   //删除外出事件
	@Override
	public int deleteGooutInfo(Long gooutid) {
		return pmsGooutsMapper.deleteByPrimaryKey(gooutid);
	}
   //修改时间状态
	@Override
	public int uodateGooutStatus(Long gooutid) {
		
		return pmsGooutsMapper.uodateGooutStatus(gooutid);
	}

	
	
}
