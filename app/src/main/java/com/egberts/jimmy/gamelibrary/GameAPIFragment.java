package com.egberts.jimmy.gamelibrary;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.json.JSONException;

public class GameAPIFragment extends Fragment {

    public static final int RESULT_OK = -1;

    private AppDatabase appDatabase;
    private GameAPIItem gameAPIItem;

    public static GameAPIFragment newInstance(GameAPIItem gameAPIItem) {
        GameAPIFragment fragment = new GameAPIFragment();
        fragment.setGameAPIItem(gameAPIItem);
        return fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        final TextView gameAPIItemName = rootView.findViewById(R.id.gameAPITitle);
        gameAPIItemName.setText(gameAPIItem.getName());

        final TextView gameAPIItemDescription = rootView.findViewById(R.id.gameAPIDescription);
        gameAPIItemDescription.setText(gameAPIItem.getOriginal_release_date());

        appDatabase = AppDatabase.getInstance(rootView.getContext());

        ImageButton addGameAPIButton = rootView.findViewById(R.id.addGameAPIItemButton);
        addGameAPIButton.setOnClickListener(new View.OnClickListener() {

            GameItem gameItem = new GameItem(gameAPIItemName.getText().toString(), gameAPIItemDescription.getText().toString());

            @Override
            public void onClick(View view) {
                appDatabase.gameDao().insertGameItem(gameItem);

                Intent intent = new Intent();
                getActivity().setResult(RESULT_OK, intent);
                getActivity().finish();
            }
        });

        return rootView;
    }

    public void setGameAPIItem(GameAPIItem gameAPIItem) {
        this.gameAPIItem = gameAPIItem;
    }
}
