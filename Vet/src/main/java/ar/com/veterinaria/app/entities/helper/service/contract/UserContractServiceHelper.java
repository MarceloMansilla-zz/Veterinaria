package ar.com.veterinaria.app.entities.helper.service.contract;

import ar.com.veterinaria.app.entities.user.User;

public interface UserContractServiceHelper{
	boolean isValidEmail(User user);

	boolean isValidLengthPasword(User user);
	
	boolean isValidPasword(User user);
	
	boolean matchPaswordAndConfirmPassword(User user);
}
