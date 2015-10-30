package middware;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.UUID;

import negocio.Message;
import negocio.RegistroServidor;


public class Comm {
	private int port;
	private String host;
	ServerSocket welcomeSocket;
	Socket connectionSocket;
	RegistroServidor rs;
	
	public Comm(RegistroServidor rs) {
		this.port = Integer.parseInt(rs.getPorta());
		this.host = rs.getIp();
	}

	
	public Message requestAndReceive(Message m) throws Exception {

		Socket clientSocket = null;
		clientSocket = new Socket(host, port);
		ObjectOutputStream outToServer;
		outToServer = new ObjectOutputStream(clientSocket.getOutputStream());
	
		outToServer.writeObject(m);
	
		Message retorno = null;
		ObjectInputStream inFromClient; 
		inFromClient = new ObjectInputStream(clientSocket.getInputStream());
		retorno= (Message) inFromClient.readObject();
		clientSocket.close();

		return retorno;

}

	public Message receive() throws Exception{
		welcomeSocket = new ServerSocket(port);
		connectionSocket = welcomeSocket.accept();
		ObjectInputStream inFromClient; 
		inFromClient = new ObjectInputStream(connectionSocket.getInputStream());
		
		Message o = (Message)inFromClient.readObject();
		
		Thread.sleep(2);
		
		return o;
		
	}

		public void reply(Message msg) throws Exception {
		
		ObjectOutputStream saida = new ObjectOutputStream(connectionSocket.getOutputStream());
		saida.writeObject(msg);
		welcomeSocket.close();
		connectionSocket.close();
		Thread.sleep(2);
	
	}
		
		public Socket receiveThread() throws Exception{
			welcomeSocket = new ServerSocket(port);
			Socket s = welcomeSocket.accept();
			welcomeSocket.close();
			return s;
		}

			
}
