package ss.week6.voteMachine;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

public class VoteList extends Observable {
	
	/**
	 * Stores all the parties that have been voted on with their votes.
	 */
	private Map<String, Integer> votes;

	/**
	 * Creates a new <code>VoteList</code>.
	 */
	public VoteList() {
		votes = new HashMap<String, Integer>();
	}
	
	/**
	 * Adds a vote for the given party.
	 * @param party the party that is voted on
	 */
	public void addVote(String party) {
		int voteCount = 0;
		if (votes.containsKey(party)) {
			voteCount = votes.get(party);
		}
		votes.put(party, voteCount + 1);
		setChanged();
		notifyObservers("vote");
	}
	
	/**
	 * Returns all the parties that have been voted on with their votes.
	 */
	public Map<String, Integer> getVotes() {
		return votes;
	}
}
