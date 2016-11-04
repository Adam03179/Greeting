package ua.gerasymenko;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

import static org.junit.Assert.assertEquals;

public class GreetingGeneratorTest {

    private SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    private GreetingGenerator generator;
    private ResourceBundle bundle;
    private Locale locale;


    @Test
    public void morningChoiceTest() throws ParseException {
        Date morning = dateFormat.parse("07:30:55");
        locale = Locale.US;
        bundle = ResourceBundle.getBundle("greetingBundle", locale);
        generator = new GreetingGenerator();
        assertEquals("Good morning, World!", generator.greetingsChoice(bundle, morning));

    }

    @Test
    public void dayChoiceTest() throws ParseException {
        Date day = dateFormat.parse("11:55:55");
        locale = Locale.US;
        bundle = ResourceBundle.getBundle("greetingBundle", locale);
        generator = new GreetingGenerator();
        assertEquals("Good day, World!", generator.greetingsChoice(bundle, day));

    }

    @Test
    public void eveningChoiceTest() throws ParseException {
        Date evening = dateFormat.parse("22:59:00");
        locale = Locale.US;
        bundle = ResourceBundle.getBundle("greetingBundle", locale);
        generator = new GreetingGenerator();
        assertEquals("Good evening, World!", generator.greetingsChoice(bundle, evening));

    }

    @Test
    public void nightChoiceTest() throws ParseException {
        Date night = dateFormat.parse("23:44:85");
        locale = Locale.US;
        bundle = ResourceBundle.getBundle("greetingBundle", locale);
        generator = new GreetingGenerator();
        assertEquals("Good night, World!", generator.greetingsChoice(bundle, night));

    }


    @Test(expected = ParseException.class)
    public void parseExceptionTest() throws ParseException {
        Date errorDate = dateFormat.parse("test");
        locale = Locale.US;
        bundle = ResourceBundle.getBundle("greetingBundle", locale);
        generator = new GreetingGenerator();
        generator.greetingsChoice(bundle, errorDate);

    }

}