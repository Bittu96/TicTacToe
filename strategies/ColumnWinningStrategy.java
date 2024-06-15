package strategies;


import java.util.HashMap;

import models.Board;
import models.Move;
import models.Symbol;

public class ColumnWinningStrategy implements WinningStrategy {
    HashMap<Integer, HashMap<Symbol, Integer>> counts = new HashMap<>();

    @Override
    public boolean checkWinner(Move move, Board board) {
        int col = move.getCell().getCol();
        Symbol playerSymbol = move.getPlayer().getPlayerSymbol();

        if (!counts.containsKey(col)) {
            counts.put(col, new HashMap<>());
        }

        HashMap<Symbol, Integer> colCounts = counts.get(col);

        if (!colCounts.containsKey(playerSymbol)) {
            colCounts.put(playerSymbol, 0);
        }

        colCounts.put(playerSymbol, colCounts.get(playerSymbol) + 1);

        if (colCounts.get(playerSymbol) == board.getSize()) {
            return true;
        }

        return false;
    }
}
