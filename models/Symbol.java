package models;

public class Symbol {
    private char sys;
    private String colour;

    public char getSys() {
        return this.sys;
    }

    public void setSys(char sys) {
        this.sys = sys;
    }

    public String getColour() {
        return this.colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public Symbol(char sys, String colour) {
        this.sys = sys;
        this.colour = colour;
    }

}
