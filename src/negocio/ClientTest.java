package negocio;

import middware.Comm;

public class ClientTest {
	
	public static void main(String[] args) throws Exception {
		Comm server = new Comm(new RegistroServidor("localhost", "5000"));
		Message reqMsg = new Message();
		reqMsg.setOperacao("nomesServicos");
		
		System.out.println(server.requestAndReceive(reqMsg).getValores());
		
		reqMsg.setOperacao("recuperarServico");
		reqMsg.setValores("ServerEncriptaDesencripta");
		
		RegistroServidor rs = (RegistroServidor) server.requestAndReceive(reqMsg).getValores();
		
		System.out.println(rs);
		
		server = new Comm(rs);
		
		byte[] chave = { (byte)26, (byte) 157, 127, 26, (byte) 145, 93, 118,
				(byte) 140 };
		
		byte[] textoEncriptado = { (byte) 251, 32, (byte) 160, 123, 119, 34, 4,
				(byte) 164, 7, 94, (byte) 143, (byte) 199, (byte) 225,
				(byte) 218, (byte) 137, 45 };
		
		reqMsg.setOperacao("desencripta");
		reqMsg.setValores(new CrypWrap(chave, textoEncriptado));
		CrypWrap s = (CrypWrap)server.requestAndReceive(reqMsg).getValores();
		
		System.out.println(s.getResult());
		

	}

}
