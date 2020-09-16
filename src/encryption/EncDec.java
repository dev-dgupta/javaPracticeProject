package encryption;
import Decoder.BASE64Decoder;
import Decoder.BASE64Encoder;
import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.Key;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

/**
 * @author abhishek.jaiswal@timesgroup.com
 */
public class EncDec {
    //		private static CustomLogFactory logger = new CustomLogFactory(EncDec.class);
    private static Cipher ecipher;
    private static Cipher dcipher;
    private static final String KEYGEN_STR = "23435356677";
    //		private static final String PADDING ="DES/ECB/PKCS5Padding";
    private static final String PADDING = "AES/CBC/PKCS5Padding";
    //		private static final String PADDING_AES ="AES/CBC/PKCS5Padding";
//		private static final String UTF8 ="UTF-8";
    private static final String UTF8 = "UTF-16";

    //		private static final String UTF16 ="UTF-16";
    public EncDec() {

    }

    private static Key getKey() {
        try {
            byte[] bytes = getbytes(KEYGEN_STR);
            DESKeySpec pass = new DESKeySpec(bytes);
            SecretKeyFactory sKeyFactory = SecretKeyFactory.getInstance("DES");
            SecretKey sKey = sKeyFactory.generateSecret(pass);
            return sKey;
        } catch (Exception ex) {
            System.out.println("Exception in getKey" + ex);
        }
        return null;
    }

//    private static Key getKey(String encKey) {
//        try {
//            byte[] bytes = getbytes(encKey);
//            DESKeySpec pass = new DESKeySpec(bytes);
//            SecretKeyFactory sKeyFactory = SecretKeyFactory.getInstance("DES");
//            SecretKey sKey = sKeyFactory.generateSecret(pass);
//            return sKey;
//        } catch (Exception ex) {
//            System.out.println("Exception in getKey" + ex);
//        }
//        return null;
//    }

    private static Key getKey(String encKey) {
        try {
//            byte[] keyBytes = Base64.encodeBase64(encKey.getBytes());
            byte[] bytes = getbytes(encKey);


            DESKeySpec pass = new DESKeySpec(bytes);
            SecretKeyFactory sKeyFactory = SecretKeyFactory.getInstance("DES");
//            SecretKeySpec secretKeySpecy = new SecretKeySpec(key, "AES");
            SecretKey sKey = sKeyFactory.generateSecret(pass);
            return sKey;
        } catch (Exception ex) {
            System.out.println("Exception in getKey" + ex);
        }
        return null;
    }

    private static byte[] getbytes(String str) {
        ByteArrayOutputStream byteOutputStream = new ByteArrayOutputStream();
        StringTokenizer sTokenizer = new StringTokenizer(str, "-", false);
        while (sTokenizer.hasMoreTokens()) {
            try {
                byteOutputStream.write(sTokenizer.nextToken().getBytes());
            } catch (IOException ex) {
                System.out.println("IOException in getbytes" + ex);
            }
        }
        byteOutputStream.toByteArray();
        return byteOutputStream.toByteArray();
    }

    public String encryptNonStatic(String sourceStr) {
        try {
            // Get secret key
            Key key = getKey();
            byte[] enc;
            Cipher ecipher1 = Cipher.getInstance(PADDING);
            ecipher1.init(Cipher.ENCRYPT_MODE, key);
            enc = ecipher1.doFinal(sourceStr.getBytes(UTF8));
            // Encode bytes to base64 to get a string
            return new BASE64Encoder().encode(enc);
        } catch (Exception ex) {
            System.out.println("[Exception [EncDec : while encrypting the string]]");
        }
        return null;
    }

    public static String encrypt(String sourceStr) {
        try {
            // Get secret key
            Key key = getKey();
            byte[] enc;
            synchronized (Cipher.class) {
                ecipher = Cipher.getInstance(PADDING);
                ecipher.init(Cipher.ENCRYPT_MODE, key);
                enc = ecipher.doFinal(sourceStr.getBytes(UTF8));
            }
            // Encode bytes to base64 to get a string
            Pattern whileSpace = Pattern.compile("\\s+", Pattern.MULTILINE);
            String encryptedString = new BASE64Encoder().encode(enc);
            return whileSpace.matcher(encryptedString).replaceAll("");
        } catch (Exception ex) {
            // System.out.println("[Exception in encrypt",ex);
        }
        return null;
    }

    public static String encrypt(String sourceStr, String encKey) {
        try {
            // Get secret key
            Key key = getKey(encKey);
            byte[] enc;
            synchronized (Cipher.class) {
                ecipher = Cipher.getInstance(PADDING);
                ecipher.init(Cipher.ENCRYPT_MODE, key);
                enc = ecipher.doFinal(sourceStr.getBytes(UTF8));
            }
            // Encode bytes to base64 to get a string
            Pattern whileSpace = Pattern.compile("\\s+", Pattern.MULTILINE);
            String encryptedString = new BASE64Encoder().encode(enc);
            return whileSpace.matcher(encryptedString).replaceAll("");
        } catch (Exception ex) {
            // System.out.println("[Exception in encrypt",ex);
        }
        return null;
    }

