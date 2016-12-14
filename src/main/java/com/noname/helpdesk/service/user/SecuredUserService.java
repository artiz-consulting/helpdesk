package com.noname.helpdesk.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.noname.helpdesk.model.domain.user.SecuredUser;
import com.noname.helpdesk.model.domain.user.User;

/**
 * <p>
 * SecuredUserService class. Service used it to map it to SecuredUser.
 * </p>
 * 
 * @author Omar Ortiz.
 */
@Service
public class SecuredUserService implements UserDetailsService {

	private final UserService userService;

	@Autowired
	public SecuredUserService(UserService userService) {
		this.userService = userService;
	}

	/** {@inheritDoc} */
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = userService.getUserByEmail(email)
				.orElseThrow(() -> new UsernameNotFoundException(
						String.format("User with email: %s not found", email)));
		return new SecuredUser(user);
	}
}
