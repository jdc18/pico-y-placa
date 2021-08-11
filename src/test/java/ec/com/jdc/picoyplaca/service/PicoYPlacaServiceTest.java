package ec.com.jdc.picoyplaca.service;

import org.junit.Test;

import ec.com.jdc.picoyplaca.exceptions.InvalidArgumentsException;

public class PicoYPlacaServiceTest {
	private PicoYPlacaService picoYPlacaService = new PicoYPlacaService();
	
	@Test(expected = InvalidArgumentsException.class)
	public void ifItReceivesZeroArgumentsItShouldThrowError() throws InvalidArgumentsException {
		String[] args = {}; 
		picoYPlacaService.setArguments(args);
	}
	
	@Test(expected = InvalidArgumentsException.class)
	public void ifItReceivesLessThanThreeArgumentsItShouldThrowError() throws InvalidArgumentsException {
		String[] args = {"aaa"}; 
		picoYPlacaService.setArguments(args);
		String[] args2 = {"aaa", "bbbb"}; 
		picoYPlacaService.setArguments(args2);
	}
	
	@Test(expected = InvalidArgumentsException.class)
	public void ifItReceivesMoreThanThreeArgumentsItShouldThrowError() throws InvalidArgumentsException {
		String[] args = {"aaa", "bbb", "ccc", "dddd"}; 
		picoYPlacaService.setArguments(args);
	}
	
	@Test
	public void ifItReceivesMoreThreeArgumentsItShouldndThrowError() throws InvalidArgumentsException {
		String[] args = {"pgu087", "ABC0213", "GYE1986"}; 
		picoYPlacaService.setArguments(args);
	}
	

}
