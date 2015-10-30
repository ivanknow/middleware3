package interfaces;

public interface IEncriptaDecripta {
	
	byte[] encripta(String texto);
	String desencripta(byte[] chave, byte[] textoEncriptado);

}
