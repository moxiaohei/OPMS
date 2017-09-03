package com.opms.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.opms.entity.PmsProjectsVersion;

public interface PmsProjectsVersionMapper {
	
	//查询项目所有版本
	List<PmsProjectsVersion> selectAllPmsProjectsVersion(Long projectId);
	
	//根据版本ID查询版本信息
	List<PmsProjectsVersion> getPmsProjectsVersion(Long versionid);
	
	//根据版本ID删除版本信息
	int deleteByPrimaryKey(Long versionid);
	
	//根据项目ID添加版本信息
	int insertPmsProjectsVersion(PmsProjectsVersion pmsProjectsVersion);
	
	//根据版本ID更新版本信息
	int updateByPrimaryKey(PmsProjectsVersion pmsProjectsVersion);
	
	//根据类型,名称进行模糊查询
	List<PmsProjectsVersion> searchPmsProjectsVersion(@Param("title")String title,@Param("projectid")Long projectid);
}