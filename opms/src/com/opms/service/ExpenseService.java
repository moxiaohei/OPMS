package com.opms.service;

import java.util.List;

import com.opms.entity.PmsExpenses;

public interface ExpenseService {

	//获取所有报销事件信息
	List<PmsExpenses> listExpenseInfo(PmsExpenses pmsExpenses);
	//添加报销事件
	int insertExpenseInfo(PmsExpenses pmsExpenses);
	//按条件搜索报销信息
	List<PmsExpenses> listSearchExpense(PmsExpenses pmsExpenses);
	//获取报销详情
	PmsExpenses getExprnseDetail(long expenseid);
	//删除报销信息
	int deleteExpenseInfo(Long expenseid);
	//修改报销信息状态
	int updateExpenseStatus(PmsExpenses pmsExpenses);
	//修改报销信息
    int	updateExpenseInfo(PmsExpenses pmsExpenses);
    // 获得未审批报销事件的信息
    List<PmsExpenses> listApprovalExpense(PmsExpenses 	pmsExpenses);
}
