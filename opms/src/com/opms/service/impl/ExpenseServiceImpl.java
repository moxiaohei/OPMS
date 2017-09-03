package com.opms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.opms.entity.PmsExpenses;
import com.opms.mappers.PmsExpensesMapper;
import com.opms.service.ExpenseService;

@Service
public class ExpenseServiceImpl implements ExpenseService {
	@Autowired
	private PmsExpensesMapper pmsExpensesMapper;
    //获取所有报销事件信息
	@Override
	public List<PmsExpenses> listExpenseInfo(PmsExpenses pmsExpenses) {
		// TODO Auto-generated method stub
		return pmsExpensesMapper.selectAllExpense(pmsExpenses);
	}
	//按条件搜索报销信息
	@Override
	public List<PmsExpenses> listSearchExpense(PmsExpenses pmsExpenses) {
		
		return pmsExpensesMapper.listSearchExpense(pmsExpenses);
	}
	//获取报销事件详情
	@Override
	public PmsExpenses getExprnseDetail(long expenseid) {
		
		return pmsExpensesMapper.selectByPrimaryKey(expenseid);
	}
	//删除请假信息
	@Override
	public int deleteExpenseInfo(Long expenseid) {
		return pmsExpensesMapper.deleteByPrimaryKey(expenseid);
	}
	//修改报销信息状态
	@Override
	public int updateExpenseStatus(PmsExpenses pmsExpenses) {
		return pmsExpensesMapper.updateByPrimaryKeySelective(pmsExpenses);
	}
	// 添加报销信息
	@Override
	public int insertExpenseInfo(PmsExpenses pmsExpenses) {
		return pmsExpensesMapper.insertSelective(pmsExpenses);
	}
	//修改报销信息
	@Override
	public int updateExpenseInfo(PmsExpenses pmsExpenses) {
		
		return pmsExpensesMapper.updateByPrimaryKeySelective(pmsExpenses);
	}
	//获取未审批报销事件信息
	@Override
	public List<PmsExpenses> listApprovalExpense(PmsExpenses pmsExpenses) {
		
		return pmsExpensesMapper.listApprovalExpense(pmsExpenses);
	}
	

}
