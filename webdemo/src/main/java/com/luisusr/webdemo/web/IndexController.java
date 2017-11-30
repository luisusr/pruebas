/**
 * 
 */
package com.luisusr.webdemo.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author luisusr
 *
 */
@Controller
public class IndexController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	@ResponseBody
	public String manejarIndex()
	{
		return "WEb DEMO 1.0";
	}

}
