package models;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private int size;
    private List<List<Cell>> grid;

    public Board(int dimention) {
        this.size = dimention;
        this.grid = new ArrayList<>();

        for (int i = 0; i < dimention; i++) {
            this.grid.add(new ArrayList<>());
            for (int j = 0; j < dimention; j++) {
                this.grid.get(i).add(new Cell(i, j));
            }
        }
    }

    public void display() {
        for (List<Cell> row : grid) {
            for (Cell cell : row) {
                cell.printCell();
            }
            System.out.println("");
        }
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<List<Cell>> getGrid() {
        return grid;
    }

    public void setGrid(List<List<Cell>> grid) {
        this.grid = grid;
    }
}
