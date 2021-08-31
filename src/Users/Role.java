package Users;

/**
 * @author shehab eldin khaled mohamed
 */

/**
 * this class represents the role of the user in the system, the role can be a playground owner or a player
 */
public class Role {
    protected String userRole;
    public Role(String roleName)
    {
        userRole = roleName;
    }

    /**
     *
     * @return userRole a string that descripe the role of the user
     */
    public String getUserRole()
    {
        return userRole;
    }

}
