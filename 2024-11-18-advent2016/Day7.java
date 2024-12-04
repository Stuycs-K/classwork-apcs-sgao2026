import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;

public class Day7 {
	public static void main(String[] args) {
		String line = "jlzynnkpwqyjvqcmcbz[fdjxnwkoqiquvbvo]bgkxfhztgjyyrcquoiv[xetgnqvwtdiuyiyv]zyfprefpmvxzauur";
		System.out.println(SSLsupp(supernets(line), hypernets(line)));
		run2();
	}
	public static void run() {
		String[] bits = initiate();
		// System.out.println(Arrays.toString(bits));
		int count = 0;
		int inv = 0;
		int invHyper = 0;
		
		for (int i = 0; i < bits.length; i++) {
			String line = bits[i];
			
			if (validHypers(line)) {
				String[] parts = process(line);
				
				if (validLine(parts)) count++;
			}
		}
		
		System.out.println(count);
	}
	
	public static void run2() {
		String[] bits = initiate();
		
		int count = 0;
		for (int i = 0; i < bits.length; i++) {
			System.out.print(i + ": ");
			if (SSLsupp(supernets(bits[i]), hypernets(bits[i]))) count++;
			System.out.println("");
		}
		System.out.println(count);
	}
	
	public static String hypernets(String s) {
		String hyps = "";
		
		while (s.indexOf("[") != -1) {
			hyps += s.substring(s.indexOf("[") + 1, s.indexOf("]")) + " ";
			s = s.replace(s.substring(s.indexOf("["), s.indexOf("]") + 1), "");
		}
		
		return hyps.substring(0, hyps.length() - 1);
	}
	
	public static String supernets(String s) {
		while (s.indexOf("[") != -1) {
			String hypernet = s.substring(s.indexOf("[") + 1, s.indexOf("]"));
			
			if (s.indexOf("]") == s.length() - 1) {
				s = s.replace("[" + hypernet + "]", "");
			} else {
				s = s.replace("[" + hypernet + "]", " ");
			}
		}
		
		return s;
	}
	
	public static String[] initiate() {
		String[] initiated = new String[1];
		try {
			ArrayList<String> basic = new ArrayList<String>();
			
			Scanner in = new Scanner(new File("7input.txt"));
			int count = 0;
			while (in.hasNextLine()) {
				basic.add(in.nextLine());
			}
			initiated = basic.toArray(initiated);
		} catch (FileNotFoundException e) {
			System.out.println("oops");
		}
		return initiated;
	}
	
	public static boolean isABBA(String s) {
		boolean ans = false;
		
		for (int i = 0; i + 3 < s.length(); i++) {
			if (s.charAt(i) != s.charAt(i + 1)) {
				if (s.substring(i, i + 2).equals(s.substring(i + 3, i + 4) + s.substring(i + 2, i + 3))) {
					ans = true;
					System.out.print(s.substring(i, i + 4) + " ");
				}
			}
		}
		
		return ans;
	}
	
	public static boolean validHypers (String s) {
		boolean valid = true;
		
		while (s.indexOf("[") != -1) {
			String hypernet = s.substring(s.indexOf("[") + 1, s.indexOf("]"));
			s = s.replace("[" + hypernet + "]", "");
			valid = valid && !isABBA(hypernet);
		}
		
		return valid;
	}
	
	public static boolean validLine (String[] s) {
		for (int i = 0; i < s.length; i++) {
			if (isABBA(s[i])) {
				return true;
			}
		}
		return false;
	}
	
	public static String[] process(String s) {
		while (s.indexOf("[") != -1) {
			String hypernet = s.substring(s.indexOf("[") + 1, s.indexOf("]"));
			
			if (s.indexOf("]") == s.length() - 1) {
				s = s.replace("[" + hypernet + "]", "");
			} else {
				s = s.replace("[" + hypernet + "]", " ");
			}
		}
		
		return s.split(" ");
	}
	
	public static boolean SSLsupp(String supernets, String hypernets) {
		for (int i = 1; i + 1 < supernets.length(); i++) {
			if (supernets.charAt(i) != ' ' && supernets.charAt(i + 1) != ' ') {
				if (supernets.charAt(i - 1) != supernets.charAt(i) && supernets.charAt(i - 1) == supernets.charAt(i + 1)) {
					String bab = "" + supernets.charAt(i) + supernets.charAt(i - 1) + supernets.charAt(i);
					System.out.print(bab + " ");
					if (hypernets.indexOf(bab) != -1) {
						System.out.print(supernets.substring(i - 1, i + 2) + " ");
						return true;
					}
				}
			}
		}
		return false;
	}
}