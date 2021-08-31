package Users;
import com.meme.Booking;
import com.meme.Playground;
import com.meme.PlaygroundStatus;
import java.util.ArrayList;
/**
 * @author Peter Essam Maguid Isaac
 */

/**
 * this class represents all playerground's details and options
 * composition between classes (PlaygroundOwner) and (User) as a PlaygroundOwner must be a user
 * it has 3 attributes: user, arraylist of type (Playground) to show playgrounds,
 * arraylist of type (Booking) to show bookings
 */
public class PlaygroundOwner extends Role {
    private User user;
    private ArrayList<Playground> playgrounds;
    private ArrayList<Booking> bookings;

    public PlaygroundOwner(String roleName){
        super(roleName);
        playgrounds = new ArrayList<Playground>();
        bookings = new ArrayList<Booking>();
    }

    /**
     * this function is to give the playground owner the ability to add playgrounds to the system
     * playground is added to Playground array list
     * @param playground the playground to be added in the list of the playgrounds the playground owner has
     */
    public void addPlayground(Playground playground){
    playgrounds.add(playground);
    }

    /**
     * this function is to give the playground owner the ability to display his playground's in
     * @return playgrounds info from array list (Playground)
     */
    public ArrayList<Playground> getPlaygrounds(){
        return playgrounds;
    }

    /**
     * this function is to give the playground owner the ability to display his bookings info
     * @return bookings info
     */
    public ArrayList<Booking> getBookingRequests(){
        return bookings;
    }

    /**
     * this function is a setter to give the playground owner the ability to set his booking's status
     * @param booking where he first enters the current booking he wants to set its status
     * @param status where he enters the status of the chosen booking
     */
    public void setBookingsRequestStatus(Booking booking, PlaygroundStatus status){
    }

    /**
     * this function is to give the playground owner the ability to add a booking to the system
     * booking is added to Booking array list
     * @param booking where he must enter the booking details he wants to add
     */
    public void addBooking(Booking booking){
       bookings.add(booking);
    }

}
