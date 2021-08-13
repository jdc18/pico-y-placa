package ec.com.jdc.picoyplaca.service;

import org.junit.Test;

import ec.com.jdc.picoyplaca.exceptions.InvalidArgumentsException;
import ec.com.jdc.picoyplaca.exceptions.InvalidDateException;
import ec.com.jdc.picoyplaca.exceptions.InvalidLicenseNumberException;

public class PicoYPlacaServiceTest {
	private PicoYPlacaService picoYPlacaService = new PicoYPlacaService();
	
	@Test(expected = InvalidArgumentsException.class)
	public void ifItReceivesZeroArgumentsItShouldThrowError() throws InvalidArgumentsException,InvalidLicenseNumberException {
		String[] args = {}; 
		picoYPlacaService.setArguments(args);
	}
	
	@Test(expected = InvalidArgumentsException.class)
	public void ifItReceivesLessThanThreeArgumentsItShouldThrowError() throws InvalidArgumentsException,InvalidLicenseNumberException {
		String[] args = {"aaa"}; 
		picoYPlacaService.setArguments(args);
		String[] args2 = {"aaa", "bbbb"}; 
		picoYPlacaService.setArguments(args2);
	}
	
	@Test(expected = InvalidArgumentsException.class)
	public void ifItReceivesMoreThanThreeArgumentsItShouldThrowError() throws InvalidArgumentsException,InvalidLicenseNumberException {
		String[] args = {"aaa", "bbb", "ccc", "dddd"}; 
		picoYPlacaService.setArguments(args);
	}
	
	@Test
	public void ifItReceivesThreeValidArgumentsItShouldntThrowError() throws InvalidArgumentsException,InvalidLicenseNumberException {
		String[] args = {"pgu0087", "2010-10-01", "14h12"}; 
		picoYPlacaService.setArguments(args);
	}
	
	@Test(expected = InvalidDateException.class)
	public void validateDateIfNullShouldThrowException() throws InvalidDateException {
		String date = null;
		picoYPlacaService.validateDate(date);
		
	}
	
	@Test(expected = InvalidDateException.class)
	public void validateDateIfEmptyShouldThrowException() throws InvalidDateException {
		String date = "";
		picoYPlacaService.validateDate(date);
		
	}
	
	@Test(expected = InvalidDateException.class)
	public void validateDateWrongFormatShouldThrowException() throws InvalidDateException {
		String date = "12-25-2006";
		picoYPlacaService.validateDate(date);
	}
	
	
	@Test
	public void validateDateCorrectDate() throws InvalidDateException {
		String date = "2020-12-01";
		picoYPlacaService.validateDate(date);
		
	}

}
