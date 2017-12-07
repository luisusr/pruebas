/**
 * 
 */
package com.luisusr.webdemo.srv.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.luisusr.webdemo.dto.EmpDTO;
import com.luisusr.webdemo.model.Emp;


/**
 * @author luisusr
 *
 */
@Component
public class Servicio {
	
	@Autowired
	private HibernateTemplate hibernateTemplate;

    @Transactional
	public List<EmpDTO> getAllEmps()
	{
		List<EmpDTO> emps = new ArrayList<>();
		hibernateTemplate.loadAll(Emp.class).forEach(e->{ 
			emps.add(new EmpDTO(e.getEmpno().toString(), e.getEname(), 
					e.getJob(), e.getMgr()==null ? "0":e.getMgr().toString(), 
					e.getHiredate().toString(), e.getSal().toString(), 
					e.getComm()==null ? "0":e.getComm().toString(),
					e.getDept().getDeptno().toString(), 
					e.getDept().getDname(), 
					e.getDept().getLoc()
					));
		});
		return emps;
		 
	}

    
}
