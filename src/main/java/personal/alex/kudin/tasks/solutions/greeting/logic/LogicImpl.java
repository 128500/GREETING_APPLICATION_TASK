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
    public int getTimeInHours(){
        return LocalTime.now().getHour();
    }

    @Override
    public ResourceBundle getLocalBundle() {

        Locale locale = Locale.getDefault();

        try {
            return ResourceBundle.getBundle("bundles.messages", locale, new UTF8Control());
        } catch (Exception e){
            LOGGER.error(e.getMessage(), e);
        }

        return ResourceBundle.getBundle("bundles.messages", Locale.ROOT);
    }

    @Override
    public String createMessage(int hour, ResourceBundle bundle) {
        String greeting = "";
        if (6 <= hour && hour < 9)greeting = bundle.getString("morning");
        if (9 <= hour && hour < 19)greeting = bundle.getString("day");
        if (19 <= hour && hour < 23)greeting = bundle.getString("evening");
        if ((0 <= hour &&  hour < 6) || hour == 23)greeting = bundle.getString("night");

        return greeting;
    }
}
