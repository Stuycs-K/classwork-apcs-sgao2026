public class MyArrays {
	public static void main(String[]args) {
		System.out.println("-----------testing arrayToString()-----------");
		System.out.println("[0, 0, 0, 1]: " + arrayToString(new int[] {0, 0, 0, 1}));
		System.out.println("[1, 10, 5, 6, 100]: " + arrayToString(new int[] {1, 10, 5, 6, 100}));
		System.out.println("[]: " + arrayToString(new int[] {}));
		
		System.out.println("-----------testing returnCopy()-----------");
		int[] og = new int[] {10, 9, 8, 7, 6, 5, 4, 3, 3};
		int[] copy = returnCopy(og);
		System.out.println(arrayToString(og) + ": " + arrayToString(copy) + " " + (og == copy));

		og = new int[] {0, 1, 9, 8 ,0 ,0, 10, 100, -10, 908};
		copy = returnCopy(og);
		System.out.println(arrayToString(og) + ": " + arrayToString(copy) + " " + (og == copy));

		og = new int[] {10, -1, 900, 0, -4,};
		copy = returnCopy(og);
		System.out.println(arrayToString(og) + ": " + arrayToString(copy) + " " + (og == copy));
		
		og = new int[0];
		copy = returnCopy(og);
		System.out.println(arrayToString(og) + ": " + arrayToString(copy) + " " + (og == copy));
		
		System.out.println("-----------testing concatArray()-----------");
		int[] ary1 = new int[] {10, -1, 100, 14, 30};
		int[] ary2 = new int[] {9, 8, -5};
		System.out.println(arrayToString(ary1) + " " + arrayToString(ary2) + ": " + arrayToString(concatArray(ary1, ary2)));
		
		ary1 = new int[] {0, 1, -10, -9};
		ary2 = new int[] {5, 6, 100, -90, 2146478, 98};
		System.out.println(arrayToString(ary1) + " " + arrayToString(ary2) + ": " + arrayToString(concatArray(ary1, ary2)));
		
		ary1 = new int[0];
		ary2 = new int[] {10, 14};
		System.out.println(arrayToString(ary1) + " " + arrayToString(ary2) + ": " + arrayToString(concatArray(ary1, ary2)));
		
		ary1 = new int[] {14, 16, 17, -20};
		ary2 = new int[0];
		System.out.println(arrayToString(ary1) + " " + arrayToString(ary2) + ": " + arrayToString(concatArray(ary1, ary2)));
		
		ary1 = new int[0];
		ary2 = new int[0];
		System.out.println(arrayToString(ary1) + " " + arrayToString(ary2) + ": " + arrayToString(concatArray(ary1, ary2)));
		
	}
	
	public static String arrayToString(int[] nums) {
		String s = "[";
		
		for (int i = 0; i < nums.length; i++) {
			if (i == nums.length - 1) {
				s += nums[i];
			} else {
				s += nums[i] + ", ";
			}
		}
		return s + "]";
	}
	
	public static int[] returnCopy(int[] ary) {
		int[] copy = new int[ary.length];
		
		for (int i = 0; i < ary.length; i++) {
			copy[i] = ary[i];
		}
		
		return copy;
	}
	
	public static int[] concatArray(int[]ary1, int[]ary2) {
		int[] concat = new int[ary1.length + ary2.length];
		int i = 0;
		
		for (i = 0; i < ary1.length; i++) {
			concat[i] = ary1[i];
		}
		for (int n = 0; i - ary1.length < ary2.length; i++) {
			concat[i] = ary2[i - ary1.length];
		}
		
		return concat;
	}
}
