package com.opms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.opms.entity.PmsCommentUser;
import com.opms.entity.PmsKnowledges;
import com.opms.entity.PmsKnowledgesComment;
import com.opms.entity.PmsKnowledgesLaud;
import com.opms.entity.PmsKnowledgesUser;
import com.opms.entity.PmsUseridKnowid;
import com.opms.mappers.PmsKnowledgesMapper;
import com.opms.service.KnowledgeService;
@Service
public class KnowledgeServiceImpl implements KnowledgeService{
  @Autowired
  private PmsKnowledgesMapper pmsKnowledgesMapper;
	@Override
	public List<String> listFindTitleAll() {
		
		return pmsKnowledgesMapper.listFindTitleAll();
	}
	@Override
	public void insertSelective(PmsKnowledges pmsKnowlwdges2) {
		pmsKnowledgesMapper.insertSelective(pmsKnowlwdges2);
		
	}
	/*public List<PmsKnowledges> selectByPrimaryKey(long knowid) {
		
		return pmsKnowledgesMapper.selectByPrimaryKey(knowid);
	}*/
	@Override
	public List<PmsKnowledges> selectByKnowledgesKey(long userid) {
		
		return pmsKnowledgesMapper.selectByKnowledgesKey(userid);
	}
	@Override
	public List<PmsKnowledgesUser> selectByKnowledgesUserKey(Long id) {
		
		return pmsKnowledgesMapper.selectByKnowledgesUserKey(id);
	}
	@Override
	public List<PmsKnowledgesUser> selectByKnowledgesUsersortid(int sortid) {
		
		return pmsKnowledgesMapper.selectByKnowledgesUsersortid(sortid);
	}
	@Override
	public List<PmsKnowledgesUser> selectKnowledgesUser() {
		
		return pmsKnowledgesMapper.selectKnowledgesUser();
	}
	@Override
	public List<PmsKnowledgesUser> selectByKnowledgesUserknowid(Long knowid) {
		
		return pmsKnowledgesMapper.selectByKnowledgesUserknowid(knowid);
	}
	@Override
	public List<PmsCommentUser> selectCommentByKnowledgeKnowid(Long knowid) {
		// TODO Auto-generated method stub
		return pmsKnowledgesMapper.selectCommentByKnowledgeKnowid(knowid);
	}
	@Override
	public void insertComment(PmsKnowledgesComment pmsKnowledgesComment) {
		pmsKnowledgesMapper.insertComment(pmsKnowledgesComment);
		
	}
	@Override
	public PmsCommentUser selectCommentByKnowledgecomtid(Long comtid) {
		// TODO Auto-generated method stub
		return pmsKnowledgesMapper.selectCommentByKnowledgecomtid(comtid);
	}
	@Override
	public Long selectKnowledgesuseridByknowid(Long knowid) {
		
		return pmsKnowledgesMapper.selectKnowledgesuseridByknowid(knowid);
	}
	@Override
	public void delKnowledgesByKnowid(Long knowid) {
		pmsKnowledgesMapper.delKnowledgesByKnowid(knowid);
		
	}
	@Override
	public void delCommentByKnowid(Long knowid) {
		pmsKnowledgesMapper.delCommentByKnowid(knowid);
		
	}
	@Override
	public void updateKnowledgeComtnum(Long knowid) {
		pmsKnowledgesMapper.updateKnowledgeComtnum(knowid);
		
	}
	@Override
	public PmsKnowledges selectByKnowledgesKnowid(Long knowid) {
		
		return pmsKnowledgesMapper.selectByKnowledgesKnowid(knowid);
	}
	@Override
	public void update_knowlwdge(PmsKnowledges pmsKnowledges) {
		pmsKnowledgesMapper.update_knowlwdge(pmsKnowledges);
	}
	@Override
	public void updateKnowledgeLaud(Long knowid) {
		pmsKnowledgesMapper.updateKnowledgeLaud(knowid);
		
	}
	@Override
	public void updateKnowledgeView(Long knowid) {
		pmsKnowledgesMapper.updateKnowledgeView(knowid);
	}
	@Override
	public List<PmsKnowledgesUser> selectlistPmsKnowledgesUserBykeywords(
			String keywords) {
		
		return pmsKnowledgesMapper.selectlistPmsKnowledgesUserBykeywords(keywords);
	}
	@Override
	public List<String> selectAlltag() {
		
		return pmsKnowledgesMapper.selectAlltag();
	}
	@Override
	public List<String> selectAlltitle() {
		
		return pmsKnowledgesMapper.selectAlltitle();
	}
	@Override
	public Long selectCommentuseridByknowid(Long knowid) {
		
		return pmsKnowledgesMapper.selectCommentuseridByknowid(knowid);
	}
	@Override
	public void updateKnowledgeLaud2(Long knowid) {
		pmsKnowledgesMapper.updateKnowledgeLaud2(knowid);
		
	}
	@Override
	public void insertLaud(PmsKnowledgesLaud pmsKnowledgesLaud) {
		pmsKnowledgesMapper.insertLaud(pmsKnowledgesLaud);
		
	}
	@Override
	public Long selectLauderuseridByknowid(Long knowid) {
		
		return pmsKnowledgesMapper.selectLauderuseridByknowid(knowid);
	}
	@Override
	public void delLaudByKnowid(PmsUseridKnowid pmsUseridKnowid) {
		pmsKnowledgesMapper.delLaudByKnowid(pmsUseridKnowid);
		
	}

}
