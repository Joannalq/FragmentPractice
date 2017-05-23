package com.example.joanna.fragmentpractice;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;

public class IngredientsFragment extends Fragment {
    private static final String KEY_CHECKED_BOXES ="KEY_CHECKED_BOXES" ;
    private CheckBox[] mCheckBoxes;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        int index=getArguments().getInt(ViewPagerFragment.KEY_INDEX);
        View view=inflater.inflate(R.layout.fragment_ingredient,container,false);
        LinearLayout linearLayout= (LinearLayout) view.findViewById(R.id.ingredientsLayout);
        //dynamic set checkbox
        String[] ingredients=Recipes.ingredients[index].split("`");
        //save and restore checkbox
        mCheckBoxes=new CheckBox[ingredients.length];
        boolean[] checkedBoxes=new boolean[mCheckBoxes.length];
        if(savedInstanceState!=null&&savedInstanceState.getBooleanArray(KEY_CHECKED_BOXES)!=null){
            checkedBoxes=savedInstanceState.getBooleanArray(KEY_CHECKED_BOXES);
        }
        setCheckBoxes(ingredients,linearLayout,checkedBoxes);
        return view;
    }

    private void setCheckBoxes(String[] ingredients, ViewGroup container, boolean[] checkedBoxes){
        int i=0;
        for(String ingredient:ingredients){
            mCheckBoxes[i]=new CheckBox(getActivity());
            mCheckBoxes[i].setPadding(8,16,8,16);
            mCheckBoxes[i].setTextSize(20);
            mCheckBoxes[i].setText(ingredient);
            container.addView(mCheckBoxes[i]);
            if(checkedBoxes[i]){
                mCheckBoxes[i].toggle();
            }
            i++;
        }
    }

    //save the checkbox statement

    @Override
    public void onSaveInstanceState(Bundle outState) {
        boolean[] stateCheckbox=new boolean[mCheckBoxes.length];
        int i=0;
        for(CheckBox checkBox:mCheckBoxes){
            stateCheckbox[i]=checkBox.isChecked();
            i++;
        }
        outState.putBooleanArray(KEY_CHECKED_BOXES,stateCheckbox);
        super.onSaveInstanceState(outState);
    }
}
