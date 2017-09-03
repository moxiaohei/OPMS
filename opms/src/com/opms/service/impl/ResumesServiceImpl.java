package com.opms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.opms.entity.PmsResumes;
import com.opms.mappers.PmsResumesMapper;
import com.opms.service.ResumesService;

/**
 * @author mengyongfei
 * @date 2017年7月27日 下午2:37:51
 * 服务层
 */
@Service
public class ResumesServiceImpl implements ResumesService{

	@Autowired
	private PmsResumesMapper pmsResumesMapper;
	
	//获取多条记录
	@Override
	public List<PmsResumes> listResumes() {
		List<PmsResumes> list = pmsResumesMapper.listResumes();
		return list;
	}
	
	//根据简历ID删除简历信息
	@Override
	public int deletePmsResumes(Long resumeid) {
		return pmsResumesMapper.deleteByPrimaryKey(resumeid);
	}
	
	//根据简历ID获取一条简历信息
	@Override
	public PmsResumes getResumes(Long resumeid) {
		return pmsResumesMapper.selectByPrimaryKey(resumeid);
	}
	
	//插入一条简历信息
	@Override
	public int insertResumes(PmsResumes pmsResumes) {
		return pmsResumesMapper.insertSelective(pmsResumes);
	}

	//模糊查询
	@Override
	public List<PmsResumes> searchResumes(Integer state, String realname) {
		return pmsResumesMapper.searchResumes(state, realname);
	}

	//根据简历ID只更新简历状态
	@Override
	public int updateStateById(Long resumeid, Integer status) {
		return pmsResumesMapper.updateStateById(resumeid, status);
	}
	
	//根据简历ID更新简历信息
	@Override
	public int updateByPrimaryKey(PmsResumes record) {
		return pmsResumesMapper.updateByPrimaryKey(record);
	}
	
}
