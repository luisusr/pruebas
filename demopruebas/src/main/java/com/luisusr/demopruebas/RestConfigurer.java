/**
 * 
 */
package com.luisusr.demopruebas;

import javax.inject.Named;
import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

/**
 * @author luisusr
 *
 */
@Configuration
public class RestConfigurer {

	@Named
    @ApplicationPath("services")
    static class JerseyConfig extends ResourceConfig {
        public JerseyConfig() {
            this.packages("com.luisusr.demopruebas.rest");
        }
    }
	
}
