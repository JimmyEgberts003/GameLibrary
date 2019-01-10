package com.egberts.jimmy.gamelibrary;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

class GameAdapter extends RecyclerView.Adapter<GameAdapter.ViewHolder> {

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView gameTitle;
        TextView gameDescription;

        ViewHolder(View itemView) {
            super(itemView);
            gameTitle = itemView.findViewById(R.id.gameTitle);
            gameDescription = itemView.findViewById(R.id.gameReleaseDate);
        }
    }

    private List<GameItem> gameItems;

    GameAdapter(List<GameItem> gameItems) {
        this.gameItems = gameItems;
    }

    @NonNull
    @Override
    public GameAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.game_item, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull GameAdapter.ViewHolder viewHolder, int i) {
        viewHolder.gameTitle.setText(gameItems.get(i).getTitle());
        viewHolder.gameDescription.setText(gameItems.get(i).getDescription());
    }

    @Override
    public int getItemCount() {
        return gameItems.size();
    }

    void swapList(List<GameItem> newGameItems) {
        gameItems = newGameItems;
        if (newGameItems != null) {
            this.notifyDataSetChanged();
        }
    }
}

