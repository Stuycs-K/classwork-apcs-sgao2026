import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
public class Day2 {
	public static void main(String[]args) {
		
	}
	
	public static void run() {
		String[] inst = initiate();
		int[] code = new int[5];
		code[0] = 5;
		
		int[][] keypad = new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
		int row = 0;
		int col = 0;
		
		for (int i = 0; i < inst.length; i++) {
			
		}
	}
	public static String[] initiate() {
		String[] lines = new String[5];
		try {
			Scanner in = new Scanner(new File("2input.txt"));
			int i = 0;
			while (in.hasNextLine()) {
				lines[i] = in.nextLine();
				i++;
			}
		} catch (FileNotFoundException e) {
			System.out.println("oops");
		}
		return lines;
	}
}
