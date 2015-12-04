package ss.week4.tictactoe;

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
    		Player player1 = new HumanPlayer(args[0], Mark.OO);
    		Player player2 = new HumanPlayer(args[1], Mark.XX);
    		Game spel = new Game(player1, player2);
    		spel.start();
    	}
    }
}