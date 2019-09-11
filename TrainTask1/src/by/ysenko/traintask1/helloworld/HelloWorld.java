package by.ysenko.traintask1.helloworld;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * My simple class.
 */
final class HelloWorld {

    /**
     * Logger for output.
     */
    private static final Logger LOGGER = LogManager.getRootLogger();

    private HelloWorld() {
    }

    /**
     * @param arg is standart main parameters
     */
    public static void main(final String[] arg) {
        LOGGER.info("Hello world");
    }
}
