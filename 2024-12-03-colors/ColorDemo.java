public class ColorDemo {
	public static void main(String[]args) {
		LEFT();
		
		go(1, 11);
		colorBack(GREEN);
		System.out.print(" ");
		
		go(2, 11);
		colorBack(GREEN);
		System.out.print(" ");
		
		go(3, 10);
		colorBack(GREEN);
		System.out.print("   ");
		
		go(4, 9);
		colorBack(GREEN);
		System.out.print("     ");
		
		go(5, 8);
		colorBack(GREEN);
		System.out.print("       ");
		
		go(6, 9);
		colorBack(GREEN);
		System.out.print("     ");
		
		go(7, 8);
		colorBack(GREEN);
		System.out.print("  ");
		colorBack(WHITE);
		System.out.print(" ");
		colorBack(GREEN);
		System.out.print("    ");
		
		go(8, 7);
		colorBack(GREEN);
		System.out.print("      ");
		colorBack(RED);
		System.out.print(" ");
		colorBack(GREEN);
		System.out.print("  ");
		
		go(9, 5);
		colorBack(GREEN);
		System.out.print("             ");
		
		go(10, 8);
		colorBack(GREEN);
		System.out.print("       ");
		
		go(11, 7);
		colorBack(GREEN);
		System.out.print("         ");
		
		go(12, 6);
		colorBack(GREEN);
		System.out.print("         ");
		colorBack(RED);
		System.out.print(" ");
		colorBack(GREEN);
		System.out.print(" ");
		
		go(13, 5);
		colorBack(GREEN);
		System.out.print("  ");
		colorBack(YELLOW);
		System.out.print(" ");
		colorBack(GREEN);
		System.out.print("          ");
		
		go(14, 3);
		colorBack(GREEN);
		System.out.print("                 ");
		
		go(15, 10);
		colorBack(101, 55, 0);
		System.out.print("   ");
		
		go(16, 10);
		colorBack(101, 55, 0);
		System.out.print("   ");
		
		go(17, 10);
		colorBack(101, 55, 0);
		System.out.print("   ");
		
		RESET();
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
		System.out.print("38;2;" + r + ";" + g + ";" + b + ";7m.");
	}
	public static void colorBack(int r, int g, int b) {
		ESC();
		System.out.print("48;2;" + r + ";" + g + ";" + b + ";7m.");
	}
	public static void go(int r, int c) {
		ESC();
		System.out.print(r + ";" + c + "f");
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
