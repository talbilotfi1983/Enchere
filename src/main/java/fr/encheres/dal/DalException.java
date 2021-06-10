package fr.encheres.dal;


import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Administrator
 *
 * Cette classe permet de recenser l'ensemble des erreurs (par leur code) pouvant survenir lors d'un traitement
 * quel que soit la couche à l'origine.
 */
public class DalException extends Exception {
	private static final long serialVersionUID = 1L;	
	public DalException() {
	}
	public DalException(String msg) {
		super(msg);
	}
	public DalException(String msg , Throwable ex) {
		super(msg,ex);
	}
	@Override
		public String getMessage() {
		StringBuffer sb = new StringBuffer("Dal Error - ");
		sb.append(super.getMessage());
			return sb.toString();
		}


}