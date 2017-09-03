package com.opms.service;

import java.util.List;

import com.opms.entity.PmsGoouts;;

public interface GooutService {

	//查询所有外出信息
	List<PmsGoouts> listGooutmanage(long userid);
	//添加外出申请
	int insertGooutmanage(PmsGoouts pmsGoouts);
	//根据条件搜索出差信息
	List<PmsGoouts> listSearchGooutManage(PmsGoouts pmsGoouts);
	//根据外出事件id查询详细 准备修改
	PmsGoouts getGooutInfo(long gooutid);
	//修改外出信息
	int updateGooutInfo(PmsGoouts pmsGoouts);
	//删除外出事件
	int deleteGooutInfo(Long gooutid);
	//修改外出事件的状态
	int uodateGooutStatus(Long gooutid);
}
