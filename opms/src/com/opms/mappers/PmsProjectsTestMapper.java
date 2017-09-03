package com.opms.mappers;

import java.util.List;

import com.opms.entity.PmsProjectsTest;

public interface PmsProjectsTestMapper {
	public List<PmsProjectsTest> listPmsProjectsTest(long projectid);

	public PmsProjectsTest getPmsProjectsTest(long testid);

	public void dispatchPeople(PmsProjectsTest pmsProjectsTest);

	public void resolvent(PmsProjectsTest pmsProjectsTest);

	public List<PmsProjectsTest> searchBug(PmsProjectsTest pmsProjectsTest);

	public void updatePmsProjectsTest(PmsProjectsTest pmsProjectsTest);

	public void inssertPmsProjectsTest(PmsProjectsTest pmsProjectsTest);

	public List<PmsProjectsTest> searchByAppoint(Long acceptid, Long projectid);// 由我指派的bug

	public List<PmsProjectsTest> searchByMyCreate(Long userid, Long projectid);// 由我创建的bug

	public List<PmsProjectsTest> searchByMySolve(Long completeid, Long projectid);// 由我解决的的bug
}