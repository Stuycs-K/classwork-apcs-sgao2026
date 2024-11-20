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
			System.out.println(Arrays.deepToString(lines));
		} catch (FileNotFoundException e) {
			System.out.println("oops");
		}
		return lines;
	}
}