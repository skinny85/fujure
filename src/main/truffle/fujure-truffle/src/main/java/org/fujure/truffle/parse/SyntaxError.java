package org.fujure.truffle.parse;

public final class SyntaxError {
    public final int line, column;
    public final String msg;

    public SyntaxError(int line, int column, String msg) {
        this.line = line;
        this.column = column;
        this.msg = msg;
    }
}
