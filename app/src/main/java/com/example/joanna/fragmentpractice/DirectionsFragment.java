package com.example.joanna.fragmentpractice;


public class DirectionsFragment extends CheckboxesFragment {
    @Override
    public String[] getContexts(int index) {
        return Recipes.directions[index].split("`");
    }
}
