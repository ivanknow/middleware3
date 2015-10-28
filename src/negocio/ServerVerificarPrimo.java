package negocio;



import interfaces.IVericarPrimo;

public class ServerVerificarPrimo implements IVericarPrimo {

	@Override
	public boolean verificaPrimo(int numero) {

		int div = 0;

		for (int i = 1; i <= numero; i++) {
			if (numero % i == 0) {
				div++;
			}
		}
		if (div == 2) {
			System.out.println("É primo");
			return true;
		} else {
			System.out.println("Não é primo");
			return false;
		}
	}
	
	public static void main(String[] args) {
		ServerVerificarPrimo vp = new ServerVerificarPrimo();
		int i = 100000000;
		vp.verificaPrimo(i);
	}

}
