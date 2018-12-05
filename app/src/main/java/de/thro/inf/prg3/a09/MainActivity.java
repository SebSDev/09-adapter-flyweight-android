package de.thro.inf.prg3.a09;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ListView;

import java.util.LinkedList;
import java.util.List;

import de.thro.inf.prg3.a09.adapter.FighterRecyclerViewAdapter;
import de.thro.inf.prg3.a09.model.Fighter;
import de.thro.inf.prg3.a09.model.FighterFactory;
import de.thro.inf.prg3.a09.adapter.FighterListAdapter;

public class MainActivity extends AppCompatActivity
{

    private static final int FIGHTER_COUNT = 20;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FighterFactory fighterFactory = new FighterFactory(this);

        List<Fighter> fighters = new LinkedList<Fighter>();
        for (int i = 0; i < FIGHTER_COUNT; i++)
        {
            // adding new fighters to the adapter
            fighters.add(fighterFactory.createFighter());
        }

        FighterRecyclerViewAdapter fighterRecyclerViewAdapter = new FighterRecyclerViewAdapter(fighters);

        final RecyclerView fighterRecyclerView = findViewById(R.id.fighterListView);
        fighterRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        fighterRecyclerView.setAdapter(fighterRecyclerViewAdapter);


    }
}
