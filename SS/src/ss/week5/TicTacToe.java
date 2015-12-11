package ss.week5;

/**
 * Executable class for the game Tic Tac Toe. The game can be played against the
 * computer. Lab assignment Module 2
 * 
 * @author Theo Ruys
 * @version $Revision: 1.4 $
 */
public class TicTacToe {
	
    public static void main(String[] args) {
    	if (args.length >= 2) {
    		Player player1;
    		Player player2;
    		if (args[0].equals("-N")) {
    			player1 = new ComputerPlayer(Mark.OO);
    		} else if (args[0].equals("-S")) {
    			player1 = new ComputerPlayer(Mark.OO, new SmartStrategy());
    		} else {
    			player1 = new HumanPlayer(args[0], Mark.OO);
    		}
    		if (args[1].equals("-N")) {
    			player2 = new ComputerPlayer(Mark.XX);
    		} else if (args[1].equals("-S")) {
    			player2 = new ComputerPlayer(Mark.XX, new SmartStrategy());
    		} else {
    			player2 = new HumanPlayer(args[1], Mark.XX);
    		}
    		Game spel = new Game(player1, player2);
    		spel.start();
    	}
    }
}