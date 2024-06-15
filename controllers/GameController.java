package controllers;

import java.util.List;

import TicTacToe.strategies.WinningStrategy;
import models.Game;
import models.GameState;
import models.Player;

public class GameController {
    public void makeMove(Game game) {
        game.makeMove();
    }

    public Game startGame(int dimention, List<Player> players, List<WinningStrategy> winningStategy) {
        return new Game(
                dimention,
                players,
                winningStategy);
    }

    public void displayBoard(Game game) {
        game.displayBoard();
    }

    public GameState checkState(Game game) {
        return game.getState();
    }

    public Player getWinner() {
        return null;
    }

    public void undo() {

    }
}

/*
 * Client -> GameController -> Service
 * 
 * 1. start the game
 * 2. while the game is IN_PROGRESS
 * 1. display the board
 * 2. make a move
 * 3. check the game state
 * 4. undo
 * 
 */