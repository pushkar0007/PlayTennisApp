package org.kata.tennis.model;
/**
 * @author pushkar
 * Player Model
 * */
public class Player {
	
	private String username;

	public Player(String username) {

		this.username = username;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	    
}
