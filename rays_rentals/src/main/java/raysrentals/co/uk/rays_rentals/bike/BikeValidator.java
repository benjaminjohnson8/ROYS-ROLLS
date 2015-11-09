package raysrentals.co.uk.rays_rentals.bike;

import org.hsqldb.lib.StringUtil;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
@Component("bikeValidator")
public class BikeValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		return false;
	}

	@Override
	public void validate(Object target, Errors errors) {
		Bike bike = (Bike) target;
		if(StringUtil.isEmpty(bike.getModel())){
			errors.rejectValue("model", "bike.model.empty.message");
		}
		
		if(StringUtil.isEmpty(bike.getManufacturer())){
			errors.rejectValue("manufacturer", "bike.manufac.empty.message");
		}
		
		if(bike.getPrice()==null){
			errors.rejectValue("price", "bike.price.empty.message");

		}
		
		if(bike.getClassification()==null){
			errors.rejectValue("price", "bike.classification.empty.message");

		}
		
		if(bike.getSize()==null){
			errors.rejectValue("price", "bike.size.empty.message");

		}
	}

}
