// As we did step 7, the rerun Driver code overwrote every instance of
// where we called getName() in the Animal.java file with "The Mighty [name]"
// when we called it with a Bird object.
// Bird b2 = new Animal() did not work because Bird is a subclass of Animal
// so, Bird can run all Animal methods and more but Animal cannot run all Bird methods
// thus, Animal = new Bird works but Bird = new Animal does not
public class Driver {
  public static void main(String[] args) {
    Animal a1 = new Animal("moo", 10, "Stacy");
    a1.speak();
    Bird b1 = new Bird("squawk", 2, "Squash", 4.0, "blue");
    b1.speak();
    // Bird b2 = new Animal("quack", 5, "Puddy");
    Animal a2 = new Bird("caw", 10, "Edgar", 2.0, "black");
  }
}
