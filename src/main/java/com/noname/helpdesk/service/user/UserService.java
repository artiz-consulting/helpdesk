package com.noname.helpdesk.service.user;

import java.util.Collection;
import java.util.Optional;

import com.noname.helpdesk.model.domain.user.User;
import com.noname.helpdesk.model.request.user.UserCreateRequest;

/**
 * <p>
 * UserService interface. Service used for user actions.
 * </p>
 * 
 * @author Omar Ortiz.
 */
public interface UserService {

	/**
	 * <p>
	 * Retrieves a collection of all {@link com.noname.helpdesk.model.domain.user.User}.
	 * </p>
	 * 
	 * @return a {@link java.util.Collection<User>} object.
	 */
	Collection<User> getAllUsers();

	/**
	 * <p>
	 * Retrieves a single {@link com.noname.helpdesk.model.domain.user.User} from its id.
	 * </p>
	 * 
	 * @param id
	 *            {@link java.lang.Long}
	 * @return a {@link java.util.Optional<User>} object.
	 */
	Optional<User> getUserById(long id);

	/**
	 * <p>
	 * Retrieves a single {@link com.noname.helpdesk.model.domain.user.User} from its email.
	 * </p>
	 * 
	 * @param email
	 *            {@link java.lang.String}
	 * @return a {@link java.util.Optional<User>} object.
	 */
	Optional<User> getUserByEmail(String email);

	/**
	 * <p>
	 * Creates a new {@link com.noname.helpdesk.model.domain.user.User} from the
	 * {@link com.noname.helpdesk.model.request.user.UserCreateRequest} request.
	 * </p>
	 * 
	 * @param request
	 *            {@link com.noname.helpdesk.model.request.user.UserCreateRequest}
	 * @return a {@link com.noname.helpdesk.model.domain.user.User} object.
	 */
	User create(UserCreateRequest request);
}
