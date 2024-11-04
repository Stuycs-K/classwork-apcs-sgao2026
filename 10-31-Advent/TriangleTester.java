import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TriangleTester {
	public static void main (String[]args) {
		System.out.println(countTrianglesA("inputTri.txt"));
		System.out.println(numLines("inputTri.txt"));
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
	/*
	public static int countTrianglesB(String filename) {
		int count = 0;
		
		try {
			int[][] set = new int[numLines(filename)][3];
			
			File file = new File(filename);
			Scanner txt = new Scanner(file);
			
			for (int i = 0; i < set.length; i++) {
				
			}
		}
	}
	*/
	public static boolean valid(int[] sides) {
		return sides[0] < (sides[1] + sides[2]) && sides[1] < (sides[0] + sides[2]) && sides[2] < (sides[0] + sides[1]);
	}
	public static int numLines (String filename) {
		try {
			int count = 0;
			File file = new File(filename);
			Scanner txt = new Scanner(file);
			
			while (txt.hasNextLine()) {
				txt.nextLine();
				count++;
			}
			txt.close();
			return count;
		} catch (FileNotFoundException e) {
			System.out.println(filename + " not found");
		}
		return 0;
	}
	public static String[][] makeSet(String filename) {
		String[][] set = new String[numLines(filename)][3];
		
		try {
			File file = new File(filename);
			Scanner txt = new Scanner(file);
				
			for (int i = 0; i < set.length; i++) {
				while (txt.hasNextLine()) {
					set[i] = txt.nextLine().split(" ");
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println(filename + " not found");
		}
			
		return set;
	}
}
