package com.meme;
/**
 * @author shehab eldin khaled mohamed
 */

/**
 * this class represents the Time
 * the class has 3 attributes : the hours, minutes, and seconds
 * @author shehab eldin khaled mohamed
 */
public class Time {
    int hr;
    int min;
    int sec;

    /**
     * the parseTime method take a string in the hh:mm:ss format and store it in the hr, min, second attribuites
     * @param timeStr the string in the hh:mm:ss format
     * @return boolean that is true if it was parsed correctly and false if the string is not in the hh:mm:ss format
     */
    private boolean parseTime(String timeStr)
    {
        if(timeStr.length() != 8) {
            System.out.println("Error you must enter time in this format hh:mm:ss");

            return false;
        }
        String[] timeStrArr = timeStr.split(":");
        if(timeStrArr.length != 3) {
            System.out.println("Error you must enter time in this format hh:mm:ss");
            return false;
        }
        for(int i = 0; i < timeStrArr.length; i++)
        {
            if(timeStrArr[i].length() != 2) {
                System.out.println("Error you must enter time in this format hh:mm:ss");
                return false;
            }
            try
            {
                int num = Integer.parseInt(timeStrArr[i]);
            }
            catch (NumberFormatException nfe)
            {
                System.out.println("Error you must enter time in this format hh:mm:ss");
                return false;
            }
        }
        hr = Integer.parseInt(timeStr.substring(0,2));
        if(hr < 0 || hr > 24) {
            System.out.println("Hour should be between 00 to 24");
            hr = 0;
            return false;
        }
        min = Integer.parseInt(timeStr.substring(3,5));
        if(min < 0 || min > 60) {
            System.out.println("Minute should be between 00 to 60");
            hr = 0;
            min = 0;
            return false;
        }
        sec = Integer.parseInt(timeStr.substring(6,8));
        if(sec < 0 || sec > 60)
        {
            System.out.println("Seconds should be between 00 to 60");
            hr = 0;
            min = 0;
            sec = 0;
            return false;
        }
        return true;
    }

    /**
     * Time is a constructor that take a string as input and initialize the hr, min ,sec attributes from it
     * @param timeStr a string in the hh:mm:ss used to initialize the hr, min, sec data attrubiutes
     *
     */
    public Time(String timeStr)
    {
       if(!parseTime(timeStr))
       {
           hr = 0;
           min = 0;
           sec = 0;
       };

    }

    /**
     * toString method overriden from the Object class used to return a string that holds the information about the time in this format "hh:mm:ss"
     * @return String time string in the format "hh:mm:ss"
     */
    public String toString()
    {
       String timeStr = new String("");

        if(hr < 10) timeStr =timeStr.concat("0");
        timeStr = timeStr.concat(Integer.toString(hr));
        timeStr = timeStr.concat(":");

        if(min < 10) timeStr = timeStr.concat("0");
        timeStr = timeStr.concat(Integer.toString(min));
        timeStr = timeStr.concat(":");

        if(sec < 10) timeStr = timeStr.concat("0");
        timeStr = timeStr.concat(Integer.toString(sec));


       return timeStr;
    }

    /**
     * getHr method used to get the value of the hours in the Time object
     * @return hr an integer that contain the hours in the time object
     */
    public int getHr() {
        return hr;
    }
    /**
     * getMin method used to get the value of the minutes in the Time object
     * @return min an integer that contain the minutes in the time object
     */
    public int getMin() {
        return min;
    }
    /**
     * getSec method used to get the value of the seconds in the Time object
     * @return sec an integer that contain the seconds in the time object
     */
    public int getSec() {
        return sec;
    }

    /**
     * setHr method takes an integer as an input that represents the amount of hours and assign it to the hr attribute
     * @param hr the number of hours to assign the hr attribute value to
     */
    public void setHr(int hr) {
        this.hr = hr;
    }
    /**
     * setMin method takes an integer as an input that represents the amount of minutes and assign it to the min attribute
     * @param min the number of minutes to assign the min attribute value to
     */
    public void setMin(int min) {
        this.min = min;
    }
    /**
     * setSec method takes an integer as an input that represents the amount of seconds and assign it to the sec attribute
     * @param sec the number of hours to assign the hr attribute value to
     */
    public void setSec(int sec)
    {
        this.sec = sec;
    }

    /**
     * setTime method takes a string that represents the time in the "hh:mm:ss" format and set from it the attributes of the Time object: hr, min, sec
     * @param timeStr the string that represent the time in "hh:mm:ss" format that is meant to be the new time to be set in the object.
     */
    public void setTime(String timeStr)
    {
        parseTime(timeStr);
    }
}
