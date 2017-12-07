
package com.luisusr.webdemo;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.mock.jndi.SimpleNamingContextBuilder;
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
import com.luisusr.webdemo.model.Emp;
import com.luisusr.webdemo.srv.impl.Servicio;

/**
 * @author luisusr
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {DSConfiguration.class, MvcConfiguration.class}, loader=AnnotationConfigWebContextLoader.class)
public class WebTests {
	
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Autowired
	private Servicio servicio;
	
	private static final Log log = LogFactory.getLog(WebTests.class);
	
	@BeforeClass
	 public static void contextSetup () throws NamingException
	   {
	       SimpleNamingContextBuilder builder = SimpleNamingContextBuilder.emptyActivatedContextBuilder();
	       DriverManagerDataSource dataSource = new DriverManagerDataSource( "jdbc:oracle:thin:@localhost:1521:orcl", "POW_REP", "POW_REP");
	       dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
	       builder.bind("jdbc/log", log);
	       builder.bind("jdbc/pruebaWeb", dataSource);
	   }
	
	@Test
	public void probarContestos()
	{
		
		try {
			InitialContext ini = new InitialContext();
			log.info("contexted!");
			Log lukuplog = (Log) ini.lookup("jdbc/log");
			log.info("lookuped!");
			
			lukuplog.info("este esta logeando con el lucuuuupedddd!!!");
			
		} catch (NamingException e) {
			e.printStackTrace();
		}  
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
		hibernateTemplate.save(data);
		data.setContenido(serialize(getClass()));
		hibernateTemplate.update(data);
		
	}
	
	public byte[] serialize(Serializable obj) {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		  
	    try {
	    	  ObjectOutputStream oos = new ObjectOutputStream(baos);
			oos.writeObject(obj);
		} catch (IOException e) {
			log.error("ocurrio un error al serializar el objeto : "+e);
				if(e.getMessage()!=null)
					log.error(e.getMessage());
		}
	    return baos.toByteArray();
	}
	
	@Test
	@Transactional
	public void DaoTest()
	{
		hibernateTemplate.loadAll(Emp.class).forEach(e->{
			log.info(e.getEmpno()+" "+e.getEname()+" "+e.getJob()+" "+e.getDept().getDname());
		});
		
		
	}
	
	@Test
	public void SRVTest()
	{
		log.info(servicio.getAllEmps().toString());
	}
}
