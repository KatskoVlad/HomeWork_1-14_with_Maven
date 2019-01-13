package homeWork.homeWork14;

import org.apache.log4j.Logger;

public class MyClassLogger {
    private static final Logger logger = Logger.getLogger(""+MyClassLogger.class);

    public static void main(String[] args) {
        logger.info("Load info logger class");
        logger.error("Test error");
    }
}
