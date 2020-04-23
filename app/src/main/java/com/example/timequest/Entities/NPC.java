package com.example.timequest.Entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.ArrayList;

public class NPC {

    private int npcID;

    private String npcName;

    //searchterm used for API learning content
    private String searchTerm;

    //what the NPC greets the user with
    private String welcomeSpeech;

    //what the NPC says to the user if they beat the trial
    private String endingSpeech;

    //what the NPC says to the user if they fail the trial
    private String failSpeech;

    //what they look like
    private String npcAvatar;

    //VideoID for video player
    private String videoID;

    public NPC(int npcID, String npcName, String searchTerm, String welcomeSpeech, String endingSpeech, String failSpeech, String npcAvatar, String videoID) {
        this.npcID = npcID;
        this.npcName = npcName;
        this.searchTerm = searchTerm;
        this.welcomeSpeech = welcomeSpeech;
        this.endingSpeech = endingSpeech;
        this.failSpeech = failSpeech;
        this.npcAvatar = npcAvatar;
        this.videoID = videoID;
    }

    public int getNpcID() {
        return npcID;
    }

    public void setNpcID(int npcID) {
        this.npcID = npcID;
    }

    public String getNpcName() {
        return npcName;
    }

    public String getSearchTerm() { return searchTerm; }

    public void setSearchTerm(String searchTerm) { this.searchTerm = searchTerm; }

    public void setNpcName(String npcName) {
        this.npcName = npcName;
    }

    public String getWelcomeSpeech() {
        return welcomeSpeech;
    }

    public void setWelcomeSpeech(String welcomeSpeech) {
        this.welcomeSpeech = welcomeSpeech;
    }

    public String getEndingSpeech() {
        return endingSpeech;
    }

    public void setEndingSpeech(String endingSpeech) {
        this.endingSpeech = endingSpeech;
    }

    public String getFailSpeech() {
        return failSpeech;
    }

    public void setFailSpeech(String failSpeech) {
        this.failSpeech = failSpeech;
    }

    public String getNpcAvatar() {
        return npcAvatar;
    }

    public void setNpcAvatar(String npcAvatar) {
        this.npcAvatar = npcAvatar;
    }

    public String getVideoID() { return videoID; }

    public void setVideoID(String videoID) { this.videoID = videoID; }

    public static ArrayList<NPC> addNPCData(){
        ArrayList<NPC> npcs = new ArrayList<>();
        npcs.add(new NPC(1, "Spartan Warrior",
                "spartan_army","You there! You seem like a fine soldier.\n" +
                        "I'm a Spartan! If you beat me, I'll let you join our legendary ranks...\n" +
                        "but I have to warn you...we're no common army. \n I'll leave you at the top of Mount Taygetus if you're not strong enough!",
                "I admit defeat.\n You're truly a warror worthy of our army. Here is a token of our battle...may it bring you good fortune in your travels!",
                "You're no match for the might of Sparta!", "npcspartan","pJJxWdJVpvU"));
        npcs.add(new NPC(2, "North Sentinel Islander","sentinelese"
                ,"Hey...what are you doing here?!\n" +
                        "Get off our island!!! \n" +
                        "...what's that? You think you can beat me? I'd like to see you try!\n" +
                        "I'll let you stay with us if you pass this test..." ,
                "...I guess you can stay on this island.\n Here, take this. This will prove you're one of us now!",
                "That was flimsy. Come back to me when you're ready to try again.", "npcsentinel","Xk4gunNQVec"));
        npcs.add(new NPC(3, "Roman Legionary","legionary",
                "Welcome to Rome, heart of the glorious Roman Empire.\n" +
                        "...\n" +
                        "You want to see the emperor? A peasant like you can't possibly imagine seeing our emperor!\n" +
                        "I see you're looking for trouble...how about this - if you conquer this challenge, I'll let you keep your head! ",
                "You really did it! What a turn of events!\n" +
                        "Maybe you aren't looking for trouble after all. Here, this will prove you're part of the empire now!",
                "Did you really think you could beat an elite Roman like myself? \n" +
                         "The Emperor will never see you at this rate. Come back when you've properly trained!", "npcroman","BIqWKPA83V0"));
        npcs.add(new NPC(4, "Athenian Man","Classical_Athens",
                "Welcome wandering traveller.", "xxx","xxx", "avatar1","ar8S6virCwM"));
        npcs.add(new NPC(5, "Norman Crusader","normans",
                "I am Norman", "xxx","xxx", "avatar1","Owf5Uq4oFps"));
        npcs.add(new NPC(6, "Cossack Warrior","cossacks",
                "I am Cossack", "xxx","xxx", "avatar1","33cP54FcERA"));
        npcs.add(new NPC(7, "Neanderthal","neanderthal",
                "I...caveman", "xxx","xxx", "avatar1","G2i2vCu9WMo"));
        npcs.add(new NPC(8, "Qing Eunuch","qing_dynasty",
                "Ni hao", "xxx","xxx", "avatar1","mP5p4QbvPtc"));
        npcs.add(new NPC(9, "Viking","vikings",
                "I am a Viking!", "xxx","xxx", "avatar1","FfLYCodzaBA"));

        return npcs;
    }

}
