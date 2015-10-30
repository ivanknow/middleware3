package negocio;

import java.io.Serializable;
import java.util.Arrays;

public class CrypWrap implements Serializable{
	private byte[] chave;
	private byte[] textoEncriptado;
	private String result;
	
	
	public CrypWrap(byte[]chave, byte[]textoEncriptado) {
		super();
		this.chave = chave;
		this.textoEncriptado = textoEncriptado;
	}


	public byte[] getChave() {
		return chave;
	}


	public void setChave(byte[] chave) {
		this.chave = chave;
	}


	public byte[] getTextoEncriptado() {
		return textoEncriptado;
	}


	public void setTextoEncriptado(byte[] textoEncriptado) {
		this.textoEncriptado = textoEncriptado;
	}


	public String getResult() {
		return result;
	}


	public void setResult(String result) {
		this.result = result;
	}


	@Override
	public String toString() {
		return "CrypWrap [chave=" + Arrays.toString(chave)
				+ ", textoEncriptado=" + Arrays.toString(textoEncriptado)
				+ ", result=" + result + "]";
	}
	
	
	
	
}
