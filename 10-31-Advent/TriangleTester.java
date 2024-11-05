import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TriangleTester {
	public static void main (String[]args) {
		System.out.println(countTrianglesA("inputTri.txt"));
		System.out.println(countTrianglesB("inputTri.txt"));
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
			
			int[][] set = makeSet(filename);
			
			for (int i = 0; i < 3; i++) {
				int[] sides = new int[3];
				int n = 0;
				
				while (n < set.length) {
					while((n + 1) % 3 != 0) {
						sides[n % 3] = set[n][i];
						n++;
					}
					sides[2] = set[n][i];
					if (valid(sides)) {
						count++;
					}
					n++;
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
			s.close();
		} catch (FileNotFoundException e) {
			System.out.println(filename + " not found");
		}
		
		return count;
	}
	public static int[][] makeSet(String filename) {		
		try {
			File file = new File(filename);
			Scanner s = new Scanner(file);
			
			int[][] set = new int[numLines(filename)][3];
			int i = 0;
				
			while (s.hasNextLine()) {
				Scanner z = new Scanner(s.nextLine());
				int n = 0;
				
				while (z.hasNextInt()) {
					set[i][n] = z.nextInt();
					n++;
				}
				i++;
			}
			
			s.close();
			return set;
		} catch (FileNotFoundException e) {
			System.out.println(filename + " not found");
		}
		
		return new int[1][1];
	}
}
