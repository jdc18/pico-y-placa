package ec.com.jdc.picoyplaca.service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;

import ec.com.jdc.picoyplaca.exceptions.InvalidArgumentsException;
import ec.com.jdc.picoyplaca.exceptions.InvalidDateException;
import ec.com.jdc.picoyplaca.exceptions.InvalidLicenseNumberException;
import ec.com.jdc.picoyplaca.exceptions.InvalidTimeException;

public class PicoYPlacaService {
	private LicensePlateService licensePlateService = new LicensePlateService();
	private String dateStr;
	private String timeStr;
	
	// TODO extract this a global constants
	private static LocalTime MORNING_LOWER_LIMIT = LocalTime.parse("07:00");
	private static LocalTime MORNING_UPPER_LIMIT = LocalTime.parse("09:30");
	private static LocalTime AFTERNOON_LOWER_LIMIT = LocalTime.parse("16:00");
	private static LocalTime AFTERNOON_UPPER_LIMIT = LocalTime.parse("19:30");
	
	public void setArguments(String[] args) throws InvalidArgumentsException, InvalidLicenseNumberException, InvalidDateException, InvalidTimeException {
		validateArguments(args);
		licensePlateService.setLicensePlateNumber(args[0]);
		validateDate(args[1]);
		dateStr = args[1];
		validateTime(args[2]);
		timeStr = args[2];
	}

	public void validateArguments(String[] args) throws InvalidArgumentsException {
		if(args == null || args.length == 0)
			throw new InvalidArgumentsException("There are no arguments");
		if(args.length < 3)
			throw new InvalidArgumentsException("The program receives 3 arguments, the license number(Ex.: PBU9876) , date yyyy-mm-dd(Ex.: 2021-10-21) and time HHhMM (Ex.:14:10)  ");
		if(args.length > 3)
			throw new InvalidArgumentsException("There are more than 3 arguments");
		
	}
	
	public boolean checkRestriction() {
		return hasRestriction(licensePlateService.getLicensePlateNumber(), dateStr, timeStr);
	}
	
	public void validateDate(String date) throws InvalidDateException {
		if(date == null)
			throw new InvalidDateException("Date is null");
		if(!date.matches("\\d{4}\\-(0?[1-9]|1[012])\\-(0?[1-9]|[12][0-9]|3[01])*"))
			throw new InvalidDateException("Date format is wrong. It should be yyyy-mm-dd(Ex.: 2021-10-21)");	
	}
	
	public void validateTime(String date) throws InvalidTimeException {
		if(date == null)
			throw new InvalidTimeException("Time is null");
		if(!date.matches("([01]?[0-9]|2[0-3]):[0-5][0-9]"))
			throw new InvalidTimeException("Time format is wrong. It should be HH:MM(Ex.: 16:20)");
	}
	
	public boolean hasRestriction(String licenseNumber, String dateStr, String timeStr) {
		Integer lastDigit = Integer.parseInt(licenseNumber.substring(6, 7));
		if(isDayRestricted(lastDigit, dateStr) && isTimeRestricted(timeStr))
			return true;
		return false;
	}
	
	public boolean isTimeRestricted(String timeStr) {
		LocalTime time= LocalTime.parse(timeStr);
		if(time.equals(MORNING_LOWER_LIMIT))
			return true;
		if(time.isAfter(MORNING_LOWER_LIMIT) && time.isBefore(MORNING_UPPER_LIMIT))
			return true;
		if( time.equals(AFTERNOON_LOWER_LIMIT))
			return true;
		if(time.isAfter(AFTERNOON_LOWER_LIMIT) && time.isBefore(AFTERNOON_UPPER_LIMIT))
			return true;
		return false;
	}
	
	public boolean isDayRestricted(int lastDigit,String dateStr) {
		LocalDate date= LocalDate.parse(dateStr);
		DayOfWeek dayOfweek = date.getDayOfWeek();
		//System.out.println(date.getDayOfWeek());
		switch (dayOfweek) {
		case MONDAY:
			if(lastDigit == 1 || lastDigit == 2) 
				return true;
			break;
		case TUESDAY:		
			if(lastDigit == 3 || lastDigit == 4)
				return true;
			break;
		case WEDNESDAY:
			if(lastDigit == 5 || lastDigit == 6)
				return true;
			break;
		case THURSDAY:
			if(lastDigit == 7 || lastDigit == 8)
				return true;
			break;
		case FRIDAY:
			if(lastDigit == 9 || lastDigit == 10)
				return true;
			break;
		case SATURDAY:
		case SUNDAY:
			return false;
		}
		return false;
	}

	public LicensePlateService getLicensePlateService() {
		return licensePlateService;
	}

	public String getDateStr() {
		return dateStr;
	}

	public String getTimeStr() {
		return timeStr;
	}
	
}
