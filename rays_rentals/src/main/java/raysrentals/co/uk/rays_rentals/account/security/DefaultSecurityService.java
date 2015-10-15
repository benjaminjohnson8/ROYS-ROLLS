/**
 * 
 */
package raysrentals.co.uk.rays_rentals.account.security;

import org.springframework.context.annotation.Profile;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import raysrentals.co.uk.lib.security.BFSSecurityService;



/**
 * Alternate security service that does nothing. This allows testing and development without the 
 * need for Stormpath
 * @author selliott
 */
@Service
@Profile(value={"default", "test"})
public class DefaultSecurityService implements BFSSecurityService
{

	@Override
	public String getLoggedInUserName()
	{
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if(null != auth && null != auth.getPrincipal())
			return auth.getName();

		return null;//"Testing Mode";
	}
}
