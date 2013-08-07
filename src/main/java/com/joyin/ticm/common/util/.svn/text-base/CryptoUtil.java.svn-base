package com.joyin.ticm.common.util;

import java.security.MessageDigest;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import com.joyin.ticm.common.constant.Constant;

/**
 * Cypto util to encrypt and decrypt password stored in properties file
 * 
 * @author colin
 * @version 1.0
 * @since Jul 3, 2013, 11:40:48 AM
 */
public class CryptoUtil {
    public static final String CRYPTO_AES = "AES/CBC/PKCS5Padding";
    public static final String KEY_AES = "AES";
    public static final String DIGEST_SHA256 = "SHA-256";
    private String cipherType = null;
    private String cipherKey = null;

    private String keyHex;
    private String ivHex;

    /**
     * @param buf
     * @return
     */
    public static final String asHex(byte buf[]) {
        StringBuffer strbuf = new StringBuffer(buf.length * 2);
        for (int i = 0; i < buf.length; i++) {
            if ((buf[i] & 255) < 16)
                strbuf.append("0");
            strbuf.append(Long.toString(buf[i] & 255, 16));
        }

        return strbuf.toString();
    }

    /**
     * @param hex
     * @return
     */
    public static final byte[] asByte(String hex) {
        int blen = hex.length() / 2;
        byte result[] = new byte[blen];
        Integer ll = new Integer(0);
        for (int i = 0; i < blen; i++)
            try {
                ll = Integer.valueOf(hex.substring(i * 2, i * 2 + 2), 16);
                int tempint = ll.intValue();
                result[i] = (byte) (tempint & 255);
            }
            catch (Exception e) {
                result[i] = 0;
            }

        return result;
    }

    /**
     * @param cipherType
     * @param keyType
     * @param keyHex
     * @param ivHex
     * @throws Exception
     */
    public CryptoUtil(String cipherType, String keyType, String keyHex,
            String ivHex) throws Exception {
        this.cipherType = cipherType;
        this.cipherKey = keyType;
        this.keyHex = keyHex;
        this.ivHex = ivHex;
    }

    /**
     * @param cipherType
     * @param keyType
     * @throws Exception
     */
    public CryptoUtil(String cipherType, String keyType) throws Exception {
        this.cipherType = cipherType;
        this.cipherKey = keyType;

        IAppContext context = AppContext.getInstance();

        keyHex = context.getProperty(Constant.CRYPTO.KEYHEX);
        ivHex = context.getProperty(Constant.CRYPTO.IVHEX);
    }

    /**
     * @return
     * @throws Exception
     */
    public String[] genKeyandIV() throws Exception {
        String keys[] = new String[2];
        KeyGenerator kgen = KeyGenerator.getInstance(cipherKey);
        kgen.init(new SecureRandom());
        SecretKey skey = kgen.generateKey();
        SecretKey sIv = kgen.generateKey();
        byte rawKey[] = skey.getEncoded();
        byte rawIv[] = sIv.getEncoded();
        keys[0] = asHex(rawKey);
        keys[1] = asHex(rawIv);
        return keys;
    }

    /**
     * encrypt using current keys
     * 
     * @param plainText
     * @return String
     * @throws Exception
     */
    public String encrypt(String plainText) throws Exception {
        return encrypt(keyHex, ivHex, plainText);
    }

    /**
     * Encrypt password
     * 
     * @param key
     * @param iv
     * @param plaintext
     * @return String
     * @throws Exception
     */
    public String encrypt(String key, String iv, String plaintext)
            throws Exception {
        byte keyRaw[] = asByte(key);

        byte ivRaw[] = null;
        if (iv != null)
            ivRaw = asByte(iv);
        byte plainRaw[] = plaintext.getBytes("UTF-8");
        byte cipherRaw[] = encrypt(keyRaw, ivRaw, plainRaw);
        return asHex(cipherRaw);
    }

    private byte[] encrypt(byte keyRaw[], byte ivRaw[], byte plainRaw[])
            throws Exception {
        byte key[] = keyRaw;
        byte iv[] = ivRaw;
        Cipher cipher = Cipher.getInstance(cipherType);
        SecretKeySpec skeySpec = _getKey(key);
        IvParameterSpec ivSpec = null;
        if (iv != null) {
            ivSpec = _getIv(iv);
            cipher.init(1, skeySpec, ivSpec);
        }
        else {
            cipher.init(1, skeySpec);
        }
        return cipher.doFinal(plainRaw);
    }

