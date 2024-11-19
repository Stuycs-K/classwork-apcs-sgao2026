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
		
		ArrayList<String> coor = new ArrayList<String>();
		int degrees = 0;
		int hblocks = 0;
		int vblocks = 0;
				
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
			
			coor.add("(" + hblocks + ", " + vblocks + ")");
		}
		
		String mark = "";
		for (int i = 0; i < coor.size(); i++) {
			String search = coor.get(i);
			System.out.println(search);
			
			if (mark.length() == 0) {
				ArrayList<String> temp = copy(coor);
				coor.remove(search);
				if (coor.indexOf(search) != -1) {
					mark = search;
				}
				coor = temp;
			}
		}
		System.out.println(mark);
		//System.out.println(Math.abs(Integer.parseInt(mark.substring(1,mark.indexOf(", ")))) + Math.abs(Integer.parseInt(mark.substring(4,5))));
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
