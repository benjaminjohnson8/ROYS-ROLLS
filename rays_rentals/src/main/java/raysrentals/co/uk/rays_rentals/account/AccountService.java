package raysrentals.co.uk.rays_rentals.account;

public interface AccountService {

	public Account retrieveCurrentLoggedInAccount();

	public Account findAccountByUsername(String username);

}
