package net.sigon.codenote.domain.util;

import org.apache.log4j.Logger;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.net.URLDecoder;
import java.security.SecureRandom;

/**
 * Created by IntelliJ IDEA.
 * User: George
 * Date: 11-9-2
 * Time: 下午3:18
 * To change this template use File | Settings | File Templates.
 */
public class DesUtil {
    private static final Logger log = Logger.getLogger(DesUtil.class);
    private final static String DES = "DES";
    private final static String PADDING="DES/ECB/PKCS5Padding";

    /**
     * 加密
     * @param src 数据源
     * @param key 密钥，长度必须是8的倍数
     * @return  返回加密后的数据
     * @throws Exception
     */
    public static byte[] encrypt(byte[] src, byte[] key)throws Exception {
        //DES算法要求有一个可信任的随机数源
        SecureRandom sr = new SecureRandom();
        // 从原始密匙数据创建DESKeySpec对象
        DESKeySpec dks = new DESKeySpec(key);
        // 创建一个密匙工厂，然后用它把DESKeySpec转换成
        // 一个SecretKey对象
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);
        SecretKey securekey = keyFactory.generateSecret(dks);
        // Cipher对象实际完成加密操作
        Cipher cipher = Cipher.getInstance(PADDING);
        // 用密匙初始化Cipher对象
        cipher.init(Cipher.ENCRYPT_MODE, securekey, sr);
        // 现在，获取数据并加密
        // 正式执行加密操作
        return cipher.doFinal(src);

    }


    /**
     * 解密
     * @param src 数据源
     * @param key 密钥，长度必须是8的倍数
     * @return   返回解密后的原始数据
     * @throws Exception
     */
    public static byte[] decrypt(byte[] src, byte[] key)throws Exception {
        // DES算法要求有一个可信任的随机数源
        SecureRandom sr = new SecureRandom();
        // 从原始密匙数据创建一个DESKeySpec对象
        DESKeySpec dks = new DESKeySpec(key);
        // 创建一个密匙工厂，然后用它把DESKeySpec对象转换成
        // 一个SecretKey对象
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);
        SecretKey securekey = keyFactory.generateSecret(dks);
        // Cipher对象实际完成解密操作
        Cipher cipher = Cipher.getInstance(PADDING);
        // 用密匙初始化Cipher对象
        cipher.init(Cipher.DECRYPT_MODE, securekey, sr);
        // 现在，获取数据并解密
        // 正式执行解密操作
        return cipher.doFinal(src);
    }

    /**

     * 密码解密
     * @param data
     * @return
     * @throws Exception
     */
    public final static String decrypt(String data,String key){
        try {
            return new String(decrypt(Base64.decode(data.getBytes()),key.getBytes()));
        }catch(Exception e) {
            log.error("Exception -->DesUtil :" + data + "," + key , e);
        }
        return null;
    }

    /**
     * 密码加密
     * @param code
     * @return
     * @throws Exception
     */

    public final static String encrypt(String code,String key){
        try {
            return Base64.encodeBytes(encrypt(code.getBytes("utf-8"), key.getBytes()));
        }catch(Exception e) {
            log.error("Exception -->DesUtil "+code + ","+key , e);
        }

        return null;
    }

    public static void main(String[] args) {
        System.out.println("1:" + DesUtil.encrypt("{}", "12345678"));
        System.out.println("2:" + DesUtil.encrypt("12345678", "12345678"));
        System.out.println("3:" + DesUtil.encrypt("1234567890", "12345678"));
        System.out.println("4:" + DesUtil.encrypt("12345678901234567890123456789012345678901234567890123456789012345678901234567890", "12345678"));
        System.out.println("4:" + DesUtil.encrypt("{'key':'ad2'}", "iO1.7.64"));

        System.out.println("5:" + DesUtil.decrypt("MDWL/mEjGaAOOrwg2psr+w==","iO1.7.64"));
        System.out.println(URLDecoder.decode("%E7%BE%8E%E4%B8%BD%E8%AF%B4"));
    }

}

