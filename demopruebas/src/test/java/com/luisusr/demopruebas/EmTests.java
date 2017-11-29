package com.luisusr.demopruebas;

import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.luisusr.demopruebas.dto.EmpDTO;
import com.luisusr.demopruebas.model.Datos;
import com.luisusr.demopruebas.model.Datosser;
import com.luisusr.demopruebas.model.Emp;
import com.luisusr.demopruebas.srv.Servicio;
import com.luisusr.demopruebas.srv.impl.ServicioComponent;



/**
 * @author luisusr
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class EmTests  {
	
	@Autowired
	private Servicio miServicio;
	
	@Autowired
	private ServicioComponent componente;
	
	@Autowired
	private HibernateTemplate getHibernateTemplate;
	
	
	
	
	private static final Log log = LogFactory.getLog(EmTests.class);

	
	@Test
	public void contexto()
	{
		log.info("contexted");
		//getHibernateTemplate().loadAll(Emp.class);
		log.info("obtener servicio de bean escaneado en configuracion: "+miServicio.getText());
		log.info("obtener servicio de componente de componet scan: "+componente.getComponent());
		
		getHibernateTemplate.loadAll(Emp.class).forEach(e->{
			log.info(e.getEmpno()+" "+e.getEname()+" "+e.getJob());
		});
		
		
	}
	
	
	@Test
	@Transactional
	public void contextoAll()
	{
		
		
		getHibernateTemplate.loadAll(Emp.class).forEach(e->{
			log.info(e.getEmpno()+" "+e.getEname()+" "+e.getJob()+" "+e.getDept().getLoc());
		});
		
		
	}
	
	
	
	@Test
	public void empsdto()
	{
		log.info(componente.getAllEmps());
		
	}
	
	@Test
	@Transactional
	@Rollback(false)
	public void instest()
	{
		
		
		Datos data = new Datos();
		data.setFRegistro(new Date());
		log.info("get id B-> "+data.getIdData());
		data.setDescripcion("s");
		//data.setDescripcion("nueva data del reg: "+data.getIdData());
		//transactionManager.getSessionFactory().getCurrentSession().save(data);
		getHibernateTemplate.save(data);
		data.setDescripcion("nueva data del reg: "+data.getIdData());
		log.info("get id A-> "+data.getIdData());
		getHibernateTemplate.update(data);
		
	}
	
	
	@Test
	@Transactional
	@Rollback(false)
	public void instsertest()
	{
		
		
		Datosser data = new Datosser();
		data.setFRegistro(new Date());
		//byte[] bytes = {69};
		//data.setContenido(miServicio.serialize(new EmpDTO()));
		data.setContenido(new byte[1]);
		getHibernateTemplate.save(data);
		data.setContenido(miServicio.serialize(new EmpDTO
				("AA", "BB", "CC", "DD", "EE", "FF", "GG", "HH", "II", "JJ")));
		getHibernateTemplate.update(data);
		
	}


}
