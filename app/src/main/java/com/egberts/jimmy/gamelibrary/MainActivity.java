package com.egberts.jimmy.gamelibrary;

import android.arch.lifecycle.Observer;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static final int REQUEST_CODE = 1234;

    private List<GameItem> gameItemList;

    private GameAdapter gameAdapter;
    private MainViewModel mainViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainViewModel = new MainViewModel(getApplicationContext());
        mainViewModel.getAllGameItems().observe(this, new Observer<List<GameItem>>() {
            @Override
            public void onChanged(@Nullable List<GameItem> newGameItemList) {
                gameItemList = newGameItemList;
                gameAdapter.swapList(newGameItemList);
            }
        });

        gameItemList = new ArrayList<>();
        gameAdapter = new GameAdapter(gameItemList);

        RecyclerView gameItemsView = findViewById(R.id.gameItemsView);
        gameItemsView.setLayoutManager(new GridLayoutManager(this, LinearLayoutManager.VERTICAL));
        gameItemsView.setAdapter(gameAdapter);

        ItemTouchHelper.SimpleCallback callback = getTouchHelperCallback();
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(callback);
        itemTouchHelper.attachToRecyclerView(gameItemsView);

        ImageButton addTriviaItemButton = findViewById(R.id.addGameItemButton);
        addTriviaItemButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create new intent, showing the 'add game' screen.
                Intent intent = new Intent(MainActivity.this, AddGameItem.class);
                startActivityForResult(intent, REQUEST_CODE);
            }
        });
    }


    @NonNull
    private ItemTouchHelper.SimpleCallback getTouchHelperCallback() {
        return new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {

            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int swipeDir) {
                mainViewModel.delete(gameItemList.remove(viewHolder.getAdapterPosition()));
            }
        };
    }
}
