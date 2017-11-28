/**
 * 
 */
package com.luisusr.demopruebas;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.luisusr.demopruebas.srv.Servicio;
import com.luisusr.demopruebas.srv.impl.ServicioImpl;

/**
 * @author luisusr
 *
 */
@Configuration
public class UtilConfigurer {
	
	@Bean
	public Servicio miServicio()
	{
		return new ServicioImpl();
	}
	
	@Bean
	public Servicio miServicio(String s)
	{
		System.out.println(s);
		return new ServicioImpl();
	}

}
