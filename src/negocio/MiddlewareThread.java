package negocio;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public abstract class MiddlewareThread implements Runnable {
	Socket s;

	public MiddlewareThread(Socket s) {
		this.s = s;
	}

	@Override
	public void run() {
		Message m;
		try {
			m = recieve();

			reply(exec(m));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public abstract Message exec(Message m);

	private Message recieve() throws IOException, ClassNotFoundException {
		ObjectInputStream inFromClient;
		inFromClient = new ObjectInputStream(s.getInputStream());

		Message o = (Message) inFromClient.readObject();
		return o;
	}

	public void reply(Message msg) throws Exception {

		ObjectOutputStream saida = new ObjectOutputStream(s.getOutputStream());
		saida.writeObject(msg);
		s.close();

	}
}
