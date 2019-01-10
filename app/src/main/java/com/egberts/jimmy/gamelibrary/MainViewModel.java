package com.egberts.jimmy.gamelibrary;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;

import java.util.List;

class MainViewModel extends ViewModel {
    private GameRepository gameRepository;
    private LiveData<List<GameItem>> gameItems;

    MainViewModel(Context context) {
        gameRepository = new GameRepository(context);
        gameItems = gameRepository.getAllGameItems();
    }

    LiveData<List<GameItem>> getAllGameItems() {
        return gameItems;
    }

    void insert(GameItem gameItem) {
        gameRepository.insert(gameItem);
    }

    void update(GameItem gameItem) {
        gameRepository.update(gameItem);
    }

    void delete(GameItem gameItem) {
        gameRepository.delete(gameItem);
    }
}
