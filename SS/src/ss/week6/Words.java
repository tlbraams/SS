package ss.week6;

import java.util.Scanner;

public class Words {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Please enter a sentence:");
		String input = in.nextLine();
		Scanner inputString = new Scanner(input);
		int count = 1;
		String word = inputString.next();
		if (word.equals("end")) {
			System.out.println("End of programme.");
		} else {
			System.out.println("Word " + count + ": " + word);
			count++;
			do {
				word = inputString.next();
				System.out.println("Word " + count + ": " + word);
				count++;
			} while (inputString.hasNext());
		}
		
	}
}
