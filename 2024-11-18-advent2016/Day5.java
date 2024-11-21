import java.util.Arrays;
import java.util.ArrayList;
import java.util.AbstractMap;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.math.BigInteger;

public class Day5 {
	
    // Driver code
    public static void main(String args[]) throws NoSuchAlgorithmException {
        run();
    }
	
	public static void run() {
		String ID = "wtnhxymk";
		String pass = "";
		
		int i = 0;
		for (int n = 0; n < 8; n++) {
			while(validHash(getMD5(ID + i)).length() == 0) {
				i++;
			}
			pass += validHash(getMD5(ID + i));
			i++;
		}
		System.out.println(pass);
	}
	
	public static String getMD5 (String in) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			BigInteger bigInt = new BigInteger(1, md.digest(in.getBytes()));
			String hash = bigInt.toString(16);
			
			while (hash.length() < 32) {
				hash = "0" + hash;
			}
			return hash;
		} catch (NoSuchAlgorithmException e) {};
		return "";
	}
	public static String validHash(String hash) {
		if (hash.substring(0, 5).equals("00000")) {
			System.out.println(hash + " " + hash.substring(5, 6));
			return hash.substring(5, 6);
		} 
		return "";
	}
	/* public static String getMd5(String input) {
        try {
 
            // Static getInstance method is called with hashing MD5
            MessageDigest md = MessageDigest.getInstance("MD5");
 
            // digest() method is called to calculate message digest
            // of an input digest() return array of byte
            byte[] messageDigest = md.digest(input.getBytes());
 
            // Convert byte array into signum representation
            // BigInteger no = new BigInteger(1, messageDigest);
            BigInteger no = new BigInteger(1, md.digest(input.getBytes()));
 
            // Convert message digest into hex value
            String hashtext = no.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        }
 
        // For specifying wrong message digest algorithms
        catch (NoSuchAlgorithmException e) {
            // throw new RuntimeException(e);
        }
		return "";
    } */
}