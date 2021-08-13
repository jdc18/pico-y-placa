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
	public void ifTimeIsRestrictedMorningReturnsTrue() {
		String time = "07:15";
		boolean isRestricted = picoYPlacaService.isTimeRestricted(time);
		assertTrue(isRestricted);
	}
	
	@Test
	public void ifTimeIsRestrictedMorningJustAtLowerLimitReturnsTrue()  {
		String time = "07:00";
		boolean isRestricted = picoYPlacaService.isTimeRestricted(time);
		assertTrue(isRestricted);
	}
	
	@Test
	public void ifTimeIsNotRestrictedMorningBeforeRestrictionReturnsFalse(){
		String time = "06:12";
		boolean isRestricted = picoYPlacaService.isTimeRestricted(time);
		assertFalse(isRestricted);
	}
	
	@Test
	public void ifTimeIsNotRestrictedMorningAfterRestrictionReturnsFalse() {
		String time = "10:30";
		boolean isRestricted = picoYPlacaService.isTimeRestricted(time);
		assertFalse(isRestricted);
	}
	
	@Test
	public void ifTimeIsNotRestsrictedMorningJustAtMorningUpperLimitRestrictionReturnsFalse()  {
		String time = "09:30";
		boolean isRestricted = picoYPlacaService.isTimeRestricted(time);
		assertFalse(isRestricted);
	}
	
	
	@Test
	public void ifTimeIsRestrictedAfternoonReturnsTrue()  {
		String time = "16:15";
		boolean isRestricted = picoYPlacaService.isTimeRestricted(time);
		assertTrue(isRestricted);
	}
	
	@Test
	public void ifTimeIsRestrictedAfternoonJustAtLowerLimitReturnsTrue() {
		String time = "16:00";
		boolean isRestricted = picoYPlacaService.isTimeRestricted(time);
		assertTrue(isRestricted);
	}
	
	@Test
	public void ifTimeIsNotRestrictedAfternoonBeforeRestrictionReturnsFalse() {
		String time = "13:12";
		boolean isRestricted = picoYPlacaService.isTimeRestricted(time);
		assertFalse(isRestricted);
	}
	
	@Test
	public void ifTimeIsNotRestrictedAfternoonAfterRestrictionReturnsFalse() {
		String time = "20:30";
		boolean isRestricted = picoYPlacaService.isTimeRestricted(time);
		assertFalse(isRestricted);
	}
	
	@Test
	public void ifTimeIsNotRestrictedAfternoonAfterAtUpperLimitRestrictionReturnsFalse() {
		String time = "19:30";
		boolean isRestricted = picoYPlacaService.isTimeRestricted(time);
		assertFalse(isRestricted);
	}
	
	@Test
	public void ifDayIsWeekendReturnsFalse() {
		int lastDigit = 0;
		String date = "2021-08-14";
		boolean isRestricted = picoYPlacaService.isDayRestricted(lastDigit, date);
		assertFalse(isRestricted);
	}
	
	@Test
	public void ifDayIsWeekendSundayReturnsFalse() {
		int lastDigit = 3;
		String date = "2021-08-15";
		boolean isRestricted = picoYPlacaService.isDayRestricted(lastDigit, date);
		assertFalse(isRestricted);
	}
	
	@Test
	public void ifDayIsMondayAndHasRestrictionsReturnsTrue() {
		int lastDigit = 1;
		String date = "2021-08-02";
		boolean isRestricted = picoYPlacaService.isDayRestricted(lastDigit, date);
		assertTrue(isRestricted);
	}
	
	@Test
	public void ifDayIsMondayAndHasRestrictionsReturnsFalse() {
		int lastDigit = 3;
		String date = "2021-08-02";
		boolean isRestricted = picoYPlacaService.isDayRestricted(lastDigit, date);
		assertFalse(isRestricted);
	}
	
	@Test
	public void ifDayIsTuesdayAndHasRestrictionsReturnsTrue() {
		int lastDigit = 3;
		String date = "2021-08-03";
		boolean isRestricted = picoYPlacaService.isDayRestricted(lastDigit, date);
		assertTrue(isRestricted);
	}
	
	@Test
	public void ifDayIsTuesdayAndHasRestrictionsReturnsFalse() {
		int lastDigit = 8;
		String date = "2021-08-03";
		boolean isRestricted = picoYPlacaService.isDayRestricted(lastDigit, date);
		assertFalse(isRestricted);
	}
	// TODO test everyday of the week
	
	@Test
	public void ifDateAndTimeHaveRestrictionsShouldReturnTrue() {
		String licenseNumber = "PBA0001";
		String date = "2021-08-02";
		String time = "09:23";
		boolean isRestricted = picoYPlacaService.hasRestriction(licenseNumber,date, time);
		assertTrue(isRestricted);
	}
	
	@Test
	public void ifDateHasRestrictionButDayDoesntShouldReturnFalse() {
		String licenseNumber = "PBA0001";
		String date = "2021-08-02";
		String time = "12:23";
		boolean isRestricted = picoYPlacaService.hasRestriction(licenseNumber,date, time);
		assertFalse(isRestricted);
	}
	
	@Test
	public void ifDateDoesntHaveRestrictionButDayHasShouldReturnFalse() {
		String licenseNumber = "PBA0001";
		String date = "2021-08-03";
		String time = "09:23";
		boolean isRestricted = picoYPlacaService.hasRestriction(licenseNumber,date, time);
		assertFalse(isRestricted);
	}
	
	@Test
	public void ifDateAndimeDontHaveRestrictionsReturnFalse() {
		String licenseNumber = "PBA0001";
		String date = "2021-08-03";
		String time = "12:23";
		boolean isRestricted = picoYPlacaService.hasRestriction(licenseNumber,date, time);
		assertFalse(isRestricted);
	}
	
}
