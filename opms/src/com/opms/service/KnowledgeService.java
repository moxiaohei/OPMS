package com.opms.service;

import java.util.List;

import com.opms.entity.PmsCommentUser;
import com.opms.entity.PmsKnowledges;
import com.opms.entity.PmsKnowledgesComment;
import com.opms.entity.PmsKnowledgesLaud;
import com.opms.entity.PmsKnowledgesUser;
import com.opms.entity.PmsUseridKnowid;

public interface KnowledgeService {

	public List<String> listFindTitleAll();

	public void insertSelective(PmsKnowledges pmsKnowlwdges2);

	//public List<PmsKnowledges> selectByPrimaryKey(long knowid);

	public List<PmsKnowledges> selectByKnowledgesKey(long userid);

	public List<PmsKnowledgesUser> selectByKnowledgesUserKey(Long id);

	public List<PmsKnowledgesUser> selectByKnowledgesUsersortid(int sortid);

	public List<PmsKnowledgesUser> selectKnowledgesUser();

	public List<PmsKnowledgesUser> selectByKnowledgesUserknowid(Long knowid);

	public List<PmsCommentUser> selectCommentByKnowledgeKnowid(Long knowid);

	public void insertComment(PmsKnowledgesComment pmsKnowledgesComment);

	public PmsCommentUser selectCommentByKnowledgecomtid(Long comtid);

	public Long selectKnowledgesuseridByknowid(Long knowid);

	public void delKnowledgesByKnowid(Long knowid);

	public void delCommentByKnowid(Long knowid);

	public void updateKnowledgeComtnum(Long knowid);

	public PmsKnowledges selectByKnowledgesKnowid(Long knowid);

	public void update_knowlwdge(PmsKnowledges pmsKnowledges);

	public void updateKnowledgeLaud(Long knowid);

	public void updateKnowledgeView(Long knowid);

	public List<PmsKnowledgesUser> selectlistPmsKnowledgesUserBykeywords(
			String keywords);

	public List<String> selectAlltag();

	public List<String> selectAlltitle();

	public Long selectCommentuseridByknowid(Long knowid);

	public void updateKnowledgeLaud2(Long knowid);

	public void insertLaud(PmsKnowledgesLaud pmsKnowledgesLaud);

	public Long selectLauderuseridByknowid(Long knowid);

	public void delLaudByKnowid(PmsUseridKnowid pmsUseridKnowid); 
		
		

}
