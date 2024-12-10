import java.util.Scanner;

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
			
			if (next.equals("quit")) {
				System.out.println(userName + " has quitted. Final standings: \n" + status(player) + "\n" + status(enemy));
				return;
			} else if (next.equals("a") || next.equals("(a)") || next.equals("attack") || next.equals("(a)ttack")) {
				player.attack(enemy);
			} else if (next.equals("sp") || next.equals("(sp)") || next.equals("special") || next.equals("(sp)ecial")) {
				player.specialAttack(enemy);
			} else if (next.equals("(su)") || next.equals("support") || next.equals("(su)pport")) {
				player.support();
			} else {
				System.out.println("Please enter a valid type.");
			}
			
			if (enemy.getHP() < 0) {
				System.out.println("Success ! " + player + " has won.");
				return;
			}
			
			int rand = (int)(Math.random() * 4);
			if (rand == 0) enemy.attack(player);
			if (rand == 1) enemy.specialAttack(player);
			if (rand == 2) enemy.support();
			
			if (player.getHP() < 0) {
				System.out.println("Rats ! " + player + " has died. Try again ?");
				return;
			}
			
			System.out.println("Standings: \n" + status(player) + "\n" + status(enemy));
		}
	}
	
	private static String status (Adventurer a) {
		return a.getName() + ": " + a.getHP() + "/" + a.getmaxHP() + " HP, " + a.getSpecial() + "/" + a.getSpecialMax() + " " + a.getSpecialName();
	}
}
