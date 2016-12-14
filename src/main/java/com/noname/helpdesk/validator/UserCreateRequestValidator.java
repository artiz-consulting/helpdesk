package com.noname.helpdesk.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.noname.helpdesk.exception.BadRequestException;
import com.noname.helpdesk.exception.ConflictException;
import com.noname.helpdesk.model.request.user.UserCreateRequest;
import com.noname.helpdesk.service.user.UserService;

/**
 * <p>
 * UserCreateRequestValidator class.
 * Validator to validate {@link com.noname.helpdesk.model.request.user.UserCreateRequest}.
 * </p>
 * 
 * @author Omar Ortiz.
 */
@Component
public class UserCreateRequestValidator implements Validator {

	private final UserService userService;

	/**
	 * <p>
	 * Constructor for UserCreateRequestValidator.
	 * </p>
	 * 
	 * @param userService
	 *            a {@link com.noname.helpdesk.service.user.UserService} object.
	 */
	@Autowired
	public UserCreateRequestValidator(UserService userService) {
		this.userService = userService;
	}

	/** {@inheritDoc} */
	@Override
	public boolean supports(Class<?> clazz) {
		return UserCreateRequest.class.equals(clazz);
	}

	/** {@inheritDoc} */
	@Override
	public void validate(Object target, Errors errors) {
		UserCreateRequest request = (UserCreateRequest) target;
		validatePasswords(request);
		validateEmail(request);
	}

	/**
	 * <p>
	 * Verifies that the passwords match.
	 * </p>
	 * 
	 * @param request
	 *            a {@link com.noname.helpdesk.model.request.user.UserCreateRequest} object.
	 */
	private void validatePasswords(UserCreateRequest request) {
		if(!request.getPassword().equals(request.getPasswordRepeat())) {
			throw new BadRequestException("Passwords does not match");
		}
	}

	/**
	 * <p>
	 * Verifies that the email is unique.
	 * </p>
	 * 
	 * @param request
	 *            a {@link com.noname.helpdesk.model.request.user.UserCreateRequest} object.
	 */
	private void validateEmail(UserCreateRequest request) {
		if(userService.getUserByEmail(request.getEmail()).isPresent()) {
			throw new ConflictException("Email already exists");
		}
	}
}
