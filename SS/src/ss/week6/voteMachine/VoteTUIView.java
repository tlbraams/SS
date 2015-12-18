package ss.week6.voteMachine;

import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;

public class VoteTUIView implements Observer, VoteView {
	
	private VoteMachine control;

	public VoteTUIView(VoteMachine vm) {
		control = vm;
	}
	
	public void start() {
		boolean doorgaan = true;
		Scanner in = new Scanner(System.in);
		Scanner lineScanner;
		while (doorgaan) {
			System.out.println("Please enter input: ");
			String line = in.nextLine();
			lineScanner = new Scanner(line);
			if (line.startsWith("HELP")) {
				System.out.println("Possible commands with explanation:");
				System.out.println("VOTE [party]: Places a vote for the given party.");
				System.out.println("ADD PARTY [party]: Adds the party to the list of parties.");
				System.out.println("VOTES: Shows the current vote tally.");
				System.out.println("PARTIES: Shows all the parties of this election.");
				System.out.println("EXIT: Closes the VoteMachine.");
				System.out.println("HELP: Prints this menu.");
			} else if (line.startsWith("EXIT")) {
				doorgaan = false;
			} else if (line.startsWith("PARTIES")) {
				control.getParties();
			} else if (line.startsWith("VOTES")) {
				control.getVotes();
			} else if (line.startsWith("ADD PARTY")) {
				lineScanner.next();
				lineScanner.next();
				control.addParty(lineScanner.next());
			} else if (line.startsWith("VOTE")) {
				lineScanner.next();
				control.vote(lineScanner.next());
			} else {
				showError("This is not a valid command. Enter HELP for a list of commands.");
			}
			
		}
		in.close();
	}
	
	public void showVotes(Map<String, Integer> votes) {
		for (String party: votes.keySet()) {
			System.out.println(party + ": " + votes.get(party));
		}
	}
	
	public void showParties(List<String> parties) {
		for (int i = 0; i < parties.size(); i++) {
			System.out.println(parties.get(i));
		}
	}
	
	public void showError(String error) {
		System.out.println(error);
	}


	public void update(Observable arg0, Object arg1) {
		if (arg1.equals("party")) {
			System.out.println("Parties updated.");
		} else if (arg1.equals("vote")) {
			System.out.println("Votes updated");
		}
		
	}
}
