import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
public class Day1 {
	public static void main(String[]args) {
		pt2();
	}
	public static void pt2() {
		String[][] dir = initiate();
		int turns = dir[0].length;
		
		int degrees = 0;
		int hblocks = 0;
		int vblocks = 0;
		
		ArrayList<Integer> coor = new ArrayList<Integer>();
		coor.add(0);
		coor.add(0);
		for (int i = 0; i < turns; i++) {
			String turn = dir[0][i];
			int blocks = Integer.parseInt(dir[1][i]);
			
			if (turn.equals("R")) {
				degrees += 1;
			} else {
				degrees -= 1;
			}
			
			if (degrees % 4 == 0) {
				vblocks += blocks;
			} else if (degrees % 4 == 1) {
				hblocks += blocks;
			} else if (degrees % 4 == 2) {
				vblocks -= blocks;
			} else {
				hblocks -= blocks;
			}
			
			boolean signFlip = false;
			int tripped = 0;
			for (int a = 0; a + 3 < coor.size(); a+=2) {
				tripped++;
				boolean xflip;
				boolean yflip;
				
				int x1 = coor.get(a); // 0
				int x2 = coor.get(a + 2); // 4
				int y1 = coor.get(a + 1); // 0
				int y2 = coor.get(a + 3); // 0
				
				if (degrees % 4 == 0) {
					xflip = hblocks > Math.min(x1, x2) && hblocks < Math.max(x1, x2);
					yflip = vblocks > y1 && (vblocks - blocks) < y1;
				} else if (degrees % 4 == 1) {
					xflip = hblocks > x1 && (hblocks - blocks) < x1;
					yflip = vblocks > Math.min(y1, y2) && hblocks < Math.max(y1, y2);
				} else if (degrees % 4 == 2) {
					xflip = hblocks > Math.min(x1, x2) && hblocks < Math.max(x1, x2); // 4
					yflip = vblocks < y1 && (vblocks + blocks) > y1; // -4
				} else {
					xflip = hblocks < x1 && (hblocks - blocks) > x1;
					yflip = vblocks > Math.min(y1, y2) && hblocks < Math.max(y1, y2);
				}
				
				if (xflip && yflip) {
					System.out.println("(" + hblocks + ", " + vblocks + ")" + tripped);
				}
			}
			coor.add(hblocks);
			coor.add(vblocks);
		}
		System.out.println(coor);
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
				degrees += 1;
			} else {
				degrees -= 1;
			}
			
			if (degrees % 4 == 0) {
				vblocks += blocks;
			} else if (degrees % 4 == 1) {
				hblocks += blocks;
			} else if (degrees % 4 == 2) {
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
	public static ArrayList<String> copy(ArrayList<String> og) {
		ArrayList<String> copy = new ArrayList<String>(og.size());
		
		for (int i = 0; i < og.size(); i++) {
			copy.add(og.get(i));
		}
		
		return copy;
	}
}
