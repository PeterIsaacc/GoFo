/**
 * @author shehab eldin khaled mohamed
 */
package com.meme;


import java.time.LocalDate;

/**
 * this class represent the work day which contains a certain date and time slot for a certain event
 *  it contains two attribuites the timeSlot and the date
 */
public class WorkDay {
      private TimeSlot timeSlot;
      private LocalDate date;

      /**
       * the workday constructor takes timeFrom, timeTo, dateStr in the for of a sting to be set to the timeSlot and date objects
       * @param timeFrom a string that contains the time in format "hh:mm:ss"
       * @param timeTo a string that contains the time in format "hh:mm:ss"
       * @param dateStr a string that contains the date in format "yyyy:mm:dd"
       */
      public WorkDay(String timeFrom, String timeTo, String dateStr)
      {
           timeSlot = new TimeSlot(timeFrom, timeTo);
           date = LocalDate.parse(dateStr);
      }

      /**
       * toString method returns a string that represent the timeslot and date in a meaningful way
       * @return workDayStr a string that contains the information about the work day like its date and timeslot
       */
      public String toString()
      {
            String workDayStr = new String("");
            workDayStr = workDayStr.concat(date.toString());
            workDayStr = workDayStr.concat(" | ");
            workDayStr = workDayStr.concat(timeSlot.toString());
            return workDayStr;
      }

      /**
       * getTimeSlot method returns the timeSlot in the form of a string
       * @return String in the format "hh:mm:ss"
       */
      public String getTimeSlot()
      {
            return timeSlot.toString();
      }
      /**
       * getDate method returns the Date in the form of a string
       * @return String in the format "yyyy:mm:dd"
       */
      public String getDate()
      {
            return date.toString();
      }

      /**
       * setTimeSlot method used to reset the timeSlot attribute to a new time slot
       * @param timeFrom the time from in the format "hh:mm:ss"
       * @param timeTo the time to in the format "hh:mm:ss"
       */
      public void setTimeSlot(String timeFrom, String timeTo)
      {
            timeSlot.setTimeTo(timeFrom);
            timeSlot.setTimeTo(timeTo);
      }

      /**
       * setDate method used to reset the date attribute to a new date
       * @param dateStr a string that represents the date in this format "yyyy:mm:dd"
       */
      public  void setDate(String dateStr)
      {
            date = LocalDate.parse(dateStr);
      }
}
