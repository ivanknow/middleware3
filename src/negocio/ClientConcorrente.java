package negocio;

public class ClientConcorrente {
	
	public static void main(String[] args) throws Exception {
		try {
			//ServNomeRun.run("localhost","5000");
			Thread.sleep(500);
			ServerCalculadoraRun.run("localhost","5001");
			Thread.sleep(500);
			ServerCalculadoraRun.run("localhost","5002");
			Thread.sleep(500);
			ServerConversaoTemperaturaRun.run("localhost", "5003");
			Thread.sleep(500);
			ServerEncriptaDesencriptaRun.run("localhost","5004");
			Thread.sleep(500);
			ServerVerificarPrimoRun.run("localhost","5005");
		
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}
