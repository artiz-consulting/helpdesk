package com.noname.helpdesk.repository.user;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.noname.helpdesk.model.domain.user.User;

/**
 * <p>
 * UserRepository interface. JPARepository used to interact with database queries.
 * </p>
 * 
 * @author Omar Ortiz.
 */
public interface UserRepository extends JpaRepository<User, Long> {

	/**
	 * <p>
	 * Retrieves a single {@link com.noname.helpdesk.model.domain.user.User} from its email.
	 * </p>
	 * 
	 * @param email
	 *            {@link java.lang.String}
	 * @return a {@link java.util.Optional<User>} object.
	 */
	Optional<User> findOneByEmail(String email);
}
