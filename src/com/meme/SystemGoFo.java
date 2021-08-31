package com.meme;

import Users.PlaygroundOwner;
import Users.Role;
import Users.User;
import java.util.ArrayList;

/**
 * This class is responsible of the system itself and the system's important functions
 */
public class SystemGoFo {
    private ArrayList<User> users;
    private ArrayList<Playground> playgrounds;
    private ArrayList<Booking> bookings;
    long PlaygroundId;
    long BookingId;

    /**
     * this constructor is responsible of initializing users list, playgrounds list and bookings list
     * it also initializes/sets default values for IDs of playground and booking
     */
    public SystemGoFo()
    {
        PlaygroundId = 1;
        BookingId = 1;
        users = new ArrayList<User>();
        playgrounds = new ArrayList<Playground>();
        bookings = new ArrayList<Booking>();
    }

    /**
     * This function is responsible of adding a playground in the system
     * when a playground user wants to add a playground to his profile in the system
     * it takes inputs for the playground's details like its ID
     * and adds the playground to the owner's playgrounds list
     * @param playground of type (Playground) in order to take playground's details
     *
     */
    public void addPlayground(Playground playground)
    {
        String playgroundId = Long.toString(PlaygroundId);
        playground.setId(playgroundId);
        playgrounds.add(playground);
        PlaygroundId++;
    }

    /**
     * This function is responsible of adding a user to the system
     * when a user registers it adds him to the users list
     * @param user of type (User) where it takes user's details and stores them in the system
     *
     */
    public void addUser(User user){
        users.add(user);
    }

    /**
     * This function is responsible of adding a booking to the system
     * when a booking is added to the system it stores this booking in the (chosen playground owner's) booking list
     * and it gives the added booking a unique ID
     * @param booking of type (Booking) where it takes booking's details and stores them in the system
     *
     */
    public void addBooking(Booking booking)
    {
        booking.setId(Long.toString(BookingId));
        Role playgroundOwner = getPlaygroundOwner(booking);
        ((PlaygroundOwner) playgroundOwner).addBooking(booking);
        bookings.add(booking);
        BookingId++;

    }

    /**
     * this functions is responsible of displaying all playgrounds
     * @return playgrounds in the system
     */
    public ArrayList<Playground> getPlaygrounds()
    {
        return playgrounds;
    }

    /**
     * this function is responsible of verifying the user's ID and Password when he wants to login
     * @param ID where the user inputs his ID to be checked
     * @param password where the user inputs his password to be checked
     * @return the user the system founds.
     */
    public User verfiyUser(String ID, String password)
    {
        for(int i = 0; i < users.size(); i++)
        {
            if(users.get(i).getId().equals(ID) && users.get(i).getPassword().equals(password))
            {
                return users.get(i);
            }
        }
        return null;
    }

    /**
     * this method gets the PlaygroundOwner object from the list of users exist in the system
     * @param booking some booking made by the player.
     * @return PlaygroundOwner the playground owner in which the player made the booking to
     */
    public Role getPlaygroundOwner(Booking booking)
    {
        for(int i = 0; i < users.size(); i++)
        {
            if(users.get(i).getRole().equals("PlaygroundOwner"))
            {
                User user = users.get(i);
                if(user.getId().equals(booking.getPlaygroundOwnerId()))
                {
                    return user.getConcreteRole();
                }

            }
        }
        return null;
    }

    /**
     * this function is responsible of verifying the user's ID  if it exists in the system or not when he wants to login
     * @param id where the user inputs his ID to be checked
     * @return true if it exists, and false if it doesn't
     */
    public boolean IdExists(String id)
    {

        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId().equals(id))
                return true;


        }
        return false;
    }

}
