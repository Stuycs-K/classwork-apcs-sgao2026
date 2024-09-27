public class MyArrays {
	public static void main(String[]args) {
		System.out.println("-----------testing arrayToString()-----------");
		System.out.println("[0, 0, 0, 1]: " + arrayToString(new int[] {0, 0, 0, 1}));
		System.out.println("[1, 10, 5, 6, 100]: " + arrayToString(new int[] {1, 10, 5, 6, 100}));
		System.out.println("[]: " + arrayToString(new int[] {}));
		
		System.out.println("-----------testing returnCopy()-----------");
		int[] og = new int[] {10, 9, 8, 7, 6, 5, 4, 3, 3}
		int[] copy = returnCopy(og)
		System.out.println(arrayToString(og) + ": " + arrayToString(copy) + " " + og == copy);
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
}
