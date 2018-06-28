package org.fujure.truffle.nodes;

import org.apache.commons.text.StringEscapeUtils;

public final class CharLiteralExprNode extends LiteralExprNode {
    private static int parseCharaLiteral(String value) {
        // first, strip the surrounding single quotes
        String character = value.substring(1, value.length() - 1);
        return (int) StringEscapeUtils.unescapeJava(character).charAt(0);
    }

    public CharLiteralExprNode(String value) {
        super(parseCharaLiteral(value));
    }
}
