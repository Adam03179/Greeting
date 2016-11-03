package ua.gerasymenko;

import org.apache.log4j.Logger;

import java.text.ParseException;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

public class GreetingExecutor {

    private static final Logger LOG = Logger.getLogger(GreetingExecutor.class);

    public static void main(String[] args) {


        Locale locale = Locale.getDefault();
        ResourceBundle defaultBundle = ResourceBundle.getBundle("greetingBundle",locale);
        Date currentDate = new Date();


        try {

            GreetingGenerator greetingGenerator = new GreetingGenerator();
            System.out.println(greetingGenerator.greetingsChoice(defaultBundle,currentDate));

        } catch (ParseException e) {
            LOG.error("date greeting error", e);
        }



    }




}