package ua.gerasymenko;

import org.apache.log4j.Logger;

import java.text.ParseException;
import java.util.Date;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class GreetingExecutor {

    private static final Logger LOG = Logger.getLogger(GreetingExecutor.class);

    public static void main(String[] args) {


        Locale locale = Locale.getDefault();

        ResourceBundle defaultBundle;
        try {
            defaultBundle = ResourceBundle.getBundle("greetingBundle", locale);
        } catch (MissingResourceException e) {
            LOG.warn("missing resourceBundle");
            defaultBundle = ResourceBundle.getBundle("greetingBundle_en_US");
        }

        Date currentDate = new Date();


        try {

            GreetingGenerator greetingGenerator = new GreetingGenerator();
            System.out.println(greetingGenerator.greetingsChoice(defaultBundle, currentDate));

        } catch (ParseException e) {
            LOG.error("date greeting error", e);
        }


    }


}
