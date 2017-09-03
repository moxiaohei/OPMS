package com.opms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.opms.entity.PmsOagoods;
import com.opms.mappers.OagoodManageMapper;

import com.opms.service.OagoodManageService;

@Service
public class OagoodManageServiceImpl implements OagoodManageService{
  @Autowired
  private  OagoodManageMapper  oagoodManageMapper;
@Override
public int insertOagoodsManage(PmsOagoods pmsOagoods) {
	
	return oagoodManageMapper.insertOagoodsManage(pmsOagoods);
}

@Override
public List<PmsOagoods> selectlistOagoodManage(Long userid) {
	
	return oagoodManageMapper.selectlistOagoodManage(userid);
}

@Override
public int selectOagoodManageCount() {
	
	return oagoodManageMapper.selectOagoodManageCount();
}
//搜索物品信息
@Override
public List<PmsOagoods> searchOagoods(PmsOagoods pmsOagoods) {
	
	return oagoodManageMapper.searchOagoods(pmsOagoods);
}
}
