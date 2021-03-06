package com.example.timequest.DAOs;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.timequest.Entities.Era;
import com.example.timequest.Entities.User;

import java.util.List;

@Dao
public interface EraDAO {

    @Insert(onConflict = OnConflictStrategy.ABORT)
    public void insertEra(Era era);


    //method to update completion status if the user gets passes the trial
    @Query("UPDATE era SET era_completed = 'Complete' WHERE era_completed = 'Incomplete'")
    public void updateToCompleted();

    //method to update completion status if the user gets completes the trial perfectly
    @Query("UPDATE era SET era_completed = 'Perfect'")
    public void updateToPerfect();

    //method to update completion status if the user gets completes the trial perfectly
    @Query("UPDATE era SET eraNotes = :notes WHERE eraName = :name")
    public void updateNotes(String notes, String name);

    //method to get the user's notes for a specific ra
    @Query("SELECT eraNotes FROM era WHERE eraName = :name")
    public String getEraNotes(String name);

    //getting all the names of each era
    @Query("SELECT eraName FROM era")
    public List<String> getEraName();



}
