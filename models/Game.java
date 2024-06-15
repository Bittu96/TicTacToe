package models;

import java.util.ArrayList;
import java.util.List;

import TicTacToe.strategies.WinningStrategy;

public class Game {
    Board board;
    List<Player> players;
    List<Move> moves;
    Player winner;
    int nextPlayerIndex;
    GameState gameState;
    List<WinningStrategy> winningStrategies;

    public Game(int dimention, List<Player> players, List<WinningStrategy> winningStrategy) {
        this.board = new Board(dimention);
        this.players = players;
        this.winningStrategies = winningStrategy;
        this.nextPlayerIndex = 0;
        this.moves = new ArrayList<>();
        this.winner = null;
        this.gameState = GameState.IN_PROGRESS;
    }

    public void displayBoard() {
        this.board.display();
    }

    public void makeMove() {
        Player currentPlayer = this.players.get(nextPlayerIndex);
        System.out.println("It's " + currentPlayer.getName() + "'s turn! Please make your move");
        Move currentMove = currentPlayer.makeMove(this.board);

        if (!validateMove(currentMove)) {
            System.out.println("invalid move!");
            return;
        }

        int row = currentMove.getCell().getRow();
        int col = currentMove.getCell().getCol();

        Cell cellToChange = board.getGrid().get(row).get(col);
        cellToChange.setCellState(CellState.FILLED);
        cellToChange.setSymbol(currentPlayer.getPlayerSymbol());

        this.moves.add(currentMove);

        this.nextPlayerIndex += 1;
        this.nextPlayerIndex %= players.size();

        if (checkWinner(currentMove, this.board)) {
            this.gameState = GameState.SUCCESS;
            this.winner = currentPlayer;
        } else if (this.moves.size() == this.board.getSize() * this.board.getSize()) {
            this.gameState = GameState.DRAW;
        }

    }

    private boolean checkWinner(Move move, Board board) {
        for (WinningStrategy winningStategy : winningStrategies) {
            if (winningStategy.checkWinner(move, board)) {
                return true;
            }
        }

        return false;
    }

    public boolean validateMove(Move move) {
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();

        // check dimentions check todo
        if (!(row >= 0 && row < this.board.getSize()) || !(col >= 0 && col < this.board.getSize())) {
            return false;
        }

        // check for empty cell
        if (!this.board.getGrid().get(row).get(col).getCellState().equals(CellState.EMPTY)) {
            return false;
        }

        return true;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public int getNextPlayerIndex() {
        return nextPlayerIndex;
    }

    public void setNextPlayerIndex(int nextPlayerIndex) {
        this.nextPlayerIndex = nextPlayerIndex;
    }

    public GameState getState() {
        return this.gameState;
    }

    public void setState(GameState gameState) {
        this.gameState = gameState;
    }

}
