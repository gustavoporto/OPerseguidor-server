package br.com.calcard.calsystem.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

public class FileKeyTool {

	public static final String PATH = "C:\\key";

	private KeyTool keyTool = null;

	public FileKeyTool() {
		keyTool = new KeyTool();
	}

	public static void main(String args[]) {

		FileKeyTool fileKeyTool = new FileKeyTool();

		fileKeyTool.gerarArquivos();

//		fileKeyTool.carregarPublicKey();
//
//		fileKeyTool.carregarPrivateKey();
//
		fileKeyTool.carregarKeyPair();

	}

	public KeyPair gerarArquivos() {

		try {

			keyTool.gerarChave();

			X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(
					keyTool.getKeyPair().getPublic().getEncoded());

			FileOutputStream fos;

			fos = new FileOutputStream(PATH + "/public.key");

			fos.write(x509EncodedKeySpec.getEncoded());

			fos.close();

			PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(
					keyTool.getKeyPair().getPrivate().getEncoded());

			fos = new FileOutputStream(PATH + "/private.key");

			fos.write(pkcs8EncodedKeySpec.getEncoded());

			fos.close();

			return keyTool.getKeyPair();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("+++++++ public key ++++++++");
		System.out.println(keyTool
				.keyToString(keyTool.getKeyPair().getPublic()));
		System.out.println("++++++++++++++++++++++++++++");

		System.out.println("+++++++ private key ++++++++");
		System.out.println(keyTool.keyToString(keyTool.getKeyPair()
				.getPrivate()));
		System.out.println("++++++++++++++++++++++++++++");

		return null;

	}

	public PublicKey carregarPublicKey() {

		try {

			File filePublicKey = new File(PATH + "/public.key");
			FileInputStream fis;

			fis = new FileInputStream(PATH + "/public.key");

			byte[] encodedPublicKey = new byte[(int) filePublicKey.length()];
			fis.read(encodedPublicKey);
			fis.close();

			X509EncodedKeySpec publicKeySpec = new X509EncodedKeySpec(
					encodedPublicKey);

			PublicKey publicKey = keyTool.getKeyFactory().generatePublic(
					publicKeySpec);

			System.out.println("+++++++ public key ++++++++");
			System.out.println(keyTool.keyToString(publicKey));
			System.out.println("++++++++++++++++++++++++++++");

			return publicKey;

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InvalidKeySpecException e) {
			e.printStackTrace();
		}

		return null;

	}

	public PrivateKey carregarPrivateKey() {

		try {

			File filePrivateKey = new File(PATH + "/private.key");
			FileInputStream fis;

			fis = new FileInputStream(PATH + "/private.key");

			byte[] encodedPrivateKey = new byte[(int) filePrivateKey.length()];
			fis.read(encodedPrivateKey);
			fis.close();

			PKCS8EncodedKeySpec privateKeySpec = new PKCS8EncodedKeySpec(
					encodedPrivateKey);

			PrivateKey privateKey = keyTool.getKeyFactory().generatePrivate(
					privateKeySpec);

			System.out.println("+++++++ private key ++++++++");
			System.out.println(keyTool.keyToString(privateKey));
			System.out.println("++++++++++++++++++++++++++++");

			return privateKey;

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InvalidKeySpecException e) {
			e.printStackTrace();
		}

		return null;
	}

	public KeyPair carregarKeyPair() {

		PublicKey publicKey = carregarPublicKey();

		PrivateKey privateKey = carregarPrivateKey();

		return new KeyPair(publicKey, privateKey);
	}

}
