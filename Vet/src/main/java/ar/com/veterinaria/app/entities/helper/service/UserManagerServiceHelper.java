package ar.com.veterinaria.app.entities.helper.service;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ar.com.veterinaria.app.entities.exception.invalidData.UserPasswordInvalidDataException;
import ar.com.veterinaria.app.entities.exception.validationLength.UserPasswordValidationLengthDataException;
import ar.com.veterinaria.app.entities.user.User;

@Service
@Transactional
public class UserManagerServiceHelper {

	@Autowired
	private static UserServiceHelper userServiceHelper;

	@SuppressWarnings("static-access")
	@Autowired
	public UserManagerServiceHelper(UserServiceHelper userServiceHelper) {
		this.userServiceHelper = userServiceHelper;
	}

	public static boolean validate(User user) {
		//VALIDATE EMAIL
		
		if (!userServiceHelper.isValidLengthPasword(user)) {
			throw new UserPasswordValidationLengthDataException(user);

		} else if (!userServiceHelper.isValidPasword(user)) {
			throw new UserPasswordInvalidDataException(user);
		}
		return true;
	}
}
