package ec.com.jdc.picoyplaca.service;

import ec.com.jdc.picoyplaca.exceptions.InvalidLicenseNumberException;
import ec.com.jdc.picoyplaca.model.LicensePlate;

public class LicensePlateService {
	private LicensePlate licensePlate = new LicensePlate();

	public void setLicensePlateNumber(String licenseNumber) throws InvalidLicenseNumberException {
		if (licenseNumber == null)
			throw new InvalidLicenseNumberException("License number is null, please insert a license number");
		if (licenseNumber.isEmpty())
			throw new InvalidLicenseNumberException("License number is empty, please insert a license number");
		if (licenseNumber.length() < 7)
			throw new InvalidLicenseNumberException("Invalid license number. Not enough chars. Recieved "
					+ licenseNumber.length() + " chars, expected 7");
		if (licenseNumber.length() > 7)
			throw new InvalidLicenseNumberException("Invalid license number. Too many chars. Recieved "
					+ licenseNumber.length() + " chars, expected 7");
		if (!licenseNumber.matches("[a-zA-Z]{3}[0-9]{4}"))
			throw new InvalidLicenseNumberException(
					"Invalid format. Expected 3 characters followed by 4 numbers. For example: PGB2781");
		licensePlate.setLicenseNumber(licenseNumber);
	}

	public String getLicensePlateNumber() {
		return licensePlate.getLicenseNumber();
	}
}
