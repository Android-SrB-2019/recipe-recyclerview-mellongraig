package com.example.graig.recipeassignment;

/**
 * Name: Graig Mellon
 * Date: 3/22/2019
 */


import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.LinkedList;

public class RecipeListAdapter extends RecyclerView.Adapter<RecipeListAdapter.RecipeViewHolder> {

    //call this variable to hold the recipe list, also use context to prepare for a second activity launch
    private final LinkedList<Recipe> mRecipeList;
    private Context mContext;

    /**
     * Inflates the item layout, attaches the parent with root to false, and then returns a view holder
     * @param parent
     * @param viewType
     * @return ViewHolder with layout
     */
    @Override
    public RecipeListAdapter.RecipeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View recipeView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recipelist_item, parent, false);
        return new RecipeViewHolder(recipeView);
    }

    /**
     * Connects the data to the recipe view holder
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(RecipeListAdapter.RecipeViewHolder holder, int position) {
        Recipe mCurrentRecipe = mRecipeList.get(position);
        holder.recipeItemView.setText(mCurrentRecipe.name);
        holder.recipeDescriptionView.setText(mCurrentRecipe.description);
    }

    /**
     * Gets the item count and returns the size
     * @return size of the list
     */
    @Override
    public int getItemCount() {
        return mRecipeList.size();
    }

    /**
     * Recipe view holder class
     */
    class RecipeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public final TextView recipeItemView;
        public final TextView recipeDescriptionView;

        /**
         * This will initialize the text view in the Recipe view holder
         * @param itemView
         */
        public RecipeViewHolder(View itemView){
            super(itemView);
            recipeItemView = itemView.findViewById(R.id.recipe_name);
            recipeDescriptionView = itemView.findViewById(R.id.recipe_description);
        }

        /**
         * This is to start the detailed recipe activity and show all elements there
         * @param v
         */
        @Override
        public void onClick(View v) {

            //call the recipe position to get the position of the main activity
            int mRecipePosition = getLayoutPosition();

            //call the recipe element
            Recipe recipeElement = mRecipeList.get(mRecipePosition);

            //start the detailed recipe activity by calling the intent
            Intent mRecipeIntent = new Intent(mContext, DetailRecipes.class);
            mRecipeIntent.putExtra("name", recipeElement.name);
            mRecipeIntent.putExtra("image", recipeElement.image);
            mRecipeIntent.putExtra("ingredients", recipeElement.ingredients);
            mRecipeIntent.putExtra("directions", recipeElement.directions);
            mContext.startActivity(mRecipeIntent);
        }
    }

    /**
     * Get the context and recipe list
     * @param mContext
     * @param mRecipeList
     */
    public RecipeListAdapter(Context mContext, LinkedList<Recipe> mRecipeList){
        this.mRecipeList = mRecipeList;
        this.mContext = mContext;
    }
}
