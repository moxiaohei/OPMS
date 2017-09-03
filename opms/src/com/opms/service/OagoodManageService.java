package com.opms.service;

import java.util.List;

import com.opms.entity.PmsOagoods;

public interface OagoodManageService {

	int insertOagoodsManage(PmsOagoods pmsOagoods);

	List<PmsOagoods> selectlistOagoodManage(Long userid);

	int selectOagoodManageCount();
    
	List<PmsOagoods> searchOagoods(PmsOagoods pmsOagoods);
	
}
