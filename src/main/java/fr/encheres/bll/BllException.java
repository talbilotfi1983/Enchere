package fr.encheres.bll;


import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Administrator
 *
 * Cette classe permet de recenser l'ensemble des erreurs (par leur code) pouvant survenir lors d'un traitement
 * quel que soit la couche à l'origine.
 */
public class BllException extends Exception {
	private static final long serialVersionUID = 1L;	
	public BllException() {
	}
	public BllException(String msg) {
		super(msg);
	}
	public BllException(String msg , Throwable ex) {
		super(msg,ex);
	}
	@Override
		public String getMessage() {
		StringBuffer sb = new StringBuffer("Bll Error - ");
		sb.append(super.getMessage());
			return sb.toString();
		}


}