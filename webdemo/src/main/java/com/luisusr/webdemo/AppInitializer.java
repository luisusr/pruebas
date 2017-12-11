/**
 * 
 */
package com.luisusr.webdemo;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * @author luisusr
 *
 */
public class AppInitializer implements WebApplicationInitializer
{

	/* (non-Javadoc)
	 * @see org.springframework.web.WebApplicationInitializer#onStartup(javax.servlet.ServletContext)
	 */
	
	private static final Log log = LogFactory.getLog(WebApplicationInitializer.class);
@Override
public void onStartup(ServletContext servletContext) throws ServletException {
    WebApplicationContext context = getContext();
    servletContext.addListener(new ContextLoaderListener(context));
    ServletRegistration.Dynamic dispatcher = servletContext.addServlet("DispatcherServlet", new DispatcherServlet(context));
    dispatcher.setLoadOnStartup(1);
    dispatcher.addMapping("/plantillaMatriz/*");
    log.info("se inicializa/instancia el servlet despachador PM");
}

private AnnotationConfigWebApplicationContext getContext() {
    AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
    context.setConfigLocation("com.luisusr.webdemo");
    log.info("se configura la locacion paquetes de configuraciones para la busqueda de locaciones de"
    		+ " controladores, servicios, repositorios, componentes. Tipicamente es el paquete raiz");
    return context;
}




}