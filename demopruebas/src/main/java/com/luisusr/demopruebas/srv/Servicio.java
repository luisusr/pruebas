/**
 * 
 */
package com.luisusr.demopruebas.srv;

import java.io.Serializable;

/**
 * @author luisusr
 *
 */
public interface Servicio {
String getText();
byte[] serialize(Serializable obj);
}
