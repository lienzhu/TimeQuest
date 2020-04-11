package com.example.timequest.Entities;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Era {

    @PrimaryKey
    @NonNull
    private int eraID;

    private String eraName;

    private String eraBanner;

    private String eraBackground;

    //0 = uncompleted, 1 = completed, 2 = completed perfectly
    private int eraCompleted;

    public Era(int eraID, String eraName, String eraBanner, String eraBackground, int eraCompleted) {
        this.eraID = eraID;
        this.eraName = eraName;
        this.eraBanner = eraBanner;
        this.eraBackground = eraBackground;
        this.eraCompleted = eraCompleted;
    }

    public int getEraID() {
        return eraID;
    }

    public void setEraID(int eraID) {
        this.eraID = eraID;
    }

    public String getEraName() {
        return eraName;
    }

    public void setEraName(String eraName) {
        this.eraName = eraName;
    }

    public String getEraBanner() {
        return eraBanner;
    }

    public void setEraBanner(String eraBanner) {
        this.eraBanner = eraBanner;
    }

    public String getEraBackground() {
        return eraBackground;
    }

    public void setEraBackground(String eraBackground) {
        this.eraBackground = eraBackground;
    }

    public int getEraCompleted() {
        return eraCompleted;
    }

    public void setEraCompleted(int eraCompleted) {
        this.eraCompleted = eraCompleted;
    }
}