    public String decryptNonStatic(String sourceStr) {
        if (sourceStr == null || "".equals(sourceStr)) {
            return null;
        }
        try {
            // Get secret key
            sourceStr = sourceStr.replace(' ', '+');
            sourceStr = sourceStr.replace("%20", "+");
            sourceStr = sourceStr.replaceAll("\n", "");

            Key key = getKey();
            byte[] dec;
            synchronized (Cipher.class) {
                dcipher = Cipher.getInstance(PADDING);
                dcipher.init(Cipher.DECRYPT_MODE, key);
                // Decode base64 to get bytes
                dec = new BASE64Decoder().decodeBuffer(sourceStr);
            }
            //Decrypt data in a single step
            byte[] utf8 = dcipher.doFinal(dec);
            // Decode using utf-8
            return new String(utf8, UTF8);
        } catch (Exception ex) {
            //System.out.println("javax.crypto.IllegalBlockSizeException: Input length must be multiple of 8 when decrypting with padded cipher");
        }
        return null;
    }

    public static String decryptDynamic(String sourceStr, String keyStr) {
        try {
            // Get secret key
            sourceStr = sourceStr.replace(' ', '+');
            sourceStr = sourceStr.replaceAll("\n", "");
            sourceStr = sourceStr.replace("%20", "+");

            Key key = getKey(keyStr);
            byte[] dec;
            synchronized (Cipher.class) {
                dcipher = Cipher.getInstance(PADDING);
                dcipher.init(Cipher.DECRYPT_MODE, key);
                // Decode base64 to get bytes
                dec = new BASE64Decoder().decodeBuffer(sourceStr);
            }
            //Decrypt data in a single step
            byte[] utf8 = dcipher.doFinal(dec);
            // Decode using utf-8
            return new String(utf8, UTF8);
        } catch (Exception ex) {
            //logger.info("Can not decrypt the string ::"+sourceStr+": Exception thrown :"+ex);
        }
        return null;
    }

    public static String decrypt(String sourceStr) {
        try {
            // Get secret key
            sourceStr = sourceStr.replace(' ', '+');
            sourceStr = sourceStr.replaceAll("\n", "");
            sourceStr = sourceStr.replace("%20", "+");

            Key key = getKey();
            byte[] dec;
            synchronized (Cipher.class) {
                dcipher = Cipher.getInstance(PADDING);
                dcipher.init(Cipher.DECRYPT_MODE, key);
                // Decode base64 to get bytes
                dec = new BASE64Decoder().decodeBuffer(sourceStr);
            }
            //Decrypt data in a single step
            byte[] utf8 = dcipher.doFinal(dec);
            // Decode using utf-8
            return new String(utf8, UTF8);
        } catch (Exception ex) {
            //logger.info("Can not decrypt the string ::"+sourceStr+": Exception thrown :"+ex);
        }
        return null;
    }

    public static String decrypt(String sourceStr, String encKey) {
        try {
            // Get secret key
            sourceStr = sourceStr.replace(' ', '+');
            sourceStr = sourceStr.replaceAll("\n", "");
            sourceStr = sourceStr.replace("%20", "+");

            Key key = getKey(encKey);
            byte[] dec;
            synchronized (Cipher.class) {
                dcipher = Cipher.getInstance(PADDING);
                dcipher.init(Cipher.DECRYPT_MODE, key);
                // Decode base64 to get bytes
                dec = new BASE64Decoder().decodeBuffer(sourceStr);
            }
            //Decrypt data in a single step
            byte[] utf8 = dcipher.doFinal(dec);
            // Decode using utf-8
            return new String(utf8, UTF8);
        } catch (Exception ex) {
            //logger.info("Can not decrypt the string ::"+sourceStr+": Exception thrown :"+ex);
        }
        return null;
    }

    public static void main(String[] args) {
//		byte[] plaintext="".getBytes(characterEncoding);
        String recoveredPlaintext = decrypt("de6nT7Qm1Ta41yKIB+Mk9V9UOv4I2LiRY+n7nimsG+yyEjyODslyPatJJnkBa8hsD" +
                "+YBxgnn1p2rtRFxSELij137bYJIrzSbJYLh5vMerLeHelb0g5efZaZsXb7wHZd+", "f216e990e8b417c6a88159731f36f06a");
//		System.out.println(Arrays.equals(plaintext, recoveredPlaintext));
        System.out.println("ClearText:" + recoveredPlaintext);
    }

}
