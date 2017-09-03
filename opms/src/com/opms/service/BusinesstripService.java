package com.opms.service;

import java.util.List;

import com.opms.entity.PmsBusinesstrips;

public interface BusinesstripService {

	
	//查询所有出差信息
   List<PmsBusinesstrips>	listBusinesstripInfo(long userid);
   //添加出差信息
   int insertBusinesstripInfo(PmsBusinesstrips pmsBusinesstrips);
   //获取一条出差信息，以便于编辑
   PmsBusinesstrips getBusinesstripInfo(long businesstripid);
   //修改更新出差信息
   int updateBusinesstripInfo(PmsBusinesstrips pmsBusinesstrips);
   //按条件搜索出差信息
   List<PmsBusinesstrips> listSearchBusinesstrip(PmsBusinesstrips pmsBusinesstrips);
   //修改出差事件状态
   int updateBusinesstripStatus(long bussinesstripid);
   //删除出差信息
   int deleteBusinesstrip(long businesstripid);
   //查询需要登录用户审批的出差信息
   List<PmsBusinesstrips> listApprovalBusinesstrip(long userid);
   
}
