/**
 * 
 */
package com.luisusr.demopruebas.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author luisusr
 *
 */
@Controller
public class WelcomeController {

	
	@RequestMapping(value = "/bienvenida", method = RequestMethod.GET)
    public ModelAndView manejarPeticion(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("bienv");
		return new ModelAndView("welcome");
    }
	
	
	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public ModelAndView manejarWelcome(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("welc");
		return new ModelAndView();
    }
	
}
