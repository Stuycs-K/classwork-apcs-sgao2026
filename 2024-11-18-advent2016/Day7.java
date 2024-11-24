import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;

public class Day7 {
	public static void main(String[] args) {
		run();
	}
	public static void run() {
		String[] bits = initiate();
		System.out.println(bits[10]);
	}
	
	public static String[] initiate() {
		String[] initiated = new String[1];
		try {
			ArrayList<String> basic = new ArrayList<String>();
			
			Scanner in = new Scanner(new File("7input.txt"));
			while (in.hasNextLine()) {
				String temp = in.nextLine();
				while (temp.indexOf("[") != -1) {
					temp = temp.substring(0, temp.indexOf("[")) + temp.substring(temp.indexOf("]") + 1);
				}
				basic.add(temp);
			}
			initiated = basic.toArray(initiated);
		} catch (FileNotFoundException e) {
			System.out.println("oops");
		}
		return initiated;
	}
}