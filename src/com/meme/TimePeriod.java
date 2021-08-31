
/**
 * @author shehab eldin khaled mohamed
 */
package com.meme;

/**
 *  * this class represents the a time period for a certain event it has 3 attributes: days, hours ,and minutes
 */
public class TimePeriod {
    public int days;
    public int hours;
    public int minutes;

    /**
     * @param days the days attribute is set to the value of this parameter
     * @param hours the hours attribute is set to the value of this parameter
     * @param minutes the minutes attribute is set to the value of this parameter
     */
    public TimePeriod(int days, int hours, int minutes)
    {
        this.days = days;
        this.hours = hours;
        this.minutes = minutes;
    }

    /**
     * default constructor sets all the attributes (days, hours, minutes) to 0
     */
    public TimePeriod()
    {
        this.days = 0;
        this.hours = 0;
        this.minutes = 0;
    }
}
