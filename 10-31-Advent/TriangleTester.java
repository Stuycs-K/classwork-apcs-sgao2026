import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TriangleTester {
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
		} catch (FileNotFoundException e) {
			System.out.println(filename + " not found.");
		}
		return count;
		
	}
	
	public static boolean valid(int[] sides) {
		return sides[0] < (sides[1] + sides[2]) && sides[1] < (sides[0] + sides[2]) && sides[2] < (sides[0] + sides[1]);
	}
}