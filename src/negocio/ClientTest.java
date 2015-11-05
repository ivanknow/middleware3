package negocio;


public class ClientTest {
	
	//Antes de iniciar o teste
	//1 - Execute a classe ServNomeRun
	//2 - Execute os demais serviços com terminação Run.
	//3 - O mesmo serviço pode ser executado mais de uma vez, mas a porta deve ser modificada
	

	public static void main(String[] args) throws Exception {

		byte[] chave = { (byte) 191, 35, 38, (byte) 151, (byte) 193, 11,
				(byte) 128, (byte) 213 };

		byte[] textoEncriptado = { (byte) 199, (byte) 237, (byte) 131,
				(byte) 244, 0, 30, (byte) 157, (byte) 136, 120, (byte) 248,
				(byte) 130, 84, 88, 29, 78, (byte) 197, 113, (byte) 225, 121,
				94, 22, 50, 67, 127, 84, 85, (byte) 228, 23, (byte) 153,
				(byte) 162, 81, 121 };

		ClientTestComentado.testCalculadoraSoma("div", 20, 2);// Parâmetros:"soma","sub","mult","div",valor1,valor2
		ClientTestComentado.testVerificaPrimo(4);
		ClientTestComentado.testConversaoTempCelsiusToFahrenheit(0);
		ClientTestComentado.encripta("texto");
		ClientTestComentado.desencripta(chave, textoEncriptado);

	}

}
