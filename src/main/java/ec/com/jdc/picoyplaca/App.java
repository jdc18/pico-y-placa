package ec.com.jdc.picoyplaca;

import ec.com.jdc.picoyplaca.service.PicoYPlacaService;

public class App {
	public static void main(String[] args) {
		PicoYPlacaService picoYPlacaService= new PicoYPlacaService();

		try {
			picoYPlacaService.setArguments(args);
			String restriction = " can be on the road";
			if(picoYPlacaService.checkRestriction()) {
				restriction = " cannot be on the road";
			}
			System.out.println("The car with license plate " + picoYPlacaService.getLicensePlateService().getLicensePlateNumber().toUpperCase() +
					" on the date " + picoYPlacaService.getDateStr() + " at " + picoYPlacaService.getTimeStr()+ restriction );
			
		}catch (Exception e) {
			// TODO: handle exception
			System.err.println("Error: " + e.getMessage());
		}
	}
}
