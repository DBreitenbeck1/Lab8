import java.util.Scanner;

public class Lab8 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[] students = { "Rosamund Asulike", "Viola Twelnigh", "Orsino Watyuwil", "Andrew Ague", "Iago Otfellow",
				"Horatio Howlett", "Cesario Nodagerl", "Richard Detherd", "Portia Mervence", "Antonio Takurpik" };
		String[] hometowns = { "Novi, MI", "Livonia, MI", "Kyoto, JP", "Salzburg, AS", "Detroit, MI", "Houston, TX",
				"Orleans, FR", "Birmingham, AL", "Birmingham, GB", "Luxemberg, LX" };
		String[] favFoods = { "Veal Cutlets", "Fruit Salad", "Spare Ribs", "Roast Pork", "Hummus", "Pastries", "Salad",
				"Mutton Chops", "Omelette", "Salmon" };

		System.out.println("Welcome to our Java Class.");

		do {
			System.out.println("Which student would you like to learn more about?" + "(enter a number 1-10)");
			int entry = 0;

			boolean valid = false;

			do {
				entry = getEntry();
				try {
					System.out.println("Student " + (entry + 1) + " is " + students[entry] + ". "
							+ "What would you like to know about " + firstName(students[entry]) + "?");

				} catch (IndexOutOfBoundsException e) {
					System.out.println("Please enter a number between 1 and 10");
					continue;
				}

				valid = (entry < 10 && entry > -1);
			} while (!valid);

			do {
				String answer = getInfo();

				if (answer.contentEquals("hometown")) {
					System.out.println(students[entry] + "'s hometown is " + hometowns[entry]);
				} else if (answer.contentEquals("favorite food")) {
					System.out.println(students[entry] + "'s favorite food is " + favFoods[entry]);
				}
				System.out.println("Would you like to ask something else? Enter 'yes' or 'no'.");

			} while (moreInfo());

			System.out.println("Would you like to ask about someone else? Enter 'yes' or 'no'.");

		} while (moreInfo());

		System.out.println("Goodbye");

		
	}

	public static String firstName(String a) {
		String first;
		int space = a.indexOf(' ');
		if (space != -1) {
			first = a.substring(0, space);
		} else {
			first = a;
		}
		return first;
	}

	public static int getEntry() {
		Scanner scanner = new Scanner(System.in);
		boolean valid = false;
		int n = -1;

		do {

			if (scanner.hasNextInt()) {
				n = scanner.nextInt() - 1;
				valid = true;
			} else {
				System.out.println("Please enter a valid number");
				scanner.next();
			}
		} while (!valid);
		return n;

	}

	public static String getInfo() {
		boolean valid = false;
		Scanner scanner = new Scanner(System.in);
		String answer = "";

		do {
			System.out.println("Enter 'hometown' or 'favorite food'");
			String a = scanner.nextLine().trim().toLowerCase();
			valid = (a.contentEquals("hometown") || a.contentEquals("favorite food"));
			if (!valid) {
				System.out.println("That is not a valid response");
			} else {
				answer = a;
			}
		} while (!valid);
		
		return answer;
	}

	public static boolean moreInfo() {
		Scanner scanner = new Scanner(System.in);
		boolean rep = true;
		String b; 
		b = scanner.nextLine().trim().toLowerCase();
		if (b.startsWith("y")) {
			rep = true;
		} else if (b.startsWith("n")) {
			rep = false;
		} else {
			System.out.println("I did not understand that.");
			moreInfo();
		}
		
		return rep;

	}

}
