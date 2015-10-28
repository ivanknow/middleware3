package negocio;

import java.io.Serializable;

public class Message implements Serializable {
	private static final long serialVersionUID = -2734963953080470754L;

	private String operacao;
	private Object valores;

	public String getOperacao() {
		return operacao;
	}
	public void setOperacao(String operacao) {
		this.operacao = operacao;
	}
	public Object getValores() {
		return valores;
	}
	public void setValores(Object valores) {
		this.valores = valores;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	
	
	
}
