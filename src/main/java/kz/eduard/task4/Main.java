package kz.eduard.task4;

import kz.eduard.task4.action.*;
import kz.eduard.task4.entity.TextComponent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileNotFoundException;

public class Main {
    private static final Logger LOGGER = LogManager.getLogger(Main.class);
    private static final String PATH = "C:\\Users\\Админ\\IdeaProjects\\textoperations\\src\\main\\java\\kz\\eduard\\task4\\text\\text.txt";

    public static void main(String[] args) {
        FileToString reader = new FileToString(PATH);
        AbstractParser textParser = new TextParser();

        String text = "";
        try {
            text = reader.readFile();
        } catch (FileNotFoundException e) {
            LOGGER.error(e);
        }

        TextComponent textComposite = textParser.splitText(text);
        LOGGER.info("Собранный текст");
        LOGGER.info(textComposite.print());

        TextComponent paragraphComposite = textComposite.getChild(0);
        TextComponent sentenceComposite = paragraphComposite.getChild(0);

        SortTextComponents textSorter = new SortBySize();
        textSorter.sort(textComposite);
        LOGGER.info("Сортировка абзацев по количеству предложений");
        LOGGER.info(textComposite.print());

        SortTextComponents sentenceSorter = new SortBySize();
        sentenceSorter.sort(sentenceComposite);
        LOGGER.info("Сортировка слов по количеству букв");
        LOGGER.info(sentenceComposite.print());

        SortTextComponents paragraphSorter = new SortBySize();
        paragraphSorter.sort(paragraphComposite);
        LOGGER.info("Сортировка предложений по количеству слов");
        LOGGER.info(paragraphComposite.print());
    }
}
