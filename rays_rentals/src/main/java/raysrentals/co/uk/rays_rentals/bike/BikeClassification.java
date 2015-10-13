package raysrentals.co.uk.rays_rentals.bike;

public enum BikeClassification {
	MOUNTAIN("MOUNTAIN"),
	TANDEM("TANDEM"),
	ROAD("ROAD");
	
    private String value;

    private BikeClassification(final String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
    
    @Override
    public String toString() {
        return this.getValue();
    }
}
