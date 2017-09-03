package com.opms.entity;

import java.util.ArrayList;
import java.util.List;

public class PmsProjectsTaskExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PmsProjectsTaskExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andTaskidIsNull() {
            addCriterion("taskid is null");
            return (Criteria) this;
        }

        public Criteria andTaskidIsNotNull() {
            addCriterion("taskid is not null");
            return (Criteria) this;
        }

        public Criteria andTaskidEqualTo(Long value) {
            addCriterion("taskid =", value, "taskid");
            return (Criteria) this;
        }

        public Criteria andTaskidNotEqualTo(Long value) {
            addCriterion("taskid <>", value, "taskid");
            return (Criteria) this;
        }

        public Criteria andTaskidGreaterThan(Long value) {
            addCriterion("taskid >", value, "taskid");
            return (Criteria) this;
        }

        public Criteria andTaskidGreaterThanOrEqualTo(Long value) {
            addCriterion("taskid >=", value, "taskid");
            return (Criteria) this;
        }

        public Criteria andTaskidLessThan(Long value) {
            addCriterion("taskid <", value, "taskid");
            return (Criteria) this;
        }

        public Criteria andTaskidLessThanOrEqualTo(Long value) {
            addCriterion("taskid <=", value, "taskid");
            return (Criteria) this;
        }

        public Criteria andTaskidIn(List<Long> values) {
            addCriterion("taskid in", values, "taskid");
            return (Criteria) this;
        }

        public Criteria andTaskidNotIn(List<Long> values) {
            addCriterion("taskid not in", values, "taskid");
            return (Criteria) this;
        }

        public Criteria andTaskidBetween(Long value1, Long value2) {
            addCriterion("taskid between", value1, value2, "taskid");
            return (Criteria) this;
        }

        public Criteria andTaskidNotBetween(Long value1, Long value2) {
            addCriterion("taskid not between", value1, value2, "taskid");
            return (Criteria) this;
        }

        public Criteria andNeedsidIsNull() {
            addCriterion("needsid is null");
            return (Criteria) this;
        }

        public Criteria andNeedsidIsNotNull() {
            addCriterion("needsid is not null");
            return (Criteria) this;
        }

        public Criteria andNeedsidEqualTo(Long value) {
            addCriterion("needsid =", value, "needsid");
            return (Criteria) this;
        }

        public Criteria andNeedsidNotEqualTo(Long value) {
            addCriterion("needsid <>", value, "needsid");
            return (Criteria) this;
        }

        public Criteria andNeedsidGreaterThan(Long value) {
            addCriterion("needsid >", value, "needsid");
            return (Criteria) this;
        }

        public Criteria andNeedsidGreaterThanOrEqualTo(Long value) {
            addCriterion("needsid >=", value, "needsid");
            return (Criteria) this;
        }

        public Criteria andNeedsidLessThan(Long value) {
            addCriterion("needsid <", value, "needsid");
            return (Criteria) this;
        }

        public Criteria andNeedsidLessThanOrEqualTo(Long value) {
            addCriterion("needsid <=", value, "needsid");
            return (Criteria) this;
        }

        public Criteria andNeedsidIn(List<Long> values) {
            addCriterion("needsid in", values, "needsid");
            return (Criteria) this;
        }

        public Criteria andNeedsidNotIn(List<Long> values) {
            addCriterion("needsid not in", values, "needsid");
            return (Criteria) this;
        }

        public Criteria andNeedsidBetween(Long value1, Long value2) {
            addCriterion("needsid between", value1, value2, "needsid");
            return (Criteria) this;
        }

        public Criteria andNeedsidNotBetween(Long value1, Long value2) {
            addCriterion("needsid not between", value1, value2, "needsid");
            return (Criteria) this;
        }

        public Criteria andUseridIsNull() {
            addCriterion("userid is null");
            return (Criteria) this;
        }

        public Criteria andUseridIsNotNull() {
            addCriterion("userid is not null");
            return (Criteria) this;
        }

        public Criteria andUseridEqualTo(Long value) {
            addCriterion("userid =", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotEqualTo(Long value) {
            addCriterion("userid <>", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThan(Long value) {
            addCriterion("userid >", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThanOrEqualTo(Long value) {
            addCriterion("userid >=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThan(Long value) {
            addCriterion("userid <", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThanOrEqualTo(Long value) {
            addCriterion("userid <=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridIn(List<Long> values) {
            addCriterion("userid in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotIn(List<Long> values) {
            addCriterion("userid not in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridBetween(Long value1, Long value2) {
            addCriterion("userid between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotBetween(Long value1, Long value2) {
            addCriterion("userid not between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andProjectidIsNull() {
            addCriterion("projectid is null");
            return (Criteria) this;
        }

        public Criteria andProjectidIsNotNull() {
            addCriterion("projectid is not null");
            return (Criteria) this;
        }

        public Criteria andProjectidEqualTo(Long value) {
            addCriterion("projectid =", value, "projectid");
            return (Criteria) this;
        }

        public Criteria andProjectidNotEqualTo(Long value) {
            addCriterion("projectid <>", value, "projectid");
            return (Criteria) this;
        }

        public Criteria andProjectidGreaterThan(Long value) {
            addCriterion("projectid >", value, "projectid");
            return (Criteria) this;
        }

        public Criteria andProjectidGreaterThanOrEqualTo(Long value) {
            addCriterion("projectid >=", value, "projectid");
            return (Criteria) this;
        }

        public Criteria andProjectidLessThan(Long value) {
            addCriterion("projectid <", value, "projectid");
            return (Criteria) this;
        }

        public Criteria andProjectidLessThanOrEqualTo(Long value) {
            addCriterion("projectid <=", value, "projectid");
            return (Criteria) this;
        }

        public Criteria andProjectidIn(List<Long> values) {
            addCriterion("projectid in", values, "projectid");
            return (Criteria) this;
        }

        public Criteria andProjectidNotIn(List<Long> values) {
            addCriterion("projectid not in", values, "projectid");
            return (Criteria) this;
        }

        public Criteria andProjectidBetween(Long value1, Long value2) {
            addCriterion("projectid between", value1, value2, "projectid");
            return (Criteria) this;
        }

        public Criteria andProjectidNotBetween(Long value1, Long value2) {
            addCriterion("projectid not between", value1, value2, "projectid");
            return (Criteria) this;
        }

        public Criteria andAcceptidIsNull() {
            addCriterion("acceptid is null");
            return (Criteria) this;
        }

        public Criteria andAcceptidIsNotNull() {
            addCriterion("acceptid is not null");
            return (Criteria) this;
        }

        public Criteria andAcceptidEqualTo(Long value) {
            addCriterion("acceptid =", value, "acceptid");
            return (Criteria) this;
        }

        public Criteria andAcceptidNotEqualTo(Long value) {
            addCriterion("acceptid <>", value, "acceptid");
            return (Criteria) this;
        }

        public Criteria andAcceptidGreaterThan(Long value) {
            addCriterion("acceptid >", value, "acceptid");
            return (Criteria) this;
        }

        public Criteria andAcceptidGreaterThanOrEqualTo(Long value) {
            addCriterion("acceptid >=", value, "acceptid");
            return (Criteria) this;
        }

        public Criteria andAcceptidLessThan(Long value) {
            addCriterion("acceptid <", value, "acceptid");
            return (Criteria) this;
        }

        public Criteria andAcceptidLessThanOrEqualTo(Long value) {
            addCriterion("acceptid <=", value, "acceptid");
            return (Criteria) this;
        }

        public Criteria andAcceptidIn(List<Long> values) {
            addCriterion("acceptid in", values, "acceptid");
            return (Criteria) this;
        }

        public Criteria andAcceptidNotIn(List<Long> values) {
            addCriterion("acceptid not in", values, "acceptid");
            return (Criteria) this;
        }

        public Criteria andAcceptidBetween(Long value1, Long value2) {
            addCriterion("acceptid between", value1, value2, "acceptid");
            return (Criteria) this;
        }

        public Criteria andAcceptidNotBetween(Long value1, Long value2) {
            addCriterion("acceptid not between", value1, value2, "acceptid");
            return (Criteria) this;
        }

        public Criteria andCcidIsNull() {
            addCriterion("ccid is null");
            return (Criteria) this;
        }

        public Criteria andCcidIsNotNull() {
            addCriterion("ccid is not null");
            return (Criteria) this;
        }

        public Criteria andCcidEqualTo(String value) {
            addCriterion("ccid =", value, "ccid");
            return (Criteria) this;
        }

        public Criteria andCcidNotEqualTo(String value) {
            addCriterion("ccid <>", value, "ccid");
            return (Criteria) this;
        }

        public Criteria andCcidGreaterThan(String value) {
            addCriterion("ccid >", value, "ccid");
            return (Criteria) this;
        }

        public Criteria andCcidGreaterThanOrEqualTo(String value) {
            addCriterion("ccid >=", value, "ccid");
            return (Criteria) this;
        }

        public Criteria andCcidLessThan(String value) {
            addCriterion("ccid <", value, "ccid");
            return (Criteria) this;
        }

        public Criteria andCcidLessThanOrEqualTo(String value) {
            addCriterion("ccid <=", value, "ccid");
            return (Criteria) this;
        }

        public Criteria andCcidLike(String value) {
            addCriterion("ccid like", value, "ccid");
            return (Criteria) this;
        }

        public Criteria andCcidNotLike(String value) {
            addCriterion("ccid not like", value, "ccid");
            return (Criteria) this;
        }

        public Criteria andCcidIn(List<String> values) {
            addCriterion("ccid in", values, "ccid");
            return (Criteria) this;
        }

        public Criteria andCcidNotIn(List<String> values) {
            addCriterion("ccid not in", values, "ccid");
            return (Criteria) this;
        }

        public Criteria andCcidBetween(String value1, String value2) {
            addCriterion("ccid between", value1, value2, "ccid");
            return (Criteria) this;
        }

        public Criteria andCcidNotBetween(String value1, String value2) {
            addCriterion("ccid not between", value1, value2, "ccid");
            return (Criteria) this;
        }

        public Criteria andCompleteidIsNull() {
            addCriterion("completeid is null");
            return (Criteria) this;
        }

        public Criteria andCompleteidIsNotNull() {
            addCriterion("completeid is not null");
            return (Criteria) this;
        }

        public Criteria andCompleteidEqualTo(Long value) {
            addCriterion("completeid =", value, "completeid");
            return (Criteria) this;
        }

        public Criteria andCompleteidNotEqualTo(Long value) {
            addCriterion("completeid <>", value, "completeid");
            return (Criteria) this;
        }

        public Criteria andCompleteidGreaterThan(Long value) {
            addCriterion("completeid >", value, "completeid");
            return (Criteria) this;
        }

        public Criteria andCompleteidGreaterThanOrEqualTo(Long value) {
            addCriterion("completeid >=", value, "completeid");
            return (Criteria) this;
        }

        public Criteria andCompleteidLessThan(Long value) {
            addCriterion("completeid <", value, "completeid");
            return (Criteria) this;
        }

        public Criteria andCompleteidLessThanOrEqualTo(Long value) {
            addCriterion("completeid <=", value, "completeid");
            return (Criteria) this;
        }

        public Criteria andCompleteidIn(List<Long> values) {
            addCriterion("completeid in", values, "completeid");
            return (Criteria) this;
        }

        public Criteria andCompleteidNotIn(List<Long> values) {
            addCriterion("completeid not in", values, "completeid");
            return (Criteria) this;
        }

        public Criteria andCompleteidBetween(Long value1, Long value2) {
            addCriterion("completeid between", value1, value2, "completeid");
            return (Criteria) this;
        }

        public Criteria andCompleteidNotBetween(Long value1, Long value2) {
            addCriterion("completeid not between", value1, value2, "completeid");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(Integer value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(Integer value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(Integer value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(Integer value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(Integer value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<Integer> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<Integer> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(Integer value1, Integer value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andLevelIsNull() {
            addCriterion("level is null");
            return (Criteria) this;
        }

        public Criteria andLevelIsNotNull() {
            addCriterion("level is not null");
            return (Criteria) this;
        }

        public Criteria andLevelEqualTo(Integer value) {
            addCriterion("level =", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotEqualTo(Integer value) {
            addCriterion("level <>", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelGreaterThan(Integer value) {
            addCriterion("level >", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("level >=", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLessThan(Integer value) {
            addCriterion("level <", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLessThanOrEqualTo(Integer value) {
            addCriterion("level <=", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelIn(List<Integer> values) {
            addCriterion("level in", values, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotIn(List<Integer> values) {
            addCriterion("level not in", values, "level");
            return (Criteria) this;
        }

        public Criteria andLevelBetween(Integer value1, Integer value2) {
            addCriterion("level between", value1, value2, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotBetween(Integer value1, Integer value2) {
            addCriterion("level not between", value1, value2, "level");
            return (Criteria) this;
        }

        public Criteria andTasktimeIsNull() {
            addCriterion("tasktime is null");
            return (Criteria) this;
        }

        public Criteria andTasktimeIsNotNull() {
            addCriterion("tasktime is not null");
            return (Criteria) this;
        }

        public Criteria andTasktimeEqualTo(Integer value) {
            addCriterion("tasktime =", value, "tasktime");
            return (Criteria) this;
        }

        public Criteria andTasktimeNotEqualTo(Integer value) {
            addCriterion("tasktime <>", value, "tasktime");
            return (Criteria) this;
        }

        public Criteria andTasktimeGreaterThan(Integer value) {
            addCriterion("tasktime >", value, "tasktime");
            return (Criteria) this;
        }

        public Criteria andTasktimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("tasktime >=", value, "tasktime");
            return (Criteria) this;
        }

        public Criteria andTasktimeLessThan(Integer value) {
            addCriterion("tasktime <", value, "tasktime");
            return (Criteria) this;
        }

        public Criteria andTasktimeLessThanOrEqualTo(Integer value) {
            addCriterion("tasktime <=", value, "tasktime");
            return (Criteria) this;
        }

        public Criteria andTasktimeIn(List<Integer> values) {
            addCriterion("tasktime in", values, "tasktime");
            return (Criteria) this;
        }

        public Criteria andTasktimeNotIn(List<Integer> values) {
            addCriterion("tasktime not in", values, "tasktime");
            return (Criteria) this;
        }

        public Criteria andTasktimeBetween(Integer value1, Integer value2) {
            addCriterion("tasktime between", value1, value2, "tasktime");
            return (Criteria) this;
        }

        public Criteria andTasktimeNotBetween(Integer value1, Integer value2) {
            addCriterion("tasktime not between", value1, value2, "tasktime");
            return (Criteria) this;
        }

        public Criteria andEndedIsNull() {
            addCriterion("ended is null");
            return (Criteria) this;
        }

        public Criteria andEndedIsNotNull() {
            addCriterion("ended is not null");
            return (Criteria) this;
        }

        public Criteria andEndedEqualTo(Integer value) {
            addCriterion("ended =", value, "ended");
            return (Criteria) this;
        }

        public Criteria andEndedNotEqualTo(Integer value) {
            addCriterion("ended <>", value, "ended");
            return (Criteria) this;
        }

        public Criteria andEndedGreaterThan(Integer value) {
            addCriterion("ended >", value, "ended");
            return (Criteria) this;
        }

        public Criteria andEndedGreaterThanOrEqualTo(Integer value) {
            addCriterion("ended >=", value, "ended");
            return (Criteria) this;
        }

        public Criteria andEndedLessThan(Integer value) {
            addCriterion("ended <", value, "ended");
            return (Criteria) this;
        }

        public Criteria andEndedLessThanOrEqualTo(Integer value) {
            addCriterion("ended <=", value, "ended");
            return (Criteria) this;
        }

        public Criteria andEndedIn(List<Integer> values) {
            addCriterion("ended in", values, "ended");
            return (Criteria) this;
        }

        public Criteria andEndedNotIn(List<Integer> values) {
            addCriterion("ended not in", values, "ended");
            return (Criteria) this;
        }

        public Criteria andEndedBetween(Integer value1, Integer value2) {
            addCriterion("ended between", value1, value2, "ended");
            return (Criteria) this;
        }

        public Criteria andEndedNotBetween(Integer value1, Integer value2) {
            addCriterion("ended not between", value1, value2, "ended");
            return (Criteria) this;
        }

        public Criteria andStartedIsNull() {
            addCriterion("started is null");
            return (Criteria) this;
        }

        public Criteria andStartedIsNotNull() {
            addCriterion("started is not null");
            return (Criteria) this;
        }

        public Criteria andStartedEqualTo(Integer value) {
            addCriterion("started =", value, "started");
            return (Criteria) this;
        }

        public Criteria andStartedNotEqualTo(Integer value) {
            addCriterion("started <>", value, "started");
            return (Criteria) this;
        }

        public Criteria andStartedGreaterThan(Integer value) {
            addCriterion("started >", value, "started");
            return (Criteria) this;
        }

        public Criteria andStartedGreaterThanOrEqualTo(Integer value) {
            addCriterion("started >=", value, "started");
            return (Criteria) this;
        }

        public Criteria andStartedLessThan(Integer value) {
            addCriterion("started <", value, "started");
            return (Criteria) this;
        }

        public Criteria andStartedLessThanOrEqualTo(Integer value) {
            addCriterion("started <=", value, "started");
            return (Criteria) this;
        }

        public Criteria andStartedIn(List<Integer> values) {
            addCriterion("started in", values, "started");
            return (Criteria) this;
        }

        public Criteria andStartedNotIn(List<Integer> values) {
            addCriterion("started not in", values, "started");
            return (Criteria) this;
        }

        public Criteria andStartedBetween(Integer value1, Integer value2) {
            addCriterion("started between", value1, value2, "started");
            return (Criteria) this;
        }

        public Criteria andStartedNotBetween(Integer value1, Integer value2) {
            addCriterion("started not between", value1, value2, "started");
            return (Criteria) this;
        }

        public Criteria andAttachmentIsNull() {
            addCriterion("attachment is null");
            return (Criteria) this;
        }

        public Criteria andAttachmentIsNotNull() {
            addCriterion("attachment is not null");
            return (Criteria) this;
        }

        public Criteria andAttachmentEqualTo(String value) {
            addCriterion("attachment =", value, "attachment");
            return (Criteria) this;
        }

        public Criteria andAttachmentNotEqualTo(String value) {
            addCriterion("attachment <>", value, "attachment");
            return (Criteria) this;
        }

        public Criteria andAttachmentGreaterThan(String value) {
            addCriterion("attachment >", value, "attachment");
            return (Criteria) this;
        }

        public Criteria andAttachmentGreaterThanOrEqualTo(String value) {
            addCriterion("attachment >=", value, "attachment");
            return (Criteria) this;
        }

        public Criteria andAttachmentLessThan(String value) {
            addCriterion("attachment <", value, "attachment");
            return (Criteria) this;
        }

        public Criteria andAttachmentLessThanOrEqualTo(String value) {
            addCriterion("attachment <=", value, "attachment");
            return (Criteria) this;
        }

        public Criteria andAttachmentLike(String value) {
            addCriterion("attachment like", value, "attachment");
            return (Criteria) this;
        }

        public Criteria andAttachmentNotLike(String value) {
            addCriterion("attachment not like", value, "attachment");
            return (Criteria) this;
        }

        public Criteria andAttachmentIn(List<String> values) {
            addCriterion("attachment in", values, "attachment");
            return (Criteria) this;
        }

        public Criteria andAttachmentNotIn(List<String> values) {
            addCriterion("attachment not in", values, "attachment");
            return (Criteria) this;
        }

        public Criteria andAttachmentBetween(String value1, String value2) {
            addCriterion("attachment between", value1, value2, "attachment");
            return (Criteria) this;
        }

        public Criteria andAttachmentNotBetween(String value1, String value2) {
            addCriterion("attachment not between", value1, value2, "attachment");
            return (Criteria) this;
        }

        public Criteria andCreatedIsNull() {
            addCriterion("created is null");
            return (Criteria) this;
        }

        public Criteria andCreatedIsNotNull() {
            addCriterion("created is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedEqualTo(Integer value) {
            addCriterion("created =", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedNotEqualTo(Integer value) {
            addCriterion("created <>", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedGreaterThan(Integer value) {
            addCriterion("created >", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedGreaterThanOrEqualTo(Integer value) {
            addCriterion("created >=", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedLessThan(Integer value) {
            addCriterion("created <", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedLessThanOrEqualTo(Integer value) {
            addCriterion("created <=", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedIn(List<Integer> values) {
            addCriterion("created in", values, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedNotIn(List<Integer> values) {
            addCriterion("created not in", values, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedBetween(Integer value1, Integer value2) {
            addCriterion("created between", value1, value2, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedNotBetween(Integer value1, Integer value2) {
            addCriterion("created not between", value1, value2, "created");
            return (Criteria) this;
        }

        public Criteria andChangedIsNull() {
            addCriterion("changed is null");
            return (Criteria) this;
        }

        public Criteria andChangedIsNotNull() {
            addCriterion("changed is not null");
            return (Criteria) this;
        }

        public Criteria andChangedEqualTo(Integer value) {
            addCriterion("changed =", value, "changed");
            return (Criteria) this;
        }

        public Criteria andChangedNotEqualTo(Integer value) {
            addCriterion("changed <>", value, "changed");
            return (Criteria) this;
        }

        public Criteria andChangedGreaterThan(Integer value) {
            addCriterion("changed >", value, "changed");
            return (Criteria) this;
        }

        public Criteria andChangedGreaterThanOrEqualTo(Integer value) {
            addCriterion("changed >=", value, "changed");
            return (Criteria) this;
        }

        public Criteria andChangedLessThan(Integer value) {
            addCriterion("changed <", value, "changed");
            return (Criteria) this;
        }

        public Criteria andChangedLessThanOrEqualTo(Integer value) {
            addCriterion("changed <=", value, "changed");
            return (Criteria) this;
        }

        public Criteria andChangedIn(List<Integer> values) {
            addCriterion("changed in", values, "changed");
            return (Criteria) this;
        }

        public Criteria andChangedNotIn(List<Integer> values) {
            addCriterion("changed not in", values, "changed");
            return (Criteria) this;
        }

        public Criteria andChangedBetween(Integer value1, Integer value2) {
            addCriterion("changed between", value1, value2, "changed");
            return (Criteria) this;
        }

        public Criteria andChangedNotBetween(Integer value1, Integer value2) {
            addCriterion("changed not between", value1, value2, "changed");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andCloseidIsNull() {
            addCriterion("closeid is null");
            return (Criteria) this;
        }

        public Criteria andCloseidIsNotNull() {
            addCriterion("closeid is not null");
            return (Criteria) this;
        }

        public Criteria andCloseidEqualTo(Long value) {
            addCriterion("closeid =", value, "closeid");
            return (Criteria) this;
        }

        public Criteria andCloseidNotEqualTo(Long value) {
            addCriterion("closeid <>", value, "closeid");
            return (Criteria) this;
        }

        public Criteria andCloseidGreaterThan(Long value) {
            addCriterion("closeid >", value, "closeid");
            return (Criteria) this;
        }

        public Criteria andCloseidGreaterThanOrEqualTo(Long value) {
            addCriterion("closeid >=", value, "closeid");
            return (Criteria) this;
        }

        public Criteria andCloseidLessThan(Long value) {
            addCriterion("closeid <", value, "closeid");
            return (Criteria) this;
        }

        public Criteria andCloseidLessThanOrEqualTo(Long value) {
            addCriterion("closeid <=", value, "closeid");
            return (Criteria) this;
        }

        public Criteria andCloseidIn(List<Long> values) {
            addCriterion("closeid in", values, "closeid");
            return (Criteria) this;
        }

        public Criteria andCloseidNotIn(List<Long> values) {
            addCriterion("closeid not in", values, "closeid");
            return (Criteria) this;
        }

        public Criteria andCloseidBetween(Long value1, Long value2) {
            addCriterion("closeid between", value1, value2, "closeid");
            return (Criteria) this;
        }

        public Criteria andCloseidNotBetween(Long value1, Long value2) {
            addCriterion("closeid not between", value1, value2, "closeid");
            return (Criteria) this;
        }

        public Criteria andCancelidIsNull() {
            addCriterion("cancelid is null");
            return (Criteria) this;
        }

        public Criteria andCancelidIsNotNull() {
            addCriterion("cancelid is not null");
            return (Criteria) this;
        }

        public Criteria andCancelidEqualTo(Long value) {
            addCriterion("cancelid =", value, "cancelid");
            return (Criteria) this;
        }

        public Criteria andCancelidNotEqualTo(Long value) {
            addCriterion("cancelid <>", value, "cancelid");
            return (Criteria) this;
        }

        public Criteria andCancelidGreaterThan(Long value) {
            addCriterion("cancelid >", value, "cancelid");
            return (Criteria) this;
        }

        public Criteria andCancelidGreaterThanOrEqualTo(Long value) {
            addCriterion("cancelid >=", value, "cancelid");
            return (Criteria) this;
        }

        public Criteria andCancelidLessThan(Long value) {
            addCriterion("cancelid <", value, "cancelid");
            return (Criteria) this;
        }

        public Criteria andCancelidLessThanOrEqualTo(Long value) {
            addCriterion("cancelid <=", value, "cancelid");
            return (Criteria) this;
        }

        public Criteria andCancelidIn(List<Long> values) {
            addCriterion("cancelid in", values, "cancelid");
            return (Criteria) this;
        }

        public Criteria andCancelidNotIn(List<Long> values) {
            addCriterion("cancelid not in", values, "cancelid");
            return (Criteria) this;
        }

        public Criteria andCancelidBetween(Long value1, Long value2) {
            addCriterion("cancelid between", value1, value2, "cancelid");
            return (Criteria) this;
        }

        public Criteria andCancelidNotBetween(Long value1, Long value2) {
            addCriterion("cancelid not between", value1, value2, "cancelid");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}