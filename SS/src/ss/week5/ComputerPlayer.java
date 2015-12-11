package ss.week5;

public class ComputerPlayer extends Player {
	
	private Strategy strat;

	// ------ Constructor: --------
	
	/**
	 * Creates a new <code>ComputerPlayer</code> with the given <code>Mark</code> and a 
	 * 					<code>NaiveStrategy</code>.
	 * @param mark the given <code>Mark</code>
	 */
	public ComputerPlayer(Mark mark) {
		super("NaiveStrategy-" + mark.toString(), mark);
		strat = new NaiveStrategy();
	}
	/**
	 * Creates a new <code>ComputerPlayer</code> with the given <code>Mark</code> and the given
	 * 					<code>Strategy</code>.
	 * @param mark the given <code>Mark</code>
	 * @param strategy the given <code>Strategy</code>
	 */
	public ComputerPlayer(Mark mark, Strategy strategy) {
		super(strategy.getName() + "-" + mark.toString(), mark);
		strat = strategy;
	}
	
	// ------- Queries: -------
	/**
	 * Gives the <code>Strategy</code> associated with this <code>ComputerPlayer</code>.
	 * @return the <code>Strategy</code>
	 */
	public Strategy getStrategy() {
		return strat;
	}
	
	// ------- Commands: -------
	
	/**
	 * Changes the <code>Strategy</code> of this <code>ComputerPlayer</code> to the given
	 * 				 <code>Strategy</code>.
	 * @param strategy the given strategy
	 */
	public void setStrategy(Strategy strategy) {
		strat = strategy;
	}
	
	/**
	 * Determines a move for the given <code>Board</code> using the <code>Strategy</code>.
	 * @param board the given board
	 */
	@Override
	public int determineMove(Board board) {
		return strat.determineMove(board, this.getMark());
	}

}
