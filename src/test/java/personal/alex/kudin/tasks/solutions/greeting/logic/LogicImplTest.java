package personal.alex.kudin.tasks.solutions.greeting.logic;

import org.junit.Test;
import personal.alex.kudin.tasks.solutions.greeting.services.UTF8Control;

import java.util.*;

import static org.junit.Assert.*;

public class LogicImplTest {

    private static final ResourceBundle RU = ResourceBundle.getBundle("bundles.messages", new Locale("ru", "RU"), new UTF8Control());
    private static final ResourceBundle UA = ResourceBundle.getBundle("bundles.messages", new Locale("uk", "UA"), new UTF8Control());
    private static final ResourceBundle EN = ResourceBundle.getBundle("bundles.messages", new Locale("en", "US"));
    private static final ResourceBundle DEFAULT = ResourceBundle.getBundle("bundles.messages", Locale.ROOT);


    private List<String> russianMessages;
    private List<String> ukrainianMessages;
    private List<String> englishMessages;
    private List<String> defaultMessages;


    public LogicImplTest(){

        russianMessages = new ArrayList<>();
        ukrainianMessages = new ArrayList<>();
        englishMessages = new ArrayList<>();
        defaultMessages = new ArrayList<>();

        Set<String> keys = EN.keySet();
        for(String key : keys){
            russianMessages.add(RU.getString(key));
            ukrainianMessages.add(UA.getString(key));
            englishMessages.add(EN.getString(key));
            defaultMessages.add(DEFAULT.getString(key));
        }
    }

    private Logic logic  = new LogicImpl();


    @Test
    public void createMessage() throws Exception {
        String message = logic.createMessage();
        assertFalse(message.isEmpty());
    }

    @Test
    public void createMessage_Russian() throws Exception {
        Locale rus = new Locale("ru", "RU");
        Locale.setDefault(rus);
        String message = logic.createMessage();
        assertTrue(russianMessages.contains(message));
    }

    @Test
    public void createMessage_Ukrainian() throws Exception {
        Locale ukr = new Locale("uk", "UA");
        Locale.setDefault(ukr);
        String message = logic.createMessage();
        assertTrue(ukrainianMessages.contains(message));
    }


    @Test
    public void createMessage_English() throws Exception {
        Locale en = new Locale("en", "US");
        Locale.setDefault(en);
        String message = logic.createMessage();
        assertTrue(englishMessages.contains(message));
    }

    @Test
    public void createMessage_Default() throws Exception {
        Locale fr = new Locale("fr", "FR");
        Locale.setDefault(fr);
        String message = logic.createMessage();
        assertTrue(defaultMessages.contains(message));
    }
}