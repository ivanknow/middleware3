package negocio;

import java.net.Socket;

public abstract class MiddlewareThread implements Runnable{
	Socket s;
	public MiddlewareThread(Socket s) {
		this.s = s;
	}
	@Override
	public void run() {
		exec();
		
	}

	public abstract void exec();
}
