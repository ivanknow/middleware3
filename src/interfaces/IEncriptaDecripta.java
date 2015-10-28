package interfaces;

public interface IEncriptaDecripta {
	
	void encripta(String texto);
	void desencripta(byte[] chave, byte[] textoEncriptado);

}
