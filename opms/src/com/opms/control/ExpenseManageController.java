package com.opms.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.opms.entity.PmsExpenses;
import com.opms.entity.PmsUsers;
import com.opms.service.ExpenseService;
import com.opms.unti.RandomTest;

@Controller
public class ExpenseManageController {
	@Autowired
	private ExpenseService expenseService;
	private HttpServletResponse response;

	// 获取报销所有事件
	@RequestMapping("expensemanage")
	public String listExpenseManage(Model mod,HttpServletRequest request) {
		PmsExpenses pmsExpenses=new PmsExpenses();
		PmsUsers user=(PmsUsers)request.getSession().getAttribute("user");
		pmsExpenses.setUserid(user.getUserid());
		mod.addAttribute("listExpense", expenseService.listExpenseInfo(pmsExpenses));
		return "expense_manage";
	}

	// 跳转增加报销信息页面
	@RequestMapping("addexpensemanage")
	public String goAddExpense() {
		return "add_expense_manage";
	}

	// 增加报销信息
	@RequestMapping("insertExpenseInfo")
	public void insertExpenseInfo(HttpServletRequest request, HttpServletResponse response, String jsondata)
			 {
		PmsExpenses pmsExpenses = (PmsExpenses) JSONObject.parseObject(jsondata, PmsExpenses.class);
		PmsUsers user=(PmsUsers)request.getSession().getAttribute("user");
		pmsExpenses.setUserid(user.getUserid());
		System.out.println(pmsExpenses);
		int total = 0;
		String[] totalString = pmsExpenses.getAmounts().split(",");
		for (String count : totalString) {
			int flag = Integer.parseInt(count);
			total = total + flag;
		}
		String totals = String.valueOf(total);
		pmsExpenses.setTotal(totals);
		pmsExpenses.setContents(pmsExpenses.getContents().substring(0, pmsExpenses.getContents().length() - 1));
		pmsExpenses.setTypes(pmsExpenses.getTypes().substring(0, pmsExpenses.getTypes().length() - 1));
		pmsExpenses.setAmounts(pmsExpenses.getAmounts().substring(0, pmsExpenses.getAmounts().length() - 1));
		pmsExpenses.setExpenseid(new RandomTest().random());
		pmsExpenses.setCreated(new java.sql.Timestamp(new java.util.Date().getTime()));
		int flag = expenseService.insertExpenseInfo(pmsExpenses);
       response.setCharacterEncoding("UTF-8");
		PrintWriter out = null;
		try {
			out = response.getWriter();
			if (flag == 1) {
				out.write(JSONArray.toJSONString("添加成功！"));
			} else if (flag == 0) {
				out.write(JSONArray.toJSONString("添加成功！"));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			out.close();
		}
		
	}

	// 搜索报销信息redirect
	@RequestMapping("searchExpense")
	public String searchExpense(Model model, PmsExpenses pmsExpenses,HttpSession session) {
		PmsUsers user=(PmsUsers)session.getAttribute("user");
		pmsExpenses.setUserid(user.getUserid());
		model.addAttribute("listExpense", expenseService.listSearchExpense(pmsExpenses));
		return "expense_manage";
	}

	// 查看报销详情 //待完成
	@RequestMapping("expensedetail")
	public String goexpensedetail(Model model, Long expenseid) {
		PmsExpenses pmsExpenses = expenseService.getExprnseDetail(expenseid);
		model.addAttribute("expenseDetail", pmsExpenses);
		// model.addAttribute("userinfo", arg1)根据用户id获取部门名称和职位
		return "expense_detail";
	}

	// 删除报销信息
	@RequestMapping("delexpenseinfo")
	public String deleteExpenseInfo(Long expenseid) {
		expenseService.deleteExpenseInfo(expenseid);
		return "redirect:expensemanage";
	}

	// 修改报销事件状态草稿为正常
	@RequestMapping("updateexpensestatus")
	public String updateExpenseStatus(Long expenseid) {
		PmsExpenses pmsExpenses = new PmsExpenses();
		pmsExpenses.setExpenseid(expenseid);
		pmsExpenses.setChanged(new java.sql.Timestamp(new java.util.Date().getTime()));
		pmsExpenses.setStatus(2);
		expenseService.updateExpenseStatus(pmsExpenses);
		return "redirect:expensemanage";
	}

	// 修改报销信息,跳转修改页面
	@RequestMapping("editexpensemanage")
	public String goEditExpense(Model model, Long expenseid) {
		model.addAttribute("editExpense", expenseService.getExprnseDetail(expenseid));
		return "edit_expense_manage";
	}

	// 修改报销信息
	@RequestMapping("updateExpenseInfo")
	public void updateExpenseInfo(HttpServletRequest request, HttpServletResponse response, String jsondata) throws IOException {
		
		PmsExpenses pmsExpenses = (PmsExpenses) JSONObject.parseObject(jsondata, PmsExpenses.class);
		int total = 0;
		System.out.println(pmsExpenses);
		pmsExpenses.setContents(pmsExpenses.getContents().substring(0, pmsExpenses.getContents().length() - 1));
		pmsExpenses.setTypes(pmsExpenses.getTypes().substring(0, pmsExpenses.getTypes().length() - 1));
		pmsExpenses.setAmounts(pmsExpenses.getAmounts().substring(0, pmsExpenses.getAmounts().length() - 1));
		pmsExpenses.setChanged(new java.sql.Timestamp(new java.util.Date().getTime()));
		String[] totalString = pmsExpenses.getAmounts().split(",");
		for (String count : totalString) {
			int flag = Integer.parseInt(count);
			total = total + flag;
		}
		String totals = String.valueOf(total);
		pmsExpenses.setTotal(totals);
		pmsExpenses.setChanged(new java.sql.Timestamp(new java.util.Date().getTime()));
		int flag = expenseService.updateExpenseInfo(pmsExpenses);
		PrintWriter out = null;
		response.setCharacterEncoding("UTF-8");
		try {
			out = response.getWriter();
			if (flag == 1) {
				out.write(JSONArray.toJSONString("修改成功！"));
				
			} else if (flag == 0) {
				out.write(JSONArray.toJSONString("修改失败！"));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			out.close();
		}

	}
	//获得待审批报销信息
	@RequestMapping("approvalexpense")
	public String goApprovalExpense(HttpServletRequest request,Model model){
		HttpSession session=request.getSession();
		PmsUsers user=(PmsUsers)session.getAttribute("user");
		PmsExpenses pmsExpenses=new PmsExpenses();
		pmsExpenses.setUserid(user.getUserid());
		pmsExpenses.setStatus(2);
		model.addAttribute("listApprovelExoense", expenseService.listApprovalExpense(pmsExpenses));
		return "approval_expense";
	}
	
	
	
	
}
