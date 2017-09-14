package fileDecrypt;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;


public class AESUtils {

	/**
	 * AES加密
	 * 
	 * @param data
	 *            待加密数据
	 * @param bKey
	 *            AES密钥
	 * @return
	 * @throws Exception
	 */
	public static byte[] AESEncrypt(byte[] data, byte[] key, String Mode) throws Exception {
		SecretKey aeskey = new SecretKeySpec(key, "AES");
		Cipher cipher = Cipher.getInstance(Mode); //
		cipher.init(Cipher.ENCRYPT_MODE, aeskey);
		byte[] byte_AES = cipher.doFinal(data);
		return byte_AES;
	}

	/**
	 * AES解密
	 * 
	 * @param data
	 *            待解密数据
	 * @param bKey
	 *            AES密钥
	 * @return
	 * @throws Exception
	 */
	public static byte[] AESDecrypt(byte[] data, byte[] bKey, String Mode) throws Exception {
		byte[] AESDecryptRet;

		SecretKey key = new SecretKeySpec(bKey, "AES");
		Cipher cipher = Cipher.getInstance(Mode);
		cipher.init(Cipher.DECRYPT_MODE, key);
		AESDecryptRet = cipher.doFinal(data);

		return AESDecryptRet;
	}
	

}
