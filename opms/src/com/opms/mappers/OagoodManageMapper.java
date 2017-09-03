package com.opms.mappers;

import java.util.List;

import com.opms.entity.PmsOagoods;

public interface OagoodManageMapper {

	int insertOagoodsManage(PmsOagoods pmsOagoods);

	List<PmsOagoods> selectlistOagoodManage(Long userid);

	int selectOagoodManageCount();

	List<PmsOagoods> searchOagoods(PmsOagoods pmsOagoods);

}
