package kz.eduard.task4.action;

import kz.eduard.task4.entity.Composite;
import kz.eduard.task4.entity.TextComponent;
import kz.eduard.task4.entity.Type;

public class SentenceParser extends AbstractParser {
    private AbstractParser next = new LexemeParser();

    @Override
    public TextComponent splitText(String paragraph) {
        Composite paragraphComposite = new Composite(Type.PARAGRAPH);
        String[] lexemes = paragraph.split("[ *]");
        for (int i = 0; i < lexemes.length; i++) {
            paragraphComposite.add(next.splitText(lexemes[i]));
        }
        return paragraphComposite;
    }
}
