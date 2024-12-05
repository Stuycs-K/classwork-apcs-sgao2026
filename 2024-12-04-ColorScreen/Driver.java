import java.util.Arrays;
public class Driver {
	public static void main(String[]args) {
		CLEAR(); HIDE(); LEFT();

		int[] things = randomThree();
		colorFore(RED);
		border(80,30,"f///@");
		
		go(1, 0);
		int[] locs = distribute(3, 80);
		for (int i = 0; i < things.length; i++) {
			go(2,locs[i]);
			if (things[i] < 25) {
				bright(); colorFore(RED);
			} else if (things[i] > 75) {
				bright(); colorFore(GREEN);
			} else {
				bright(); colorFore(WHITE);
			}
			System.out.print(things[i]);
		}
		go(3, 2);
		RESET();
		colorFore(CYAN);
		line(78,"w");
		
		go(4,1);
		christmas(4, 1);
		go(4, 20);
		christmas(4, 20);
		go(4, 39);
		christmas(4, 39);
		go(4, 58);
		christmas(4, 58);
		
		go(23, 33);
		RESET();
		bright(); colorFore(WHITE);
		System.out.print("merry christmas");
		
		go(30, 0);
		RESET(); SHOW();
	}
	
	public static void border(int length, int width, String pattern) {
		ESC(); 
		LEFT();
		String[] bits = pattern.split("");
		int perimeter = length * 2 + (width - 2)* 2;
		
		for (int i = 1; i <= perimeter; i++) {
			if (i < length) {
				go(0, i);
				System.out.print(bits[(i - 1) % bits.length]);
				// if (i == 1) return;
			} else if (i < length + width - 1) {
				go(i - length + 1, length);
				System.out.print(bits[(i - 1) % bits.length]);
			} else if (i < length * 2 + width - 2) {
				go(width, length - (i - length - width) - 1);
				System.out.print(bits[(i - 1) % bits.length]);
			} else {
				go(width - (i - (length * 2 + width - 3)) + 1,0);
				System.out.print(bits[(i - 1) % bits.length]);
			}
		} 
		go(width + 1, 0);
	}
	public static void line(int length, String pattern) {
		System.out.print(pattern.repeat(length / pattern.length()) + pattern.substring(0, (length % pattern.length())));
	}
	public static int[] randomThree() {
		return new int[] {(int)(Math.random() * 100), (int)(Math.random() * 100), (int)(Math.random() * 100)};
	}
	public static int[] distribute(int sects, double length) {
		int[] locs = new int[sects];
		double even = (length - sects - 1) / (sects + 1);
		// System.out.print(even + " ");
		double here = 1.0;
		
		for (int i = 0; i < locs.length; i++) {
			here += even;
			
			locs[i] = (int) here;
			here++;
		}
		return locs;
	}
	public static void christmas(int r, int c) {
		go(r + 2, c + 11);
		colorBack(GREEN);
		System.out.print(" ");
		
		go(r + 3, c + 10);
		colorBack(GREEN);
		System.out.print("   ");
		
		go(r + 4, c + 9);
		colorBack(GREEN);
		System.out.print("     ");
		
		go(r + 5, c + 8);
		colorBack(GREEN);
		System.out.print("       ");
		
		go(r + 6, c + 9);
		colorBack(GREEN);
		System.out.print("     ");
		
		go(r + 7, c + 8);
		colorBack(GREEN);
		System.out.print("  ");
		colorBack(WHITE);
		System.out.print(" ");
		colorBack(GREEN);
		System.out.print("    ");
		
		go(r + 8, c + 7);
		colorBack(GREEN);
		System.out.print("      ");
		colorBack(RED);
		System.out.print(" ");
		colorBack(GREEN);
		System.out.print("  ");
		
		go(r + 9, c + 5);
		colorBack(GREEN);
		System.out.print("             ");
		
		go(r + 10, c + 8);
		colorBack(GREEN);
		System.out.print("       ");
		
		go(r + 11, c + 7);
		colorBack(GREEN);
		System.out.print("         ");
		
		go(r + 12, c + 6);
		colorBack(GREEN);
		System.out.print("         ");
		colorBack(RED);
		System.out.print(" ");
		colorBack(GREEN);
		System.out.print(" ");
		
		go(r + 13, c + 5);
		colorBack(GREEN);
		System.out.print("  ");
		colorBack(YELLOW);
		System.out.print(" ");
		colorBack(GREEN);
		System.out.print("          ");
		
		go(r + 14, c + 3);
		colorBack(GREEN);
		System.out.print("                 ");
		
		go(r + 15, c + 10);
		colorBack(101, 55, 0);
		System.out.print("   ");
		
		go(r + 16, c + 10);
		colorBack(101, 55, 0);
		System.out.print("   ");
		
		go(r + 17, c + 10);
		colorBack(101, 55, 0);
		System.out.print("   ");
	}
	
	public static final int BLACK = 30;
	public static final int RED = 31;
	public static final int GREEN = 32;
	public static final int YELLOW = 33;
	public static final int BLUE = 34;
	public static final int MAGENTA = 35;
	public static final int CYAN = 36;
	public static final int WHITE = 37;
	
	public static void colorFore(int color) {
		ESC();
		System.out.print(color + "m");
	}
	public static void colorBack(int color) {
		ESC();
		System.out.print(color + 10 + "m");
	}
	public static void colorFore(int r, int g, int b) {
		ESC();
		System.out.print("38;2;" + r + ";" + g + ";" + b + "m");
	}
	public static void colorBack(int r, int g, int b) {
		ESC();
		System.out.print("48;2;" + r + ";" + g + ";" + b + "m");
	}
	public static void bright() {
		ESC();
		System.out.print(1 + "m");
	}	
	public static void dark() {
		ESC();
		System.out.print(2 + "m");
	}	
	public static void italics() {
		ESC();
		System.out.print(3 + "m");
	}
	public static void erase(int r, int c, int size) {
		go(r, c);
		RESET();
		for (int i = 0; i < size; i++) {
			System.out.print(" ");
		}
	}
	public static void go(int r, int c) {
		ESC();
		System.out.print(r + ";" + c + "f");
	}
	public static void wait(int millis){
	    try {
	    	Thread.sleep(millis);
	    } catch (InterruptedException e) {}
	}
	
	public static void ESC() {
		System.out.print("\u001b[");
	}
	public static void RESET() {
		System.out.print("\u001b[0m");
	}
	public static void CLEAR() {
		System.out.print("\u001b[2J");
	}
	public static void LEFT() {
		System.out.print("\u001b[H");
	}
	public static void HIDE() {
		System.out.print("\u001b[?25l");
	}
	public static void SHOW() {
		System.out.print("\u001b[?25h");
	}
	
}
