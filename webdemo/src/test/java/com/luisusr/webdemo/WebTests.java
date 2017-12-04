/**
 * 
 */
package com.luisusr.webdemo;

import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.AnnotationConfigWebContextLoader;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;


import com.luisusr.webdemo.configurers.DSConfiguration;
import com.luisusr.webdemo.configurers.MvcConfiguration;
import com.luisusr.webdemo.model.Datosser;

/**
 * @author luisusr
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {DSConfiguration.class, MvcConfiguration.class}, loader=AnnotationConfigWebContextLoader.class)
public class WebTests {
	
	@Autowired
	private HibernateTemplate getHibernateTemplate;
	
	private static final Log log = LogFactory.getLog(WebTests.class);
	
	@Test
	public void probarContestos()
	{
		log.info("contexted!");
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
		data.setContenido(new byte[2]);
		getHibernateTemplate.update(data);
		
	}

}
