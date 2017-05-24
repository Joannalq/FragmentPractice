package com.example.joanna.fragmentpractice;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class DualPaneFragment extends Fragment {
    private static final String INGREDIENTS_FRAG = "ingredients_fragment";
    private static final String DIRECTIONS_FRAG = "directions_fragment";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        int index=getArguments().getInt(ViewPagerFragment.KEY_INDEX);
        // Toast.makeText(getActivity(),Recipes.names[index],Toast.LENGTH_SHORT).show();
        getActivity().setTitle(Recipes.names[index]);
        View view=inflater.inflate(R.layout.fragment_dualpane,container,false);

        FragmentManager fragmentManager=getChildFragmentManager();
        IngredientFragment savedIngredientsFragment= (IngredientFragment) fragmentManager.findFragmentByTag(INGREDIENTS_FRAG);
        if(savedIngredientsFragment==null){
            IngredientFragment ingredientsFragment=new IngredientFragment();
            Bundle bundle=new Bundle();
            bundle.putInt(ViewPagerFragment.KEY_INDEX,index);
            // bundle.putBoolean(KEY_IS_INGREDIENTS,true);
            ingredientsFragment.setArguments(bundle);
            fragmentManager.beginTransaction()
                    .add(R.id.leftPlaceholder,ingredientsFragment,INGREDIENTS_FRAG)
                    .commit();
        }

        DirectionsFragment savedDirectionsFragment= (DirectionsFragment) fragmentManager.findFragmentByTag(DIRECTIONS_FRAG);
        if(savedDirectionsFragment==null){
            DirectionsFragment directionssFragment=new DirectionsFragment();
            Bundle bundle=new Bundle();
            bundle.putInt(ViewPagerFragment.KEY_INDEX,index);
            // bundle.putBoolean(KEY_IS_DIRECTIONSS,true);
            directionssFragment.setArguments(bundle);
            fragmentManager.beginTransaction()
                    .add(R.id.rightPlaceholder,directionssFragment,DIRECTIONS_FRAG)
                    .commit();
        }
        return view;
    }

    @Override
    public void onStop() {
        super.onStop();
        getActivity().setTitle(getResources().getString(R.string.app_name));
    }
}
