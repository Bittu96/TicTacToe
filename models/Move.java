package models;

public class Move {
    private Cell cell;
    private Player player;

    public Cell getCell() {
        return this.cell;
    }

    public void setCell(Cell cell) {
        this.cell = cell;
    }

    public Player getPlayer() {
        return this.player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Move(Cell cell, Player player) {
        this.cell = cell;
        this.player = player;
    }
}
