public class MyArrays {
	public static void main(String[]args) {
		System.out.println("testing arrayToString()");
		System.out.println("[0, 0, 0, 1]: " + arrayToString(new int[] {0, 0, 0, 1}));
		System.out.println("[1, 10, 5, 6, 100]: " + arrayToString(new int[] {1, 10, 5, 6, 100}));
		System.out.println("[]: " + arrayToString(new int[] {}));
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
}
