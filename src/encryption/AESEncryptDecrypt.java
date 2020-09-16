package encryption;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.SecureRandom;
import java.util.Arrays;

/**
 * Created by Divya.Gupta on 11-04-2017.
 */
public class AESEncryptDecrypt {


/**
 * This example program shows how AES encryption and decryption can be done in Java.
 * <p/>
 * Please note that secret key and encrypted text is unreadable binary and hence
 * <p/>
 * in the following program we display it in hexadecimal format of the underlying bytes.
 *
 * @author Jayson
 */

    /**
     * 1. Generate a plain text for encryption
     * <p/>
     * 2. Get a secret key (printed in hexadecimal form). In actual use this must
     * <p/>
     * by encrypted and kept safe. The same key is required for decryption.
     * <p/>
     * 3.
     */

    public static void main(String[] args) throws Exception {
//        String plainText = "f216e990e8b417c6a88159731f36f06aIndia Standard Time Asia/Kolkata1490698558815";
//        SecretKey secKey = getSecretEncryptionKey();
//
//        byte[] cipherText = encryptText(plainText, secKey);
//        String decryptedText = decryptText(cipherText, secKey);
//
//        System.out.println("Original Text:" + plainText);
//        System.out.println("AES Key (Hex Form):" + bytesToHex(secKey.getEncoded()));
//        System.out.println("Encrypted Text (Hex Form):" + bytesToHex(cipherText));
//        System.out.println("Descrypted Text:" + decryptedText);

        String plainText = "f216e990e8b417c6a88159731f36f06a(GMT+05:30) India Standard Time (Asia/Kolkata)" +
                "1493723044692";
        String key = "f216e990e8b417c6a88159731f36f06a";
        System.out.println(key.getBytes().length);
        SecretKeySpec secretKeySpecy = new SecretKeySpec(key.getBytes(),0,32, "AES");
//        byte[] cipherText = encryptText(plainText, secretKeySpecy);
//        byte[] cipherText = Base64.decodeBase64("4hRt3CfeTpNwZqUefvLcOi+5W7Ra85ZVRyFDeD1fR1I5lkjD9yI3hHein04BrI/knY84y2SKC/RxktMLv3MzvpM1GYHLNn6eXGY1DMlpOJI3lvCB6Tw8KZo20uk3hzwLHnjLRNSEXHvilHP0FbFOog==");
        byte[] cipherText = ("4hRt3CfeTpNwZqUefvLcOi+5W7Ra85ZVRyFDeD1fR1I5lkjD9yI3hHein04BrI/knY84y2SKC" +
                "/RxktMLv3MzvpM1GYHLNn6eXGY1DMlpOJI3lvCB6Tw8KZo20uk3hzwLHnjLRNSEXHvilHP0FbFOog==").getBytes();
        System.out.println("Cipher Text:" + cipherText);
        System.out.println("Encypted Text:" + new String(Base64.encodeBase64(cipherText)));
        System.out.println(plainText);
        String decryptedText = decryptText(cipherText, secretKeySpecy);


//        System.out.println("AES Key (Hex Form):" + bytesToHex(secretKeySpecy.getEncoded()));
//        System.out.println("Encrypted Text (Hex Form):" + bytesToHex(cipherText));
        System.out.println(decryptedText);
        System.out.println(plainText.equalsIgnoreCase(decryptedText));


    }


    /**
     * gets the AES encryption key. In your actual programs, this should be safely
     * <p/>
     * stored.
     *
     * @return
     * @throws Exception
     */

    public static SecretKey getSecretEncryptionKey() throws Exception {
        KeyGenerator generator = KeyGenerator.getInstance("AES");
        generator.init(256); // The AES key size in number of bits
        SecretKey secKey = generator.generateKey();
        return secKey;
    }

    /**
     * Encrypts plainText in AES using the secret key
     *
     * @param plainText
     * @param secKey
     * @return
     * @throws Exception
     */

    public static byte[] encryptText(String plainText, SecretKey secKey) throws Exception {
        // AES defaults to AES/ECB/PKCS5Padding in Java 7
        Cipher aesCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");

        byte[] iv = new byte[16];
        SecureRandom prng = new SecureRandom();
        prng.nextBytes(iv);

        aesCipher.init(Cipher.ENCRYPT_MODE, secKey, new IvParameterSpec(iv));

        byte[] byteDataToEncrypt = plainText.getBytes();
        byte[] byteCipherText = aesCipher.doFinal(byteDataToEncrypt);

        byte[] ivPlusCipher = new byte[iv.length + byteCipherText.length];
        System.arraycopy(iv, 0, ivPlusCipher, 0, iv.length);
        System.arraycopy(byteCipherText, 0, ivPlusCipher, iv.length, byteCipherText.length);

        return ivPlusCipher;
    }

    /**
     * Decrypts encrypted byte array using the key used for encryption.
     *
     * @param byteCipherText
     * @param secKey
     * @return
     * @throws Exception
     */

    public static String decryptText(byte[] byteCipherText, SecretKey secKey) throws Exception {
        // AES defaults to AES/ECB/PKCS5Padding in Java 7
        byte[] iv = new byte[16];
        SecureRandom rnd = new SecureRandom();
        rnd.nextBytes(iv);
        Cipher aesCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        aesCipher.init(Cipher.DECRYPT_MODE, secKey, new IvParameterSpec(iv));


        byte[] bytePlainText = aesCipher.doFinal(byteCipherText);
        return new String( Arrays.copyOfRange(bytePlainText, 16, bytePlainText.length));

    }

    /**
     * Convert a binary byte array into readable hex form
     *
     * @param hash
     * @return
     */

    private static String bytesToHex(byte[] hash) {
        return DatatypeConverter.printHexBinary(hash);
    }

}
