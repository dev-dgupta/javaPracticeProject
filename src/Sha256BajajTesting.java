//import javax.crypto.*;
//import javax.crypto.spec.IvParameterSpec;
//import javax.crypto.spec.SecretKeySpec;
//import java.io.UnsupportedEncodingException;
//import java.security.AlgorithmParameters;
//import java.security.MessageDigest;
//import java.util.*;
//import java.util.concurrent.TimeUnit;
//
//import org.apache.commons.codec.binary.*;
//import org.springframework.security.crypto.encrypt.Encryptors;
//import org.springframework.security.crypto.encrypt.TextEncryptor;
//import org.springframework.security.crypto.keygen.KeyGenerators;
//
///**
// * Created by Divya.Gupta on 03-03-2017.
// */
//public class Sha256BajajTesting {
//
//    public static void main(String[] args) {
////        aes256New();
//        long time = System.currentTimeMillis();
//        String sharedKey = "f216e990e8b417c6a88159731f36f06a";
//        Calendar cal = Calendar.getInstance();
//        String timezone = displayTimeZone(cal.getTimeZone());
//        System.out.println("sharedKey: " + sharedKey);
//        System.out.println("timezone: " + "India Standard Time Asia/Kolkata");
//        System.out.println("time: " + "1490698558815");
//
//        String token = calculateHashKey(sharedKey, timezone, 1490698558815L);
//        System.out.println("token: " + token);
//
//        System.out.println("PKEAiC3bkKADgTY+9PHIBMskvnL8AaVgnO9f7hCbibMWz35PYtWeA69MzW2xEBkyh7Kuh1UjMihhiPPplEZmQA==".equals(token) ? true : false);
////        TimeZone tz = getTimeZoneVal("India Standard Time Asia/Kolkata");
////        System.out.println("bank timezone: " + tz);
////        String bankTimeZoneVal = displayTimeZone(tz);
////        System.out.println("bankTimeZoneVal: " + bankTimeZoneVal);
////        long bankTime = getCurrentTimeForTZ(tz);
////        System.out.println("bankTime:" + bankTime);
////        System.out.println(validateForBank(bankTimeZoneVal, bankTime, token));
//    }
//
//    private static String calculateHashKey(String sharedKey, String timezone, long timeStamp) {
//        String token = sharedKey + timezone + timeStamp;
//        return hashKeyFromEncryptionAlgo(token,sharedKey);
//    }
//
//    private static String displayTimeZone(TimeZone tz) {
//
//        long hours = TimeUnit.MILLISECONDS.toHours(tz.getRawOffset());
//        long minutes = TimeUnit.MILLISECONDS.toMinutes(tz.getRawOffset()) - TimeUnit.HOURS.toMinutes(hours);
//        // avoid -4:-30 issue
//        minutes = Math.abs(minutes);
//
//        String result;
//        if (hours > 0) {
//            result = String.format("(GMT+%d:%02d) %s", hours, minutes, tz.getDisplayName());
//        } else {
//            result = String.format("(GMT%d:%02d) %s", hours, minutes, tz.getDisplayName());
//        }
//        return result + " (" + tz.getID() + ")";
//
//    }
//
//    private static boolean validateSessionForBanks(String hashKey, String bankToken) {
//        return hashKey.equalsIgnoreCase(bankToken);
//    }
//
//    /**
//     * encryption algorithm to generate hashkey
//     *
//     * @param token
//     * @return
//     */
//    private static String hashKeyFromEncryptionAlgo(String token, String secretKey) {
//        try {
//            return aes256(token.getBytes("UTF-8"), secretKey.getBytes("UTF-8"));
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//        return "";
//    }
//
//    private static String sha256(String base) {
//        try {
//            MessageDigest digest = MessageDigest.getInstance("AES-256");
//            byte[] hash = digest.digest(base.getBytes("UTF-8"));
//            StringBuilder hexString = new StringBuilder();
//
//            for (byte aHash : hash) {
//                String hex = Integer.toHexString(0xff & aHash);
//                if (hex.length() == 1) hexString.append('0');
//                hexString.append(hex);
//            }
//
//            return hexString.toString();
//        } catch (Exception ex) {
//            throw new RuntimeException(ex);
//        }
//    }
//
//    private static String aes256(byte[] base, byte[] secretKey) {
//        try {
////            SecretKeyFactory factory = SecretKeyFactory.getInstance(secretKey);
////            KeySpec spec = new PBEKeySpec(password, salt, 65536, 256);
////            SecretKey tmp = factory.generateSecret(spec);
//            SecretKey secret = new SecretKeySpec(org.apache.commons.codec.binary.Base64.encodeBase64(secretKey), "AES");
//            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
//            cipher.init(Cipher.ENCRYPT_MODE, secret);
//            AlgorithmParameters params = cipher.getParameters();
//            byte[] iv = params.getParameterSpec(IvParameterSpec.class).getIV();
//            byte[] ciphertext = cipher.doFinal(base);
//            System.out.println(String.valueOf(iv));
//            System.out.println(String.valueOf(ciphertext));
//            return String.valueOf(ciphertext);
//        } catch (Exception ex) {
//            throw new RuntimeException(ex);
//        }
//    }
//
//    public static boolean validateForBank(String timezone, long nonce, String bankToken) {
//        String sharedKey = "f216e990e8b417c6a88159731f36f06a";
//        //correct nonce would be if timezone is same
//
//        if (checkForNonceExpiry(nonce, timezone))
//            return false;
//
//        String hashKey = calculateHashKey(sharedKey, timezone, nonce);
//        return validateSessionForBanks(hashKey, bankToken);
//    }
//
//    private static boolean checkForNonceExpiry(long nonce, String timezone) {
//        Calendar cal = Calendar.getInstance();
//        String timeZoneVal = displayTimeZone(cal.getTimeZone());
//        TimeZone tz = null;
//        if (!timezone.equalsIgnoreCase(timeZoneVal)) {
//            tz = getTimeZoneVal(timezone);
//        }
//
//        if (tz == null) {
////            logger.error("***********Timezone not found************" + timezone);
//            tz = cal.getTimeZone();
//        }
//        long currentTime = getCurrentTimeForTZ(tz);
//        return (currentTime - nonce > 36000000);
//    }
//
//    private static long getCurrentTimeForTZ(TimeZone tz) {
//        long date = System.currentTimeMillis();
//        int offset = tz.getOffset(date);
//        return date + offset;
//    }
//
//    private static TimeZone getTimeZoneVal(String timezone) {
//        //find correct timezone
//        TimeZones[] timeZonesList = TimeZones.values();
//        String tze = "";
//        for (int i = 0; i < timeZonesList.length; i++) {
//            if (TimeZones.values()[i].getValue().equals(timezone)) {
//                tze = (TimeZones.values()[i].name()).replace("_", "/");
//                break;
//            }
//        }
//        return TimeZone.getTimeZone(tze);
//    }
//
//    private static void aes256New() {
//        final String password = "I";
//        final String salt = KeyGenerators.string().generateKey();
//        String sharedKey = "f216e990e8b417c6a88159731f36f06a";
//        TextEncryptor encryptor = Encryptors.text(password, salt);
//        System.out.println("Salt: \"" + salt + "\"");
//
//        String textToEncrypt = sharedKey + "India Standard Time Asia/Kolkata" + "1490698558815";
//        System.out.println("Original text: \"" + textToEncrypt + "\"");
//
//        String encryptedText = encryptor.encrypt(textToEncrypt);
//        System.out.println("Encrypted text: \"" + encryptedText + "\"");
//
//        // Could reuse encryptor but wanted to show reconstructing TextEncryptor
//        TextEncryptor decryptor = Encryptors.text(password, salt);
//        String decryptedText = decryptor.decrypt(encryptedText);
//        System.out.println("Decrypted text: \"" + decryptedText + "\"");
//
//        if (textToEncrypt.equals(decryptedText)) {
//            System.out.println("Success: decrypted text matches");
//        } else {
//            System.out.println("Failed: decrypted text does not match");
//        }
//    }
//}
//
//enum TimeZones {
//
//    Asia_Tokyo("(GMT+9:00) Japan Standard Time (Asia/Tokyo)"),
//    Asia_Calcutta("(GMT+5:30) India Standard Time (Asia/Calcutta)"),
//    Africa_Abidjan("(GMT0:00) Greenwich Mean Time (Africa/Abidjan)");
//    private String value;
//
//    TimeZones(String value) {
//        this.value = value;
//    }
//
//    public String getValue() {
//        return this.value;
//    }
//}
