package com.mikechoinoski.week3exercise;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Calendar;

/**
 * A class that returns a welcome message.
 *
 * @author mchoinoski
 */

public class WelcomeMessageTag extends SimpleTagSupport{

    @Override

    /** This method does the processing for the tag.
     *
     * @throws JspException an exception for jsps
     * @throws IOException an io exception
     */

    public void doTag() throws JspException, IOException {

        String welcomeMessage = null;
        LocalTime timeForNow = LocalTime.now();
        LocalDate dateForNow = LocalDate.now();

        super.doTag();

        welcomeMessage = getHolidayMessage(dateForNow);

        if (welcomeMessage == null) {
            welcomeMessage = getTimeMessage(timeForNow);
        }

        JspWriter out = getJspContext().getOut();
        out.println(welcomeMessage);
    }

    /** This method returns a message based on the current date
     *
     * @param currentDate the current date
     * @return the welcome message for the date
     */

    public String getHolidayMessage(LocalDate currentDate) {

        String holidayMessage = null;

        LocalDate.of(Calendar.getInstance().get(Calendar.YEAR), 01, 01);

        LocalDate newYearsDay   = LocalDate.of(Calendar.getInstance().get(Calendar.YEAR), 01, 01);
        LocalDate valentinesDay = LocalDate.of(Calendar.getInstance().get(Calendar.YEAR), 02, 14);
        LocalDate fourthOfJuly  = LocalDate.of(Calendar.getInstance().get(Calendar.YEAR), 07, 04);
        LocalDate halloween     = LocalDate.of(Calendar.getInstance().get(Calendar.YEAR), 10, 31);
        LocalDate christmasEve  = LocalDate.of(Calendar.getInstance().get(Calendar.YEAR), 12, 24);
        LocalDate christmasDay  = LocalDate.of(Calendar.getInstance().get(Calendar.YEAR), 12, 25);
        LocalDate newYearsEve   = LocalDate.of(Calendar.getInstance().get(Calendar.YEAR), 12, 31);

        if (currentDate.equals(newYearsDay)) {
            holidayMessage = "Happy New Years!";
        } else if (currentDate.equals(valentinesDay)) {
            holidayMessage = "Happy Valentines Day!";
        } else if (currentDate.equals(fourthOfJuly)) {
            holidayMessage = "Happy Independence Day!";
        } else if (currentDate.equals(halloween)) {
            holidayMessage = "Happy Halloween!";
        } else if (currentDate.equals(christmasEve)) {
            holidayMessage = "Happy Christmas Eve!";
        } else if (currentDate.equals(christmasDay)) {
            holidayMessage = "Merry Christmas!";
        } else if (currentDate.equals(newYearsEve)) {
            holidayMessage = "Happy New Years Eve!";
        }

        return holidayMessage;

    }

    /** This method returns a message based on the time of day
     *
     * @param currentTime the current time of the day
     * @return the welcome message for the time of day
     */

    public String getTimeMessage(LocalTime currentTime) {

        LocalTime midnight = LocalTime.of(0, 0, 0, 0);
        LocalTime morning = LocalTime.of(6, 0, 0, 0);
        LocalTime noon = LocalTime.of(12, 0, 0, 0);
        LocalTime evening = LocalTime.of(18, 0, 0, 0);

        String timeMessage = null;

        if (currentTime.equals(midnight) ||
                (currentTime.isAfter(midnight) && currentTime.isBefore(morning))) {
            timeMessage = "Good Night";
        } else if (currentTime.equals(morning) ||
                (currentTime.isAfter(morning) && currentTime.isBefore(noon))) {
            timeMessage = "Good Morning";
        } else if (currentTime.equals(noon) ||
                (currentTime.isAfter(noon) && currentTime.isBefore(evening))) {
            timeMessage = "Good Morning";
        } else if (currentTime.equals(evening) ||
                (currentTime.isAfter(evening) && currentTime.isBefore(LocalTime.MAX)) ||
                (currentTime.equals(LocalTime.MAX))) {
            timeMessage = "Good Evening";
        }

        return timeMessage;

    }


}