package com.joyin.ticm.common.util;

import com.joyin.ticm.common.constant.Constant;
import com.joyin.ticm.common.util.logger.ILogger;
import com.joyin.ticm.common.util.logger.LoggerFactory;

/**
 * 密码处理类
 * 
 * @author colin
 * @version 1.0
 * @since Jul 3, 2013, 11:40:48 AM
 */
public class PasswordUtil {
    private ILogger _log = LoggerFactory.getBusinessLogger(this.getClass());

    // key Hex and iv hex values from key file
    private String _keyHex = "";
    private String _ivHex = "";

    /**
     * Constructor to setup the hex parameters
     */
    public PasswordUtil() {
        IAppContext cryptoCtx = AppContext.getInstance();

        _keyHex = cryptoCtx.getProperty(Constant.CRYPTO.KEYHEX);
        _ivHex = cryptoCtx.getProperty(Constant.CRYPTO.IVHEX);

        if (_keyHex == null || _ivHex == null) {
            _log.error("Key or IV is null");
        }
    }

    /**
     * Decrypt the encrypted password with keyHex and ivHex found in the crypto
     * key file
     * 
     * @param encypted -
     *            encrypted password
     * @return String - decrypted password
     */
    public String decrypt(String encryptedPassword) {
        try {
            // decrypt the password
            CryptoUtil aes = new CryptoUtil(CryptoUtil.CRYPTO_AES,
                    CryptoUtil.KEY_AES);
            return aes.decrypt(encryptedPassword);
        }
        catch (Exception e) {
            _log.error("Error decrypting password.", e);
            throw new ExceptionInInitializerError(e);
        }
    }

    /**
     * Encrypt the string with keyHex and ivHex found in the crypto key file
     * 
     * @param plainText
     *            password to encrypt
     * @return String decrypted password
     */
    public String encrypt(String plainText) {
        try {
            // encrypt the password
            CryptoUtil aes = new CryptoUtil(CryptoUtil.CRYPTO_AES,
                    CryptoUtil.KEY_AES);
            return aes.encrypt(plainText);
        }
        catch (Exception e) {
            _log.error("Error encrypting password.", e);
            throw new ExceptionInInitializerError(e);
        }
    }
}
