package kz.eduard.task4.action;

import kz.eduard.task4.entity.Composite;
import kz.eduard.task4.entity.TextComponent;
import kz.eduard.task4.entity.Type;

public class SentenceParser extends AbstractParser {
    private AbstractParser next = new LexemeParser();
    private final static String LEXEME_REGEX = "[ *]";

    @Override
    public TextComponent splitText(String sentence) {
        Composite sentenceComposite = new Composite(Type.SENTENCE);
        String[] lexemes = sentence.trim().split(LEXEME_REGEX);
        for (int i = 0; i < lexemes.length; i++) {
            sentenceComposite.add(next.splitText(lexemes[i]));
        }
        return sentenceComposite;
    }
}
