package negocio;

import middware.Comm;

public class ClientConcorrente {
	
	public static void main(String[] args) throws Exception {
		try {
			//ServNomeRun.run("localhost","5000");
			
			//ServerCalculadoraRun.run("localhost","5001");
			
			//ServerCalculadoraRun.run("localhost","5002");
			
			//ServerConversaoTemperaturaRun.run("localhost", "5003");
			
			//ServerEncriptaDesencriptaRun.run("localhost","5004");
			
			//ServerVerificarPrimoRun.run("localhost","5005");
			
			Comm server = new Comm(new RegistroServidor("localhost", "5000"));
			Message reqMsg = new Message(){};
			reqMsg.setOperacao("nomesServicos");
			
			reqMsg.setOperacao("recuperarServico");
			reqMsg.setValores("ServerCalculadora");
			
			server = new Comm((RegistroServidor) server.requestAndReceive(reqMsg).getValores());

			reqMsg.setOperacao("soma");
			reqMsg.setValores(new NumerosWrap(20, 2));
			
			NumerosWrap s = (NumerosWrap)server.requestAndReceive(reqMsg).getValores();
			
			System.out.println(s.getResult());
			
			reqMsg.setOperacao("div");
			reqMsg.setValores(new NumerosWrap(20, 2));
			
			 s = (NumerosWrap)server.requestAndReceive(reqMsg).getValores();
			
			System.out.println(s.getResult());
			
		
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}
