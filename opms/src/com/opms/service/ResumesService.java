package com.opms.service;

import java.util.List;

import com.opms.entity.PmsResumes;

public interface ResumesService {
	
	//查询所有简历信息
	List<PmsResumes> listResumes();
	
	//根据简历ID删除简历信息
	int deletePmsResumes(Long resumeid);
	
	//根据简历ID获取简历信息
	PmsResumes getResumes(Long resumeid);
	
	//根据简历ID更新简历信息
	int updateByPrimaryKey(PmsResumes record);
	
	//添加简历信息
	int insertResumes(PmsResumes pmsResumes);
	
	//模糊查询简历信息
	List<PmsResumes> searchResumes(Integer status,String realname);
	
	//根据简历ID更新简历状态
	int updateStateById(Long resumeid,Integer status);
}
