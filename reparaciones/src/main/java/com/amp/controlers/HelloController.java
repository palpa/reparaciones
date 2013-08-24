package com.amp.controlers;

import java.util.Arrays;
import java.util.List;

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
		
		List<Item> items = Arrays.asList(
			      new Item("Item 1", "$19.99", Arrays.asList(new Feature("New!"), new Feature("Awesome!"))),
			      new Item("Item 2", "$29.99", Arrays.asList(new Feature("Old."), new Feature("Ugly.")))
			    );
		
		m.addAttribute("items", items);
		
		return "hello";
	}

	static class Item {
		Item(String name, String price, List<Feature> features) {
			this.name = name;
			this.price = price;
			this.features = features;
		}

		String name, price;
		List<Feature> features;
	}

	static class Feature {
		Feature(String description) {
			this.description = description;
		}

		String description;
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