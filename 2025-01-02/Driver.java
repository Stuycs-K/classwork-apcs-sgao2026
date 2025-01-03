public class Driver {
	public static void main(String[]args) {
		// System.out.println(fib(Integer.parseInt(args[0])));
		makeWords(2,"","abc");
	}
	public static int fib (int n) {
		if (n < 2) {
			return n;
		} else {
			return fib(n - 1) + fib(n - 2);
		}
	}
	public static void makeWords(int remainingLetters, String result, String alphabet) {
		if (remainingLetters == 0) {
			System.out.println(result);
		} else {
			for (int i = 0; i < alphabet.length(); i++) {
				makeWords(remainingLetters - 1, result + alphabet.substring(i, i + 1), alphabet);
			}
		}
	}
}

// n = 46 (0m6.961s)
// n = 46
