package com.luisusr.webdemo;
public class WebInitializer
{
	
}
///**
// * este es otra forma de inicializar por javaconfig extendiendo de 
//AbstractAnnotationConfigDispatcherServletInitializer aunque me parece que es mejo la otra
// ya que seguimos el mismo principio del web.xml por escaneo de paquetes mediante el servlet despachador
// */
//package com.luisusr.webdemo;
//
//import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
//
//import com.luisusr.webdemo.configurers.MvcConfiguration;
//
///**
// * @author luisusr
// *
// */
//public class WebInitializer extends
//AbstractAnnotationConfigDispatcherServletInitializer{
//
//	/* (non-Javadoc)
//	 * @see org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer#getRootConfigClasses()
//	 */
//	@Override
//	protected Class<?>[] getRootConfigClasses() {
//		return null;
//	}
//
//	/* (non-Javadoc)
//	 * @see org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer#getServletConfigClasses()
//	 */
//	@Override
//	protected Class<?>[] getServletConfigClasses() {
//		return new Class[] { MvcConfiguration.class };
//	}
//
//	/* (non-Javadoc)
//	 * @see org.springframework.web.servlet.support.AbstractDispatcherServletInitializer#getServletMappings()
//	 */
//	@Override
//	protected String[] getServletMappings() {
//		return new String[] { "/" };
//	}
//
//}
