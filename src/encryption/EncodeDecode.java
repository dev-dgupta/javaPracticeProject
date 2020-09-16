package encryption;

import org.apache.commons.codec.binary.Base64;


import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;

/**
 * Created by Divya.Gupta on 25-04-2017.
 */
public class EncodeDecode {

//    public String calculateChecksumForJSON(String jsonObj, String bankName) {
//        String encodedStr = getBase64Encoded(jsonObj);
//        String sharedKey = "f216e990e8b417c6a88159731f36f06a";
//        String newKey = encodedStr + "#" + sharedKey;
//        return hashKeyFromEncryptionAlgo(newKey);
//    }

    private String hashKeyFromEncryptionAlgo(String token) {
        return sha256(token);
    }

    private String sha256(String base) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(base.getBytes("UTF-8"));
            StringBuilder hexString = new StringBuilder();

            for (byte aHash : hash) {
                String hex = Integer.toHexString(0xff & aHash);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }

            return hexString.toString();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public static byte[] getBase64Encoded(String jsonObj) {
        return Base64.encodeBase64(jsonObj.getBytes());
    }

    public static void main(String[] args) {
//// Encode
//        String asB64 = Base64.getEncoder().encodeToString("some string".getBytes("utf-8"));
//        System.out.println(asB64); // Output will be: c29tZSBzdHJpbmc=
//
//// Decode
//        byte[] asBytes = Base64.getDecoder().decode("c29tZSBzdHJpbmc=");
//        System.out.println(new String(asBytes, "utf-8")); // And the output is: some string
        byte[] encodedStr=getBase64Encoded("{\"nbSubLoc\":{\"ty\":\"Flat\",\"unit\":12800,\"unitDesc\":\"Sq-ft\"," +
                "\"subLst\":[{\"estMinPrcStr\":\"37.5 Lac\",\"estMaxPrcStr\":\"45.8 Lac\",\"tyrf\":\"100760\"," +
                "\"ltpdp\":\"Noida-Extension-Block-A\",\"avgPrice\":3375,\"locality\":\"Noida Extension Block A, " +
                ("Noida\",\"locId\":100760},{\"estMinPrcStr\":\"37.1 Lac\",\"estMaxPrcStr\":\"45.3 Lac\"," +
                        "\"tyrf\":\"100761\",\"ltpdp\":\"Noida-Extension-Block-B\",\"avgPrice\":3338," +
                        "\"locality\":\"Noida Extension Block B, Noida\",\"locId\":100761}],\"area\":1234," +
                        "\"pty\":10002,\"subCnt\":3,\"tyrf\":88450,\"bdDesc\":\"2\",\"bd\":11701},\"bhk\":\"2\"," +
                        "\"estMinPrcStrTol\":\"0\",\"estMaxPrcStr\":\"46.9 Lac\",\"isAccUpd\":true,\"accNew\":\"The " +
                        "price may vary by 8%\",\"maxrange\":\"1.0 Cr\",\"expgrth\":\"1.9 %\",\"avgSlider\":41," +
                        "\"tyval\":\"10002\",\"isPw\":true,\"avgBhkTyPrice\":\"41.3 Lac\",\"nbPsmInLoc\":[]," +
                        "\"partition3\":\"75.0 Lac\",\"partition2\":\"50.0 Lac\",\"estMinPrcTol\":0," +
                        "\"propworth\":\"propworth\",\"hasprc\":\"N\",\"avgPwPrice\":\"42.6 Lac\"," +
                        "\"requestId\":\"3333\",\"estMinPrcStr\":\"38.3 Lac\",\"cityValDesc\":\"Noida\"," +
                        ("\"nbLoc\":{\"result\":[]},\"sdmd\":51393,\"pid\":11664124,\"partition1\":\"25.0 Lac\"," +
                                "\"imgUrl\":\"http://api.magicbricks.com/mobileImages/no_image.jpg\",\"ty\":\"Flat\"," +
                                "\"grth\":\"1.9 %\",\"input\":{\"ty\":\"lmt\",\"ct\":6403,\"tyrf\":88450," +
                                "\"pty\":\"10002\",\"bd\":11701,\"area\":1234,\"areamx\":0,\"aunit\":12800,\"auDesc\":\"Sq-ft\",\"flr\":0,\"par\":0,\"oppar\":0,\"copar\":0},\"minSlider\":38,\"avgPrice\":3452,\"isgrowth\":true,\"rdmd\":3257,\"accMsg\":\"Variation may be due to factors like age, quality of construction, interiors, flooring etc.\",\"locality\":\"Noida Extension, Noida\",\"qstr\":\"ct\\u003d6403\\u0026ty\\u003dlmt\\u0026tyrf\\u003d4d423838343530\\u0026pty\\u003d10002\\u0026unit\\u003d12800\\u0026bd\\u003d11701\\u0026area\\u003d1234\\u0026fac\\u003dnull\\u0026dvc\\u003dweb\\u0026apiVersion\\u003d2.0\",\"accuracy\":92,\"maxSlider\":43,\"success\":true}")));
        System.out.println(new String(encodedStr));
        System.out.println(new String(getBase64Decoded(encodedStr)));

//        System.out.println("eyJuYlN1YkxvYyI6eyJ0eSI6IkZsYXQiLCJ1bml0IjoxMjgwMCwidW5pdERlc2MiOiJTcS1mdCIsInN1YkxzdCI6W3siZXN0TWluUHJjU3RyIjoiMzcuNSBMYWMiLCJlc3RNYXhQcmNTdHIiOiI0NS44IExhYyIsInR5cmYiOiIxMDA3NjAiLCJsdHBkcCI6Ik5vaWRhLUV4dGVuc2lvbi1CbG9jay1BIiwiYXZnUHJpY2UiOjMzNzUsImxvY2FsaXR5IjoiTm9pZGEgRXh0ZW5zaW9uIEJsb2NrIEEsIE5vaWRhIiwibG9jSWQiOjEwMDc2MH0seyJlc3RNaW5QcmNTdHIiOiIzNy4xIExhYyIsImVzdE1heFByY1N0ciI6IjQ1LjMgTGFjIiwidHlyZiI6IjEwMDc2MSIsImx0cGRwIjoiTm9pZGEtRXh0ZW5zaW9uLUJsb2NrLUIiLCJhdmdQcmljZSI6MzMzOCwibG9jYWxpdHkiOiJOb2lkYSBFeHRlbnNpb24gQmxvY2sgQiwgTm9pZGEiLCJsb2NJZCI6MTAwNzYxfV0sImFyZWEiOjEyMzQsInB0eSI6MTAwMDIsInN1YkNudCI6MywidHlyZiI6ODg0NTAsImJkRGVzYyI6IjIiLCJiZCI6MTE3MDF9LCJiaGsiOiIyIiwiZXN0TWluUHJjU3RyVG9sIjoiMCIsImVzdE1heFByY1N0ciI6IjQ2LjkgTGFjIiwiaXNBY2NVcGQiOnRydWUsImFjY05ldyI6IlRoZSBwcmljZSBtYXkgdmFyeSBieSA4JSIsIm1heHJhbmdlIjoiMS4wIENyIiwiZXhwZ3J0aCI6IjEuOSAlIiwiYXZnU2xpZGVyIjo0MSwidHl2YWwiOiIxMDAwMiIsImlzUHciOnRydWUsImF2Z0Joa1R5UHJpY2UiOiI0MS4zIExhYyIsIm5iUHNtSW5Mb2MiOltdLCJwYXJ0aXRpb24zIjoiNzUuMCBMYWMiLCJwYXJ0aXRpb24yIjoiNTAuMCBMYWMiLCJlc3RNaW5QcmNUb2wiOjAsInByb3B3b3J0aCI6InByb3B3b3J0aCIsImhhc3ByYyI6Ik4iLCJhdmdQd1ByaWNlIjoiNDIuNiBMYWMiLCJyZXF1ZXN0SWQiOiIzMzMzIiwiZXN0TWluUHJjU3RyIjoiMzguMyBMYWMiLCJjaXR5VmFsRGVzYyI6Ik5vaWRhIiwibmJMb2MiOnsicmVzdWx0IjpbXX0sInNkbWQiOjUxMzkzLCJwaWQiOjExNjY0MTI0LCJwYXJ0aXRpb24xIjoiMjUuMCBMYWMiLCJpbWdVcmwiOiJodHRwOi8vYXBpLm1hZ2ljYnJpY2tzLmNvbS9tb2JpbGVJbWFnZXMvbm9faW1hZ2UuanBnIiwidHkiOiJGbGF0IiwiZ3J0aCI6IjEuOSAlIiwiaW5wdXQiOnsidHkiOiJsbXQiLCJjdCI6NjQwMywidHlyZiI6ODg0NTAsInB0eSI6IjEwMDAyIiwiYmQiOjExNzAxLCJhcmVhIjoxMjM0LCJhcmVhbXgiOjAsImF1bml0IjoxMjgwMCwiYXVEZXNjIjoiU3EtZnQiLCJmbHIiOjAsInBhciI6MCwib3BwYXIiOjAsImNvcGFyIjowfSwibWluU2xpZGVyIjozOCwiYXZnUHJpY2UiOjM0NTIsImlzZ3Jvd3RoIjp0cnVlLCJyZG1kIjozMjU3LCJhY2NNc2ciOiJWYXJpYXRpb24gbWF5IGJlIGR1ZSB0byBmYWN0b3JzIGxpa2UgYWdlLCBxdWFsaXR5IG9mIGNvbnN0cnVjdGlvbiwgaW50ZXJpb3JzLCBmbG9vcmluZyBldGMuIiwibG9jYWxpdHkiOiJOb2lkYSBFeHRlbnNpb24sIE5vaWRhIiwicXN0ciI6ImN0XHUwMDNkNjQwM1x1MDAyNnR5XHUwMDNkbG10XHUwMDI2dHlyZlx1MDAzZDRkNDIzODM4MzQzNTMwXHUwMDI2cHR5XHUwMDNkMTAwMDJcdTAwMjZ1bml0XHUwMDNkMTI4MDBcdTAwMjZiZFx1MDAzZDExNzAxXHUwMDI2YXJlYVx1MDAzZDEyMzRcdTAwMjZmYWNcdTAwM2RudWxsXHUwMDI2ZHZjXHUwMDNkd2ViXHUwMDI2YXBpVmVyc2lvblx1MDAzZDIuMCIsImFjY3VyYWN5Ijo5MiwibWF4U2xpZGVyIjo0Mywic3VjY2VzcyI6dHJ1ZX0=");
//        System.out.println(getBase64Decoded("[B@5566e377"));
//        System.out.println(getBase64Decoded("d2e4f434fa58e850410fccda333de4bb79ae346fb499b7d08f894a3a19e16a97"));
    }
    private static String bytesToHex(String hash) {
        return DatatypeConverter.printHexBinary(hash.getBytes());
    }

    public static byte[] getBase64Decoded(byte[] jsonObj) {

        return Base64.decodeBase64(jsonObj);
    }


}
