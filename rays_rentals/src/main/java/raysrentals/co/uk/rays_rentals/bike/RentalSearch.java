package raysrentals.co.uk.rays_rentals.bike;

import raysrentals.co.uk.lib.search.Search;
import raysrentals.co.uk.rays_rentals.customer.Customer;

public class RentalSearch extends Search<RentalRecord> {

	public RentalSearch() {
		super(RentalRecord.class);
	}

	public void setRentalId(Long rentalId)
	{
		if(null != rentalId)
		{
			super.addFilterEqual("id", rentalId);
		}
		addSearchParam("id", rentalId);
	}
	
	public Long getRentalId()
	{
		return (Long)getSearchParam("id");
	}
	
	public void setRentDate(String rentDate){
		if(null != rentDate && !rentDate.isEmpty())
		{
			super.addFilterEqual("rentDate", rentDate);
		}
	}
	
	public String getRentDate(){
		return(String)getSearchParam("rentDate");
	}
	
	public void setTimeOut(String timeOut){
		if(null != timeOut && !timeOut.isEmpty())
		{
			super.addFilterEqual("timeOut", timeOut);
		}
	}
	
	public String getTimeOut(){
		return(String)getSearchParam("timeOut");
	}
	
	public void setTimeBackDue(String timeBackDue){
		if(null != timeBackDue && !timeBackDue.isEmpty())
		{
			super.addFilterEqual("timeBackDue", timeBackDue);
		}
	}
	
	public String getTimeBackDue(){
		return(String)getSearchParam("timeBackDue");
	}
	
	public void setTimeBackActual(String timeBackActual){
		if(null != timeBackActual && !timeBackActual.isEmpty())
		{
			super.addFilterEqual("timeBackActual", timeBackActual);
		}
	}
	
	public String getTimeBackActual(){
		return(String)getSearchParam("timeBackActual");
	}
	
	public void setBike(Bike bike)
	{
		if(null != bike)
		{
			super.addFilterEqual("bike", bike);
		}
		addSearchParam("bike", bike);
	}
	public Bike getBike()
	{
		return (Bike)getSearchParam("bike");
	}
	
	public void setBikeModel(String bikeModel)
	{
		if(null != bikeModel && !bikeModel.isEmpty())
		{
			super.addFilterEqual("bike.model", bikeModel);
		}
		addSearchParam("bike.model", bikeModel);
	}
	public String getBikeModel()
	{
		return (String)getSearchParam("bike.model");
	}
	
//	public void setCustomer(Customer customer )
//	{
//		if(null != customer)
//		{
//			super.addFilterEqual("customer", customer);
//		}
//		addSearchParam("customer", customer);
//	}
//	public Customer getCustomer()
//	{
//		return (Customer)getSearchParam("customer");
//	}
	
//	public void setLastName(String lastName)
//	{
//		if(null != lastName && !lastName.isEmpty())
//		{
//			super.addFilterLike("customer.lastName", lastName.contains("%") ? lastName : lastName+"%");
//		}
//		addSearchParam("customer.lastName", lastName);
//	}
//	public String getLastName()
//	{
//		return (String)getSearchParam("customer.lastName");
//	}

}
