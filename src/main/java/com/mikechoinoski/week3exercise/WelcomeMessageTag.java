package com.mikechoinoski.week3exercise;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.time.LocalTime;


public class WelcomeMessageTag extends SimpleTagSupport{

    @Override
    public void doTag() throws JspException, IOException {

        super.doTag();

        LocalTime midnight = LocalTime.of(0, 0, 0, 0);
        LocalTime morning = LocalTime.of(6, 0, 0, 0);
        LocalTime noon = LocalTime.of(12, 0, 0, 0);
        LocalTime evening = LocalTime.of(18, 0, 0, 0);

        LocalTime currentTime = LocalTime.now();

        String welcomeMessage = null;

        if (currentTime.equals(midnight) ||
                (currentTime.isAfter(midnight) && currentTime.isBefore(morning))) {
            welcomeMessage = "Good Night";
        } else if (currentTime.equals(morning) ||
                (currentTime.isAfter(morning) && currentTime.isBefore(noon))) {
            welcomeMessage = "Good Morning";
        } else if (currentTime.equals(noon) ||
                (currentTime.isAfter(noon) && currentTime.isBefore(evening))) {
            welcomeMessage = "Good Morning";
        } else if (currentTime.equals(evening) ||
                (currentTime.isAfter(evening) && currentTime.isBefore(LocalTime.MAX)) ||
                (currentTime.equals(LocalTime.MAX))) {
            welcomeMessage = "Good Evening";
        }

        JspWriter out = getJspContext().getOut();
        out.println(welcomeMessage);
    }

}