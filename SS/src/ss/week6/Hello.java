package ss.week6;

import java.util.Scanner;

public class Hello {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String answer;
		do {
			System.out.println("What is your name?");
			answer = in.nextLine();
			System.out.println("Hello " + answer);
		} while (!answer.equals(""));
		in.close();

	}

}
