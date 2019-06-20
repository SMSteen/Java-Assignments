package com.polly.thecode;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class HomeController {
	private String pwd = "12thManBiggestFan";

	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(@RequestParam(value="pwd") String pwd, RedirectAttributes redirectAttributes) {
		if(pwd.equals(this.pwd)) {
			System.out.println("You are a true Seattle Seahawks fan!");
			return "code.jsp";
		} else {
			redirectAttributes.addFlashAttribute("error", "You are not worthy. You must train harder!");
			System.out.println(pwd);
			System.out.println(redirectAttributes.getFlashAttributes());
			return "redirect:/";
		}
		
	}
}
