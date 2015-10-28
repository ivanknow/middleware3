package negocio;


import interfaces.IEncriptaDecripta;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class ServerEncriptaDesencripta implements IEncriptaDecripta {

	@Override
	public void encripta(String texto) {

		try {
			KeyGenerator keygenerator = KeyGenerator.getInstance("DES");
			SecretKey chaveDES = keygenerator.generateKey();

			// acrescimo
			byte chave[] = chaveDES.getEncoded();
			System.out.println("chave: ");
			for (int i = 0; i < chave.length; i++) {
				System.out.print((0x00FF & chave[i]) + " ");
			}
			System.out.println();
			// fim acrescimo

			Cipher cifraDES;
			// Cria a cifra
			cifraDES = Cipher.getInstance("DES/ECB/PKCS5Padding");
			// Inicializa a cifra para o processo de encripta��o
			cifraDES.init(Cipher.ENCRYPT_MODE, chaveDES);
			// Texto puro
			byte[] textoPuro = texto.getBytes();
			System.out.println("Texto [Formato de Byte] : " + textoPuro);
			System.out.println("Texto Puro : " + new String(textoPuro));
			// Texto encriptado
			byte[] textoEncriptado = cifraDES.doFinal(textoPuro);
			System.out.println("Texto Encriptado : " + textoEncriptado);

			// acrescimo
			for (int i = 0; i < textoEncriptado.length; i++) {
				System.out.print((0x00FF & textoEncriptado[i]) + " ");
			}
			System.out.println();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void desencripta(byte[] chave, byte[] textoEncriptado) {

		try {

			Cipher cifraDES;
			cifraDES = Cipher.getInstance("DES/ECB/PKCS5Padding");

			SecretKey chaveDESteste = new SecretKeySpec(chave, "DES");

			// Inicializa a cifra tamb�m para o processo de decripta��o
			cifraDES.init(Cipher.DECRYPT_MODE, chaveDESteste);
			// Decriptografa o texto
			byte[] textoDecriptografado = cifraDES.doFinal(textoEncriptado);
			System.out.println("Texto Decriptografado : "
					+ new String(textoDecriptografado));

		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		ServerEncriptaDesencripta ed = new ServerEncriptaDesencripta();
		//ed.encripta("Jo�o Paulo");

		byte[] chave = { (byte)26, (byte) 157, 127, 26, (byte) 145, 93, 118,
				(byte) 140 };
		byte[] textoEncriptado = { (byte) 251, 32, (byte) 160, 123, 119, 34, 4,
				(byte) 164, 7, 94, (byte) 143, (byte) 199, (byte) 225,
				(byte) 218, (byte) 137, 45 };
		ed.desencripta(chave, textoEncriptado);
	}
}
