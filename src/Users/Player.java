/**
 * Users package contains the classes related to the users of the system
 */

/**
 * @author Peter Essam Maguid
 */
package Users;
import java.awt.print.Book;
import java.util.ArrayList;
import com.meme.Booking;
import com.meme.BookingStatus;


/**
 *  this class is for the player user
 *  composition between classes (player) and (user) where a player must be a user
 *  player class has 3 attributes: bookings(player's list of bookings), favoriteTeam(player's team list of members)
 */
public class Player extends Role {
 private ArrayList<Booking> bookings;
 private ArrayList<Player> favoriteTeam;
 private User user;
 private Role role;

    public Player(String roleName){
        super(roleName);
        bookings = new ArrayList<Booking>();
        favoriteTeam = new ArrayList<Player>();
    }

    /**
     * this function is to get all Bookings the player has made
     * @return bookings an array list of all the bookings the player has made
     */
    public ArrayList<Booking> getBookings() {
        return bookings;
    }
    public void addBooking(Booking booking)
    {
        bookings.add(booking);
    }
}

