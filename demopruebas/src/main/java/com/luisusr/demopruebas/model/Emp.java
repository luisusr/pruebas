package com.luisusr.demopruebas.model;
// Generated Nov 28, 2017 10:50:26 AM by Hibernate Tools 5.1.6.Final

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Emp generated by hbm2java
 */
@Entity
@Table(name = "EMP", schema = "POW_REP")
public class Emp implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long empno;
	private Dept dept;
	private String ename;
	private String job;
	private Short mgr;
	private Date hiredate;
	private BigDecimal sal;
	private BigDecimal comm;

	public Emp() {
	}

	public Emp(Long empno) {
		this.empno = empno;
	}

	public Emp(Long empno, Dept dept, String ename, String job, Short mgr, Date hiredate, BigDecimal sal,
			BigDecimal comm) {
		this.empno = empno;
		this.dept = dept;
		this.ename = ename;
		this.job = job;
		this.mgr = mgr;
		this.hiredate = hiredate;
		this.sal = sal;
		this.comm = comm;
	}

	@Id

	@Column(name = "EMPNO", unique = true, nullable = false, precision = 4, scale = 0)
	public Long getEmpno() {
		return this.empno;
	}

	public void setEmpno(Long empno) {
		this.empno = empno;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DEPTNO")
	public Dept getDept() {
		return this.dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}

	@Column(name = "ENAME", length = 10)
	public String getEname() {
		return this.ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	@Column(name = "JOB", length = 9)
	public String getJob() {
		return this.job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	@Column(name = "MGR", precision = 4, scale = 0)
	public Short getMgr() {
		return this.mgr;
	}

	public void setMgr(Short mgr) {
		this.mgr = mgr;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "HIREDATE", length = 7)
	public Date getHiredate() {
		return this.hiredate;
	}

	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}

	@Column(name = "SAL", precision = 7)
	public BigDecimal getSal() {
		return this.sal;
	}

	public void setSal(BigDecimal sal) {
		this.sal = sal;
	}

	@Column(name = "COMM", precision = 7)
	public BigDecimal getComm() {
		return this.comm;
	}

	public void setComm(BigDecimal comm) {
		this.comm = comm;
	}

}
