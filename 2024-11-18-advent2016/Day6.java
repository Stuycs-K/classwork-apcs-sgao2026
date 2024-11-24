import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;

public class Day6 {
	public static void main(String[]args) {
		run2();
	}
	public static void run() {
		String[][] bits = initiate();
		char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		String word = "";
		
		for (int b = 0; b < bits[0].length; b++) {
			String[] letters = new String[bits.length];
			for (int i = 0; i < bits.length; i++) {
				letters[i] = bits[i][b];
				// System.out.println(letters[i]);
			}
			
			int[] counts = counts(letters);
			System.out.println(Arrays.toString(counts));
			System.out.println(alphabet[arrayMax(counts)]);
			word = word + alphabet[arrayMax(counts)];
		}
		System.out.println(word);
	}
	public static void run2() {
		String[][] bits = initiate();
		char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		String word = "";
		
		for (int b = 0; b < bits[0].length; b++) {
			String[] letters = new String[bits.length];
			for (int i = 0; i < bits.length; i++) {
				letters[i] = bits[i][b];
				// System.out.println(letters[i]);
			}
			
			int[] counts = counts(letters);
			System.out.println(Arrays.toString(counts));
			System.out.println(alphabet[arrayMin(counts)]);
			word = word + alphabet[arrayMin(counts)];
		}
		System.out.println(word);
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
		// System.out.println(Arrays.deepToString(bits));
		return bits;
	}
	public static int[] counts (String[] letters) {
		String line = Arrays.toString(letters);
		line = line.substring(1, line.length() - 1);
		line = line.replaceAll(", ", "");
		// System.out.println(line);
		
		char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		int[] dict = new int[26];
		
		for (int i = 0; i < alphabet.length; i++) {
			dict[i] = count(line, alphabet[i]);
		}
		
		// System.out.println(Arrays.toString(dict));
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
	public static int arrayMax (int[] a) {
		int max = -1;
		
		for (int i = 1; i < a.length; i++) {
			try {
				if (a[i] > a[max]) {
					System.out.println(a[i] + " > " + a[max] + ": " + (a[i] > a[max]));
					max = i;
				}
			} catch (ArrayIndexOutOfBoundsException e) {
				max++;
			}
		}
		return max;
	}	
	public static int arrayMin (int[] a) {
		int min = 0;
		
		for (int i = 1; i < a.length; i++) {
			try {
				if (a[i] < a[min]) {
					System.out.println(a[i] + " < " + a[min] + ": " + (a[i] < a[min]));
					min = i;
				}
			} catch (ArrayIndexOutOfBoundsException e) {
				min++;
			}
		}
		return min;
	}
}
