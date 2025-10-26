package lld.snakeandladder;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Anirudh
 * @since 26/10/25
 */
public class Game {

    Board board;
    Dice dice;
    Player winner;
    Deque<Player> players = new LinkedList<>();

    public Game() {
        initGame();
    }

    private void initGame() {
        board = new Board(10, 5, 5);
        dice = new Dice(1);
        winner = null;
        addPlayers();
    }

    private void addPlayers() {
        Player p1 = new Player("P1", 0);
        Player p2 = new Player("P2", 0);
        players.add(p1);
        players.add(p2);
    }

    public void startGame() {
        while (winner == null) {
            Player playerTurn = findPlayerTurn();
            System.out.println("Player turn:" + playerTurn.id + " current position is: " + playerTurn.currentPosition);
            int diceNum = dice.rollDice();
            int playerNewPosition = playerTurn.currentPosition + diceNum;
            playerNewPosition = jumpCheck(playerNewPosition);
            playerTurn.currentPosition = playerNewPosition;
            System.out.println("Player turn:" + playerTurn.id + " new Position is: " + playerNewPosition);


            if (playerNewPosition > board.cells.length * board.cells.length - 1) {
                winner = playerTurn;
            }
        }
        System.out.println("\n===> The Winner is:" + winner.id);
    }

    private int jumpCheck(int playerNewPosition) {
        if (playerNewPosition > board.cells.length * board.cells.length - 1)
            return Math.min(playerNewPosition,100);
        Cell cell = board.getCell(playerNewPosition);
        if (cell.jump != null && cell.jump.start == playerNewPosition) {
            String jumpBy = (cell.jump.start < cell.jump.end) ? "Ladder" : "Snake";
            System.out.println("[+] Jump done by: " + jumpBy);

            return cell.jump.end;
        }
        return playerNewPosition;
    }

    private Player findPlayerTurn() {
        Player player = players.removeFirst();
        players.addLast(player);
        return player;
    }
}
