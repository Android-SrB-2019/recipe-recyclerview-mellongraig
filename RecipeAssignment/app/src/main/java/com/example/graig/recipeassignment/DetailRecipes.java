package com.example.graig.recipeassignment;

/**
 * Name: Graig Mellon
 * Date: 3/22/2019
 */


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetailRecipes extends AppCompatActivity {

    //call these global variables for this activity
    private TextView mRecipeName;
    private ImageView mRecipeImage;
    private TextView mRecipeIngredientsName;
    private TextView mRecipeIngredients;
    private TextView mRecipeDirectionsName;
    private TextView mRecipeDirections;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_recipes);

        mRecipeName = findViewById(R.id.recipe_name);
        mRecipeImage = findViewById(R.id.recipe_image);
        mRecipeIngredientsName = findViewById(R.id.recipe_ingredients);
        mRecipeIngredients = findViewById(R.id.recipelist_ingredients);
        mRecipeDirectionsName = findViewById(R.id.recipe_directions);
        mRecipeDirections = findViewById(R.id.recipelist_directions);

        Bundle mRecipeBundle = getIntent().getExtras();

        if(mRecipeBundle != null){
            mRecipeName.setText(mRecipeBundle.getString("name"));
            String recipeImage = mRecipeBundle.getString("image");
            mRecipeIngredientsName.setText(getString(R.string.ingredients));
            mRecipeIngredients.setText(mRecipeBundle.getString("ingredients"));
            mRecipeDirectionsName.setText(getString(R.string.directions));
            mRecipeDirections.setText(mRecipeBundle.getString("directions"));

            Picasso.get()
                    .load(recipeImage)
                    .fit()
                    .placeholder(R.drawable.ic_launcher_background)
                    .error(R.drawable.ic_launcher_background)
                    .into(mRecipeImage);
        }
    }
}
