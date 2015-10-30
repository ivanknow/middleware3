package negocio;

import middware.Comm;

public class ServerEncriptaDesencriptaRun {

	public static void main(String[] args) throws Exception {

		run("localhost", "5553");
	}
	
	public static void run(String host,String port)throws Exception{
		ServerEncriptaDesencripta servico = new ServerEncriptaDesencripta();
		RegistroServidor rs = new RegistroServidor(host, port);

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
						mOut.setValores(servico.desencripta(cw.getChave(),cw.getTextoEncriptado()));
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
