package computerized.com.clubbuddy;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Todo: Implement this
 */
public class md5stuff {
    // Makes the MD5
    public static String makehash(int pin, int phone) {
        String concatonated = "" + phone + pin;
        concatonated = getMD5(concatonated);
        return concatonated;
    }

    // Actually calculates the MD5
    // http://www.asjava.com/core-java/java-md5-example/
    public static String getMD5(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            BigInteger number = new BigInteger(1, messageDigest);
            String hashtext = number.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
