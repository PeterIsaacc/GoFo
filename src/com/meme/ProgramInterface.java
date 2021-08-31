/**
 * @author Shehab Eldin khaled mohamed, Peter Essam Maguid Isaac
 */
package com.meme;
import Users.Player;
import Users.PlaygroundOwner;
import Users.Role;
import Users.User;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class is responsible of the program interface which is responsible of
 * displaying program's important functions and forms
 */
public class ProgramInterface {
    private User user;
    SystemGoFo system = new SystemGoFo();

    /**
     * this function displays the playground registration form
     * for the playground owner to register his playgrounds
     * it takes inputs for playground's details and stores them in playgrounds menu/list
     */
    public void displayPlaygroundRegisterationForm(){
        Scanner sc= new Scanner(System.in);
        System.out.println("Please enter playground name: ");
        String playgroundName = sc.nextLine();
        System.out.println("Please enter playground location: ");
        String location = sc.nextLine();

        System.out.println("Please enter playground type: ");
        String playgroundType = sc.nextLine();

        System.out.println("Please enter playground length: ");
        String lengthStr = sc.nextLine();
        double length = Double.parseDouble(lengthStr);

        System.out.println("Please enter playground width: ");
        String widthStr = sc.nextLine();
        double width = Double.parseDouble(widthStr);

        Size playgroundSize = new Size(width,length);

        System.out.println("Enter time available | time from: ");
        String timeFrom = sc.nextLine();

        System.out.println("Enter time available | time to: ");
        String timeTo = sc.nextLine();

        TimeSlot timeSlot = new TimeSlot(timeFrom,timeTo);
        System.out.println("Please enter price per hour: ");
        String pricePerHourStr = sc.nextLine();
        double pricePerHour = Double.parseDouble(pricePerHourStr);

        System.out.println("Please enter cancellation period");

        System.out.println("Enter days ");
        String daysStr = sc.nextLine();
        int days = Integer.parseInt(daysStr);

        System.out.println("Enter hours ");
        String hoursStr = sc.nextLine();
        int hours = Integer.parseInt(hoursStr);

        System.out.println("Enter minutes ");
        String minutesStr = sc.nextLine();
        int minutes = Integer.parseInt(minutesStr);

        TimePeriod cancelationPeriod = new TimePeriod(days,hours,minutes);

        Playground playground = new Playground(playgroundName,location,playgroundType,playgroundSize,timeSlot,pricePerHour,cancelationPeriod);
        playground.setPlaygroundOwnerID(user.getId());
        ((PlaygroundOwner) user.getConcreteRole()).addPlayground(playground);
        system.addPlayground(playground);
        System.out.println("Playground has been added successfully");
    }

    /**
     * this function displays the user registration form
     * when a user(whether a playground owner or a player) wants to register in the system
     * it takes inputs for user's details and stores them in users' menu/list
     */
    public void userRegisterationForm(){
        Scanner sc = new Scanner(System.in);
        boolean Success = false;
        String userName = new String();
        String userId = new String();
        String userEmail = new String();
        String userPassword = new String();
        String userPhone = new String();
        String userLocation = new String();
        Role userRole = null;
        while(true) {
            System.out.println("Are you a playground owner or a player ?");
            System.out.println("Enter 0 if your are a playground owner enter 1 if you are a player");
            String choiceStr = sc.nextLine();
            int choice = Integer.parseInt(choiceStr );
            if (choice == 0) {
                userRole = new PlaygroundOwner("PlaygroundOwner");
            } else if (choice == 1) {
                userRole = new Player("Player");
            }
            else {
                System.out.printf("please enter 0 or 1 ");
                continue;
            }
            System.out.println("Please enter your name: ");
            userName = sc.nextLine();

            while (true) {
                System.out.println("Please enter your Id: ");
                userId = sc.nextLine();
                if (system.IdExists(userId)) {
                    System.out.println("This ID already exists please enter another ID");
                    continue;
                }
                break;
            }
            System.out.println("Please enter your password: ");
            userPassword = sc.nextLine();

            System.out.println("Please enter your email: ");
            userEmail = sc.nextLine();

            System.out.println("Please enter your phone: ");
            userPhone = sc.nextLine();

            System.out.println("Please enter your location: ");
            userLocation = sc.nextLine();

            break;
        }
        User newUser =new User(userName,userId,userPassword,userEmail,userPhone,userLocation, userRole);
        system.addUser(newUser);
        user = newUser;


    }

