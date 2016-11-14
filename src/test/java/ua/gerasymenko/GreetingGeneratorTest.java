package ua.gerasymenko;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

import static org.junit.Assert.assertEquals;
import static ua.gerasymenko.GreetingGenerator.greetingsChoice;


public class GreetingGeneratorTest {

    private SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    private Locale locale = Locale.US;
    private ResourceBundle bundle = ResourceBundle.getBundle("greetingBundle", locale);

    public GreetingGeneratorTest() throws ParseException {
    }


    @Test
    public void morningBeginChoiceTest() throws ParseException {
        Date morning = dateFormat.parse("06:00:00");
        assertEquals("Good morning, World!", greetingsChoice(bundle, morning));

    }

    @Test
    public void morningEndChoiceTest() throws ParseException {
        Date morning = dateFormat.parse("08:59:59");
        assertEquals("Good morning, World!", greetingsChoice(bundle, morning));

    }

    @Test
    public void dayBeginChoiceTest() throws ParseException {
        Date day = dateFormat.parse("09:00:00");
        assertEquals("Good day, World!", greetingsChoice(bundle, day));

    }

    @Test
    public void dayEndChoiceTest() throws ParseException {
        Date day = dateFormat.parse("18:59:59");
        assertEquals("Good day, World!", greetingsChoice(bundle, day));

    }

    @Test
    public void eveningBeginChoiceTest() throws ParseException {
        Date evening = dateFormat.parse("19:00:00");
        assertEquals("Good evening, World!", greetingsChoice(bundle, evening));

    }

    @Test
    public void eveningEndChoiceTest() throws ParseException {
        Date evening = dateFormat.parse("22:59:59");
        assertEquals("Good evening, World!", greetingsChoice(bundle, evening));

    }

    @Test
    public void nightBeginChoiceTest() throws ParseException {
        Date night = dateFormat.parse("23:00:00");
        assertEquals("Good night, World!", greetingsChoice(bundle, night));

    }

    @Test
    public void nightEndChoiceTest() throws ParseException {
        Date night = dateFormat.parse("05:59:59");
        assertEquals("Good night, World!", greetingsChoice(bundle, night));

    }


    @Test(expected = ParseException.class)
    public void parseExceptionTest() throws ParseException {
        Date errorDate = dateFormat.parse("test");
        greetingsChoice(bundle, errorDate);

    }

}