package com.teamroster.models;

import java.io.Serializable;
import java.util.ArrayList;

public class Roster {
	private ArrayList<Team> teams = new ArrayList<Team>();
	
	public Roster() {}
	
	public ArrayList<Team> getTeams() {
		return teams;
	}
	public void setTeams(Team newTeam) {
		this.teams.add(newTeam);
	}

}
