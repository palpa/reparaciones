package com.amp.controlers;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/")
public class HelloController {

	protected final Log logger = LogFactory.getLog(getClass());

	@RequestMapping(method = RequestMethod.GET)
	public String getIndex() {
		return "index";
	}

	@RequestMapping("hello")
	public String loadHelloPage(Model m) {
		m.addAttribute("name", "Mustache..");
		m.addAttribute("pagina", "partial.html");
		return "hello";
	}

	// @RequestMapping(value = "/hello.htm")
	// public ModelAndView handleRequest(HttpServletRequest request,
	// HttpServletResponse response) throws ServletException, IOException {
	//
	// logger.info("Entre al controlador");
	//
	// return new ModelAndView("hello");
	// }

}