package negocio;

import middware.Comm;

public class ServNomeRun {
	public static void main(String[] args) throws Exception {

		Comm m = new Comm(new RegistroServidor("localhost", "5000"));

		Message reqMsg = new Message();
		Message resMsg = new Message();
		ServidorNomes sn = new ServidorNomes();
		while (true) {
			reqMsg = m.receive();
			String op = reqMsg.getOperacao();
			switch (op) {
			case "nomesServicos":
				resMsg.setValores(sn.nomesServicos());
				break;
			case "recuperarServico":
				resMsg.setValores(sn.recuperarServico((String)reqMsg.getValores()));
				break;
			case "adicionarServico":
				sn.adicionarServico((RegistroServidor)reqMsg.getValores());
				break;
			}

			m.reply(resMsg);

		}
	}
}
