package negocio;

import middware.Comm;

public class ServerEncriptaDesencriptaRun {

	public static void main(String[] args) throws Exception {

		ServerEncriptaDesencripta servico = new ServerEncriptaDesencripta();
		RegistroServidor rs = new RegistroServidor("localhost", "5553");

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
				public Message exec(Message mIn) {
					Message mOut = new Message();
					ServerEncriptaDesencripta servico = new ServerEncriptaDesencripta();
					String op = mIn.getOperacao();

					switch (op) {
					case "encripta":
						mOut.setValores(servico.encripta((String) mIn.getValores()));
						break;
					case "desencripta":
						CrypWrap cw = (CrypWrap) mIn.getValores();
						mOut.setValores(servico.desencripta(cw.chave,cw.textoEncriptado));
						break;
					default:
						mOut = null;
						break;
					}
					return mOut;
				}
			};
			new Thread(thread).start();

		}

	}

}
