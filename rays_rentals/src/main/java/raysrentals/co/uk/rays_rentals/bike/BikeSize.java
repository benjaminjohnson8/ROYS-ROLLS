package raysrentals.co.uk.rays_rentals.bike;

public enum BikeSize {
	SMALL_MALE("SMALL_MALE"),
	STANDARD_MALE("STANDARD_MALE"),
	LARGE_MALE("LARGE_MALE"),
	STANDARD_FEMALE("STANDARD_FEMALE"),
	CHILD("CHILD");
	
	
    private String value;

    private BikeSize(final String value) {
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
