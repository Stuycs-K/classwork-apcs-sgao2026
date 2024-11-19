import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Day1 {
	public static void main(String[]args) {
		run();
	}
	public static void run() {
		int degrees = 0;
		int hblocks = 0;
		int vblocks = 0;
		
		String[][] directions = initiate();
		
		for (int i = 0; i < directions[0].length; i++) {
			String turn = directions[0][i];
			int blocks = Integer.parseInt(directions[1][i]);
			
			if (turn.equals("R")) {
				degrees += 90;
			} else {
				degrees -= 90;
			}
			
			if ((degrees / 90) % 4 == 0) {
				vblocks += blocks;
			} else if ((degrees / 90) % 4 == 1) {
				hblocks += blocks;
			} else if ((degrees / 90) % 4 == 2) {
				vblocks -= blocks;
			} else {
				hblocks -= blocks;
			}
		}
		
		System.out.println(Math.abs(hblocks) + Math.abs(vblocks));		
	}
	public static String[][] initiate() {
		try {
			File file = new File("1input.txt");
			Scanner input = new Scanner(file);
			
			String line = input.nextLine();
			
			String[] dir = line.split(", ");
			String[][] directions = new String[2][dir.length];
			
			for (int i = 0; i < dir.length; i++) {
				directions[0][i] = dir[i].substring(0,1);
				directions[1][i] = dir[i].substring(1); 
			}
			return directions;
		} catch (FileNotFoundException e) {
			System.out.println("oops");
		}
		return new String[1][1];
	}
}
