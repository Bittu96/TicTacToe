package strategies;


import java.util.HashMap;

import models.Board;
import models.Move;
import models.Symbol;

public class DiagonalWinningStrategy implements WinningStrategy {
    HashMap<Symbol, Integer> d1Counts = new HashMap<>();
    HashMap<Symbol, Integer> d2Counts = new HashMap<>();

    @Override
    public boolean checkWinner(Move move, Board board) {
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();
        Symbol playerSymbol = move.getPlayer().getPlayerSymbol();

        if (row == col) {
            if (!d1Counts.containsKey(playerSymbol)) {
                d1Counts.put(playerSymbol, 0);
            }

            d1Counts.put(playerSymbol, d1Counts.get(playerSymbol) + 1);
            if (d1Counts.get(playerSymbol) == board.getSize()) {
                return true;
            }
        }

        if (row + col == board.getSize() - 1) {
            if (!d2Counts.containsKey(playerSymbol)) {
                d2Counts.put(playerSymbol, 0);
            }

            d2Counts.put(playerSymbol, d2Counts.get(playerSymbol) + 1);
            if (d2Counts.get(playerSymbol) == board.getSize()) {
                return true;
            }
        }

        return false;
    }
}
