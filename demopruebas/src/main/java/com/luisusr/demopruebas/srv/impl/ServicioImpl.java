/**
 * 
 */
package com.luisusr.demopruebas.srv.impl;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import com.luisusr.demopruebas.srv.Servicio;

/**
 * @author luisusr
 *
 */
public class ServicioImpl implements Servicio {
	
	private static final Log log = LogFactory.getLog(ServicioImpl.class);

	/* (non-Javadoc)
	 * @see com.luisusr.demopruebas.srv.Service#getText()
	 */
	@Override
	public String getText() {
		return "Mr. BEAN!";
	}

	/* (non-Javadoc)
	 * @see com.luisusr.demopruebas.srv.Servicio#serialize(java.io.Serializable)
	 */
	@Override
	public byte[] serialize(Serializable obj) {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		  
	    try {
	    	  ObjectOutputStream oos = new ObjectOutputStream(baos);
			oos.writeObject(obj);
		} catch (IOException e) {
			log.error("ocurrio un error al serializar el objeto : "+e);
				if(e.getMessage()!=null)
					log.error(e.getMessage());
		}
	    return baos.toByteArray();
	}
	
//	private  Serializable deserialize(InputStream stream) throws Exception {
//
//        ObjectInputStream ois = new ObjectInputStream(stream);
//        try {
//            return (Serializable) ois.readObject();
//        } finally {
//            ois.close();
//        }
//    }

}
