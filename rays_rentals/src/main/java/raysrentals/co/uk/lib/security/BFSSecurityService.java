/**
 * 
 */
package raysrentals.co.uk.lib.security;

/**
 * Security service to provide utility methods for the authenticated user.
 * @author selliott
 */
public interface BFSSecurityService
{
	/**
	 * Returns the users name of the currently logged in User, or null if no one is logged in.
	 * @return The username of the current authenticated user, or null if no one is logged in.
	 */
	public String getLoggedInUserName();
}
