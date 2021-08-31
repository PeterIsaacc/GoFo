package com.meme;

/**
 * @author Peter Essam Maguid Isaac
 * this class is to know every detail about playground time slots
 */

/**
 * this class has 2 attributes: timeFrom(start time of time slot) , timeTo(end time of time slot)
 * aggregation between classes TimeSlot and Time
 */
public class TimeSlot {
    private Time timeFrom;
    private Time timeTo;

    /**
     * class constructor sets start time and end time of a time slot
     * represents the start and end time of a time slot in the "hh:mm:ss" format
     * @param TimeFrom is the start time of time slot
     * @param TimeTo is the end time of time slot
     */
    public TimeSlot(String TimeFrom, String TimeTo) {
        timeFrom = new Time(TimeFrom);
        timeTo = new Time(TimeTo);
    }

    /**
     * this is a setter for TimeFrom(start time of time slot)
     * represents the start time of a time slot in the "hh:mm:ss" format
     * @param TimeFrom is the start time of time slot
     */
    public void setTimeFrom(String TimeFrom){
        this.timeFrom.setTime(TimeFrom);
    }

    /**
     * this is a setter for TimeTo(end time of time slot)
     * represents the end time in the "hh:mm:ss" format
     * @param TimeTo is the end time of time slot
     */
    public void setTimeTo(String TimeTo){
        this.timeFrom.setTime(TimeTo);
    }

    /**
     * this is a getter for TimeFrom(start time of time slot)
     * @return value of TimeFrom(start time of time slot) in the "hh:mm:ss" format
     */
    public String getTimeFrom(){
      return String.valueOf(timeFrom);
    }

    /**
     *  this is a getter for TimeTo(end time of time slot)
     * @return value of TimeTo(end time of time slot) in the "hh:mm:ss" format
     */
    public String getTimeTo(){
        return String.valueOf(timeTo);
    }

    /**
     * this method is to print all time details(start time and end time of a time slot)
     * @return a string that represents the data of the object
     */
    public String toString()
    {
        String timeFromTo = new String();
        timeFromTo = timeFromTo.concat(timeFrom.toString());
        timeFromTo = timeFromTo.concat(" <-> ");
        timeFromTo = timeFromTo.concat(timeTo.toString());
        return timeFromTo;
    }
}
