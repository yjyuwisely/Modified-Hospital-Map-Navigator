package aaa.bbb.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "home";
	}

	@GetMapping("testpage")
	public String testpage() {
		logger.info("Welcome testpage!");
		return "testpage";
	}

	@GetMapping("departmentList")
	public String departmentList() {
		logger.info("Welcome departmentList!");
		return "departmentList";
	}

	/*
	 * @GetMapping("departmentMap") public String departmentMap() {
	 * logger.info("Welcome departmentMap!"); return "departmentMap"; }
	 */

	@RequestMapping(value = "/departmentMap", method = RequestMethod.POST)
	public String showDepartmentMap(@RequestParam("department") String department, Model model) {
		// Logic to handle the selected department and prepare data for the
		// departmentMap.jsp
		// Add the necessary data to the model
		model.addAttribute("selectedDepartment", department);

		// Return the view name (departmentMap.jsp)
		return "departmentMap";

	}
}
