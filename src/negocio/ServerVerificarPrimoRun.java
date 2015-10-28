package negocio;

import middware.Comm;

public class ServerVerificarPrimoRun {
	
public static void main(String[] args) throws Exception {
		
		ServerVerificarPrimo servico = new ServerVerificarPrimo();
		RegistroServidor rs = new RegistroServidor("localhost","5552");
		
		rs.setNomeServico(servico.getClass().getSimpleName());
		
		ServidorNomes sn = new ServidorNomes();
		
		Comm mCliente = new Comm(new RegistroServidor("localhost", "5000"));
		Comm mServidor = new Comm(rs);
		
		Message reqMsg = new Message();
		Message resMsg = new Message();
		
		
		reqMsg.setValores(rs);
		
		reqMsg.setOperacao("adicionarServico");
		
		
		mCliente.requestAndReceive(reqMsg);
		
		
		while (true) {
			reqMsg = mServidor.receive();
			String op = reqMsg.getOperacao();
			switch (op) {
			case "verificaPrimo":
				resMsg.setValores(servico.verificaPrimo((Integer)reqMsg.getValores()));
				break;
			}

			mServidor.reply(resMsg);

		}
		
	}

}
