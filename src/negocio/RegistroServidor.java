package negocio;

import java.io.Serializable;

public class RegistroServidor implements Serializable {
	
	private static final long serialVersionUID = -2734963953080470754L;
	private String ip;
	private String porta;
	private String identificador;
	private String nomeServico;
	private int requisicoes;
	
	
	
	public RegistroServidor(String ip, String porta) {
		super();
		this.ip = ip;
		this.porta = porta;
	
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getPorta() {
		return porta;
	}
	public void setPorta(String porta) {
		this.porta = porta;
	}
	public String getIdentificador() {
		return identificador;
	}
	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}
	public String getNomeServico() {
		return nomeServico;
	}
	public void setNomeServico(String nomeServico) {
		this.nomeServico = nomeServico;
	}
	public int getRequisicoes() {
		return requisicoes;
	}
	public void setRequisicoes(int requisicoes) {
		this.requisicoes = requisicoes;
	}
	@Override
	public String toString() {
		return "RegistroServidor [ip=" + ip + ", porta=" + porta + ", identificador=" + identificador + ", nomeServico="
				+ nomeServico + ", requisicoes=" + requisicoes + "]";
	}
	
	
	
}
