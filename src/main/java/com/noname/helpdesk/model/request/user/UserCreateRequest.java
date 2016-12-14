package com.noname.helpdesk.model.request.user;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotEmpty;

import com.noname.helpdesk.model.domain.user.Role;

/**
 * <p>
 * UserCreateRequest class. User request received from client for creation.
 * </p>
 * 
 * @author Omar Ortiz.
 */
public class UserCreateRequest implements Serializable {

	/** Constant <code>serialVersionUID=-9077759529079281285L</code> */
	private static final long serialVersionUID = -9077759529079281285L;

	@NotEmpty
	private String email;

	@NotEmpty
	private String password;

	@NotEmpty
	private String passwordRepeat;

	@NotEmpty
	private Role role;

	/**
	 * <p>
	 * Getter for the field <code>email</code>.
	 * </p>
	 * 
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * <p>
	 * Setter for the field <code>email</code>.
	 * </p>
	 * 
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * <p>
	 * Getter for the field <code>password</code>.
	 * </p>
	 * 
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * <p>
	 * Setter for the field <code>password</code>.
	 * </p>
	 * 
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * <p>
	 * Getter for the field <code>passwordRepeat</code>.
	 * </p>
	 * 
	 * @return the passwordRepeat
	 */
	public String getPasswordRepeat() {
		return passwordRepeat;
	}

	/**
	 * <p>
	 * Setter for the field <code>passwordRepeat</code>.
	 * </p>
	 * 
	 * @param passwordRepeat
	 *            the passwordRepeat to set
	 */
	public void setPasswordRepeat(String passwordRepeat) {
		this.passwordRepeat = passwordRepeat;
	}

	/**
	 * <p>
	 * Getter for the field <code>role</code>.
	 * </p>
	 * 
	 * @return the role
	 */
	public Role getRole() {
		return role;
	}

	/**
	 * <p>
	 * Setter for the field <code>role</code>.
	 * </p>
	 * 
	 * @param role
	 *            the role to set
	 */
	public void setRole(Role role) {
		this.role = role;
	}
}
