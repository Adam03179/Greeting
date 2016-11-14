package ua.gerasymenko;

import org.apache.log4j.Logger;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;


class GreetingGenerator {

    private static final Logger LOG = Logger.getLogger(GreetingGenerator.class);
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");


    static String greetingsChoice(ResourceBundle bundle, Date currentDate) throws ParseException {

        Date current = dateFormat.parse(dateFormat.format(currentDate));
        Date morning = dateFormat.parse("05:59:59");
        Date day = dateFormat.parse("09:00:00");
        Date evening = dateFormat.parse("19:00:00");
        Date night = dateFormat.parse("23:00:00");

        if (current.after(morning) && current.before(day)) {
            LOG.info("Morning greeting was generated");
            return bundle.getString("MORNING");
        } else if (current.after(morning) && current.before(evening)) {
            LOG.info("Day greeting was generated");
            return bundle.getString("DAY");
        } else if (current.after(morning) && current.before(night)) {
            LOG.info("Evening greeting was generated");
            return bundle.getString("EVENING");
        } else {
            LOG.info("Night greeting was generated");
            return bundle.getString("NIGHT");
        }


    }


}
