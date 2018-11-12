package personal.alex.kudin.tasks.solutions.greeting.logic;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import personal.alex.kudin.tasks.solutions.greeting.services.UTF8Control;

import java.time.LocalTime;
import java.util.Locale;
import java.util.ResourceBundle;

public class LogicImpl implements Logic {

    private final static Logger LOGGER = LogManager.getLogger(LogicImpl.class.getName());

    @Override
    public String createMessage() {

        /* Get the locale time in hours */
        int hours = LocalTime.now().getHour();

        /* Get the locale bundle according to the system locale */
        Locale locale = Locale.getDefault();
        ResourceBundle localeBundle = ResourceBundle.getBundle("bundles.messages", Locale.ROOT);
        try {
            localeBundle = ResourceBundle.getBundle("bundles.messages", locale, new UTF8Control());
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }

        /* Get message from the respective locale bundle */
        String greeting = "";
        if (6 <= hours && hours < 9) greeting = localeBundle.getString("morning");
        if (9 <= hours && hours < 19) greeting = localeBundle.getString("day");
        if (19 <= hours && hours < 23) greeting = localeBundle.getString("evening");
        if ((0 <= hours && hours < 6) || hours == 23) greeting = localeBundle.getString("night");

        return greeting;
    }
}
