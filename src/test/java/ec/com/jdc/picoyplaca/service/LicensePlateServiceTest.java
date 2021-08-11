package ec.com.jdc.picoyplaca.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import ec.com.jdc.picoyplaca.exceptions.InvalidLicenseNumberException;

public class LicensePlateServiceTest {
	
	private LicensePlateService licensePlateService = new LicensePlateService();
	
	@Test(expected = InvalidLicenseNumberException.class)
	public void licensePlateServiceShouldThrowExceptionWhenNull() throws InvalidLicenseNumberException {
		String licenseNumber = null;
		licensePlateService.setLicensePlateNumber(licenseNumber);
	}
	
	@Test(expected = InvalidLicenseNumberException.class)
	public void licensePlateServiceShouldThrowExceptionWhenEmpty() throws InvalidLicenseNumberException {
		String licenseNumber = "";
		licensePlateService.setLicensePlateNumber(licenseNumber);
	}
	
	@Test(expected = InvalidLicenseNumberException.class)
	public void licensePlateServiceShouldThrowExceptionWhenNotEnoughtCharacters() throws InvalidLicenseNumberException {
		String licenseNumber = "abc12";
		licensePlateService.setLicensePlateNumber(licenseNumber);
		licenseNumber = "a";
		licensePlateService.setLicensePlateNumber(licenseNumber);
	}
	
	@Test(expected = InvalidLicenseNumberException.class)
	public void licensePlateServiceShouldThrowExceptionwhenTooManyCharacters() throws InvalidLicenseNumberException {
		String licenseNumber = "abc124555";
		licensePlateService.setLicensePlateNumber(licenseNumber);
		licenseNumber = "abc124555adfasdf";
		licensePlateService.setLicensePlateNumber(licenseNumber);
	}
	
	@Test(expected = InvalidLicenseNumberException.class)
	public void licensePlateServiceShouldThrowExceptionwhenNotSetInProperFormat() throws InvalidLicenseNumberException {
		String licenseNumber = "adasfhj";
		licensePlateService.setLicensePlateNumber(licenseNumber);
		licenseNumber = "1234567";
		licensePlateService.setLicensePlateNumber(licenseNumber);
		licenseNumber = "1234PGU";
		licensePlateService.setLicensePlateNumber(licenseNumber);
	}
	
	@Test
	public void licensePlateServiceShouldAcceptAProperLicensePlate() throws InvalidLicenseNumberException {
		String licenseNumber = "pbu0198";
		licensePlateService.setLicensePlateNumber(licenseNumber);
		assertEquals(licenseNumber, licensePlateService.getLicensePlateNumber());
		String licenseNumber2 = "PBU0198";
		licensePlateService.setLicensePlateNumber(licenseNumber2);
		assertEquals(licenseNumber2, licensePlateService.getLicensePlateNumber());
	}	
	
}
