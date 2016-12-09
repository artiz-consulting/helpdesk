// TODO: DELETE
package com.noname.helpdesk.command.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.noname.helpdesk.command.ObservableCommand;

/**
 * <p>
 * TestCommandFactory class.
 * </p>
 * 
 * @author Omar Ortiz.
 */
@Service
public class TestCommandFactory {

	private TestCommand testCommand;

	/**
	 * <p>
	 * Constructor for TestCommandFactory.
	 * </p>
	 * 
	 * @param testCommand
	 *            a {@link com.noname.helpdesk.command.test.TestCommand} object.
	 */
	@Autowired
	public TestCommandFactory(TestCommand testCommand) {
		this.testCommand = testCommand;
	}

	/**
	 * <p>
	 * Creates a new ObservableCommand for Testing purposes.
	 * </p>
	 *            
	 * @return an {@link com.noname.helpdesk.command.ObservableCommand<String>} object.
	 */
	public ObservableCommand<String> createTestCommand() {
		return testCommand;
	}
}
