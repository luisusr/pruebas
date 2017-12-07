/**
 * 
 */
package com.luisusr.webdemo.web;

import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.luisusr.webdemo.dto.EmpDTO;
import com.luisusr.webdemo.srv.impl.Servicio;

/**
 * @author luisusr
 *
 */
@Controller
public class IndexController {
	
	private static final Log log = LogFactory.getLog(IndexController.class);
	
	@Autowired
	private Servicio servicio;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	@ResponseBody
	public String manejarIndex()
	{
		return "WEb DEMO 1.0";
	}
	
	
	@RequestMapping(value = "/ds", method = RequestMethod.GET)
	@ResponseBody
	public String obtenercontesto()
	{
		try {
			InitialContext ini = new InitialContext();
			log.info("contexted!");
			DataSource ds = (DataSource) ini.lookup("java:comp/env/jdbc/pruebaWeb");   
			log.info("lucuped!");
			log.info(ds.toString());
			
			return "SUCECS";
		} catch (NamingException e) {
		
			e.printStackTrace();
			log.error("EEEERR LUCUP "+e);
			if(e.getMessage()!=null)
				log.error("causado por: " + e.getMessage());
		}  
		
		return "ERROR";
		
	}
	
	@RequestMapping(value = "/daoemp", method = RequestMethod.GET)
	@ResponseBody
	public List<EmpDTO> getAllEmps()
	{
		return servicio.getAllEmps();
	}
	
	

}
