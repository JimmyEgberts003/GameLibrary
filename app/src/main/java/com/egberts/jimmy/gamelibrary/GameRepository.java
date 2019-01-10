package com.egberts.jimmy.gamelibrary;

import android.arch.lifecycle.LiveData;
import android.content.Context;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

class GameRepository {

    private GameDao gameDao;
    private LiveData<List<GameItem>> gameItems;
    private Executor executor = Executors.newSingleThreadExecutor();

    GameRepository(Context context) {
        AppDatabase appDatabase = AppDatabase.getInstance(context);
        gameDao = appDatabase.gameDao();
        gameItems = gameDao.getAllGameItems();
    }
    
    LiveData<List<GameItem>> getAllGameItems() {
        return gameItems;
    }

    void insert(final GameItem gameItem) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                gameDao.insertGameItem(gameItem);
            }
        });

    }

    void update(final GameItem gameItem) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                gameDao.updateGameItem(gameItem);
            }
        });

    }

    void delete(final GameItem gameItem) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                gameDao.deleteGameItem(gameItem);
            }
        });
    }
}