    /**
     * This function displays the booking form
     * when a player user wants to book a specific playground
     * it takes inputs for booking details like start and end time and stores them in booking list
     * @param playground of type (Playground) in order to choose which playground the player wants to book
     *
     */
    public void displayBookingForm(Playground playground){

        System.out.println("enter your booking date in \"yyyy-mm-dd\" format");
        Scanner sc = new Scanner(System.in);
        String date = sc.nextLine();

        System.out.println("enter your booking start time  in \"hh:mm:ss\" format");
        String startTime = sc.nextLine();

        System.out.println("enter your booking end time  in \"hh:mm:ss\" format");
        String endTime = sc.nextLine();

        WorkDay Wday = new WorkDay(startTime, endTime,date);

        Booking booking =new Booking(Wday,playground);
        booking.setPlayerID(user.getId());
        ((Player) user.getConcreteRole()).addBooking(booking);
        playground.addBooking(booking);
        system.addBooking(booking);

        System.out.println("Playground is booked successfully");

    }

    /**
     * this function displays the playgrounds list
     * when a user wants to book a playground
     * it takes inputs for the chosen playground's id and checks if such a playground exists
     */
    public void displayPlayground(){
        Scanner sc = new Scanner(System.in);
        ArrayList<Playground> playgrounds = system.getPlaygrounds();
        if(playgrounds.size() == 0)
        {
            System.out.println("No playgrounds exists in the system yet!");
            return;
        }
        for(int i = 0; i< playgrounds.size(); i++){
            System.out.println((playgrounds.get(i)));
        }
        System.out.println("Enter 0 to return to main menu or 1 to book a playground");
        String choiceStr = sc.nextLine();
        int choice = Integer.parseInt(choiceStr);
        if(choice == 0)
            return;
        else if(choice == 1) {
            System.out.println("Enter the id of the playground you want to book: ");
            String playgroundId = sc.nextLine();
            for (int i = 0; i < playgrounds.size(); i++) {
                if (playgrounds.get(i).getPlaygroundID().equals(playgroundId)) {
                    displayBookingForm(playgrounds.get(i));
                    break;
                }
                if(i == playgrounds.size() - 1){
                    System.out.println("No such playground exists !!");
                }
            }

        }
    }

    /**
     * this function displays the login form
     * when a user(whether a playground owner or a player) wants to login in the system
     * it takes inputs for user's details like his id and password and checks if they are right
     */
    public void loginForm() {

        user = null;
        do {
            System.out.println("Enter ID");
            Scanner sc = new Scanner(System.in);
            String ID = sc.nextLine();
            System.out.println("Enter Password");

            String Pass = sc.nextLine();
            user = system.verfiyUser(ID,Pass);
            if(user == null) {
                System.out.println("WRONG ID OR PASSWORD !!");
            }
        } while (user == null);
    }