    /**
     * decrypt using current keys
     * 
     * @param plainText
     * @return String
     * @throws Exception
     */
    public String decrypt(String plainText) throws Exception {
        return decrypt(keyHex, ivHex, plainText);
    }

    /**
     * Decrypt password
     * 
     * @param keyRaw
     * @param ivRaw
     * @param plainRaw
     * @return
     * @throws Exception
     */
    private String decrypt(String key, String iv, String cipher)
            throws Exception {
        byte keyRaw[] = asByte(key);
        byte ivRaw[] = null;
        if (iv != null)
            ivRaw = asByte(iv);
        byte cipherRaw[] = asByte(cipher);
        byte plainRaw[] = decrypt(keyRaw, ivRaw, cipherRaw);
        return new String(plainRaw, "UTF-8");
    }

    private byte[] decrypt(byte keyRaw[], byte ivRaw[], byte cipherRaw[])
            throws Exception {
        byte key[] = keyRaw;
        byte iv[] = ivRaw;
        Cipher cipher = Cipher.getInstance(cipherType);
        SecretKeySpec skeySpec = _getKey(key);
        IvParameterSpec ivSpec = null;
        if (iv != null) {
            ivSpec = _getIv(iv);
            cipher.init(2, skeySpec, ivSpec);
        }
        else {
            cipher.init(2, skeySpec);
        }
        byte plainRaw[] = cipher.doFinal(cipherRaw);
        return plainRaw;
    }

    /**
     * 给字符串解密
     * 
     * @param plainText
     * @return String
     */
    public String getDecrypted(String encryptedPassword) throws Exception {
        String decrypted = null;
        try {
            decrypted = decrypt(keyHex, ivHex, encryptedPassword);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return decrypted;
    }

    /**
     * 给字符串加密
     * 
     * @param plainText
     * @return String
     */
    public String getEncrypte(String plainText) {
        String encrypted = null;
        try {
            encrypted = encrypt(keyHex, ivHex, plainText);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return encrypted;
    }

    /**
     * Gets a hex encoded hash of the text
     * 
     * @param text
     * @return String of hex encode hash
     * @throws Exception
     */
    public String getHash(String text) throws Exception {
        if (text == null) {
            return null;
        }

        return asHex(hash(text.getBytes("UTF-8")));
    }

    private byte[] hash(byte[] bytes) throws Exception {
        if (bytes == null) {
            return null;
        }

        MessageDigest messagedigest = MessageDigest.getInstance(cipherType);

        messagedigest.update(bytes);
        return messagedigest.digest();
    }

    private IvParameterSpec _getIv(byte ivRaw[]) {
        return new IvParameterSpec(ivRaw);
    }

    private SecretKeySpec _getKey(byte keyRaw[]) {
        return new SecretKeySpec(keyRaw, cipherKey);
    }

    public static void main(String[] args) throws Exception {
        String keyRaw = "a61a7165d4e87e9dadc9d550c59df906";
        String ivRaw = "617bb399509b1f44778e5d1d42f8160b";

        // decrypt the password
        CryptoUtil aes = new CryptoUtil(CryptoUtil.CRYPTO_AES,
                CryptoUtil.KEY_AES, keyRaw, ivRaw);

        String[] tt = aes.genKeyandIV();
        System.out.println(tt[0]);
        System.out.println(tt[1]);

        String password = "3235373035";
        String cipherRaw = aes.encrypt(keyRaw, ivRaw, password);
        String decryptedRaw = aes.decrypt(keyRaw, ivRaw, cipherRaw);

        System.out.println(cipherRaw);
        System.out.println(decryptedRaw);

        // sha256 hash
        CryptoUtil sha = new CryptoUtil(CryptoUtil.DIGEST_SHA256,
                CryptoUtil.KEY_AES, keyRaw, ivRaw);
        String hashed = sha.getHash(password);
        System.out.println(hashed);
    }
}
