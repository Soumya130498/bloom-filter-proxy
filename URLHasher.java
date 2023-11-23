import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class URLHasher {

    public static String hashURL(String url) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-1");

            byte[] hashBytes = digest.digest(url.getBytes(StandardCharsets.UTF_8));

            StringBuilder hexString = new StringBuilder();
            for (byte hashByte : hashBytes) {
                String hex = Integer.toHexString(0xff & hashByte);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }

            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        String url = "https://wordpress.com/go/content-blogging/bloggers-block-writing-resources-to-try-when-youre-out-of-ideas/";
        String hashedURL = hashURL(url);

        System.out.println("Original URL: " + url);
        System.out.println("Hashed URL: " + hashedURL);
    }
}

