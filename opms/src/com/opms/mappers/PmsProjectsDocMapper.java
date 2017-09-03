package com.opms.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.opms.entity.PmsProjectsDoc;

public interface PmsProjectsDocMapper {
	//查询项目所有文档
	List<PmsProjectsDoc> selectAllPmsProjectsDoc(Long projectId);
	
	//根据文档ID查询文档信息
	List<PmsProjectsDoc> getPmsProjectsDoc(Long versionid);
	
	//根据文档ID删除文档信息
	int deleteDocByPrimaryKey(Long docid);
	
	//根据文档ID添加文档信息
	int insertPmsProjectsDoc(PmsProjectsDoc pmsProjectsDoc);
	
	//根据文档ID更新文档信息
	int updateDocByPrimaryKey(PmsProjectsDoc pmsProjectsDoc);
	
	//根据类型,名称进行模糊查询
	List<PmsProjectsDoc> searchPmsProjectsDoc(@Param("sort")Integer sort, @Param("title")String title,@Param("projectid")Long projectid);
}