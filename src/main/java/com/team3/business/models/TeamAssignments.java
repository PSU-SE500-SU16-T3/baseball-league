package com.team3.business.models;

import java.util.List;

public class TeamAssignments {
	private String teamId;	
	List<TeamAssignment> teamAssignments;	

	public String getTeamId() {
		return teamId;
	}

	public void setTeamId(String teamId) {
		this.teamId = teamId;
	}

	public List<TeamAssignment> getTeamAssignments() {
		return teamAssignments;
	}

	public void setTeamAssignments(List<TeamAssignment> teamAssignments) {
		this.teamAssignments = teamAssignments;
	}
}
