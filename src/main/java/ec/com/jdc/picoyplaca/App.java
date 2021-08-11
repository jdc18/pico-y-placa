package ec.com.jdc.picoyplaca;

import java.time.LocalDate;

import ec.com.jdc.picoyplaca.service.LicensePlateService;

public class App {
	public static void main(String[] args) {
		// TODO delete this
		for(int i=0; i<args.length; i++) {
			System.out.println(args[i]);
		}
		LicensePlateService licensePlateService= new LicensePlateService();

		try {
			licensePlateService.setLicensePlateNumber(args[0]);

			
			//TODO fix this with arguments
			System.out.println(LocalDate.now());
		}catch (Exception e) {
			// TODO: handle exception
			System.err.println("Error: " + e.getMessage());
		}
	}
}
