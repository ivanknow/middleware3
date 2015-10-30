package negocio;

import middware.Comm;

public class ClientTest {
	
	public static void main(String[] args) throws Exception {
		Comm server = new Comm(new RegistroServidor("localhost", "5000"));
		Message reqMsg = new Message();
		reqMsg.setOperacao("nomesServicos");
		
		System.out.println(server.requestAndReceive(reqMsg).getValores());
		
		reqMsg.setOperacao("recuperarServico");
		reqMsg.setValores("ServerConversaoTemperatura");
		
		RegistroServidor rs = (RegistroServidor) server.requestAndReceive(reqMsg).getValores();
		
		System.out.println(rs);
		
		server = new Comm(rs);
		
		reqMsg.setOperacao("celsiusToFahrenheit");
		reqMsg.setValores(new Double(31));
		
		System.out.println(server.requestAndReceive(reqMsg).getValores());
		

	}

}
