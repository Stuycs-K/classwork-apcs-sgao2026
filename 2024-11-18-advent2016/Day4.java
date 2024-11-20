import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;

public class Day4 {
	public static void main(String[]args) {
		run();
	}
	public static void run() {
		String[][] lines = initiate();
		String[] allNames = allNames(lines);
		String[] allIDs = allIDs(lines);
		String[] allChecks = allChecks(lines);
		
		int sum = 0;
		for (int i = 0; i < allNames.length; i++) {
			ArrayList<ArrayList<String>> sorted = sortCount(allNames[i]);
			String trial = sorted.get(0).get(0) + sorted.get(1).get(0) + sorted.get(2).get(0) + sorted.get(3).get(0) + sorted.get(4).get(0);
			
			if (trial.equals(allIDs[i])) {
				sum += Integer.parseInt(allChecks[i]);
			}
		}
		System.out.println(sum);
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
		
		System.out.println(Arrays.toString(unsorted));
		System.out.println(name);
		
		for (int i = 1; i < unsorted.length; i += 2) {
			if (Integer.parseInt(unsorted[i]) != 0) {
				ArrayList<String> unit = new ArrayList<String>();
				unit.add(unsorted[i - 1]); // letter
				unit.add(unsorted[i]); // count
				
				int place = sorted.size();
				for (int p = 0; p < sorted.size() && place == sorted.size(); p++) {
					if (Integer.parseInt(sorted.get(p).get(1)) < Integer.parseInt(unsorted[i])) {
						place = p;
						System.out.println(unit + " triggered 1 " + place);
					} else if (sorted.get(p).get(1).equals(unsorted[i])) {
						try {
							while ((sorted.get(p).get(0).charAt(0) < unsorted[i - 1].charAt(0)) && sorted.get(p).get(1).equals(unsorted[i])) {
								p++;
							}
						} catch (IndexOutOfBoundsException e) {}
						place = p;
						System.out.println(unit + " triggered 2 " + place);
					}
				}
				sorted.add(place, unit);
				System.out.println(sorted);
			}
		}
		System.out.println(sorted);
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
}