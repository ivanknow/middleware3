package negocio;

import middware.Comm;

public class ServerCalculadoraRun {
	public static void main(String[] args) throws Exception {
		run("localhost", "5544");
	}

	public static void run(String host, String port) throws Exception {

		ServerCalculadora servico = new ServerCalculadora();
		RegistroServidor rs = new RegistroServidor(host,port);

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
					ServerCalculadora servico = new ServerCalculadora();
					String op = mIn.getOperacao();
					switch (op) {
					case "soma":
						mOut.setValores(servico.soma((NumerosWrap) mIn.getValores()));
						break;
					case "sub":
						mOut.setValores(servico.sub((NumerosWrap) mIn.getValores()));
						break;
					case "mult":
						mOut.setValores(servico.mult((NumerosWrap) mIn.getValores()));
						break;
					case "div":
						mOut.setValores(servico.div((NumerosWrap) mIn.getValores()));
						break;
					default:
						mOut = null;

					}
					System.out.println("Resultado" + ((NumerosWrap) mOut.getValores()).getResult());
					return mOut;
				}
			};
			new Thread(thread).start();

		}

	}
}
