/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package astronutsimulation;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Hasib
 */
public class MissionDataTable implements Serializable {
    private String missionName;
    private int leaderId, teamSize, cost;
    private ArrayList<String> memberofMission;

    public MissionDataTable(String missionName, int leaderId, int teamSize, int cost, ArrayList<String> memberofMission) {
        this.missionName = missionName;
        this.leaderId = leaderId;
        this.teamSize = teamSize;
        this.cost = cost;
        this.memberofMission = memberofMission;
    }

    public String getMissionName() {
        return missionName;
    }

    public int getLeaderId() {
        return leaderId;
    }

    public int getTeamSize() {
        return teamSize;
    }

    public int getCost() {
        return cost;
    }

    public ArrayList<String> getMemberofMission() {
        return memberofMission;
    }
    
}
