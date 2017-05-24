package com.example.joanna.fragmentpractice;


public class IngredientFragment extends CheckboxesFragment {
    @Override
    public String[] getContexts(int index) {
        return Recipes.ingredients[index].split("`");
    }
}
