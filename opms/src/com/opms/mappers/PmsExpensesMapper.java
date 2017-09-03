package com.opms.mappers;

import com.opms.entity.PmsExpenses;
import java.util.List;

public interface PmsExpensesMapper {


    int deleteByPrimaryKey(Long expenseid);

    int insert(PmsExpenses record);

    int insertSelective(PmsExpenses record);


    PmsExpenses selectByPrimaryKey(Long expenseid);



    int updateByPrimaryKeySelective(PmsExpenses record);

    int updateByPrimaryKey(PmsExpenses record);
    //获取所有报销事件信息
    List<PmsExpenses> selectAllExpense(PmsExpenses pmsExpenses);
    //按条件搜索报销事件信息
    List<PmsExpenses> listSearchExpense(PmsExpenses pmsExpenses);
    //查询未审批报销事件的信息
    List<PmsExpenses> listApprovalExpense(PmsExpenses pmsExpenses);
}