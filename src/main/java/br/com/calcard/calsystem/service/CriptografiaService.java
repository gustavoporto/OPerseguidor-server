package br.com.calcard.calsystem.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.InvalidParameterSpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Random;
import java.util.regex.Pattern;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import sun.misc.BASE64Encoder;
import br.com.calcard.calsystem.checkedException.ServiceException;

public class CriptografiaService {

	public static void main(String[] args) throws NoSuchAlgorithmException,
			ServiceException {

		try {

			CriptografiaService.RSA rsa = new CriptografiaService().new RSA();

			/*** encrypt */
			String ciphertext = rsa.encrypt("gustavo");

			System.out.println(ciphertext);

			/*** decrypt */
			String plaintext = rsa
					.decrypt("k060MG6UCRrCuHBI8mtGAdn+F1fNNWIj3vD8YwQQNQqwZrI0hfmNZlVqOONFPpzUa6SpuyMMUb81tc4sKYAX8ds2w1FZbPQcqwuuzpHDagfmPD/28u8OcufAMnQawCKjpcPzFmxEcyfX0xh41cQGvG5gJ3YN9lTEgw0oK+rrQFEMcuQF3IlY/1ScXhUdeEQfzVrNDLHj+UybGRmzXcMBptC5yTQnl8jwNsfiKMgRNTVRHa9SMPthiG+hz5i6FZzzFpmpczsy+KKp33BSbRAwTk9BUCWFCAexX94TIiyFl9zK34CAOecaQ0Z59z6+c7hUSggl0+GSbLOJz0Vio+/G9UT9e3dTCdqG4SxlVYagu7AFbW90aiom6qAEOURRgft4rFH3J6vCWl6ggJ4gadLKstBZT+nwVxCWIVqneLr6VH/n9t5Fee4aMaU8ekL7bXXvjvq5JvrcUKK8MGsVAL0T7ANIbYPzyjnz4FfpSHxsNpzBQPChErLouBLNiZXGOjqOY3e97gzNuvp3X8RXZVePdzVHd/x9h7GeF/tS9TtCRIjhXvtyAjqpbAZ/AWsOkW2j0GsYSj4BmItPN6kb8JDiM7lLXWwGcYwn75/qSgLwyPeA0Prr6oPhmGhbjqhTa0BCASsIoEi9IJUk4fN3fNCcv6zLi7B0uBRqn7s9b6JYkBY=");

			System.out.println(CriptografiaService.Utils
					.base64_decode(plaintext));

		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		}

	}

	/*
	 * AES
	 */
	public class AES {
		private final String ALGORITHM = "AES"; // symmetric algorithm for data
												// encryption
		private final String MODE = "CBC";
		private final String PADDING = "PKCS5Padding"; // Padding for symmetric
														// algorithm
		private final String CIPHER_TRANSFORMATION = ALGORITHM + "/" + MODE
				+ "/" + PADDING;
		private Charset PLAIN_TEXT_ENCODING = Charset.forName("UTF-8"); // character
																		// encoding
		// private final String CRYPTO_PROVIDER = "SunMSCAPI"; // provider for
		// the crypto
		private int KEY_SIZE_BITS = 128; /*
										 * symmetric key size (128, 192, 256) if
										 * using 256 you must have the Java
										 * Cryptography Extension (JCE)
										 * Unlimited Strength Jurisdiction
										 * Policy Files installed
										 */
		private int KEY_SIZE_BYTES = KEY_SIZE_BITS / 8;

		private Cipher cipher = Cipher.getInstance(CIPHER_TRANSFORMATION);
		private byte[] ivBytes = new byte[KEY_SIZE_BYTES];
		private SecretKey key;

		public AES() throws NoSuchAlgorithmException, NoSuchPaddingException,
				NoSuchProviderException, InvalidParameterSpecException,
				InvalidKeyException, InvalidAlgorithmParameterException {
			KeyGenerator kgen = KeyGenerator.getInstance(ALGORITHM);
			kgen.init(KEY_SIZE_BITS);
			key = kgen.generateKey();
			cipher.init(Cipher.ENCRYPT_MODE, key);
			ivBytes = cipher.getParameters()
					.getParameterSpec(IvParameterSpec.class).getIV();
		}

