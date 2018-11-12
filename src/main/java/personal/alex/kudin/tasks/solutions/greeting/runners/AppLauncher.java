package personal.alex.kudin.tasks.solutions.greeting.runners;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import personal.alex.kudin.tasks.solutions.greeting.logic.Logic;
import personal.alex.kudin.tasks.solutions.greeting.logic.LogicImpl;

/**
 * This class is a starting point of the application
 */

public class AppLauncher {

    private static final Logger LOGGER = LogManager.getLogger(AppLauncher.class.getName());

    public static void main(String[] args) {

        LOGGER.trace("Starting the application");
        try {
            Logic logic = new LogicImpl();
            String message = logic.createMessage();
            System.out.println(message);

        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        } finally {
            LOGGER.trace("Running of the application is completed");
            LogManager.shutdown();
        }
    }
}
