import java util.Scanner;

public class Game {
	public static void main(String[]args) {
		Scanner in = new Scanner(System.in);
		
		Warrior enemy = new Warrior("enemy");
		
		System.out.println("Enter username");
		String userName = in.nextLine();
		System.out.println("Username is: " + userName);
		
		CodeWarrior player = new CodeWarrior(userName);
		
		while (true) {
			System.out.println("Type: (a)ttack / (sp)ecial / (su)pport / quit");
			String next = in.nextLine();
			
			if (!(validInput(next))) {
				System.out.println("Please try again");
			} else {
				if (next.equals("quit")) {
					System.out.println(userName + " has quitted. Final standings: \n" + status(player) + "\n" + status(enemy));
				}
			}
		}
	}
	
	private static boolean validInput(String s) {
		return s.equals("a") || s.equals("(a)") || s.equals("attack") || s.equals"(a)ttack" || s.equals("sp") || s.equals("(sp)") || s.equals("special") || s.equals"(sp)ecial" || s.equals("su") || s.equals("(su)") || s.equals("support") || s.equals"(su)pport" || s.equals("quit");
	}
	private static String status (Adventurer a) {
		return a.getName() + ": " + a.getHP() + "/" + a.getMaxHP() + " HP, " + a.getSpecial() + "/" + a.getSpecialMax() + " " + getSpecialName();
	}
}
