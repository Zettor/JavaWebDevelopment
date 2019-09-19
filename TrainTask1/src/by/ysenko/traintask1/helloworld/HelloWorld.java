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
    private static final Logger logger =
            LogManager.getLogger(HelloWorld.class);

    private HelloWorld() {
    }

    /**
     * @param arg is standart main parameters
     */
    public static void main(final String[] arg) {

        logger.info("Hello world");
        logger.info("Hello world");
    }

    public static Integer sum(final int a, final int b) {
        return a+b;
    }
}
