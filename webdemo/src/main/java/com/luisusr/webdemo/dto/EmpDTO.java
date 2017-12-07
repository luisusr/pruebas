/**
 * 
 */
package com.luisusr.webdemo.dto;

import java.io.Serializable;

/**
 * @author luisusr
 *
 */
public class EmpDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String empno;
	private String ename;
	private String job;
	private String mgr;
	private String hiredate;
	private String sal;
	private String comm;
	private String deptno;
	private String dname;
	private String loc;
	
	public EmpDTO()
	{
		
	}
	
	/**
	 * @param empno
	 * @param ename
	 * @param job
	 * @param mgr
	 * @param hiredate
	 * @param sal
	 * @param comm
	 * @param deptno
	 * @param deptno_1
	 * @param dname
	 * @param loc
	 */
	public EmpDTO(String empno, String ename, String job, String mgr, String hiredate, String sal, String comm,
			String deptno,  String dname, String loc) {
		this.empno = empno;
		this.ename = ename;
		this.job = job;
		this.mgr = mgr;
		this.hiredate = hiredate;
		this.sal = sal;
		this.comm = comm;
		this.deptno = deptno;
		this.dname = dname;
		this.loc = loc;
	}


	/**
	 * @return the empno
	 */
	public String getEmpno() {
		return empno;
	}
	/**
	 * @param empno the empno to set
	 */
	public void setEmpno(String empno) {
		this.empno = empno;
	}
	/**
	 * @return the ename
	 */
	public String getEname() {
		return ename;
	}
	/**
	 * @param ename the ename to set
	 */
	public void setEname(String ename) {
		this.ename = ename;
	}
	/**
	 * @return the job
	 */
	public String getJob() {
		return job;
	}
	/**
	 * @param job the job to set
	 */
	public void setJob(String job) {
		this.job = job;
	}
	/**
	 * @return the mgr
	 */
	public String getMgr() {
		return mgr;
	}
	/**
	 * @param mgr the mgr to set
	 */
	public void setMgr(String mgr) {
		this.mgr = mgr;
	}
	/**
	 * @return the hiredate
	 */
	public String getHiredate() {
		return hiredate;
	}
	/**
	 * @param hiredate the hiredate to set
	 */
	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}
	/**
	 * @return the sal
	 */
	public String getSal() {
		return sal;
	}
	/**
	 * @param sal the sal to set
	 */
	public void setSal(String sal) {
		this.sal = sal;
	}
	/**
	 * @return the comm
	 */
	public String getComm() {
		return comm;
	}
	/**
	 * @param comm the comm to set
	 */
	public void setComm(String comm) {
		this.comm = comm;
	}
	/**
	 * @return the deptno
	 */
	public String getDeptno() {
		return deptno;
	}
	/**
	 * @param deptno the deptno to set
	 */
	public void setDeptno(String deptno) {
		this.deptno = deptno;
	}
	
	/**
	 * @return the dname
	 */
	public String getDname() {
		return dname;
	}
	/**
	 * @param dname the dname to set
	 */
	public void setDname(String dname) {
		this.dname = dname;
	}
	/**
	 * @return the loc
	 */
	public String getLoc() {
		return loc;
	}
	/**
	 * @param loc the loc to set
	 */
	public void setLoc(String loc) {
		this.loc = loc;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "EmpDTO [empno=" + empno + ", ename=" + ename + ", job=" + job + ", mgr=" + mgr + ", hiredate="
				+ hiredate + ", sal=" + sal + ", comm=" + comm + ", deptno=" + deptno + ", dname=" + dname + ", loc="
				+ loc + "]";
	}

	
	

}
