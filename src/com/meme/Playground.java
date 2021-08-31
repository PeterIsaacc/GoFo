package com.meme;

import Users.PlaygroundOwner;
/**
 * @author shehab eldin khaled mohamed
 */
import java.awt.print.Book;
import java.util.ArrayList;

/**
 * this class represents the Playground in the GoFo system
 */
public class Playground {
    private String name;
    private String location;
    private String playgroundID;
    private String playgroundType;
    private Size playgroundSize;
    private String playgroundOwnerID;
    private TimeSlot timeAvailble;
    private double pricePerHour;
    private PlaygroundStatus playgroundStatus;
    private  ArrayList<Booking> bookings;
    private ArrayList<WorkDay> availbleWorkDays;
    private TimePeriod cancelationPeriod;

    public Playground(String name, String location, String playgroundType, Size playgroundSize, TimeSlot timeAvailble,
                      double pricePerHour, TimePeriod cancelationPeriod){
        this.name = name;
        this.location = location;
        this.playgroundType = playgroundType;
        this.playgroundSize = playgroundSize;
        this.timeAvailble = timeAvailble;
        this.pricePerHour = pricePerHour;
        this.cancelationPeriod = cancelationPeriod;
        this.playgroundStatus = PlaygroundStatus.Active;
        this.availbleWorkDays = new ArrayList<WorkDay>();
        this.bookings = new ArrayList<Booking>();
        for(int i = 1; i <= 5; i++)
        {
            String workDayDate = new String("");
            workDayDate = workDayDate.concat("2021-");
            workDayDate = workDayDate.concat("07-");
            workDayDate = workDayDate.concat("0" + Integer.toString(i));
            WorkDay workDay = new WorkDay(timeAvailble.getTimeFrom(), timeAvailble.getTimeTo(),workDayDate);
            availbleWorkDays.add(workDay);

        }
    }

    /**
     *
     * @return the playground ID
     */
    public String getPlaygroundID()
    {
        return playgroundID;
    }
    /**
     *
     * @return the playground status
     */
    public PlaygroundStatus getPlaygroundStatus()
    {
        return playgroundStatus;
    }

    /**
     *
     * @return the bookings the player had make
     */
    public ArrayList<Booking> getBookings() {
        return bookings;
    }

    /**
     *
     * @return the working time available for the playground
     */
    public  TimeSlot getTimeAvailble()
    {
        return timeAvailble;
    }

    /**
     *
     * @return  the workday availble for the playground
     */
    public ArrayList<WorkDay> getAvailbleWorkDays()
    {
        return availbleWorkDays;
    }
    public void updateWorkDayTime(WorkDay workDay)
    {

    }

    /**
     *
     * @param booking the booking that needs to ben added in the Array of bookings
     */
    public void addBooking(Booking booking)
    {
        bookings.add(booking);
        updateWorkDayTime(booking.getBookingWorkDay());
    }

    /**
     *
     * @return playground owner id
     */
    public String getPlaygroundOwnerID()
    {
        return playgroundOwnerID;
    }

    /**
     *
     * @return string represent meaningful information about the playground
     */
    public String toString()
    {
        String playgroundStr = new String("");
        playgroundStr = playgroundStr.concat("Playground name: ");
        playgroundStr = playgroundStr.concat(name + "\n");
        playgroundStr = playgroundStr.concat("Playground ID: ");
        playgroundStr = playgroundStr.concat(playgroundID + "\n");
        playgroundStr = playgroundStr.concat("Playground Owner ID: ");
        playgroundStr = playgroundStr.concat(playgroundOwnerID + "\n");
        playgroundStr = playgroundStr.concat("Playground location: ");
        playgroundStr = playgroundStr.concat(location + "\n");
        playgroundStr = playgroundStr.concat("Playground type: ");
        playgroundStr = playgroundStr.concat(playgroundType + "\n");
        playgroundStr = playgroundStr.concat("Playground length: ");
        playgroundStr = playgroundStr.concat(playgroundSize.length + "\n");
        playgroundStr = playgroundStr.concat("Playground width: ");
        playgroundStr = playgroundStr.concat(playgroundSize.width + "\n");
        playgroundStr = playgroundStr.concat("Price per hour: ");
        playgroundStr = playgroundStr.concat(pricePerHour+ "\n");
        playgroundStr = playgroundStr.concat("Playground cancellation period(days hours minutes): ");
        playgroundStr = playgroundStr.concat(cancelationPeriod.days + " " + cancelationPeriod.hours + " " + cancelationPeriod.minutes+"\n");

        playgroundStr =  playgroundStr.concat("\nAvailable Time to book\n");
        for(int i = 0; i < availbleWorkDays.size();i++)
            playgroundStr =  playgroundStr.concat(availbleWorkDays.get(i).toString() + "\n");
        return playgroundStr;
    }

    /**
     * setId method set the playground id to a new id;
     * @param playgroundID the Id to change the playgroundId to
     */
    public void setId(String playgroundID)
    {
        this.playgroundID = playgroundID;
    }

    /**
     *
     * @return name of the playground
     */
    public String getName()
    {
        return name;
    }

    public void setPlaygroundOwnerID(String ID)
    {
        this.playgroundOwnerID = ID;
    }

}
