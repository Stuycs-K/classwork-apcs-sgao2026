import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
public class Day2 {
	public static void main(String[]args) {
		pt2();
	}
	
	public static void run() {
		String[] inst = initiate();
		ArrayList<Integer> code = new ArrayList<Integer>(4);
		// code[0] = 5;
		
		int[][] keypad = new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
		int row = 1;
		int col = 1;
		
		String all = "URDL";
		String[][] ref = new String[][] {{"-1", "0"}, {"0", "1"}, {"1", "0"}, {"0", "-1"}};
		
		for (int i = 0; i < inst.length; i++) {
			String line = inst[i];
			System.out.println(line);
			
			for (int a = 0; a < line.length(); a++) {
				int index = all.indexOf(line.substring(a, a + 1));
				String[] set = ref[index];
				// System.out.print(line.substring(a, a + 1) + ": " + Arrays.toString(set) + " ");
				if ((row + Integer.parseInt(set[0])) < 3 && (row + Integer.parseInt(set[0])) > -1) {
					row += Integer.parseInt(set[0]);
				} 
				if ((col + Integer.parseInt(set[1])) < 3 && (col + Integer.parseInt(set[1])) > -1) {
					col += Integer.parseInt(set[1]);
				} 
				
				// System.out.println(row + " " + col);
			}
			code.add(keypad[row][col]);
			System.out.println(code);
		}
		System.out.println(code);
	}
	public static void pt2() {
		String[] inst = initiate();
		ArrayList<String> code = new ArrayList<String>(4);
		// code[0] = 5;
		
		String[][] keypad = new String[][] {{"0", "0", "1", "0", "0"}, {"0", "2", "3", "4", "0"}, {"5", "6", "7", "8", "9"}, {"0", "A", "B", "C", "0"}, {"0", "0", "D", "0", "0"}};
		// System.out.println(Arrays.deepToString(keypad));
		int[][] bounds = new int[][] {{2}, {1, 3}, {0, 4}, {1, 3}, {2}};
		int row = 2;
		int col = 0;
		
		String all = "URDL";
		String[][] ref = new String[][] {{"-1", "0"}, {"0", "1"}, {"1", "0"}, {"0", "-1"}};
		
		for (int i = 0; i < inst.length; i++) {
			String line = inst[i];
			System.out.println(line);
			
			for (int a = 0; a < line.length(); a++) {
				int index = all.indexOf(line.substring(a, a + 1));
				String[] set = ref[index];
				
				int posr = row + Integer.parseInt(set[0]);
				int posc = col + Integer.parseInt(set[1]);
				
				if (posr >= 0 && posr <= 4) {
					int[] bound = new int[] {bounds[posr][0], bounds[posr][bounds[posr].length - 1]};
					if (bound[0] <= col && col <= bound[1]) {
						row = posr;
					}
				}
				if (posc >= 0 && posc <= 4) {
					int[] bound = new int[] {bounds[row][0], bounds[row][bounds[row].length - 1]};
					if (bound[0] <= posc && posc <= bound[1]) {
						col = posc;
					}
				}
				
				System.out.println(row + " " + col);
			}
			code.add(keypad[row][col]);
			System.out.println(code);
		}
		System.out.println(code);
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
