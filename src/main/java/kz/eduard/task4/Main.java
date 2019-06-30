package kz.eduard.task4;

import kz.eduard.task4.action.FileToString;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileNotFoundException;

public class Main {
    private static final Logger LOGGER = LogManager.getLogger(Main.class);
    public static final String PATH = "C:\\Users\\Админ\\IdeaProjects\\textoperations\\src\\main\\java\\kz\\eduard\\task4\\text\\text.txt";

    public static void main(String[] args) {
        FileToString reader = new FileToString(PATH);
        String res[] = {};
        try {
            String text = reader.readFile();
            res = text.split("\\t*");
        } catch (FileNotFoundException e) {
            LOGGER.error(e);
        }
        for (int i = 0; i < res.length; i++) {
            LOGGER.info(res[i]);
            LOGGER.info("\n");
            LOGGER.info("---");
        }
    }
}
