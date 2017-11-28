/**
 * 
 */
package com.luisusr.demopruebas.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.luisusr.demopruebas.dto.EmpDTO;
import com.luisusr.demopruebas.srv.impl.ServicioComponent;

/**
 * @author luisusr
 *
 */
@Component
@Path("/raw/")
@Produces(MediaType.APPLICATION_JSON)
public class ServicioRest {
	@Autowired
	private ServicioComponent servicio;
	
	@GET
	public String returnRawJson(){
		return "{\"nombre\":\"mi nombre\", \"apellidos\":\"apellido1 apellido2\"}";
	}
	
	@GET
	@Path("daoemp")
	public List<EmpDTO> getAllEmps()
	{
		return servicio.getAllEmps();
	}

}
