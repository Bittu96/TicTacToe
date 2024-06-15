package strategies;


import java.util.HashMap;

import models.Board;
import models.Move;
import models.Symbol;

public class RowWinningStrategy implements WinningStrategy {
    HashMap<Integer, HashMap<Symbol, Integer>> counts = new HashMap<>();

    @Override
    public boolean checkWinner(Move move, Board board) {
        int row = move.getCell().getRow();
        Symbol playerSymbol = move.getPlayer().getPlayerSymbol();

        if (!counts.containsKey(row)) {
            counts.put(row, new HashMap<>());
        }

        HashMap<Symbol, Integer> rowCounts = counts.get(row);

        if (!rowCounts.containsKey(playerSymbol)) {
            rowCounts.put(playerSymbol, 0);
        }

        rowCounts.put(playerSymbol, rowCounts.get(playerSymbol) + 1);

        if (rowCounts.get(playerSymbol) == board.getSize()) {
            return true;
        }

        return false;
    }
}
