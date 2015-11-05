package negocio;

import java.net.ConnectException;

import middware.Comm;

public class ClientTestComentado {
	
	public static void testCalculadoraSoma(String operacao, Integer valor1, Integer valor2) throws Exception {
		try {
			
		//Antes de iniciar o teste
		//1 - Execute a classe ServNomeRun
		//2 - Execute os demais serviços com terminação Run.
		//3 - O mesmo serviço pode ser executado mais de uma vez, mas a porta deve ser modificada
		
		//Configura servidor de nomes
		Comm server = new Comm(new RegistroServidor("localhost", "5000"));
		
		//Cria mensagem de requisicao de nomes
		Message reqMsg = new Message(){};
		reqMsg.setOperacao("nomesServicos");
		
		//mostra nomes de servicos disponiveis atualmente
		System.out.println(server.requestAndReceive(reqMsg).getValores());
		
		//prepara mensagem para requerer servico de calculadora
		reqMsg.setOperacao("recuperarServico");
		reqMsg.setValores("ServerCalculadora");
		
		//recebe referencia para serviço
		RegistroServidor rs = (RegistroServidor) server.requestAndReceive(reqMsg).getValores();
		
		System.out.println(rs);
		
		//faz nova conexao com servico
		server = new Comm(rs);
		
		//prepara mensagem
		reqMsg.setOperacao(operacao);
		reqMsg.setValores(new NumerosWrap(valor1, valor2));
		NumerosWrap s = (NumerosWrap)server.requestAndReceive(reqMsg).getValores();
		
		//resultado
		System.out.println(s.getResult());
		
		} catch (ConnectException e) {
			System.out.println("[ERRO]Algum dos servidores esta indisponivel");
		}catch (Exception e) {
			System.out.println("[ERRO]Erro inesperado");
		}

	}
	
	public static void testVerificaPrimo(int numero){
		
		try {
			
			//Antes de iniciar o teste
			//1 - Execute a classe ServNomeRun
			//2 - Execute os demais serviços com terminação Run.
			//3 - O mesmo serviço pode ser executado mais de uma vez, mas a porta deve ser modificada
			
			//Configura servidor de nomes
			Comm server = new Comm(new RegistroServidor("localhost", "5000"));
			
			//Cria mensagem de requisicao de nomes
			Message reqMsg = new Message(){};
			reqMsg.setOperacao("nomesServicos");
			
			//mostra nomes de servicos disponiveis atualmente
			System.out.println(server.requestAndReceive(reqMsg).getValores());
			
			//prepara mensagem para requerer servico de calculadora
			reqMsg.setOperacao("recuperarServico");
			reqMsg.setValores("ServerVerificarPrimo");
			
			//recebe referencia para serviço
			RegistroServidor rs = (RegistroServidor) server.requestAndReceive(reqMsg).getValores();
			
			System.out.println(rs);
			
			//faz nova conexao com servico
			server = new Comm(rs);
			
			//prepara mensagem
			reqMsg.setOperacao("verificaPrimo");
			reqMsg.setValores(numero);
			//NumerosWrap s = (NumerosWrap)server.requestAndReceive(reqMsg).getValores();
			
			//resultado
			System.out.println(server.requestAndReceive(reqMsg).getValores());
			
			} catch (ConnectException e) {
				System.out.println("[ERRO]Algum dos servidores esta indisponivel");
			}catch (Exception e) {
				System.out.println("[ERRO]Erro inesperado");
			}
		
	}
	
	public static void testConversaoTempCelsiusToFahrenheit(double numero){
		
		try {
			
			//Antes de iniciar o teste
			//1 - Execute a classe ServNomeRun
			//2 - Execute os demais serviços com terminação Run.
			//3 - O mesmo serviço pode ser executado mais de uma vez, mas a porta deve ser modificada
			
			//Configura servidor de nomes
			Comm server = new Comm(new RegistroServidor("localhost", "5000"));
			
			//Cria mensagem de requisicao de nomes
			Message reqMsg = new Message(){};
			reqMsg.setOperacao("nomesServicos");
			
			//mostra nomes de servicos disponiveis atualmente
			System.out.println(server.requestAndReceive(reqMsg).getValores());
			
			//prepara mensagem para requerer servico de calculadora
			reqMsg.setOperacao("recuperarServico");
			reqMsg.setValores("ServerConversaoTemperatura");
			
			//recebe referencia para serviço
			RegistroServidor rs = (RegistroServidor) server.requestAndReceive(reqMsg).getValores();
			
			System.out.println(rs);
			
			//faz nova conexao com servico
			server = new Comm(rs);
			
			//prepara mensagem
			reqMsg.setOperacao("celsiusToFahrenheit");
			reqMsg.setValores(numero);
			//NumerosWrap s = (NumerosWrap)server.requestAndReceive(reqMsg).getValores();
			
			//resultado
			System.out.println(server.requestAndReceive(reqMsg).getValores());
			
			} catch (ConnectException e) {
				System.out.println("[ERRO]Algum dos servidores esta indisponivel");
			}catch (Exception e) {
				System.out.println("[ERRO]Erro inesperado");
			}
		
	}
	
