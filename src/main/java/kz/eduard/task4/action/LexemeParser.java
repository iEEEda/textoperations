package kz.eduard.task4.action;

import kz.eduard.task4.entity.Composite;
import kz.eduard.task4.entity.Leaf;
import kz.eduard.task4.entity.TextComponent;
import kz.eduard.task4.entity.Type;

public class LexemeParser extends AbstractParser {
    @Override
    public TextComponent splitText(String lexeme) {
        Composite lexemeComposite = new Composite(Type.LEXEME);
        String[] symbols = lexeme.split("\\t*");
        for (int i = 0; i < symbols.length; i++) {
            lexemeComposite.add(new Leaf(symbols[i].charAt(0)));
        }
        return lexemeComposite;
    }
}
