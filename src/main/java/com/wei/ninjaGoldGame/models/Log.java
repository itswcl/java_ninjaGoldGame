package com.wei.ninjaGoldGame.models;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Log {

	// member variable
	private String action;
	private int gold;
	
	public Log(String action, int gold) {
		this.setAction(action);
		this.setGold(gold);
	}
	
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public int getGold() {
		return gold;
	}
	public void setGold(int gold) {
		this.gold = gold;
	}
	
	public String message() {
		Date date = new Date();
		String str = new SimpleDateFormat("MMMM dd yyyy hh:mm aa").format(date);
		
		int number = this.getGold();
		
		if (number < 0) {
			return String.format("You entered a %s and lost %s gold. Ouch.  (%s)", this.getAction(), Math.abs(number), str);
		} else {
			return String.format("You entered a %s and earns %s gold. (%s)", this.getAction(), number, str);
		}
		
	}
	
}
