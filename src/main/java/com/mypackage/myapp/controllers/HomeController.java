package com.mypackage.myapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView welcomePage() {

	    ModelAndView home = new ModelAndView("home"); 


	    return home;
	}
	
	@RequestMapping(value = "/about", method = RequestMethod.GET)
	public ModelAndView aboutPage() {

	    ModelAndView about = new ModelAndView("about"); 


	    return about;
	}
	
	@RequestMapping(value = "/contact", method = RequestMethod.GET)
	public ModelAndView contactPage() {

	    ModelAndView contact = new ModelAndView("contact"); 


	    return contact;
	}
	

//	@RequestMapping(value = "/", method = RequestMethod.GET)
//	public String home(Locale locale, Model model) {
//
//		return "home";
//	}
//	@RequestMapping(value = "/home", method = RequestMethod.GET)
//	public String home2(Locale locale, Model model) {
//
//		return "home";
//	}

	// private static final Logger logger =
	// LoggerFactory.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	// @RequestMapping(value = "/", method = RequestMethod.GET)
	// public String home(Locale locale, Model model) {
	// logger.info("Welcome home! The client locale is {}.", locale);
	//
	// /*
	// * metoda getDate wyeksponowana by byla dostepna dla innych kontrolerow
	// * by data byla zawsze w stopce
	// */
	// model.addAttribute("serverTime", getDate(locale));
	//
	// return "home";
	// }

	// @RequestMapping("/hello")
	// public ModelAndView helloWorld(Locale locale, Model model) {
	// model.addAttribute("serverTime", getDate(locale));
	//
	// StringBuffer message = new StringBuffer();
	// System.out.println(locale.toString());
	// if (locale.toString().equals("pl")) {
	// message.append("Witaj �wiecie!");
	// } else if (locale.toString().equals("en")) {
	// message.append("Hello World!");
	//
	// } else if (locale.toString().equals("de")) {
	// message.append("Hallo Welt!");
	//
	// } else if (locale.toString().equals("ja")) {
	// message.append("Hello, I'm JAVA and I don't know Japanese, sorry :)");
	//
	// }
	//
	// return new ModelAndView("hello", "message", message);
	// }

	// @RequestMapping("/")
	// public String home(HttpServletRequest request) {
	// System.out.println(request.getServletPath());
	// return "home";
	// }

	// public static String getDate(Locale locale) {
	//
	// Date date = new Date();
	// DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,
	// DateFormat.LONG, locale);
	// String formattedDate = dateFormat.format(date);
	//
	// return formattedDate;
	//
	// }

}
