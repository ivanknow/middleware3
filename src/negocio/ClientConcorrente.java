package negocio;

import middware.Comm;

public class ClientConcorrente {
	
	public static void main(String[] args) throws Exception {
		Comm server = new Comm(new RegistroServidor("localhost", "5000"));
		Message reqMsg = new Message();
		reqMsg.setOperacao("nomesServicos");
		
		System.out.println(server.requestAndReceive(reqMsg).getValores());
		
		reqMsg.setOperacao("recuperarServico");
		reqMsg.setValores("ServerCalculadora");
		
		RegistroServidor rs = (RegistroServidor) server.requestAndReceive(reqMsg).getValores();
		
		System.out.println(rs);
		
		server = new Comm(rs);
		
		reqMsg.setOperacao("div");
		reqMsg.setValores(new NumerosWrap(20, 2));
		NumerosWrap s = (NumerosWrap)server.requestAndReceive(reqMsg).getValores();
		System.out.println(s.getResult());
		

	}

}
