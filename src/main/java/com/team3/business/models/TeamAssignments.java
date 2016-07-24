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
	
	@Override
	public boolean equals(Object obj) {
		// If the object is compared with itself then return true  
        if (obj == this) {
            return true;
        }
 
        /* Check if o is an instance of Complex or not
          "null instanceof [type]" also returns false */
        if (!(obj instanceof TeamAssignments)) {
            return false;
        }
         
        // typecast o to Complex so that we can compare data members 
        TeamAssignments ta = (TeamAssignments) obj;
         
        // Compare the data members and return accordingly 
        return teamId.equals(ta.getTeamId());
	}
}
