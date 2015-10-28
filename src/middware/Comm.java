package middware;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.UUID;

import negocio.Message;
import negocio.RegistroServidor;


public class Comm implements IComm {
	private int port;
	private String host;
	ServerSocket welcomeSocket;
	Socket connectionSocket;
	RegistroServidor rs;
	
	public Comm(RegistroServidor rs) {
		this.port = Integer.parseInt(rs.getPorta());
		this.host = rs.getIp();
	}

	@Override
	public void send(Message msg) throws Exception {
		Socket clientSocket = null;
		clientSocket = new Socket(host, port);
		ObjectOutputStream outToServer;
		outToServer = new ObjectOutputStream(clientSocket.getOutputStream());
		outToServer.writeObject(msg);
		clientSocket.close();
		Thread.sleep(500);
	}
	
	
	

	public Message receive2() throws Exception {
		Message msg = null;
		ServerSocket welcomeSocket = new ServerSocket(port);
		Socket connectionSocket = welcomeSocket.accept();
		ObjectInputStream inFromClient; 
		inFromClient = new ObjectInputStream(connectionSocket.getInputStream());
		msg = (Message) inFromClient.readObject();
		welcomeSocket.close();
		connectionSocket.close();
		
		return msg;
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
		Thread.sleep(2);
		return retorno;

}
	@Override
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
}
