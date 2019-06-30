package kz.eduard.task4.action;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileToString {
    private static final Logger LOGGER = LogManager.getLogger(FileToString.class);
    private String path;
    private StringBuilder text;
    public FileToString(String path) {
        this.path = path;
    }

    public String readFile()throws FileNotFoundException {

        text = new StringBuilder();

        try {
            FileReader fileReader = new FileReader(path);
            int c = fileReader.read();
            while(c != -1){
                text.append((char)c);
                c = fileReader.read();
            }
        } catch (FileNotFoundException e) {
            LOGGER.error(e);
        } catch (IOException e) {
            LOGGER.error(e);
        }
        return text.toString();
    }
}
