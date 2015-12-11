package ss.week5;

public interface Strategy {

	/**
	 * Returns the name of the <code>Strategy</code>.
	 * @return the name
	 */
	public String getName();
	
	/**
	 * Returns a legal move given the <code>Board</code> b for the player with <code>Mark</code>.
	 * @param b the board
	 * @param m the mark
	 * @return a legal move
	 */
	public int determineMove(Board b, Mark m);
}
