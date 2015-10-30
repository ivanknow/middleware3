package negocio;

import middware.Comm;

public class ServerConversaoTemperaturaRun {
	public static void main(String[] args) throws Exception {

		ServerConversaoTemperatura servico = new ServerConversaoTemperatura();
		RegistroServidor rs = new RegistroServidor("localhost", "5551");

		rs.setNomeServico(servico.getClass().getSimpleName());

		ServidorNomes sn = new ServidorNomes();

		Comm mCliente = new Comm(new RegistroServidor("localhost", "5000"));
		Comm mServidor = new Comm(rs);

		Message reqMsg = new Message();

		reqMsg.setValores(rs);

		reqMsg.setOperacao("adicionarServico");

		mCliente.requestAndReceive(reqMsg);

		while (true) {
			MiddlewareThread thread = new MiddlewareThread(mServidor.receiveThread()) {

				@Override
				public Message exec(Message m) {
					Message mOut = new Message();
					ServerConversaoTemperatura servico = new ServerConversaoTemperatura();
					String op = reqMsg.getOperacao();
					switch (op) {
					case "celsiusToFahrenheit":
						mOut.setValores(servico.celsiusToFahrenheit((Double) m.getValores()));
						break;
					default:
						mOut = null;
					}

					return mOut;
				}
			};
			new Thread(thread).start();
		}

	}
}