		public String getIVAsHex() {
			return Utils.byteArrayToHexString(ivBytes);
		}

		public String getKeyAsHex() {
			return Utils.byteArrayToHexString(key.getEncoded());
		}

		public void setStringToKey(String keyText)
				throws NoSuchAlgorithmException, UnsupportedEncodingException {
			setKey(keyText.getBytes());
		}

		public void setHexToKey(String hexKey) {
			setKey(Utils.hexStringToByteArray(hexKey));
		}

		public void setKey(byte[] bArray) {
			byte[] bText = new byte[KEY_SIZE_BYTES];
			int end = Math.min(KEY_SIZE_BYTES, bArray.length);
			System.arraycopy(bArray, 0, bText, 0, end);
			key = new SecretKeySpec(bText, ALGORITHM);
		}

		public void setStringToIV(String ivText) {
			setIV(ivText.getBytes());
		}

		public void setHexToIV(String hexIV) {
			setIV(Utils.hexStringToByteArray(hexIV));
		}

		public void setIV(byte[] bArray) {
			byte[] bText = new byte[KEY_SIZE_BYTES];
			int end = Math.min(KEY_SIZE_BYTES, bArray.length);
			System.arraycopy(bArray, 0, bText, 0, end);
			ivBytes = bText;
		}

		public byte[] generateIV() {
			byte[] iv = Utils.getRandomBytes(KEY_SIZE_BYTES);
			return iv;
		}

		public String encrypt(String plaintext, String passphrase)
				throws NoSuchAlgorithmException, UnsupportedEncodingException,
				InvalidKeyException, InvalidAlgorithmParameterException,
				IllegalBlockSizeException, BadPaddingException {
			if (plaintext.length() == 0)
				return null;

			setStringToKey(passphrase);

			cipher.init(Cipher.ENCRYPT_MODE, key, new IvParameterSpec(ivBytes));
			byte[] encrypted = cipher.doFinal(plaintext
					.getBytes(PLAIN_TEXT_ENCODING));
			return Utils.byteArrayToBase64String(encrypted);
		}

		public String decrypt(String ciphertext, String passphrase) {
			try {
				if (ciphertext.length() == 0)
					return null;

				setStringToKey(passphrase);

				byte[] dec = Utils.base64StringToByteArray(ciphertext);
				cipher.init(Cipher.DECRYPT_MODE, key, new IvParameterSpec(
						ivBytes));
				byte[] decrypted = cipher.doFinal(dec);
				return new String(decrypted, PLAIN_TEXT_ENCODING);

			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			} catch (InvalidKeyException e) {
				e.printStackTrace();
			} catch (InvalidAlgorithmParameterException e) {
				e.printStackTrace();
			} catch (IllegalBlockSizeException e) {
				e.printStackTrace();
			} catch (BadPaddingException e) {
				e.printStackTrace();
			}
			return null;
		}
	}

	/*
	 * PBKDF2: deriveKey
	 */
	private static class PBKDF2 {
		private static byte[] deriveKey(byte[] password, byte[] salt,
				int iterationCount, int dkLen) throws NoSuchAlgorithmException,
				InvalidKeyException {
			SecretKeySpec keyspec = new SecretKeySpec(password, "HmacSHA256");
			Mac prf = Mac.getInstance("HmacSHA256");
			prf.init(keyspec);

			// Note: hLen, dkLen, l, r, T, F, etc. are horrible names for
			// variables and functions in this day and age, but they
			// reflect the terse symbols used in RFC 2898 to describe
			// the PBKDF2 algorithm, which improves validation of the
			// code vs. the RFC.
			//
			// dklen is expressed in bytes. (16 for a 128-bit key)

			int hLen = prf.getMacLength(); // 20 for SHA1
			int l = Math.max(dkLen, hLen); // 1 for 128bit (16-byte) keys
			int r = dkLen - (l - 1) * hLen; // 16 for 128bit (16-byte) keys
			byte T[] = new byte[l * hLen];
			int ti_offset = 0;
			for (int i = 1; i <= l; i++) {
				F(T, ti_offset, prf, salt, iterationCount, i);
				ti_offset += hLen;
			}

			if (r < hLen) {
				// Incomplete last block
				byte DK[] = new byte[dkLen];
				System.arraycopy(T, 0, DK, 0, dkLen);
				return DK;
			}
			return T;
		}

