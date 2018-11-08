package personal.alex.kudin.tasks.solutions.greeting.logic;

import java.time.LocalTime;
import java.util.ResourceBundle;

public interface Logic {

    /**
     * Returns the quantity of hours according to the current
     * time of the system
     * @return quantity of hours
     */
    int getTimeInHours();


    /**
     * Returns relative resource bundle according to the current
     * locale settings of the system
     * @return relative resource bundle
     */
    ResourceBundle getLocalBundle();


    /**
     * Creates a gretting message showing on a display according to the
     * quantity of the hours given as a parameter
     * @param hours quantity of hours
     * @param localBundle a bundle from witch to retreive relative message
     * @return created message
     */
    String createMessage(int hours, ResourceBundle localBundle);
}
