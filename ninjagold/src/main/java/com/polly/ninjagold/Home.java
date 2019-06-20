package com.polly.ninjagold;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Random; 

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Home {
	private int totalGold;
	private ArrayList<HashMap<String, String>> activities = new ArrayList<HashMap<String, String>>();
	
	@RequestMapping("/")
	public String index() {
		return "redirect:/gold";
	}
	
	@RequestMapping("/gold")
	public String gold(HttpSession session) {
		session.setAttribute("gold", this.totalGold);
		session.setAttribute("activities", this.activities);
		return "index.jsp";
	}

	
    @RequestMapping(value="gold", method=RequestMethod.POST)
    public String process(@RequestParam(value="building") String building) {
    	// get the timestamp
    	String pattern = "MMMMM d, yyyy 'at' KK':'m a";
    	SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
    	String date = simpleDateFormat.format(new Date());

    	// get the gold amount
		int gold = getGold(building);
		this.totalGold += gold;
		
		// if accumulated too much debt
		if (this.totalGold <= -75) {
			// redirect the user to debtors prison
	    	return "redirect:/prison";
		}
		
		// otherwise, proceed with game
		// create the hashmap to store activity
		HashMap<String, String> activity = new HashMap<String, String>();
		String term1;
		String term2;
		if (gold < 0) {
			activity.put("class", "loss");
			term1 = "lost";
			term2 = "Ouch!";
		} else {
			activity.put("class", "win");
			term1 = "earned";
			term2 = "Sweet!";
		}
		
		// put the activity in the hashmap
		activity.put("result", String.format("You entered a %s and %s %d gold. %s (%s)", building, term1, gold, term2, date));
		
		// put the hashmap in the activities list at the beginning
		this.activities.add(0, activity);
		
		// redirect the view
    	return "redirect:/gold";
    }
    
    @RequestMapping("/prison")
    public String over(HttpSession session) {
		// update session
		session.setAttribute("gold", this.totalGold);
		return "prison.jsp";
    }
    
	@RequestMapping("/reset")
	public String reset(HttpSession session) {
		// reset totalGold and activities
		this.totalGold = 0;
		this.activities.clear();
		
		// remove session
		session.invalidate();
		
		// redirect the view
    	return "redirect:/";
	}
    

	// helper method to determine amount of gold
	private int getGold(String bldg) {
		// generate random number
		Random r = new Random(); // create instance of Random class
	    switch (bldg) {
	        case "farm":
				return r.nextInt(20 - 10 + 1) + 10;
	        case "cave":
				return r.nextInt(10 - 5 + 1) + 5;
	        case "house":
	        	return r.nextInt(5 - 2 + 1) + 2;
	        case "spa":
	        	return -(r.nextInt(20 - 5 + 1) + 5);
	        default: 
	        	return r.nextInt(50 - -50 + 1) + -50;
	    }
	}
}
