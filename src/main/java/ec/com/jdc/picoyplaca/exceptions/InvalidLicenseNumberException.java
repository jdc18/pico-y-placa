package ec.com.jdc.picoyplaca.exceptions;

public class InvalidLicenseNumberException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public InvalidLicenseNumberException (String msg){
		super(msg);
	}

}
