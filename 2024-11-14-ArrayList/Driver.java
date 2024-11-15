import java.util.ArrayList;

public class Driver {
  public static void main (String[] args) {
    ArrayList<String> a1 = ArrayListPractice.createRandomArray(0);
    ArrayList<String> a2 = ArrayListPractice.createRandomArray(1);
    ArrayList<String> a3 = ArrayListPractice.createRandomArray(20);

    System.out.println(a1);
    ArrayListPractice.replaceEmpty(a1);
    System.out.println(a1);
    System.out.println(ArrayListPractice.makeReversedList(a1));

    System.out.println(a2);
    ArrayListPractice.replaceEmpty(a2);
    System.out.println(a2);
    System.out.println(ArrayListPractice.makeReversedList(a2));

    System.out.println(a3);
    ArrayListPractice.replaceEmpty(a3);
    System.out.println(a3);
    System.out.println(ArrayListPractice.makeReversedList(a3));



  }
}
