/**
 * @author shehab eldin khaled mohamed
 */
package Users;

/**
 * this class represents the user in the goFo system
 */
public class User {
    private String name;
    private String Id;
    private String password;
    private String email;
    private String phone;
    private String location;
    private Role role;

    /**
     * User constructor to initialize the data in the object
     * @param name the user name that will be initialized to this user
     * @param Id the user ID that will be initialized to this user
     * @param password the user password that will be initialized to this user
     * @param email the user email that will be initialized to this user
     * @param phone the user phone that will be initialized to this user
     * @param location the user location that will be initialized to this user
     * @param role the user role that will be initialized to this user
     */
    public User(String name, String Id, String password, String email, String phone, String location, Role role)
    {
        this.name = name;
        this.Id = Id;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.location = location;
        this.role = role;

    }

    /**
     *
     * @return password of the user
     */
    public String getPassword() {
        return password;
    }

    /**
     * getName method returns the name of this user
     * @return name of the user
     */
    public String getName()
    {
        return name;
    }
    /**
     * getName method returns the name of this user
     * @return Id of the user
     */
    public String getId()
    {
        return Id;
    }
    /**
     * getName method returns the email of this user
     * @return email of the user
     */
    public String getEmail()
    {
        return email;
    }
    /**
     * getName method returns the phone of this user
     * @return phone
     */
    public String getPhone()
    {
        return phone;
    }
    /**
     * getName method returns the Location of this user
     * @return Location
     */
    public String getLocation()
    {
        return location;
    }

    /**
     *
     * @param anotherUser represents the user we want to compare with our users in the system
     * @return the user if it exists and null if it doesnt
     */
    public boolean equals(User anotherUser)
    {
         if(this.Id.equals(anotherUser.Id) && this.password.equals(anotherUser.password))
         {
             return true;
         }
         else
             return false;
    }

    /**
     * getRole method gets the role of the user in the system
     * @return userRole a String describing the role of the user
     */
    public String getRole()
    {
        return role.getUserRole();
    }

    /**
     * @return role it returns an object of type role to be then casted to either player or playgroundowner so we can get information from them
     */
     public Role getConcreteRole()
     {
         return role;
     }

}
