package personal.alex.kudin.tasks.solutions.greeting.runners;

import personal.alex.kudin.tasks.solutions.greeting.frames.VisualisationFrame;
import personal.alex.kudin.tasks.solutions.greeting.logic.Logic;
import personal.alex.kudin.tasks.solutions.greeting.logic.LogicImpl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.*;
import java.util.ResourceBundle;

/**
 * This class is a starting point of the application
 */

public class AppLauncher {

    private static final Logger LOGGER = LogManager.getLogger(AppLauncher.class.getName());

    public static void main(String[] args) {

        LOGGER.trace("Starting the application");
        try {
            Logic logic = new LogicImpl();
            int hour = logic.getTimeInHours();
            ResourceBundle bundle = logic.getLocalBundle();
            final String message = logic.createMessage(hour, bundle);

            SwingUtilities.invokeLater(() -> new VisualisationFrame(message));
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        } finally {
            LOGGER.trace("Running of the application is completed");
            LogManager.shutdown();
        }
    }
}
