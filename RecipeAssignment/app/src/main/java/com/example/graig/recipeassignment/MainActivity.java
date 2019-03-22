package com.example.graig.recipeassignment;

/**
 * Name: Graig Mellon
 * Date: 3/22/2019
 */

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecipeListAdapter mRecipeAdapter;
    private RecyclerView.LayoutManager mRecipeLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
