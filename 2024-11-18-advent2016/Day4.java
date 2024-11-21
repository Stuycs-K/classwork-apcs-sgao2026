import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;

public class Day4 {
	public static void main(String[]args) {
		System.out.println(decode("qzmtzixmtkozyivhz", 343));
		pt2();
	}
	
	public static void pt2() {
		ArrayList<String> validNames = run(); // ID, name
		
		int count = 0; 
		for (int i = 0; i < validNames.size(); i += 2) {
			count += Integer.parseInt(validNames.get(i));
		}
		System.out.println(count);
		
		for (int i = 1; i < validNames.size(); i += 2) {
			int ID = Integer.parseInt(validNames.get(i - 1));
			// char[] cipher = cipher(ID);
			
			String[] words = validNames.get(i).split("-");
			// if (words[0].length() == 3) {
				String room = "";
				
				for (int w = 0; w < words.length; w++) {
					room += decode(words[w], ID);
					
					if (w != words.length - 1) {
						room += " ";
					}
			 	}
				
				System.out.println(ID + ": " + room);
			// } 
		}
	}
	public static ArrayList<String> run() {
		String[][] lines = initiate();
		String[] allNames = allNames(lines);
		String[] allRawNames = allNamesDashed(lines);
		String[] allIDs = allIDs(lines);
		String[] allChecks = allChecks(lines);
		
		int sum = 0;
		ArrayList<String> validNames = new ArrayList<String>();
		for (int i = 0; i < allNames.length; i++) {
			ArrayList<ArrayList<String>> sorted = sortCount(allNames[i]);
			String trial = sorted.get(0).get(0) + sorted.get(1).get(0) + sorted.get(2).get(0) + sorted.get(3).get(0) + sorted.get(4).get(0);
			
			// System.out.println(trial + " " + allChecks[i]);
			if (trial.equals(allChecks[i])) {
				sum += Integer.parseInt(allIDs[i]);
				validNames.add(allIDs[i] + "");
				validNames.add(allRawNames[i]);
			}
		}
		System.out.println(sum);
		// System.out.println(validNames);
		return validNames;
	}
	
	public static String[][] initiate() {
		String[][] lines = new String[947][];
		try {
			Scanner in = new Scanner(new File("4input.txt"));
			int i = 0;
			while (in.hasNextLine()) {
				String line = in.nextLine();
				
				int iCheck = line.indexOf("[") + 1;
				int iSect = line.lastIndexOf("-") + 1;
				String checksum = line.substring(iCheck, line.length() - 1);
				String ID = line.substring(iSect, iCheck - 1);
				String name = line.substring(0, iSect - 1);
				
				lines[i] = new String[] {name, ID, checksum};
				i++;
			}
			// System.out.println(Arrays.deepToString(lines));
		} catch (FileNotFoundException e) {
			System.out.println("oops");
		}
		return lines;
	}
	
	public static String[] allNames(String[][] lines) {
		String[] names = new String[lines.length];
		for (int i = 0; i < lines.length; i++) {
			names[i] = lines[i][0].replaceAll("-", "");
		}
		return names;
	}
	public static String[] allNamesDashed(String[][] lines) {
		String[] names = new String[lines.length];
		for (int i = 0; i < lines.length; i++) {
			names[i] = lines[i][0];
		}
		return names;
	}
	public static String[] allIDs(String[][] lines) {
		String[] IDs = new String[lines.length];
		for (int i = 0; i < lines.length; i++) {
			IDs[i] = lines[i][1];
		}
		return IDs;
	}
	public static String[] allChecks(String[][] lines) {
		String[] checksums = new String[lines.length];
		for (int i = 0; i < lines.length; i++) {
			checksums[i] = lines[i][2];
		}
		return checksums;
	}
	public static ArrayList<ArrayList<String>> sortCount(String name) {
		ArrayList<ArrayList<String>> sorted = new ArrayList<ArrayList<String>>();
		String[] unsorted = rawCount(name);
		
		// System.out.println(Arrays.toString(unsorted));
		// System.out.println(name);
		
		for (int i = 1; i < unsorted.length; i += 2) {
			if (Integer.parseInt(unsorted[i]) != 0) {
				ArrayList<String> unit = new ArrayList<String>();
				unit.add(unsorted[i - 1]); // letter
				unit.add(unsorted[i]); // count
				
				int place = sorted.size();
				for (int p = 0; p < sorted.size() && place == sorted.size(); p++) {
					if (Integer.parseInt(sorted.get(p).get(1)) < Integer.parseInt(unsorted[i])) {
						place = p;
						// System.out.println(unit + " triggered 1 " + place);
					} else if (sorted.get(p).get(1).equals(unsorted[i])) {
						try {
							while ((sorted.get(p).get(0).charAt(0) < unsorted[i - 1].charAt(0)) && sorted.get(p).get(1).equals(unsorted[i])) {
								p++;
							}
						} catch (IndexOutOfBoundsException e) {}
						place = p;
						// System.out.println(unit + " triggered 2 " + place);
					}
				}
				sorted.add(place, unit);
				// System.out.println(sorted);
			}
		}
		// System.out.println(sorted);
		return sorted;
	}
	public static String[] rawCount(String line) {
		String[] dict = new String[26 * 2];
		char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		
		for (int i = 0; i < alphabet.length; i++) {
			dict[i * 2] = "" + alphabet[i];
			dict[i * 2 + 1] = "" + count(line, alphabet[i]);
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
	public static char[] cipher(int shift) {
		shift %= 26;
		char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		char[] cipher = new char[26];
		
		for (int i = shift; i < alphabet.length; i++) {
			cipher[i - shift] = alphabet[i];
		}
		
		for (int i = 0; i < shift; i++) {
			cipher[26 - shift + i] = alphabet[i];
		}
		// System.out.println(Arrays.toString(cipher));
		return cipher;
	}
	public static String decode (String og, int shift) {
		String alphabet = "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz"; // .toCharArray();
		shift %= 26;
		String decoded = "";
		
		for (int i = 0; i < og.length(); i++) {
			// System.out.println(alphabet[(new String(cipher)).indexOf(og.charAt(i))]);
			int ini = alphabet.indexOf(og.charAt(i)) + shift;
			
			decoded = decoded + alphabet.charAt(ini);
			// System.out.println(decoded);
		}
		return decoded;
	}
}