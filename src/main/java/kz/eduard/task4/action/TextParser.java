package kz.eduard.task4.action;

import kz.eduard.task4.entity.Composite;
import kz.eduard.task4.entity.TextComponent;
import kz.eduard.task4.entity.Type;

public class TextParser extends AbstractParser {
    private AbstractParser next = new ParagraphParser();
    private final static String PARAGRAPH_REGEX = "[\\n]";

    @Override
    public TextComponent splitText(String text) {
        Composite textComposite = new Composite(Type.TEXT);
        String[] paragraphs = text.split(PARAGRAPH_REGEX);
        for (int i = 0; i < paragraphs.length; i++) {
            textComposite.add(next.splitText(paragraphs[i]));
        }
        return textComposite;
    }
}