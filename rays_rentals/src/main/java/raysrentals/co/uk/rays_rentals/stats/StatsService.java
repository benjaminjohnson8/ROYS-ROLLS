package raysrentals.co.uk.rays_rentals.stats;

public interface StatsService {

	public int availableBikeCount();

	public int allBikeCount();

	public int getPercentageOfAvailable();

	public int getUnavailableBikes();

	public int getPercentageOfUnAvailable();

}
