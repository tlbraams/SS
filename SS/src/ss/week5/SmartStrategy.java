package ss.week5;

public class SmartStrategy implements Strategy {
	
	private final String name = "Smart";

	public SmartStrategy() {
	}
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public int determineMove(Board b, Mark m) {
		int result = -1;
		if (b.isEmptyField(Board.DIM / 2, Board.DIM / 2)) {
			result = b.index(Board.DIM / 2, Board.DIM / 2);
		} else {
			for (int i = 0; i < Board.DIM * Board.DIM && result == -1; i++) {
				Board board = b.deepCopy();
				if (board.isEmptyField(i)) {
					board.setField(i, m);
					if (board.isWinner(m)) {
						result = i;
					} else {
						board.setField(i, m.other());
						if (board.isWinner(m.other())) {
							result = i;
						}
					}
				}
			}
			if (result == -1) {
				result = (new NaiveStrategy()).determineMove(b, m);
			}
		}
		return result;
	}

}
