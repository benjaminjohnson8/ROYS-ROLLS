package raysrentals.co.uk.rays_rentals.account;

import org.springframework.beans.factory.annotation.Autowired;

import raysrentals.co.uk.lib.security.BFSSecurityService;

public class AccountServiceImpl implements AccountService{
	@Autowired
	BFSSecurityService securityService;
	@Autowired 
	AccountRepository accountRepository;
	
	@Override
    public Account findAccountByUsername(String username)
    {
        return accountRepository.findByEmail(username);
    }
	@Override
    public Account retrieveCurrentLoggedInAccount()
    {
        String loggedInUserName = securityService.getLoggedInUserName();
        Account accountByUsername = this.findAccountByUsername(loggedInUserName);
        return accountByUsername;
    }

}
