import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TriangleTester {
	public static void main (String[]args) {
		makeSet("inputTri.txt");
		System.out.println(countTrianglesA("inputTri.txt"));
		System.out.println(numLines("inputTri.txt"));
		// System.out.println(countTrianglesB("inputTri.txt"));
		System.out.println("File not found");
	}
	public static int countTrianglesA(String filename) {
		int count = 0;
		
		int[] sides = new int[3];
		try {
			File file = new File(filename);
			Scanner sets = new Scanner(file);
			while (sets.hasNext()) {
				Scanner r = new Scanner(sets.nextLine());
				int i = 0;
				
				while (r.hasNextInt()) {
					sides[i] = r.nextInt();
					i++;
				}
				
				if (valid(sides)) {
					count++;
				}
			}
			sets.close();
		} catch (FileNotFoundException e) {
			System.out.println(filename + " not found.");
		}
		return count;
		
	}
	
	public static int countTrianglesB(String filename) {
		int count = 0;
		
		try {			
			File file = new File(filename);
			Scanner txt = new Scanner(file);
			
			String[][] set = makeSet(filename);

			
			for (int i = 0; i < 3; i++) {
				int[] sides = new int[3];
				int n = 0;
				
				while (n < set.length) {
					while(n + 1 % 3 != 0) {
						System.out.println("[" + sides[0] + ", " + sides[1] + ", " + sides[2] + "]");
						System.out.println(n);
						System.out.println(i);
						System.out.println(set[n][i]);
						sides[n % 3] = Integer.parseInt(set[n][i]);
						System.out.println(sides[n % 3]);
						n++;
					}
					if (valid(sides)) {
						count++;
					}
				}
			}
			txt.close();
		} catch (FileNotFoundException e) {
			System.out.println(filename + " file not found");
		}
		return count;
	}
	
	public static boolean valid(int[] sides) {
		return sides[0] < (sides[1] + sides[2]) && sides[1] < (sides[0] + sides[2]) && sides[2] < (sides[0] + sides[1]);
	}
	public static int numLines (String filename) {
		int count = 0;
		
		try {
			File file = new File(filename);
			Scanner s = new Scanner(file);
			
			while (s.hasNextLine()) {
				s.nextLine();
				count++;
			}
		} catch (FileNotFoundException e) {
			System.out.println(filename + " not found");
		}
		
		return count;
	}
	public static String[][] makeSet(String filename) {		
		try {
			File file = new File(filename);
			Scanner s = new Scanner(file);
			
			String[][] set = new String[numLines(filename)][3];
			int i = 0;
			System.out.println(s.nextLine());
				
			while (s.hasNextLine()) {
				String line = s.nextLine();
				System.out.println(line);
				set[i] = s.nextLine().split(" ");
				System.out.println("[" + set[i][0] + ", " + set[i][1] + ", " + set[i][2]);
				i++;
			}
			
			s.close();
			return set;
		} catch (FileNotFoundException e) {
			System.out.println(filename + " not found");
		}
		
		return new String[1][1];
	}
}
