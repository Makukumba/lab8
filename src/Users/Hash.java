package Users;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

    public class Hash {
        public static String hashPassword(String password) {
            try {
                MessageDigest md = MessageDigest.getInstance("SHA-512");
                byte[] bytes = md.digest(password.getBytes());
                BigInteger integers = new BigInteger(1, bytes);
                String newPassword = integers.toString(16);
                return newPassword;
            } catch (NoSuchAlgorithmException exception) {
                throw new IllegalStateException(exception);
            }
        }
    }
