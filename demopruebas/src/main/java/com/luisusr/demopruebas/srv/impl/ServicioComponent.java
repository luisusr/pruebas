/**
 * 
 */
package com.luisusr.demopruebas.srv.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.luisusr.demopruebas.dto.EmpDTO;
import com.luisusr.demopruebas.model.Emp;

/**
 * @author luisusr
 *
 */
@Component
public class ServicioComponent {
	
	@Autowired
	private HibernateTemplate getHibernateTemplate;

	public String getComponent()
	{
		return "service desde component";
	}
	
	@Transactional
	public List<EmpDTO> getAllEmps()
	{
		List<EmpDTO> emps = new ArrayList<>();
		getHibernateTemplate.loadAll(Emp.class).forEach(e->{
			emps.add(new EmpDTO(e.getEmpno().toString(), e.getEname(), 
					e.getJob(), e.getMgr()==null ? "0":e.getMgr().toString(), 
					e.getHiredate().toString(), e.getSal().toString(), 
					e.getComm()==null ? "0":e.getComm().toString(), 
					e.getDept().getDeptno().toString(), 
					e.getDept().getDname(), e.getDept().getLoc()));
		});
		return emps;
		 
	}
	
}
