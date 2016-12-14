package com.noname.helpdesk.service.user;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.noname.helpdesk.model.domain.user.User;
import com.noname.helpdesk.model.request.user.UserCreateRequest;
import com.noname.helpdesk.repository.user.UserRepository;

/**
 * <p>
 * UserServiceImpl class. UserService implementation.
 * </p>
 * 
 * @author Omar Ortiz.
 */
@Service
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;

	/**
	 * <p>
	 * Constructor for UserServiceImpl.
	 * </p>
	 * 
	 * @param userRepository
	 *            a {@link com.noname.helpdesk.repository.user.UserRepository} object.
	 */
	@Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

	/** {@inheritDoc} */
	@Override
	public Collection<User> getAllUsers() {
		return userRepository.findAll(new Sort("email"));
	}

	/** {@inheritDoc} */
	@Override
	public Optional<User> getUserById(long id) {
		return Optional.ofNullable(userRepository.findOne(id));
	}

	/** {@inheritDoc} */
	@Override
	public Optional<User> getUserByEmail(String email) {
		return userRepository.findOneByEmail(email);
	}

	/** {@inheritDoc} */
	@Override
	public User create(UserCreateRequest request) {
		final User user = new User();
		user.setEmail(request.getEmail());
		user.setPasswordHash(new BCryptPasswordEncoder().encode(request.getPassword()));
		user.setRole(request.getRole());
		return userRepository.save(user);
	}
}