		private static void F(byte[] dest, int offset, Mac prf, byte[] S,
				int c, int blockIndex) {
			final int hLen = prf.getMacLength();
			byte U_r[] = new byte[hLen];
			// U0 = S || INT (i);
			byte U_i[] = new byte[S.length + 4];
			System.arraycopy(S, 0, U_i, 0, S.length);
			INT(U_i, S.length, blockIndex);
			for (int i = 0; i < c; i++) {
				U_i = prf.doFinal(U_i);
				xor(U_r, U_i);
			}

			System.arraycopy(U_r, 0, dest, offset, hLen);
		}

		private static void xor(byte[] dest, byte[] src) {
			for (int i = 0; i < dest.length; i++) {
				dest[i] ^= src[i];
			}
		}

		private static void INT(byte[] dest, int offset, int i) {
			dest[offset + 0] = (byte) (i / (256 * 256 * 256));
			dest[offset + 1] = (byte) (i / (256 * 256));
			dest[offset + 2] = (byte) (i / (256));
			dest[offset + 3] = (byte) (i);
		}

		// Costructor
		private PBKDF2() {
		}

	}

	/*
	 * HASH
	 */
	public class HASH {

		public String MD2(String message) throws NoSuchAlgorithmException {
			MessageDigest md2 = MessageDigest.getInstance("MD2");
			byte[] array = md2.digest(message.getBytes());
			return arrayToString(array);
		}

		public String MD5(String message) {
			try {

				MessageDigest md5;
				md5 = MessageDigest.getInstance("MD5");
				byte[] array = md5.digest(message.getBytes());
				return arrayToString(array);

			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}

			return null;

		}

		public String SHA1(String message) throws NoSuchAlgorithmException {
			MessageDigest sha1 = MessageDigest.getInstance("SHA-1");
			byte[] array = sha1.digest(message.getBytes());
			return arrayToString(array);
		}

		public String SHA256(String message) throws NoSuchAlgorithmException {
			MessageDigest sha256 = MessageDigest.getInstance("SHA-256");
			byte[] array = sha256.digest(message.getBytes());
			return arrayToString(array);
		}

		public String SHA384(String message) throws NoSuchAlgorithmException {
			MessageDigest sha384 = MessageDigest.getInstance("SHA-384");
			byte[] array = sha384.digest(message.getBytes());
			return arrayToString(array);
		}

		public String SHA512(String message) throws NoSuchAlgorithmException {
			MessageDigest sha512 = MessageDigest.getInstance("SHA-512");
			byte[] array = sha512.digest(message.getBytes());
			return arrayToString(array);
		}

