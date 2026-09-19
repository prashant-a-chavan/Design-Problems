package practicedp.designproblems.tictactoe.v1;

public enum Symbol {
    X('X'), O('O'), EMPTY('-');

    private final char displayChar;


    Symbol(char displayChar) {
        this.displayChar = displayChar;
    }

    public char getDisplayChar() {
        return displayChar;
    }
}
