package kz.eduard.task4.action;

import kz.eduard.task4.entity.Composite;
import kz.eduard.task4.entity.TextComponent;
import kz.eduard.task4.entity.Type;

public class ParagraphParser extends AbstractParser {
    private AbstractParser next = new SentenceParser();
    private final static String SENTENCE_REGEX = "[?!.\\r]";

    @Override
    public TextComponent splitText(String paragraph) {
        Composite paragraphComposite = new Composite(Type.PARAGRAPH);
        String[] sentences = paragraph.split(SENTENCE_REGEX);
        for (int i = 0; i < sentences.length; i++) {
            paragraphComposite.add(next.splitText(sentences[i]));
        }
        return paragraphComposite;
    }
}
