/**
 * @author shehab eldin khaled mohamed
 */

package com.meme;

import java.awt.print.Book;
import java.security.PublicKey;
import java.util.Scanner;
import Users.Player;

import java.util.ArrayList;

/**
 * this class reperesents the Booking in the GoFo System
 */
public class Booking {
    private WorkDay bookingWorkDay;
    private Playground playground;
    private String playerID;
    ArrayList<Player> playerTeam;
    private boolean teamCompleted;
    private BookingStatus bookingStatus;
    private String bookingID;
    private boolean lookingForATeam;

    /**
     *
     * @param wday the booking time
     * @param playground the playground that is booked
     */
    public Booking(WorkDay wday, Playground playground) {
        bookingWorkDay = wday;
        this.playground = playground;
        bookingStatus = BookingStatus.Pending;
        this.playerTeam = new ArrayList<Player>();
    }

    /**
     * setBookingStatus sets the value of the booking status to a new value
     * @param bookingStatus the new booking status that will be set to the object
     */
    public void setBookingStatus(BookingStatus bookingStatus)
    {
        this.bookingStatus = bookingStatus;
    }

    /**
     *
     * @return the booking ID
     */
    public String getBookingID()
    {
        return bookingID;
    }
    /**
     * getBookingStatus method returns the status of this booking
     * @return bookingStatus the status of this booking
     */
    public BookingStatus getBookingStatus() {
        return bookingStatus;
    }

    /**
     *
     * @return String that represents meaningful data about the booking
     */
    public String toString()
    {
        String bookingInfo = new String("");
        bookingInfo = bookingInfo.concat("Playground name: ");
        bookingInfo = bookingInfo.concat(playground.getName() + "\n");
        bookingInfo = bookingInfo.concat("Player ID: " + playerID + "\n");
        bookingInfo = bookingInfo.concat("Team completed: " + teamCompleted + "\n");
        bookingInfo = bookingInfo.concat("Booking status: " + bookingStatus + "\n");
        bookingInfo = bookingInfo.concat("Booking ID: " + bookingID + "\n");
        bookingInfo = bookingInfo.concat("looking for a team: " + lookingForATeam + "\n");
        bookingInfo = bookingInfo.concat("Booking time: " + bookingWorkDay.toString());



        return bookingInfo;
    }
    public void setPlayerID(String ID)
    {
        playerID = ID;
    }

    /**
     *
     * @return Workday returns the workDay information about the booking
     */
    public WorkDay getBookingWorkDay() {
        return bookingWorkDay;
    }

    /**
     *
     * @return playerId the playgroundOwner ID
     */
    public String getPlaygroundOwnerId()
    {
        return playground.getPlaygroundOwnerID();
    }
    /**
     *
     * @return boolean true if the team is completed and false if it is not completed
     */
    public boolean isTeamCompleted()
    {
        return teamCompleted;
    }

    public void setId(String id)
    {
        bookingID = id;
    }
}
