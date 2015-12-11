package ss.week5;

import java.util.HashSet;

public class NaiveStrategy implements Strategy {
	
	private final String name = "Naive";
	
	public NaiveStrategy() {
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public int determineMove(Board b, Mark m) {
		HashSet<Integer> board = new HashSet<Integer>();
		for (int i = 0; i < Board.DIM * Board.DIM; i++) {
			if (b.isEmptyField(i)) {
				board.add(i);
			}
		} 
		int result = -1;
		while (result == -1) {
			int random = (int) Math.floor(Math.random() * (Board.DIM * Board.DIM));
			if (board.contains(random)) {
				result = random;
			}
		}
		return result;
	}

}
