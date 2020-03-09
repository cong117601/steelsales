package com.ycxy.steelsales.pojo.log;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SteelsaleLogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SteelsaleLogExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andLogTimeIsNull() {
            addCriterion("log_time is null");
            return (Criteria) this;
        }

        public Criteria andLogTimeIsNotNull() {
            addCriterion("log_time is not null");
            return (Criteria) this;
        }

        public Criteria andLogTimeEqualTo(Date value) {
            addCriterion("log_time =", value, "logTime");
            return (Criteria) this;
        }

        public Criteria andLogTimeNotEqualTo(Date value) {
            addCriterion("log_time <>", value, "logTime");
            return (Criteria) this;
        }

        public Criteria andLogTimeGreaterThan(Date value) {
            addCriterion("log_time >", value, "logTime");
            return (Criteria) this;
        }

        public Criteria andLogTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("log_time >=", value, "logTime");
            return (Criteria) this;
        }

        public Criteria andLogTimeLessThan(Date value) {
            addCriterion("log_time <", value, "logTime");
            return (Criteria) this;
        }

        public Criteria andLogTimeLessThanOrEqualTo(Date value) {
            addCriterion("log_time <=", value, "logTime");
            return (Criteria) this;
        }

        public Criteria andLogTimeIn(List<Date> values) {
            addCriterion("log_time in", values, "logTime");
            return (Criteria) this;
        }

        public Criteria andLogTimeNotIn(List<Date> values) {
            addCriterion("log_time not in", values, "logTime");
            return (Criteria) this;
        }

        public Criteria andLogTimeBetween(Date value1, Date value2) {
            addCriterion("log_time between", value1, value2, "logTime");
            return (Criteria) this;
        }

        public Criteria andLogTimeNotBetween(Date value1, Date value2) {
            addCriterion("log_time not between", value1, value2, "logTime");
            return (Criteria) this;
        }

        public Criteria andLogLoginNameIsNull() {
            addCriterion("log_login_name is null");
            return (Criteria) this;
        }

        public Criteria andLogLoginNameIsNotNull() {
            addCriterion("log_login_name is not null");
            return (Criteria) this;
        }

        public Criteria andLogLoginNameEqualTo(String value) {
            addCriterion("log_login_name =", value, "logLoginName");
            return (Criteria) this;
        }

        public Criteria andLogLoginNameNotEqualTo(String value) {
            addCriterion("log_login_name <>", value, "logLoginName");
            return (Criteria) this;
        }

        public Criteria andLogLoginNameGreaterThan(String value) {
            addCriterion("log_login_name >", value, "logLoginName");
            return (Criteria) this;
        }

        public Criteria andLogLoginNameGreaterThanOrEqualTo(String value) {
            addCriterion("log_login_name >=", value, "logLoginName");
            return (Criteria) this;
        }

        public Criteria andLogLoginNameLessThan(String value) {
            addCriterion("log_login_name <", value, "logLoginName");
            return (Criteria) this;
        }

        public Criteria andLogLoginNameLessThanOrEqualTo(String value) {
            addCriterion("log_login_name <=", value, "logLoginName");
            return (Criteria) this;
        }

        public Criteria andLogLoginNameLike(String value) {
            addCriterion("log_login_name like", value, "logLoginName");
            return (Criteria) this;
        }

        public Criteria andLogLoginNameNotLike(String value) {
            addCriterion("log_login_name not like", value, "logLoginName");
            return (Criteria) this;
        }

        public Criteria andLogLoginNameIn(List<String> values) {
            addCriterion("log_login_name in", values, "logLoginName");
            return (Criteria) this;
        }

        public Criteria andLogLoginNameNotIn(List<String> values) {
            addCriterion("log_login_name not in", values, "logLoginName");
            return (Criteria) this;
        }

        public Criteria andLogLoginNameBetween(String value1, String value2) {
            addCriterion("log_login_name between", value1, value2, "logLoginName");
            return (Criteria) this;
        }

        public Criteria andLogLoginNameNotBetween(String value1, String value2) {
            addCriterion("log_login_name not between", value1, value2, "logLoginName");
            return (Criteria) this;
        }

        public Criteria andLogRemoteAddrIsNull() {
            addCriterion("log_remote_addr is null");
            return (Criteria) this;
        }

        public Criteria andLogRemoteAddrIsNotNull() {
            addCriterion("log_remote_addr is not null");
            return (Criteria) this;
        }

        public Criteria andLogRemoteAddrEqualTo(String value) {
            addCriterion("log_remote_addr =", value, "logRemoteAddr");
            return (Criteria) this;
        }

        public Criteria andLogRemoteAddrNotEqualTo(String value) {
            addCriterion("log_remote_addr <>", value, "logRemoteAddr");
            return (Criteria) this;
        }

        public Criteria andLogRemoteAddrGreaterThan(String value) {
            addCriterion("log_remote_addr >", value, "logRemoteAddr");
            return (Criteria) this;
        }

        public Criteria andLogRemoteAddrGreaterThanOrEqualTo(String value) {
            addCriterion("log_remote_addr >=", value, "logRemoteAddr");
            return (Criteria) this;
        }

        public Criteria andLogRemoteAddrLessThan(String value) {
            addCriterion("log_remote_addr <", value, "logRemoteAddr");
            return (Criteria) this;
        }

        public Criteria andLogRemoteAddrLessThanOrEqualTo(String value) {
            addCriterion("log_remote_addr <=", value, "logRemoteAddr");
            return (Criteria) this;
        }

        public Criteria andLogRemoteAddrLike(String value) {
            addCriterion("log_remote_addr like", value, "logRemoteAddr");
            return (Criteria) this;
        }

        public Criteria andLogRemoteAddrNotLike(String value) {
            addCriterion("log_remote_addr not like", value, "logRemoteAddr");
            return (Criteria) this;
        }

        public Criteria andLogRemoteAddrIn(List<String> values) {
            addCriterion("log_remote_addr in", values, "logRemoteAddr");
            return (Criteria) this;
        }

        public Criteria andLogRemoteAddrNotIn(List<String> values) {
            addCriterion("log_remote_addr not in", values, "logRemoteAddr");
            return (Criteria) this;
        }

        public Criteria andLogRemoteAddrBetween(String value1, String value2) {
            addCriterion("log_remote_addr between", value1, value2, "logRemoteAddr");
            return (Criteria) this;
        }

        public Criteria andLogRemoteAddrNotBetween(String value1, String value2) {
            addCriterion("log_remote_addr not between", value1, value2, "logRemoteAddr");
            return (Criteria) this;
        }

        public Criteria andLogUriIsNull() {
            addCriterion("log_uri is null");
            return (Criteria) this;
        }

        public Criteria andLogUriIsNotNull() {
            addCriterion("log_uri is not null");
            return (Criteria) this;
        }

        public Criteria andLogUriEqualTo(String value) {
            addCriterion("log_uri =", value, "logUri");
            return (Criteria) this;
        }

        public Criteria andLogUriNotEqualTo(String value) {
            addCriterion("log_uri <>", value, "logUri");
            return (Criteria) this;
        }

        public Criteria andLogUriGreaterThan(String value) {
            addCriterion("log_uri >", value, "logUri");
            return (Criteria) this;
        }

        public Criteria andLogUriGreaterThanOrEqualTo(String value) {
            addCriterion("log_uri >=", value, "logUri");
            return (Criteria) this;
        }

        public Criteria andLogUriLessThan(String value) {
            addCriterion("log_uri <", value, "logUri");
            return (Criteria) this;
        }

        public Criteria andLogUriLessThanOrEqualTo(String value) {
            addCriterion("log_uri <=", value, "logUri");
            return (Criteria) this;
        }

        public Criteria andLogUriLike(String value) {
            addCriterion("log_uri like", value, "logUri");
            return (Criteria) this;
        }

        public Criteria andLogUriNotLike(String value) {
            addCriterion("log_uri not like", value, "logUri");
            return (Criteria) this;
        }

        public Criteria andLogUriIn(List<String> values) {
            addCriterion("log_uri in", values, "logUri");
            return (Criteria) this;
        }

        public Criteria andLogUriNotIn(List<String> values) {
            addCriterion("log_uri not in", values, "logUri");
            return (Criteria) this;
        }

        public Criteria andLogUriBetween(String value1, String value2) {
            addCriterion("log_uri between", value1, value2, "logUri");
            return (Criteria) this;
        }

        public Criteria andLogUriNotBetween(String value1, String value2) {
            addCriterion("log_uri not between", value1, value2, "logUri");
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