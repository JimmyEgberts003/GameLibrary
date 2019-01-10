package com.egberts.jimmy.gamelibrary;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@Database(entities = {GameItem.class}, version = 1)
abstract class AppDatabase extends RoomDatabase {

    abstract GameDao gameDao();
    private final static String DATABASE_NAME = "game_db";
    private static AppDatabase appDatabaseInstance;

    // Return either a new instance if no instance exists, or return a new instance.
    static AppDatabase getInstance(Context context) {
        if (appDatabaseInstance == null) {
            appDatabaseInstance = Room.databaseBuilder(context, AppDatabase.class, DATABASE_NAME).allowMainThreadQueries().build();
        }
        return appDatabaseInstance;
    }
}
