/**
 * 
 */
package com.luisusr.webdemo.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author luisusr
 *
 */
@Controller
public class WelcomeController {
	
	private static final Log log = LogFactory.getLog(WelcomeController.class);

	
	@RequestMapping(value = "/bienvenida", method = RequestMethod.GET)
    public ModelAndView manejarPeticion(HttpServletRequest request, HttpServletResponse response) throws Exception {
		log.info("bienv");
		return new ModelAndView("welcome");
    }
	
	
	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public ModelAndView manejarWelcome(HttpServletRequest request, HttpServletResponse response) throws Exception {
		log.info("welcmmmmaaavvvvvvv");
		log.info(""+1+1);
		return new ModelAndView();
    }
	
	
	@RequestMapping(value = "/welc", method = RequestMethod.GET)
	public String obtenerWelcomeStr(ModelMap model, HttpServletRequest request)
	{
		log.info("strwelc");
		return "welcome";
	}
	
}
