package personal.alex.kudin.tasks.solutions.greeting.logic;

import org.junit.Test;
import personal.alex.kudin.tasks.solutions.greeting.services.UTF8Control;

import java.util.Locale;
import java.util.ResourceBundle;

import static org.junit.Assert.*;

public class LogicImplTest {

    private static final ResourceBundle RU = ResourceBundle.getBundle("bundles.messages", new Locale("ru", "RU"), new UTF8Control());
    private static final ResourceBundle UA = ResourceBundle.getBundle("bundles.messages", new Locale("uk", "UA"), new UTF8Control());
    private static final ResourceBundle EN = ResourceBundle.getBundle("bundles.messages", new Locale("en", "US"));
    private static final ResourceBundle NONE = ResourceBundle.getBundle("bundles.messages", Locale.ROOT);

    private Logic logic  = new LogicImpl();

    @Test
    public void getTimeInHours() throws Exception {

        int hours = logic.getTimeInHours();
        assertTrue(hours > 0 && hours <= 23);
    }

    @Test
    public void getLocalBundle() throws Exception {
        assertTrue(logic.getLocalBundle() != null);
    }

    @Test
    public void createMessage() throws Exception {
    }

    @Test
    public void createMessage_Morning() throws Exception {
        int morning_hours = (int)Math.round(Math.random() * 2) + 6;
        String ru_mes = logic.createMessage(morning_hours, RU);
        assertTrue(ru_mes.equals("Доброе утро, Мир!"));

        String ua_mes = logic.createMessage(morning_hours, UA);
        assertTrue(ua_mes.equals("Доброго ранку, Світ!"));

        String en_mes = logic.createMessage(morning_hours,EN);
        assertTrue(en_mes.equals("Good morning, World!"));

        String def_mes = logic.createMessage(morning_hours, NONE);
        assertTrue(def_mes.equals("Good morning, World!"));
    }

    @Test
    public void createMessage_Day() throws Exception {
        int day_hours = (int)Math.round(Math.random() * 9) + 9;
        String ru_mes = logic.createMessage(day_hours, RU);
        assertTrue(ru_mes.equals("Добрый день, Мир!"));

        String ua_mes = logic.createMessage(day_hours, UA);
        assertTrue(ua_mes.equals("Добридень, Світ!"));

        String en_mes = logic.createMessage(day_hours, EN);
        assertTrue(en_mes.equals("Good afternoon, World!"));

        String def_mes = logic.createMessage(day_hours, NONE);
        assertTrue(def_mes.equals("Good afternoon, World!"));
    }


    @Test
    public void createMessage_Evening() throws Exception {
        int eve_hours = (int)Math.round(Math.random() * 3) + 19;
        String ru_mes = logic.createMessage(eve_hours, RU);
        assertTrue(ru_mes.equals("Добрый вечер, Мир!"));

        String ua_mes = logic.createMessage(eve_hours, UA);
        assertTrue(ua_mes.equals("Доброго вечора, Світ!"));

        String en_mes = logic.createMessage(eve_hours, EN);
        assertTrue(en_mes.equals("Good evening, World!"));

        String def_mes = logic.createMessage(eve_hours, NONE);
        assertTrue(def_mes.equals("Good evening, World!"));
    }

    @Test
    public void createMessage_Night() throws Exception {
        int night_hours = (int)Math.round(Math.random() * 5);

        String ru_mes = logic.createMessage(night_hours, RU);
        assertTrue(ru_mes.equals("Доброй ночи, Мир!"));

        String ua_mes = logic.createMessage(night_hours, UA);
        assertTrue(ua_mes.equals("Доброї ночі, Світ!"));

        String en_mes = logic.createMessage(night_hours, EN);
        assertTrue(en_mes.equals("Good night, World!"));

        String def_mes = logic.createMessage(night_hours, NONE);
        assertTrue(def_mes.equals("Good night, World!"));
    }
}