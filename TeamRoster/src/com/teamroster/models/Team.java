package com.teamroster.models;

import java.util.ArrayList;

public class Team {
	private String teamName;
	private ArrayList<Player> players = new ArrayList<Player>();

	public Team(String name) {
		this.setTeamName(name);
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public void addPlayer(Player player) {
		this.getPlayers().add(player);
	}

	public int getNumPlayers() {
		return this.getPlayers().size();
	}

	public ArrayList<Player> getPlayers() {
		return players;
	}

}
