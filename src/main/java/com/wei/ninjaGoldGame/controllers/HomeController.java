package com.wei.ninjaGoldGame.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.wei.ninjaGoldGame.models.Log;


@Controller
public class HomeController {

	
	@RequestMapping("/gold")
	public String index(HttpSession session) {
		if (session.getAttribute("score") == null) {
			session.setAttribute("score", 0);
			session.setAttribute("message", "");
		}

		return "index.jsp";
	}
	
	
	// route for farm POST
	@PostMapping("/farm")
	public String farm(
			@RequestParam(value="farm") String farm,
			HttpSession session
			) {
		Integer score = (Integer) session.getAttribute("score");
		Integer farmScore = Integer.parseInt(farm);
		
		String message =  (String) session.getAttribute("message");
		String newMessage = new Log("farm", farmScore).message();

		session.setAttribute("score", score += farmScore);
		session.setAttribute("message", message += "<div style='color: green;'>" + newMessage + "<div>");

		
		return "redirect:/gold";
	}
	
	
	// route for cave POST
	@PostMapping("/cave")
	public String cave(
			@RequestParam(value="cave") String cave,
			HttpSession session
			) {
		Integer score = (Integer) session.getAttribute("score");
		Integer caveScore = Integer.parseInt(cave);

		String message =  (String) session.getAttribute("message");
		String newMessage = new Log("cave", caveScore).message();
		
		
		session.setAttribute("score", score += caveScore);
		session.setAttribute("message", message += "<div style='color: green;'>" + newMessage + "<div>");

		
		return "redirect:/gold";
	}
	
	
	// route for house POST
	@PostMapping("/house")
	public String house(
			@RequestParam(value="house") String house,
			HttpSession session
			) {
		Integer score = (Integer) session.getAttribute("score");
		Integer houseScore = Integer.parseInt(house);
		
		session.setAttribute("score", score += houseScore);
		
		String message =  (String) session.getAttribute("message");
		String newMessage = new Log("house", houseScore).message();

		session.setAttribute("message", message += "<div style='color: green;'>" + newMessage + "<div>");
		
		return "redirect:/gold";
	}
	
	
	// route for casino POST
	@PostMapping("/casino")
	public String casino(
			@RequestParam(value="casino") String casino,
			HttpSession session
			) {
		Integer score = (Integer) session.getAttribute("score");
		Integer casinoScore = Integer.parseInt(casino);

		session.setAttribute("score", score += casinoScore);
		
		String message =  (String) session.getAttribute("message");
		String newMessage = new Log("casino", casinoScore).message();
		
		if (newMessage.contains("lost")) {
			session.setAttribute("message", message += "<div style='color: red;'>" + newMessage + "</div>");
		} else {
			session.setAttribute("message", message += "<div style='color: green;'>" + newMessage + "<div>");
		}
		
		return "redirect:/gold";
	}
}
