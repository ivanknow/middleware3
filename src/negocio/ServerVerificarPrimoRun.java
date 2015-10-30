package negocio;

import middware.Comm;

public class ServerVerificarPrimoRun {

	public static void main(String[] args) throws Exception {

		run("localhost", "5552");

	}
	
	public static void run(String host,String port)throws Exception{
		ServerVerificarPrimo servico = new ServerVerificarPrimo();
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
					ServerVerificarPrimo servico = new ServerVerificarPrimo();
					String op = mIn.getOperacao();

					switch (op) {
					case "verificaPrimo":
						mOut.setValores(servico.verificaPrimo((int) mIn.getValores()));
						break;

					default:
						break;
					}
					
					return mOut;
				}
			};

			new Thread(thread).start();

		}
	}

}