	public static void encripta(String texto) {
		
		try {
			
			//Antes de iniciar o teste
			//1 - Execute a classe ServNomeRun
			//2 - Execute os demais serviços com terminação Run.
			//3 - O mesmo serviço pode ser executado mais de uma vez, mas a porta deve ser modificada
			
			//Configura servidor de nomes
			Comm server = new Comm(new RegistroServidor("localhost", "5000"));
			
			//Cria mensagem de requisicao de nomes
			Message reqMsg = new Message(){};
			reqMsg.setOperacao("nomesServicos");
			
			//mostra nomes de servicos disponiveis atualmente
			System.out.println(server.requestAndReceive(reqMsg).getValores());
			
			//prepara mensagem para requerer servico de calculadora
			reqMsg.setOperacao("recuperarServico");
			reqMsg.setValores("ServerEncriptaDesencripta");
			
			//recebe referencia para serviço
			RegistroServidor rs = (RegistroServidor) server.requestAndReceive(reqMsg).getValores();
			
			System.out.println(rs);
			
			//faz nova conexao com servico
			server = new Comm(rs);
			
			//prepara mensagem
			reqMsg.setOperacao("encripta");
			reqMsg.setValores(texto);
			//NumerosWrap s = (NumerosWrap)server.requestAndReceive(reqMsg).getValores();
			
			//resultado
			System.out.println(server.requestAndReceive(reqMsg).getValores());
			
			} catch (ConnectException e) {
				System.out.println("[ERRO]Algum dos servidores esta indisponivel");
			}catch (Exception e) {
				System.out.println("[ERRO]Erro inesperado");
			}
		
	}
	
	public static void desencripta (byte[]chave, byte[]textoEncriptado) {
		
		try {
			
			//Antes de iniciar o teste
			//1 - Execute a classe ServNomeRun
			//2 - Execute os demais serviços com terminação Run.
			//3 - O mesmo serviço pode ser executado mais de uma vez, mas a porta deve ser modificada
			
			//Configura servidor de nomes
			Comm server = new Comm(new RegistroServidor("localhost", "5000"));
			
			//Cria mensagem de requisicao de nomes
			Message reqMsg = new Message(){};
			reqMsg.setOperacao("nomesServicos");
			
			//mostra nomes de servicos disponiveis atualmente
			System.out.println(server.requestAndReceive(reqMsg).getValores());
			
			//prepara mensagem para requerer servico de calculadora
			reqMsg.setOperacao("recuperarServico");
			reqMsg.setValores("ServerEncriptaDesencripta");
			
			//recebe referencia para serviço
			RegistroServidor rs = (RegistroServidor) server.requestAndReceive(reqMsg).getValores();
			
			System.out.println(rs);
			
			//faz nova conexao com servico
			server = new Comm(rs);
			
			//prepara mensagem
//			reqMsg.setOperacao("encripta");
//			reqMsg.setValores(texto);
			reqMsg.setOperacao("desencripta");
			reqMsg.setValores(new CrypWrap(chave, textoEncriptado));
			
			//NumerosWrap s = (NumerosWrap)server.requestAndReceive(reqMsg).getValores();
			
			//resultado
			System.out.println(server.requestAndReceive(reqMsg).getValores());
			
			} catch (ConnectException e) {
				System.out.println("[ERRO]Algum dos servidores esta indisponivel");
			}catch (Exception e) {
				System.out.println("[ERRO]Erro inesperado");
			}
	
		
	}
		
	


}
