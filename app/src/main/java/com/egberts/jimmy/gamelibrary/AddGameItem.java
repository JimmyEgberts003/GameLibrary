package com.egberts.jimmy.gamelibrary;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddGameItem extends AppCompatActivity {

    private final String QUERY_FORMAT = "json";
    private final Integer QUERY_LIMIT = 5;

    private List<GameAPIItem> gameAPIItemList;
    private SectionsPagerAdapter mSectionsPagerAdapter;

    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return GameAPIFragment.newInstance(gameAPIItemList.get(position));
        }

        @Override
        public int getCount() {
            return gameAPIItemList.size();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_game_item);

        gameAPIItemList = new ArrayList<>();
        getGamesAPI();

        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        final ViewPager mViewPager = findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);
    }

    private void getGamesAPI() {
        GameAPIClient client = GameAPIClient.retrofit.create(GameAPIClient.class);
        Call<Games> call = client.getGames(GameAPIClient.API_KEY, QUERY_FORMAT, QUERY_LIMIT);
        call.enqueue(new Callback<Games>() {
            @Override
            public void onResponse(@NonNull Call<Games> call, @NonNull Response<Games> response) {
                if (response.isSuccessful()) {
                    Games games = response.body();
                    for (int i = 0; i < QUERY_LIMIT; i++) {
                        assert games != null;
                        gameAPIItemList.add(games.getResults().get(i));
                        mSectionsPagerAdapter.notifyDataSetChanged();
                    }
                } else {
                    showToast("Retrieving games failed!");
                }
            }

            @Override
            public void onFailure(@NonNull Call<Games> call, @NonNull Throwable t) {
                showToast("Connecting to external API failed!");
            }
        });
    }

    private void showToast(String message) {
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, message, duration);
        toast.show();
    }
}
