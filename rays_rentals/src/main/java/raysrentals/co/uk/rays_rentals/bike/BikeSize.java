package raysrentals.co.uk.rays_rentals.bike;

public enum BikeSize {
	SMALL_MALE("SMALL_MALE"),
	STANDARD_MALE("STANDARD_MALE"),
	LARGE_MALE("LARGE_MALE"),
	STANDARD_FEMALE("STANDARD_FEMALE"),
	CHILD("CHILD");
	
	
	private String prettyName;
	
	
	private BikeSize(String prettyName) {
		this.prettyName = prettyName;
	}

	public String getPrettyName()
	{
		return prettyName;
	}
}
