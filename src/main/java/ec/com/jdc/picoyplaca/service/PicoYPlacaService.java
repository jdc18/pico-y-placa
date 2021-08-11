package ec.com.jdc.picoyplaca.service;

import ec.com.jdc.picoyplaca.exceptions.InvalidArgumentsException;

public class PicoYPlacaService {
	private LicensePlateService licensePlateService = new LicensePlateService();
	private String date;
	private String time;
	
	public void setArguments(String[] args) throws InvalidArgumentsException {
		if(args == null || args.length == 0)
			throw new InvalidArgumentsException("There are no arguments");
		if(args.length < 3)
			throw new InvalidArgumentsException("The program receives 3 arguments, the license number(Ex.: PBU9876) , date yyyy-mm-dd(Ex.: 2021-10-21) and time HHhMM (Ex.:14h10)  ");
		if(args.length > 3)
			throw new InvalidArgumentsException("There are more than 3 arguments");
	}
	
	
}
