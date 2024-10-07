import java.util.Arrays;
public class ArrayDemo{
	public static void main(String[] args) {
		System.out.println("-----------testing arrToString()-----------\n");
		int[][] test = {{0, 1, 8 ,9}, {0, 0, 9}, {}};
		System.out.println("Expected " + Arrays.deepToString(test) + ": " + arrToString(test));
		System.out.println("Expected 27: " + arr2DSum(test));

		test = new int[][] {{},{},{}};
		System.out.println("Expected " + Arrays.deepToString(test) + ": " + arrToString(test));
		System.out.println("Expected 0: " + arr2DSum(test));
	
		test = new int[][] {{-10, -2, -10},{22},{-17, 1}};
		System.out.println("Expected " + Arrays.deepToString(test) + ": " + arrToString(test));
		System.out.println("Expected -16: " + arr2DSum(test));
		
		System.out.println("-----------testing countZeros2D()-----------\n");
		test = new int[][] {{9, 0, 10, 9}, {5, 6, 7}, {0}};
		System.out.println(Arrays.deepToString(test) + " expected 2: " + countZeros2D(test));
		
		test = new int[][] {{}, {}};
		System.out.println(Arrays.deepToString(test) + " expected 0: " + countZeros2D(test));
		
		test = new int[][] {{10, -9}, {4}};
		System.out.println(Arrays.deepToString(test) + "expected 0: " + countZeros2D(test));
		
		System.out.println("-----------testing htmlTable()-----------\n");
		test = new int[][] {{0, 9, 8, -9}, {0, 0}, {-1000}};
		System.out.println("input: " + Arrays.deepToString(test) + "\ntable:\n" + htmlTable(test));
		
		test = new int[][] {{}, {}, {}};
		System.out.println("input: " + Arrays.deepToString(test) + "\ntable:\n" + htmlTable(test));
		
		test = new int[][] {{4}, {-6, -7}, {11111}};
		System.out.println("input: " + Arrays.deepToString(test) + "\ntable:\n" + htmlTable(test));
	}

	public static String arrToString(int[] nums){
		if (nums.length == 0)
		return "[]";
		String result = "[";
		for (int i = 0; i < nums.length - 1; i++) {
			result += nums[i] + ", ";
		}
		
		return result + nums[nums.length - 1] + "]";
	}

	public static String arrToString(int[][] nums){
		String result = "[";
		for (int i = 0; i < nums.length; i++) {
			result += arrToString(nums[i]);

			if (i < nums.length - 1) {
				result += ", ";
			}
		}
		return result + "]";
	}
  
	public static int countZeros2D(int[][] nums) {
		int count = 0;
		
		for (int i = 0; i < nums.length; i++) {
			for (int n = 0; n < nums[i].length; n++) {
				if (nums[i][n] == 0) {
  				count ++;
				}
			}
		}
  	
		return count;
	}

	public static int arr2DSum (int [][] nums) {
		int total = 0;

		for (int i = 0; i < nums.length; i++) {
			for (int n = 0; n < nums[i].length; n++) {
				total += nums[i][n];
			}
		}

		return total;
	}

	public static int[][] swapRC (int [][] nums) {
		int[][] result = new int[nums[0].length][nums.length];
	
		for (int i = 0; i < nums[0].length; i++) {
			for (int n = 0; n < nums.length; n++) {
				result[i][n] = nums[n][i];
			}
		}
		return result;
	}
  
	public static void replaceNegative(int[][] vals) {
		for (int i = 0; i < vals.length; i ++) {
			for (int n = 0; n < vals[i].length; n++) {
				if (vals[i][n] < 0) {
					if (i == n) {
						vals[i][n] = 1;
					} else {
						vals[i][n] = 0;
					}
				}
			}
		}
	}
  
	public static int[][] copy(int[][] nums) {
		int[][] result = new int[nums.length][];
	  
		for (int i = 0; i < nums.length; i++) {
			int[] arr = new int[nums[i].length];
		  
			for (int n = 0; n < nums[i].length; n++) {
				arr[n] = nums[i][n];
			}
		  
			result[i] = arr;
		}
	  
		return result;
	}
  
	public static String tableRow (int[] nums) {
		String row = "<tr>";
		for (int i = 0; i < nums.length; i++) {
			row += "<td>" + nums[i] + "</td>";
		}
		return row + "</tr>";
	}
	
	public static String htmlTable(int[][] nums) {
		String table = "<table>";
		for (int i = 0; i < nums[i].length; i++) {
			table += tableRow(nums[i]);
		}
		
		return table + "</table>";
	}
}
