package com.noname.helpdesk.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * <p>
 * IndexController class. Start point of the application.
 * </p>
 * 
 * @author Omar Ortiz.
 */
@Controller
public class IndexController {

	@Value("${app.env}")
	private String env;

	@Value("${app.dashboardPage}")
	private String dashboardPage;

	/**
	 * <p>
	 * Retrieves the dashboard page.
	 * </p>
	 * 
	 * @return a {@link java.lang.String} object.
	 */
	@RequestMapping(value = "/dashboard", method = GET)
	public ModelAndView dashboard() {
		final ModelAndView mav = new ModelAndView(dashboardPage);
        mav.addObject("env", env);
        return mav;
	}
}
