package negocio;

import interfaces.ITemperatura;

public class ServerConversaoTemperatura implements ITemperatura{

	@Override
	public String celsiusToFahrenheit(Double tempCelsius) {
		
		Double f = (tempCelsius * 1.8) + 32;
		System.out.println(String.valueOf(f));
		return String.valueOf(f);
	}
	
	public static void main(String[] args) {
		ServerConversaoTemperatura vt = new ServerConversaoTemperatura();
		vt.celsiusToFahrenheit(100.0);
	}
	
	
}
