package com.opms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.opms.entity.PmsBusinesstrips;
import com.opms.mappers.PmsBusinesstripsMapper;
import com.opms.service.BusinesstripService;
@Service
public class BusinesstripServiceImpl implements BusinesstripService {
	@Autowired
	private PmsBusinesstripsMapper PmsBusinesstripsMapper;
	//查询所有出差信息
	@Override
	public List<PmsBusinesstrips> listBusinesstripInfo(long userid) {
	
		return PmsBusinesstripsMapper.listBusinesstrip(userid);
	}
	//添加出差信息
	@Override
	public int insertBusinesstripInfo(PmsBusinesstrips pmsBusinesstrips) {
		return PmsBusinesstripsMapper.insertSelective(pmsBusinesstrips);
	}
	//  //获取一条出差信息，以便于编辑
	@Override
	public PmsBusinesstrips getBusinesstripInfo(long businesstripid) {
		return PmsBusinesstripsMapper.selectByPrimaryKey(businesstripid);
	}
	//修改更新出差信息
	@Override
	public int updateBusinesstripInfo(PmsBusinesstrips pmsBusinesstrips) {
		return PmsBusinesstripsMapper.updateByPrimaryKeySelective(pmsBusinesstrips);
	}
	////按条件搜索出差信息
	@Override
	public List<PmsBusinesstrips> listSearchBusinesstrip(PmsBusinesstrips pmsBusinesstrips) {
		
		return PmsBusinesstripsMapper.listSearchBusinesstrip(pmsBusinesstrips);
	}
	
	//修改出差状态 草稿-正常发布
	@Override
	public int updateBusinesstripStatus(long bussinesstripid) {
		
		return PmsBusinesstripsMapper.updateBusinesstripStatus(bussinesstripid);
	}
	//删除出差信息
	@Override
	public int deleteBusinesstrip(long businesstripid) {
		return PmsBusinesstripsMapper.deleteByPrimaryKey(businesstripid);
	}
	//查询待登录用户审批
	@Override
	public List<PmsBusinesstrips> listApprovalBusinesstrip(long userid) {
		
		return PmsBusinesstripsMapper.listApprovalBusinesstrip(userid);
	}

	
	
	
	
	
	
}
