package ss.week6.voteMachine;

import ss.week6.voteMachine.gui.*;

public class VoteMachine {
	
	/**
	 * Stores the <code>PartyList</code> and <code>VoteList</code> associated with this VoteMachine.
	 */
	private PartyList parties;
	private VoteList votes;
	private VoteView view;
	
	/**
	 * Creates a new <code>VoteMachine</code>.
	 */
	public VoteMachine() {
		parties = new PartyList();
		votes = new VoteList();
		view = new VoteGUIView(this);
		parties.addObserver(view);
		votes.addObserver(view);
	}
	
	public VoteMachine(String a) {
		parties = new PartyList();
		votes = new VoteList();
		view = new VoteGUIView(this);
		parties.addObserver(view);
		votes.addObserver(view);
	}
	/**
	 * Starts the view.
	 */
	public void start() {
		view.start();
	}
	
	/**
	 * Adds a party to the <code>VoteMachince</code>.
	 * @param party the party to be added
	 */
	public void addParty(String party) {
		parties.addParty(party);
	}
	
	/**
	 * Adds a vote for the given party.
	 * @param party the party that is voted on
	 */
	public void vote(String party) {
		if (parties.hasParty(party)) {
			votes.addVote(party);
		} else {
			view.showError("This party is not participating in this election.");
		}
	}
	
	public void getParties() {
		view.showParties(parties.getParties());
	}
	
	public void getVotes() {
		view.showVotes(votes.getVotes());
	}

	
	public static void main(String[] args) {
		VoteMachine voteMachine = new VoteMachine();
		voteMachine.start();
	}
}
