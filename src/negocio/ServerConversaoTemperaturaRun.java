package negocio;

import middware.Comm;

public class ServerConversaoTemperaturaRun {
	public static void main(String[] args) throws Exception {
		
		ServerConversaoTemperatura servico = new ServerConversaoTemperatura();
		RegistroServidor rs = new RegistroServidor("127.0.0.1","");
		
		rs.setNomeServico(servico.getClass().getSimpleName());
		
		ServidorNomes sn = new ServidorNomes();
		
		Comm m = new Comm(rs);
		
		
		Message reqMsg = new Message();
		Message resMsg = new Message();
		
		
		reqMsg.setValores(rs);
		
		reqMsg.setOperacao("adicionarServico");
		
		
		m.requestAndReceive(reqMsg);
		
		
		while (true) {
			reqMsg = m.receive();
			String op = reqMsg.getOperacao();
			switch (op) {
			case "celsiusToFahrenheit":
				resMsg.setValores(servico.celsiusToFahrenheit((Double)reqMsg.getValores()));
				break;
			}

			m.reply(resMsg);

		}
		
	}
}
