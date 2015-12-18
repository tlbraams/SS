package ss.week6.voteMachine;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class PartyList extends Observable {

	/**
	 * Stores all the parties for the election.
	 */
	private List<String> parties;
	
	public PartyList() {
		parties = new ArrayList<String>();
	}
	
	/**
	 * Add a new party to the List.
	 * @param party the party to be added
	 */
	public void addParty(String party) {
		parties.add(party);
		setChanged();
		notifyObservers("party");
	}
	
	/**
	 * Checks if the partylist conatins the given party.
	 * @param party the party to be found
	 */
	public boolean hasParty(String party) {
		return parties.contains(party);
	}
	
	/**
	 * Return all the the parties in the list.
	 * @return the parties
	 */
	public List<String> getParties() {
		return parties;
	}
}
