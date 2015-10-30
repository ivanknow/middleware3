package negocio;

import middware.Comm;

public class ServNomeRun {
	public static void main(String[] args) throws Exception {
		
		run("localhost","5000");
	}
	static ServidorNomes sn = new ServidorNomes();
	public static void run(String host,String port) throws Exception{
		Comm m = new Comm(new RegistroServidor(host, port));

		
		while (true) {
			MiddlewareThread thread = new MiddlewareThread(m.receiveThread()) {
				
				@Override
				public Message exec(Message mIn) {
					Message mOut = new Message();
					String op = mIn.getOperacao();
					
					switch (op) {
					case "nomesServicos":
						mOut.setValores(sn.nomesServicos());
						break;
					case "recuperarServico":
						mOut.setValores(sn.recuperarServico((String)mIn.getValores()));
						break;
					case "adicionarServico":
						sn.adicionarServico((RegistroServidor)mIn.getValores());
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