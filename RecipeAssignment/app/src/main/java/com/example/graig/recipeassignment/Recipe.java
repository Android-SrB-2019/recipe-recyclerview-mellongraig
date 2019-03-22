package com.example.graig.recipeassignment;

import java.util.LinkedList;

/**
 * Name: Graig Mellon
 * Date: 3/21/2019
 */

public class Recipe {

    public Recipe(String name, String description, String image, String ingredients, String directions) {
        //call each variable instance by using this
        this.name = name;
        this.description = description;
        this.image = image;
        this.ingredients = ingredients;
        this.directions = directions;
    }

    //variable declarations
    public String name;
    public String description;
    public String image;
    public String ingredients;
    public String directions;

    /**
     * Get the recipes from the data provider
     * @return recipe list
     */
    public static LinkedList<Recipe> getRecipes(){
        return DataProvider.getRecipes();
    }
}