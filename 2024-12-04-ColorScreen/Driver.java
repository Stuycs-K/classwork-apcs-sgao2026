public class Driver {
	public static void main(String[]args) {
		CLEAR(); HIDE(); LEFT();
		
		for (int i = 0; i < )
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