		private String arrayToString(byte[] array) {
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < array.length; ++i) {
				sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100)
						.substring(1, 3));
			}
			return sb.toString();
		}
	}

	/*
	 * RSA
	 */
	public class RSA {

		private final Charset PLAIN_TEXT_ENCODING = Charset.forName("UTF-8");
		private static final int KEY_SIZE_BITS = 4096;
		public static final String PATH = "C:\\key";

		private KeyPair keyPair;
		// private BigInteger modulus;
		// private BigInteger exponent;
		private Cipher cipher;
		private KeyFactory keyFactory;
		private KeyPairGenerator keyPairGenerator;

		public RSA() throws ServiceException {

			try {

				cipher = Cipher.getInstance("RSA");
				keyFactory = KeyFactory.getInstance("RSA");

			} catch (NoSuchAlgorithmException e) {
				throw new ServiceException("N�o foi instanciar objeto RSA", e);
			} catch (NoSuchPaddingException e) {
				throw new ServiceException("N�o foi instanciar objeto RSA", e);
			}

		}

		public RSA doGerarChave(int keySizeBits) throws ServiceException {
			try {
				keyPairGenerator = KeyPairGenerator.getInstance("RSA");
				keyPairGenerator.initialize(keySizeBits, new SecureRandom());
				keyPair = keyPairGenerator.generateKeyPair();
				return this;
			} catch (NoSuchAlgorithmException e) {
				throw new ServiceException(
						"N�o foi poss�vel gerar chave de criptografia", e);
			}
		}

		public RSA doGerarChave() throws ServiceException {

			return doGerarChave(KEY_SIZE_BITS);

		}

		public String doKeyToString(Key key) {

			byte[] publicKeyBytes = key.getEncoded();

			BASE64Encoder encoder = new BASE64Encoder();
			return encoder.encode(publicKeyBytes);

		}

		public KeyPair doCarregarKeyPair() throws InvalidKeySpecException,
				IOException {
			keyPair = new KeyPair(doCarregarPublicKey(), doCarregarPrivateKey());
			return keyPair;
		}

		private PrivateKey doCarregarPrivateKey() throws IOException,
				InvalidKeySpecException {

			File filePrivateKey = new File(PATH + "/private.key");
			FileInputStream fis;

			fis = new FileInputStream(PATH + "/private.key");

			byte[] encodedPrivateKey = new byte[(int) filePrivateKey.length()];
			fis.read(encodedPrivateKey);
			fis.close();

			PKCS8EncodedKeySpec privateKeySpec = new PKCS8EncodedKeySpec(
					encodedPrivateKey);

			PrivateKey privateKey = keyFactory.generatePrivate(privateKeySpec);

			System.out.println("+++++++ private key ++++++++");
			System.out.println(doKeyToString(privateKey));
			System.out.println("++++++++++++++++++++++++++++");

			return privateKey;

		}

		private PublicKey doCarregarPublicKey() throws IOException,
				InvalidKeySpecException {

			File filePublicKey = new File(PATH + "/public.key");
			FileInputStream fis;

			fis = new FileInputStream(PATH + "/public.key");

			byte[] encodedPublicKey = new byte[(int) filePublicKey.length()];
			fis.read(encodedPublicKey);
			fis.close();

			X509EncodedKeySpec publicKeySpec = new X509EncodedKeySpec(
					encodedPublicKey);

			PublicKey publicKey = keyFactory.generatePublic(publicKeySpec);

			System.out.println("+++++++ public key ++++++++");
			System.out.println(doKeyToString(publicKey));
			System.out.println("++++++++++++++++++++++++++++");

			return publicKey;

		}

		// private boolean setNewKey(int KeySize) throws
		// NoSuchAlgorithmException,
		// InvalidKeySpecException {
		// if (KeySize <= 0)
		// return false;
		//
		// KeyPair keyPair = new FileKeyTool().carregarKeyPair();
		//
		// // RSAPublicKeySpec pub = (RSAPublicKeySpec) keyFactory.getKeySpec(
		// // keyPair.getPublic(), RSAPublicKeySpec.class);
		// // modulus = pub.getModulus();
		// // exponent = pub.getPublicExponent();
		//
		// return true;
		// }

		public String encrypt(String plaintext) throws InvalidKeyException,
				IllegalBlockSizeException, BadPaddingException {

			if (plaintext.length() == 0)
				return null;

			return encrypt(plaintext, keyPair.getPublic());

		}

		public String encrypt(String plaintext, Key key)
				throws IllegalBlockSizeException, BadPaddingException,
				InvalidKeyException {
			if (plaintext.length() == 0)
				return null;
			cipher.init(Cipher.ENCRYPT_MODE, key);
			byte[] encrypted = cipher.doFinal(plaintext.getBytes());
			return Utils.byteArrayToBase64String(encrypted);
		}

		public String decrypt(String ciphertext) {

			if (ciphertext.length() == 0)
				return null;

			return decrypt(ciphertext, keyPair.getPrivate());

		}

		public String decrypt(String ciphertext, Key key) {
			try {

				if (ciphertext.length() == 0)
					return null;

				byte[] dec = Utils.base64StringToByteArray(ciphertext);

				cipher.init(Cipher.DECRYPT_MODE, key);

				byte[] decrypted = cipher.doFinal(dec);

				return new String(decrypted, PLAIN_TEXT_ENCODING);

			} catch (InvalidKeyException e) {
				e.printStackTrace();
			} catch (IllegalBlockSizeException e) {
				e.printStackTrace();
			} catch (BadPaddingException e) {
				e.printStackTrace();
			}
			return null;
		}

		public KeyPair getKeyPair() {
			return keyPair;
		}

	}

	/*
	 * Utils
	 */
	public static class Utils {
		public static String pbkdf2(String password, String salt,
				int iterationCount, int dkLen) throws InvalidKeyException,
				NoSuchAlgorithmException {
			if (dkLen != 16 && dkLen != 24 && dkLen != 32) {
				dkLen = 16;
			}
			if (iterationCount < 0) {
				iterationCount = 0;
			}

			byte[] _password = password.getBytes();
			byte[] _salt = salt.getBytes();
			byte[] key = PBKDF2.deriveKey(_password, _salt, iterationCount,
					dkLen);
			return new String(key);
		}

		public static byte[] getRandomBytes(int len) {
			if (len < 0) {
				len = 8;
			}
			Random ranGen = new SecureRandom();
			byte[] aesKey = new byte[len];
			ranGen.nextBytes(aesKey);
			return aesKey;
		}

		public static String byteArrayToHexString(byte[] raw) {
			StringBuilder sb = new StringBuilder(2 + raw.length * 2);
			sb.append("0x");
			for (int i = 0; i < raw.length; i++) {
				sb.append(String.format("%02X", Integer.valueOf(raw[i] & 0xFF)));
			}
			return sb.toString();
		}

		public static byte[] hexStringToByteArray(String hex) {
			Pattern replace = Pattern.compile("^0x");
			String s = replace.matcher(hex).replaceAll("");

			byte[] b = new byte[s.length() / 2];
			for (int i = 0; i < b.length; i++) {
				int index = i * 2;
				int v = Integer.parseInt(s.substring(index, index + 2), 16);
				b[i] = (byte) v;
			}
			return b;
		}

		public static String byteArrayToBase64String(byte[] raw) {
			return new String(Base64Coder.encode(raw));
		}

		public static byte[] base64StringToByteArray(String str) {
			return Base64Coder.decode(str);
		}

		public static String base64_encode(String str) {
			return Base64Coder.encodeString(str);
		}

		public static String base64_decode(String str) {
			return Base64Coder.decodeString(str);
		}
	}

	/*
	 * Base64Coder
	 */
	private static class Base64Coder {
		// The line separator string of the operating system.
		private static final String systemLineSeparator = System
				.getProperty("line.separator");

		// Mapping table from 6-bit nibbles to Base64 characters.
		private static final char[] map1 = new char[64];
		static {
			int i = 0;
			for (char c = 'A'; c <= 'Z'; c++)
				map1[i++] = c;
			for (char c = 'a'; c <= 'z'; c++)
				map1[i++] = c;
			for (char c = '0'; c <= '9'; c++)
				map1[i++] = c;
			map1[i++] = '+';
			map1[i++] = '/';
		}

		// Mapping table from Base64 characters to 6-bit nibbles.
		private static final byte[] map2 = new byte[128];
		static {
			for (int i = 0; i < map2.length; i++)
				map2[i] = -1;
			for (int i = 0; i < 64; i++)
				map2[map1[i]] = (byte) i;
		}

		/**
		 * Encodes a string into Base64 format. No blanks or line breaks are
		 * inserted.
		 * 
		 * @param s
		 *            A String to be encoded.
		 * @return A String containing the Base64 encoded data.
		 */
		public static String encodeString(String s) {
			return new String(encode(s.getBytes()));
		}

		/**
		 * Encodes a byte array into Base 64 format and breaks the output into
		 * lines of 76 characters. This method is compatible with
		 * <code>sun.misc.BASE64Encoder.encodeBuffer(byte[])</code>.
		 * 
		 * @param in
		 *            An array containing the data bytes to be encoded.
		 * @return A String containing the Base64 encoded data, broken into
		 *         lines.
		 */
		@SuppressWarnings("unused")
		public static String encodeLines(byte[] in) {
			return encodeLines(in, 0, in.length, 76, systemLineSeparator);
		}

		/**
		 * Encodes a byte array into Base 64 format and breaks the output into
		 * lines.
		 * 
		 * @param in
		 *            An array containing the data bytes to be encoded.
		 * @param iOff
		 *            Offset of the first byte in <code>in</code> to be
		 *            processed.
		 * @param iLen
		 *            Number of bytes to be processed in <code>in</code>,
		 *            starting at <code>iOff</code>.
		 * @param lineLen
		 *            Line length for the output data. Should be a multiple of
		 *            4.
		 * @param lineSeparator
		 *            The line separator to be used to separate the output
		 *            lines.
		 * @return A String containing the Base64 encoded data, broken into
		 *         lines.
		 */
		public static String encodeLines(byte[] in, int iOff, int iLen,
				int lineLen, String lineSeparator) {
			int blockLen = (lineLen * 3) / 4;
			if (blockLen <= 0)
				throw new IllegalArgumentException();
			int lines = (iLen + blockLen - 1) / blockLen;
			int bufLen = ((iLen + 2) / 3) * 4 + lines * lineSeparator.length();
			StringBuilder buf = new StringBuilder(bufLen);
			int ip = 0;
			while (ip < iLen) {
				int l = Math.min(iLen - ip, blockLen);
				buf.append(encode(in, iOff + ip, l));
				buf.append(lineSeparator);
				ip += l;
			}
			return buf.toString();
		}

		/**
		 * Encodes a byte array into Base64 format. No blanks or line breaks are
		 * inserted in the output.
		 * 
		 * @param in
		 *            An array containing the data bytes to be encoded.
		 * @return A character array containing the Base64 encoded data.
		 */
		public static char[] encode(byte[] in) {
			return encode(in, 0, in.length);
		}

		/**
		 * Encodes a byte array into Base64 format. No blanks or line breaks are
		 * inserted in the output.
		 * 
		 * @param in
		 *            An array containing the data bytes to be encoded.
		 * @param iLen
		 *            Number of bytes to process in <code>in</code>.
		 * @return A character array containing the Base64 encoded data.
		 */
		@SuppressWarnings("unused")
		public static char[] encode(byte[] in, int iLen) {
			return encode(in, 0, iLen);
		}

		/**
		 * Encodes a byte array into Base64 format. No blanks or line breaks are
		 * inserted in the output.
		 * 
		 * @param in
		 *            An array containing the data bytes to be encoded.
		 * @param iOff
		 *            Offset of the first byte in <code>in</code> to be
		 *            processed.
		 * @param iLen
		 *            Number of bytes to process in <code>in</code>, starting at
		 *            <code>iOff</code>.
		 * @return A character array containing the Base64 encoded data.
		 */
		public static char[] encode(byte[] in, int iOff, int iLen) {
			int oDataLen = (iLen * 4 + 2) / 3; // output length without padding
			int oLen = ((iLen + 2) / 3) * 4; // output length including padding
			char[] out = new char[oLen];
			int ip = iOff;
			int iEnd = iOff + iLen;
			int op = 0;
			while (ip < iEnd) {
				int i0 = in[ip++] & 0xff;
				int i1 = ip < iEnd ? in[ip++] & 0xff : 0;
				int i2 = ip < iEnd ? in[ip++] & 0xff : 0;
				int o0 = i0 >>> 2;
				int o1 = ((i0 & 3) << 4) | (i1 >>> 4);
				int o2 = ((i1 & 0xf) << 2) | (i2 >>> 6);
				int o3 = i2 & 0x3F;
				out[op++] = map1[o0];
				out[op++] = map1[o1];
				out[op] = op < oDataLen ? map1[o2] : '=';
				op++;
				out[op] = op < oDataLen ? map1[o3] : '=';
				op++;
			}
			return out;
		}

		/**
		 * Decodes a string from Base64 format. No blanks or line breaks are
		 * allowed within the Base64 encoded input data.
		 * 
		 * @param s
		 *            A Base64 String to be decoded.
		 * @return A String containing the decoded data.
		 * @throws IllegalArgumentException
		 *             If the input is not valid Base64 encoded data.
		 */
		public static String decodeString(String s) {
			return new String(decode(s));
		}

		/**
		 * Decodes a byte array from Base64 format and ignores line separators,
		 * tabs and blanks. CR, LF, Tab and Space characters are ignored in the
		 * input data. This method is compatible with
		 * <code>sun.misc.BASE64Decoder.decodeBuffer(String)</code>.
		 * 
		 * @param s
		 *            A Base64 String to be decoded.
		 * @return An array containing the decoded data bytes.
		 * @throws IllegalArgumentException
		 *             If the input is not valid Base64 encoded data.
		 */
		@SuppressWarnings("unused")
		public static byte[] decodeLines(String s) {
			char[] buf = new char[s.length()];
			int p = 0;
			for (int ip = 0; ip < s.length(); ip++) {
				char c = s.charAt(ip);
				if (c != ' ' && c != '\r' && c != '\n' && c != '\t')
					buf[p++] = c;
			}
			return decode(buf, 0, p);
		}

		/**
		 * Decodes a byte array from Base64 format. No blanks or line breaks are
		 * allowed within the Base64 encoded input data.
		 * 
		 * @param s
		 *            A Base64 String to be decoded.
		 * @return An array containing the decoded data bytes.
		 * @throws IllegalArgumentException
		 *             If the input is not valid Base64 encoded data.
		 */
		public static byte[] decode(String s) {
			return decode(s.toCharArray());
		}

		/**
		 * Decodes a byte array from Base64 format. No blanks or line breaks are
		 * allowed within the Base64 encoded input data.
		 * 
		 * @param in
		 *            A character array containing the Base64 encoded data.
		 * @return An array containing the decoded data bytes.
		 * @throws IllegalArgumentException
		 *             If the input is not valid Base64 encoded data.
		 */
		public static byte[] decode(char[] in) {
			return decode(in, 0, in.length);
		}

		/**
		 * Decodes a byte array from Base64 format. No blanks or line breaks are
		 * allowed within the Base64 encoded input data.
		 * 
		 * @param in
		 *            A character array containing the Base64 encoded data.
		 * @param iOff
		 *            Offset of the first character in <code>in</code> to be
		 *            processed.
		 * @param iLen
		 *            Number of characters to process in <code>in</code>,
		 *            starting at <code>iOff</code>.
		 * @return An array containing the decoded data bytes.
		 * @throws IllegalArgumentException
		 *             If the input is not valid Base64 encoded data.
		 */
		public static byte[] decode(char[] in, int iOff, int iLen) {
			if (iLen % 4 != 0)
				throw new IllegalArgumentException(
						"Length of Base64 encoded input string is not a multiple of 4.");
			while (iLen > 0 && in[iOff + iLen - 1] == '=')
				iLen--;
			int oLen = (iLen * 3) / 4;
			byte[] out = new byte[oLen];
			int ip = iOff;
			int iEnd = iOff + iLen;
			int op = 0;
			while (ip < iEnd) {
				int i0 = in[ip++];
				int i1 = in[ip++];
				int i2 = ip < iEnd ? in[ip++] : 'A';
				int i3 = ip < iEnd ? in[ip++] : 'A';
				if (i0 > 127 || i1 > 127 || i2 > 127 || i3 > 127)
					throw new IllegalArgumentException(
							"Illegal character in Base64 encoded data.");
				int b0 = map2[i0];
				int b1 = map2[i1];
				int b2 = map2[i2];
				int b3 = map2[i3];
				if (b0 < 0 || b1 < 0 || b2 < 0 || b3 < 0)
					throw new IllegalArgumentException(
							"Illegal character in Base64 encoded data.");
				int o0 = (b0 << 2) | (b1 >>> 4);
				int o1 = ((b1 & 0xf) << 4) | (b2 >>> 2);
				int o2 = ((b2 & 3) << 6) | b3;
				out[op++] = (byte) o0;
				if (op < oLen)
					out[op++] = (byte) o1;
				if (op < oLen)
					out[op++] = (byte) o2;
			}
			return out;
		}

		// Dummy constructor.
		private Base64Coder() {
		}
	}
}
