package negocio;

import middware.Comm;

public class ServerEncriptaDesencriptaRun {
	
public static void main(String[] args) throws Exception {
		
		ServerEncriptaDesencripta servico = new ServerEncriptaDesencripta();
		RegistroServidor rs = new RegistroServidor("localhost","5553");
		
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
			case "encripta":
				resMsg.setValores(servico.encripta((String)reqMsg.getValores()));
				break;
				
			case "desencripta":
			//	resMsg.setValores(servico.desencripta(reqMsg.getValores()));
			}

			mServidor.reply(resMsg);

		}
		
	}

}
