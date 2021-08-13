package ec.com.jdc.picoyplaca.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import ec.com.jdc.picoyplaca.exceptions.InvalidArgumentsException;
import ec.com.jdc.picoyplaca.exceptions.InvalidDateException;
import ec.com.jdc.picoyplaca.exceptions.InvalidLicenseNumberException;
import ec.com.jdc.picoyplaca.exceptions.InvalidTimeException;

public class PicoYPlacaServiceTest {
	private PicoYPlacaService picoYPlacaService = new PicoYPlacaService();
	
	@Test(expected = InvalidArgumentsException.class)
	public void ifItReceivesZeroArgumentsItShouldThrowError() throws InvalidArgumentsException,InvalidLicenseNumberException {
		String[] args = {}; 
		picoYPlacaService.validateArguments(args);
	}
	
	@Test(expected = InvalidArgumentsException.class)
	public void ifItReceivesLessThanThreeArgumentsItShouldThrowError() throws InvalidArgumentsException,InvalidLicenseNumberException {
		String[] args = {"aaa"}; 
		picoYPlacaService.validateArguments(args);
		String[] args2 = {"aaa", "bbbb"}; 
		picoYPlacaService.validateArguments(args2);
	}
	
	@Test(expected = InvalidArgumentsException.class)
	public void ifItReceivesMoreThanThreeArgumentsItShouldThrowError() throws InvalidArgumentsException,InvalidLicenseNumberException {
		String[] args = {"aaa", "bbb", "ccc", "dddd"}; 
		picoYPlacaService.validateArguments(args);
	}
	
	@Test
	public void ifItReceivesThreeValidArgumentsItShouldntThrowError() throws InvalidArgumentsException,InvalidLicenseNumberException {
		String[] args = {"pgu0087", "2010-10-01", "14:12"}; 
		picoYPlacaService.validateArguments(args);
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
	
	
	@Test(expected = InvalidTimeException.class)
	public void validateTimeIfNullShouldThrowException() throws InvalidTimeException {
		String time = null;
		picoYPlacaService.validateTime(time);
		
	}
	
	@Test(expected = InvalidTimeException.class)
	public void validateTimeIfEmptyShouldThrowException() throws InvalidTimeException {
		String time = "";
		picoYPlacaService.validateTime(time);
		
	}
	
	@Test(expected = InvalidTimeException.class)
	public void validateTimeWrongFormatShouldThrowException() throws InvalidTimeException {
		String time = "12-25-2006";
		picoYPlacaService.validateTime(time);
	}
	
	@Test(expected = InvalidTimeException.class)
	public void validateTimeOver24hoursFormatShouldThrowException() throws InvalidTimeException {
		String time = "25:12";
		picoYPlacaService.validateTime(time);
	}
	
	@Test
	public void validateTimeCorrectDate() throws InvalidTimeException {
		String time = "20:12";
		picoYPlacaService.validateTime(time);
	}
	
	@Test
	public void ifTimeIsRestrictedMorningReturnsTrue() throws InvalidTimeException {
		String time = "07:15";
		boolean isRestricted = picoYPlacaService.isTimeRestricted(time);
		assertTrue(isRestricted);
	}
	
	@Test
	public void ifTimeIsRestrictedMorningJustAtLowerLimitReturnsTrue() throws InvalidTimeException {
		String time = "07:00";
		boolean isRestricted = picoYPlacaService.isTimeRestricted(time);
		assertTrue(isRestricted);
	}
	
	@Test
	public void ifTimeIsNotRestrictedMorningBeforeRestrictionReturnsFalse() throws InvalidTimeException {
		String time = "06:12";
		boolean isRestricted = picoYPlacaService.isTimeRestricted(time);
		assertFalse(isRestricted);
	}
	
	@Test
	public void ifTimeIsNotRestrictedMorningAfterRestrictionReturnsFalse() throws InvalidTimeException {
		String time = "10:30";
		boolean isRestricted = picoYPlacaService.isTimeRestricted(time);
		assertFalse(isRestricted);
	}
	
	@Test
	public void ifTimeIsNotRestsrictedMorningJustAtMorningUpperLimitRestrictionReturnsFalse() throws InvalidTimeException {
		String time = "09:30";
		boolean isRestricted = picoYPlacaService.isTimeRestricted(time);
		assertFalse(isRestricted);
	}
	
	
	@Test
	public void ifTimeIsRestrictedAfternoonReturnsTrue() throws InvalidTimeException {
		String time = "16:15";
		boolean isRestricted = picoYPlacaService.isTimeRestricted(time);
		assertTrue(isRestricted);
	}
	
	@Test
	public void ifTimeIsRestrictedAfternoonJustAtLowerLimitReturnsTrue() throws InvalidTimeException {
		String time = "16:00";
		boolean isRestricted = picoYPlacaService.isTimeRestricted(time);
		assertTrue(isRestricted);
	}
	
	@Test
	public void ifTimeIsNotRestrictedAfternoonBeforeRestrictionReturnsFalse() throws InvalidTimeException {
		String time = "13:12";
		boolean isRestricted = picoYPlacaService.isTimeRestricted(time);
		assertFalse(isRestricted);
	}
	
	@Test
	public void ifTimeIsNotRestrictedAfternoonAfterRestrictionReturnsFalse() throws InvalidTimeException {
		String time = "20:30";
		boolean isRestricted = picoYPlacaService.isTimeRestricted(time);
		assertFalse(isRestricted);
	}
	
	@Test
	public void ifTimeIsNotRestrictedAfternoonAfterAtUpperLimitRestrictionReturnsFalse() throws InvalidTimeException {
		String time = "19:30";
		boolean isRestricted = picoYPlacaService.isTimeRestricted(time);
		assertFalse(isRestricted);
	}
/*
	@Test
	public void ifTimeIsRestrictedReturnsTrue() throws InvalidTimeException {
		String licenseNumber = "PBU0191";
		String date = "2021-08-02";
		String time = "20h12";
		boolean canDrive = picoYPlacaService.calculatePicoYPlaca(licenseNumber, date, time);
		assertTrue(canDrive);
	}*/
}
