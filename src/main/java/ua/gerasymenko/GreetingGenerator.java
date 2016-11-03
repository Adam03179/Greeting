package ua.gerasymenko;

import org.apache.log4j.Logger;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

public class GreetingGenerator {

    private static final Logger LOG = Logger.getLogger(GreetingGenerator.class);

    private Date morning;
    private Date day;
    private Date evening;
    private Date night;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");


    public GreetingGenerator() throws ParseException {


        this.morning = dateFormat.parse(DayPeriods.MORNING.toString());
        this.day = dateFormat.parse(DayPeriods.DAY.toString());
        this.evening = dateFormat.parse(DayPeriods.EVENING.toString());
        this.night = dateFormat.parse(DayPeriods.NIGHT.toString());
    }


    public String greetingsChoice(ResourceBundle bundle, Date currentDate) throws ParseException {

        Date current = dateFormat.parse(dateFormat.format(currentDate));

        if (current.after(morning) && current.before(day)) {
            LOG.info("Morning greeting was generated");
            return bundle.getString("MORNING");
        } else if (current.after(day) && current.before(evening)) {
            LOG.info("Day greeting was generated");
            return bundle.getString("DAY");
        } else if (current.after(evening) && current.before(night)) {
            LOG.info("Evening greeting was generated");
            return bundle.getString("EVENING");
        } else {
            LOG.info("Night greeting was generated");
            return bundle.getString("NIGHT");
        }


    }


}
