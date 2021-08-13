package ec.com.jdc.picoyplaca.service;

import ec.com.jdc.picoyplaca.exceptions.InvalidArgumentsException;
import ec.com.jdc.picoyplaca.exceptions.InvalidDateException;
import ec.com.jdc.picoyplaca.exceptions.InvalidLicenseNumberException;

public class PicoYPlacaService {
	private LicensePlateService licensePlateService = new LicensePlateService();
	private String date;
	private String time;
	
	public void setArguments(String[] args) throws InvalidArgumentsException, InvalidLicenseNumberException {
		validateArguments(args);
		licensePlateService.setLicensePlateNumber(args[0]);
		
		
	}

	private void validateArguments(String[] args) throws InvalidArgumentsException {
		if(args == null || args.length == 0)
			throw new InvalidArgumentsException("There are no arguments");
		if(args.length < 3)
			throw new InvalidArgumentsException("The program receives 3 arguments, the license number(Ex.: PBU9876) , date yyyy-mm-dd(Ex.: 2021-10-21) and time HHhMM (Ex.:14h10)  ");
		if(args.length > 3)
			throw new InvalidArgumentsException("There are more than 3 arguments");
		
	}
	
	public void validateDate(String date) throws InvalidDateException {
		if(date == null)
			throw new InvalidDateException("Date is null");
		if(!date.matches("\\d{4}\\-(0?[1-9]|1[012])\\-(0?[1-9]|[12][0-9]|3[01])*"))
			throw new InvalidDateException("Date format is wrong. It should be yyyy-mm-dd(Ex.: 2021-10-21)");	
	}
	
	public void validateTime(String date) throws InvalidDateException {
		if(date == null)
			throw new InvalidDateException("Time is null");
		if(!date.matches("([01]?[0-9]|2[0-3]):[0-5][0-9]"))
			throw new InvalidDateException("Time format is wrong. It should be HH:MM(Ex.: 16h20)");
	}
	
	
	
	
	
	
}
