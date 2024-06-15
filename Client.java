import java.util.ArrayList;
import java.util.List;

import TicTacToe.strategies.ColumnWinningStrategy;
import TicTacToe.strategies.DiagonalWinningStrategy;
import TicTacToe.strategies.RowWinningStrategy;
import TicTacToe.strategies.WinningStrategy;
import controllers.GameController;
import models.Bot;
import models.BotDifficultyLevel;
import models.Game;
import models.GameState;
import models.Player;
import models.PlayerType;
import models.Symbol;

public class Client {
    public static void main(String[] args) {
        // create controller
        GameController gameController = new GameController();

        try {
            // add player for the game
            List<Player> players = new ArrayList<>();
            players.add(new Player(1, "Mrudul", PlayerType.HUMAN, new Symbol('X', "Green")));
            players.add(new Bot(2, "Botter", BotDifficultyLevel.EASY, new Symbol('O', "Blue")));

            // add winning strategies
            List<WinningStrategy> winningStategies = new ArrayList<>();
            winningStategies.add(new RowWinningStrategy());
            winningStategies.add(new ColumnWinningStrategy());
            winningStategies.add(new DiagonalWinningStrategy());

            // start the game
            Game game = gameController.startGame(3, players, winningStategies);
            System.out.println("**** Game Started! ****");

            gameController.displayBoard(game);
            while (gameController.checkState(game).equals(GameState.IN_PROGRESS)) {
                gameController.makeMove(game);
                gameController.displayBoard(game);
            }

            if (gameController.checkState(game).equals(GameState.SUCCESS)) {
                System.out.println("**** GAME OVER ****");
                System.out.println("Winner is " + game.getWinner().getName() + "!!!");
            } else {
                System.out.println("**** GAME OVER ****");
                System.out.println("Game ended in draw");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Something went wrong!, Please restart the game.");
        }

    }
}