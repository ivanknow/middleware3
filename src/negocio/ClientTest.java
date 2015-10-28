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
		reqMsg.setValores(new Double(30));
		String s = server.requestAndReceive(reqMsg).getValores()+"";
		System.out.println(s);
		
		
		
		/*case "nomesServicos":
				resMsg.setValores(sn.nomesServicos());
				break;
			case "recuperarServico":
				resMsg.setValores(sn.recuperarServico((String)reqMsg.getValores()));
				break;*/
	}

}
