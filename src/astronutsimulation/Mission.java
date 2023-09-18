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
public class Mission implements Serializable {
    private String missionName, missionDestination, missionDuration;
    private int leaderId, missionCost;
    private ArrayList<String> collectionOfAstronutId;

    public Mission(String missionName, String missionDestination, String missionDuration, int leaderId, int missionCost, ArrayList<String> collectionOfAstronutId) {
        this.missionName = missionName;
        this.missionDestination = missionDestination;
        this.missionDuration = missionDuration;
        this.leaderId = leaderId;
        this.missionCost = missionCost;
        this.collectionOfAstronutId = collectionOfAstronutId;
    }

    public String getMissionName() {
        return missionName;
    }

    public String getMissionDestination() {
        return missionDestination;
    }

    public String getMissionDuration() {
        return missionDuration;
    }

    public int getLeaderId() {
        return leaderId;
    }

    public int getMissionCost() {
        return missionCost;
    }

    public ArrayList<String> getCollectionOfAstronutId() {
        return collectionOfAstronutId;
    }

    public void addNewMission(Mission newMission){
        DataReadWrite.writeObjectToFile("Mission.bin", newMission);
        GenerateAlerts.successfulAlert("Mission added Successfully!");
    }
   
    
}
