package es.luisusr.miru.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PruebaController {
	
	
	
	@RequestMapping("/pruebars")
	@ResponseBody
	public String hola()
	{
		System.out.println("OLA  en spring MIRUs}3 4");
		
		return "HOLAs34";
	}
	

}
