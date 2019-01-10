package com.egberts.jimmy.gamelibrary;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface GameDao {

    @Query("SELECT * FROM game")
    LiveData<List<GameItem>> getAllGameItems();

    @Insert
    void insertGameItem(GameItem gameItem);

    @Delete
    void deleteGameItem(GameItem gameItem);

    @Update
    void updateGameItem(GameItem gameItem);
}

