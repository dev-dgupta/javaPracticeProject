//import javax.crypto.Cipher;
//import javax.crypto.spec.IvParameterSpec;
//import javax.crypto.spec.SecretKeySpec;
//import org.apache.commons.codec.binary.Base64;
//
//import java.lang.reflect.Field;
//import java.util.Arrays;
//
//
////String clearText = 'sharedkey+timeZoneStr+CurrentTimeStr';
////        Blob cryptoKey = EncodingUtil.base64Decode('mRMjHmlC1C+1L/Dkz8EJuw==');
////        Blob encryptedData = Crypto.encryptWithManagedIV('AES128', key, Blob.valueOf(clearText));
////        String encodedCipherText = EncodingUtil.base64Encode(cipherText);
////        System.debug(encodedCipherText);
//
////String sharedkey='f216e990e8b417c6a88159731f36f06a';
////        system.debug('sharedkey='+sharedkey);
////        Long currentTimeMilli=System.currentTimeMillis();
////        system.debug('currentTimeMilli='+currentTimeMilli);
////        String CurrentTimeStr=String.ValueOF(currentTimeMilli);
////        System.debug('CurrentTimeStr='+CurrentTimeStr);
////        TimeZone tz = UserInfo.getTimeZone();
////        String timeZoneStr=tz.getDisplayName()+' '+tz.getID() ;
////        System.debug('timeZoneStr='+timeZoneStr);
////
////        String dataToEncrypt=sharedkey+timeZoneStr+CurrentTimeStr;
////
////        system.debug( 'dataToEncrypt=' +dataToEncrypt);
////
////        Blob cryptoKey = Blob.valueOf(sharedkey);
////
////// Generate the data to be encrypted.
////        Blob data = Blob.valueOf(dataToEncrypt);
////
////// Encrypt the data and have Salesforce.com generate the initialization vector
////        Blob encryptedData = Crypto.encryptWithManagedIV('AES256', cryptoKey, data);
////
////
//////To view encrypted data in String format
////        String encryptedDataString =  EncodingUtil.base64Encode(encryptedData);
////        system.debug('encryptedDataString='+encryptedDataString );
////
////
////// Decrypt the data - the first 16 bytes contain the initialization vector
////        Blob decryptedData = Crypto.decryptWithManagedIV('AES256', cryptoKey, encryptedData);
////
////// Decode the decrypted data for subsequent use
////        String decryptedDataString = decryptedData.toString();
////
////        System.debug( 'decryptedDataString='+decryptedDataString );
//
//public class AES {
//
//    private static final String characterEncoding = "UTF-16";
//    private static final String cipherTransformation = "AES/CBC/PKCS5Padding";
//    private static final String aesEncryptionAlgorithm = "AES";
//
//    public static byte[] decryptBase64EncodedWithManagedIV(String encryptedText, String key) throws Exception {
//        byte[] cipherText = Base64.decodeBase64(encryptedText.getBytes());
//        byte[] keyBytes = Base64.decodeBase64(key.getBytes());
//        return decryptWithManagedIV(cipherText, keyBytes);
//    }
//
//    public static byte[] decryptWithManagedIV(byte[] cipherText, byte[] key) throws Exception{
//        byte[] initialVector = Arrays.copyOfRange(cipherText,0,16);
//        byte[] trimmedCipherText = Arrays.copyOfRange(cipherText,32,cipherText.length);
////        byte[] trimmedCipherText = cipherText;
//        return decrypt(trimmedCipherText, key, initialVector);
//    }
//
//    public static byte[] decrypt(byte[] cipherText, byte[] key, byte[] initialVector) throws Exception{
//        Cipher cipher = Cipher.getInstance(cipherTransformation);
//        SecretKeySpec secretKeySpecy = new SecretKeySpec(key, aesEncryptionAlgorithm);
//        IvParameterSpec ivParameterSpec = new IvParameterSpec(initialVector);
//        cipher.init(Cipher.DECRYPT_MODE, secretKeySpecy, ivParameterSpec);
//        return cipher.doFinal(cipherText);
//    }
//
//    public static void main(String args[]) throws Exception{
//        try {
//            Field field = Class.forName("javax.crypto.JceSecurity").
//                    getDeclaredField("isRestricted");
//            field.setAccessible(true);
//            field.set(null, java.lang.Boolean.FALSE);
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//        byte[] plaintext="".getBytes(characterEncoding);
//        byte[] recoveredPlaintext = decryptBase64EncodedWithManagedIV("de6nT7Qm1Ta41yKIB+Mk9V9UOv4I2LiRY+n7nimsG+yyEjyODslyPatJJnkBa8hsD+YBxgnn1p2rtRFxSELij137bYJIrzSbJYLh5vMerLeHelb0g5efZaZsXb7wHZd+", "f216e990e8b417c6a88159731f36f06a");
//        System.out.println(Arrays.equals(plaintext, recoveredPlaintext));
//        System.out.println("ClearText:" + new String(recoveredPlaintext,characterEncoding));
//    }
//
//
//}