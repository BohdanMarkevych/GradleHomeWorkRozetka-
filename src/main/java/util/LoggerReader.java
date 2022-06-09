package util;

import Decorator.Button;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class LoggerReader {
    public void readLog() {

        Logger logger = Logger.getLogger((LoggerReader.class).toString());
        FileHandler fh;

        try {

            fh = new FileHandler("src/test/MyLogFile.log");
            logger.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);

            // the following statement is used to log any messages
            logger.info("My first log");

        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        logger.info("");

    }
}
