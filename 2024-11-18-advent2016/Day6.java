import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;

public class Day6 {
	public static void main(String[]args) {
		run();
	}
	public static void run() {
		String[][] bits = initiate();
	}
	
	public static String[][] initiate() {
		String[][] bits = new String[624][];
		
		try {
			Scanner in = new Scanner (new File("6input.txt"));
			
			int i = 0;
			while(in.hasNextLine()) {
				String line = in.nextLine();
				
				bits[i] = line.split("");
				i++;
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("oops");
		}
		System.out.println(Arrays.deepToString(bits));
		return bits;
	}
	public static int[] counts (String[] letters) {
		String line = Arrays.toString(letters);
		line = line.substring(1, line.length() - 1);
		line = line.replaceAll(", ", "");
		
		char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		int[] dict = new int[26];
		
		for (int i = 0; i < alphabet.length; i++) {
			dict[i] = count(line, alphabet[i]);
		}
		
		return dict;
	}
	public static int count (String s, char c) {
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == c) {
				count++;
			}
		}
		return count;
	}
}
