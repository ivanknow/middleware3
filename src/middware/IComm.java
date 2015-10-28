package middware;

import negocio.Message;

public interface IComm {
	void send(Message msg) throws Exception;
	Message receive() throws Exception;
}