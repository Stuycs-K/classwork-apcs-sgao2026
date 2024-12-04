public class ColorDemo {
	public static void main(String[]args) {
		
	}
	
	public static void ESC(String[] inst) {
		String result = "\u001b[";
		
		for (int i = 0; i < inst.length; i++) {
			result += inst[i];
			
			if (i != inst.length - 1) result += ";";
		}
		
		System.out.print(result + "m");
	}
	public static void RESET() {
		System.out.print("\u001b[0m");
	}
	public static void CLEAR() {
	
	}
}
