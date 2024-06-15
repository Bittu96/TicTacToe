package TicTacToe.strategies;

import java.util.List;

import models.Board;
import models.Cell;
import models.CellState;
import models.Move;

public class EasyBotPlayingStategy implements BotPlayingStrategy {
    @Override
    public Move makeMove(Board board) {
        List<List<Cell>> grid = board.getGrid();
        for (List<Cell> row : grid) {
            for (Cell cell : row) {
                if (cell.getCellState() == CellState.EMPTY) {
                    System.err.println("Bot made a move.");
                    return new Move(new Cell(cell.getRow(), cell.getCol()), null);
                }
            }
        }
        return null;
    }
}