    /**
     * This function displays the playground owner's bookings list,
     * it also checks if there are bookings or not.
     * if there are bookings ,
     * this function gives the playground owner the ability to accept or to deny the booking he chooses.
     *
     */
    public void displayPlaygroundOwnerBookings()
    {
        Scanner sc = new Scanner(System.in);
        ArrayList<Booking> bookings = ((PlaygroundOwner) user.getConcreteRole()).getBookingRequests();
        if(bookings.size() == 0)
        {
            System.out.println("You don't have any bookings yet");
            return;
        }
        for(int i = 0; i < bookings.size(); i++) System.out.println(bookings.get(i));
        System.out.println("Enter 0 to return to main menu or 1 to accept/deny a booking request: ");
        String choiceStr = sc.nextLine();
        int choice = Integer.parseInt(choiceStr);
        if(choice == 0) return;
        else if(choice == 1)
        {
            System.out.println("Enter the Booking Id you want to accept/deny: ");
            String bookingId = sc.nextLine();
            for(int i = 0; i < bookings.size(); i++)
            {
                if(bookings.get(i).getBookingID().equals(bookingId))
                {
                    System.out.println(bookings.get(i));
                    System.out.println("Enter 0/1 if you want to deny/accept the request");
                    choiceStr = sc.nextLine();
                    choice = Integer.parseInt(choiceStr);
                    if(choice == 0)
                    {
                        bookings.get(i).setBookingStatus(BookingStatus.Denied);
                        System.out.println("Book has been Denied successfully");

                    }
                    else if(choice == 1)
                    {
                        bookings.get(i).setBookingStatus(BookingStatus.Accepted);
                        System.out.println("Book has been accepted successfully");

                    }
                    break;
                }
            }
        }
    }

    /**
     * This function displays user main menu for users
     * it asks the user
     * if he wants to logout of the system or to view/book his playgrounds or to display his bookings
     * and then continues the process of the rest of the functions when he chooses what he wants to do
     */
    public void displayUserMenu()
    {
        Scanner sc = new Scanner(System.in);
        while (true) {
            if (user.getRole().equals("Player")) {
                System.out.println("Hello " + user.getName());
                System.out.println("Enter 0 to logout");
                System.out.println("Enter 1 to view/book Playgrounds");
                System.out.println("Enter 2 to display my bookings");
                String choiceStr = sc.nextLine();
                int choice = Integer.parseInt(choiceStr);
                if (choice == 0) {
                    user = null;
                    return;
                }
                if (choice == 1) {
                    displayPlayground();
                } else if (choice == 2) {
                    ArrayList<Booking> bookings = ((Player) user.getConcreteRole()).getBookings();
                    if(bookings.size() == 0)
                    {
                        System.out.println("you didn't make any bookings yet");
                    }
                    for (int i = 0; i < bookings.size(); i++) {
                        System.out.println(bookings.get(i));
                    }
                }
            } else if (user.getRole().equals("PlaygroundOwner")) {
                System.out.println("hello " + user.getName());
                System.out.println("Enter 0 to logout");
                System.out.println("Enter 1 to see and accept/deny booking requests");
                System.out.println("Enter 2 to register a Playground");
                System.out.println("Enter 3 to view your Playgrounds");
                String choiceStr = sc.nextLine();
                int choice = Integer.parseInt(choiceStr);
                if (choice == 0) {
                    user = null;
                    return;
                } else if (choice == 1) {
                    displayPlaygroundOwnerBookings();
                } else if (choice == 2) {
                    displayPlaygroundRegisterationForm();
                }
                else if (choice == 3) {
                    displayPlaygroundOwnerPlaygrounds();
                }
            }
        }
    }

    /**
     * This function displays the playground owner's playgrounds list,
     * it also checks if there are playgrounds or not.
     * if there are playgrounds , it just displays them.
     * else, it gives him error message that he hasn't registered playgrounds yet
     *
     */
    public void displayPlaygroundOwnerPlaygrounds()
    {
        ArrayList<Playground> playgrounds = ((PlaygroundOwner) user.getConcreteRole()).getPlaygrounds();
        if(playgrounds.size() == 0)
        {
            System.out.println("You don't have in playgrounds registered in the system");
            return;
        }
        for(int i = 0; i < playgrounds.size(); i++)
        {
            System.out.println(playgrounds.get(i));
        }
    }

    /**
     * this function is responsible of running the whole system
     * where the whole system starts by implementing this function in the main function
     */
    public void run()
    {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("");
            System.out.println("type 0 if you want to register, type 1 if you want to login");
            String choiceStr = sc.nextLine();
            int choice = Integer.parseInt(choiceStr);
            if(choice == 0) userRegisterationForm();
            else if(choice == 1) loginForm();
            displayUserMenu();
        }
    }



}