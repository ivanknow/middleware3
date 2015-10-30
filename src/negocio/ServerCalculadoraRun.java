package negocio;

import middware.Comm;

public class ServerCalculadoraRun {
	public static void main(String[] args) throws Exception {
		
		ServerCalculadora servico = new ServerCalculadora();
		RegistroServidor rs = new RegistroServidor("localhost","5554");
		
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
			case "soma":
				resMsg.setValores(servico.soma((NumerosWrap)reqMsg.getValores()));
				break;
			case "sub":
				resMsg.setValores(servico.sub((NumerosWrap)reqMsg.getValores()));
				break;
			case "mult":
				resMsg.setValores(servico.mult((NumerosWrap)reqMsg.getValores()));
				break;
			case "div":
				resMsg.setValores(servico.div((NumerosWrap)reqMsg.getValores()));
				break;
			
			}

			mServidor.reply(resMsg);

		}
		
	}
}
