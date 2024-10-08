public class ArrayMethods{
// Alvaro Hernandez Jenaro - Alvaroh8@nycstudents.net
// Sandra Gao sandrag44@nycstudents.net

  public static void main(String[] args) {
	System.out.println("-----------testing arrToString, arr2DSum-----------\n");
    int[][] test = {{0, 1, 8 ,9}, {0, 0, 9}, {}};
    System.out.println("Expected [[0, 1, 8, 9], [0, 0, 9]]: " + arrToString(test));
    System.out.println("Expected 27: " + arr2DSum(test));

    test = new int[][] {{},{},{}};
    System.out.println("Expected [[], [], []]: " + arrToString(test));
    System.out.println("Expected 0: " + arr2DSum(test));

    test = new int[][] {{-10, -2, -10},{22},{-17, 1}};
    System.out.println("Expected [[-10, -2, -10], [22], [-17, 1]]: " + arrToString(test));
    System.out.println("Expected -16: " + arr2DSum(test));
	
	System.out.println("\n-----------testing swapRC()-----------\n");
	test = new int[][] {{0, 0, 1}, {1, -10, 20}, {4, 6, 9}, {10, 20, 127}};
	System.out.println("Expected [[0, 1, 4, 10], [0, -10, 6, 20], [1, 20, 9, 127]]: " + arrToString(swapRC(test)));
	
	test = new int[][] {{10, -2, 4}};
	System.out.println("Expected [[10], [-2], [4]]: " + arrToString(swapRC(test)));
	
	test = new int[][] {{4}, {20}, {-10}};
	System.out.println("Expected [[4, 20, -10]]: " + arrToString(swapRC(test)));
	
	System.out.println("\n-----------testing replaceNegative()-----------\n");
	test = new int[][] {{0, 0, 3, 1}, {1, -10, 20, 4, -5}, {-4, -6, -9}};
	replaceNegative(test);
	System.out.println("Expected [[0, 0, 3, 1], [1, 1, 20, 4, 0], [0, 0, 1]]: " + arrToString(test));
	
	System.out.println("\n-----------testing copy()-----------\n");
	test = new int[][] {{0, -9, 10, 8}, {8, 8, 10, 11, -8}, {0, 0, 9, 10, 81, -100}};
	System.out.println("Original: " + arrToString(test));
	int[][] copy = copy(test);
	test[0][1] = 10;
	System.out.println("Check link: " + arrToString(test));
	System.out.println("Copy: " + arrToString(copy) + "\n");
	
	test = new int[][] {{10, 10, -19, -100}, {-4, -10, 15, 17}, {21, 23, 77, 89}};
	System.out.println("Original: " + arrToString(test));
	copy = copy(test);
	test[2][3] = 10;
	System.out.println("Check link: " + arrToString(test));
	System.out.println("Copy: " + arrToString(copy) + "\n");
	
	test = new int[][] {{10}, {}, {-100}};
	System.out.println("Original: " + arrToString(test));
	copy = copy(test);
	test[0][0] = -20;
	System.out.println("Check link: " + arrToString(test));
	System.out.println("Copy: " + arrToString(copy) + "\n");
  }

  public static String arrToString(int[] nums){
    if (nums.length == 0)
      return "[]";
    String result = "[";
    for (int i = 0; i < nums.length - 1; i++)
    {
      result += nums[i] + ", ";
    }
    return result + nums[nums.length - 1] + "]";
  }

  public static String arrToString(int[][] nums){
      String result = "[";
      for (int i = 0; i < nums.length; i++)
      {
        result += arrToString(nums[i]);

        if (i < nums.length - 1) {
          result += ", ";
        }
      }
      return result + "]";
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
}
