package raysrentals.co.uk.rays_rentals.bike;

public enum BikeClassification {
	MOUNTAIN("MOUNTAIN"),
	TANDEM("TANDEM"),
	ROAD("ROAD");
	
private String prettyName;
	
	
	private BikeClassification(String prettyName) {
		this.prettyName = prettyName;
	}

	public String getPrettyName()
	{
		return prettyName;
	}
}
