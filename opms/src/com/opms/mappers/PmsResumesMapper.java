package com.opms.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.opms.entity.PmsResumes;

public interface PmsResumesMapper {

	List<PmsResumes> listResumes();//查询所有简历信息
	
    int deleteByPrimaryKey(Long resumeid);//根据简历ID删除简历信息

    int insertSelective(PmsResumes record);//插入一条简历信息

    PmsResumes selectByPrimaryKey(Long resumeid);//根据简历ID获取一条简历信息

    int updateByPrimaryKey(PmsResumes record);//根据简历ID更新简历信息
    
    List<PmsResumes> searchResumes(@Param("status")Integer status,@Param("realname")String realname);//模糊查询
    
    int updateStateById(@Param("resumeid")Long resumeid,@Param("status")Integer status);
    
}