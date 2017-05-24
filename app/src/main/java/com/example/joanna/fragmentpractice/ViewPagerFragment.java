package com.example.joanna.fragmentpractice;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ViewPagerFragment extends Fragment {
    public static final String KEY_INDEX="recipt index";
   // public static final String KEY_IS_INGREDIENTS="KEY_IS_INGREDINET";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        int index=getArguments().getInt(KEY_INDEX);
       // Toast.makeText(getActivity(),Recipes.names[index],Toast.LENGTH_SHORT).show();
        getActivity().setTitle(Recipes.names[index]);
        View view=inflater.inflate(R.layout.fragment_viewpage,container,false);
        final IngredientFragment ingredientsFragment=new IngredientFragment();
        Bundle bundle=new Bundle();
        bundle.putInt(KEY_INDEX,index);
       // bundle.putBoolean(KEY_IS_INGREDIENTS,true);
        ingredientsFragment.setArguments(bundle);
        final DirectionsFragment directionsFragment=new DirectionsFragment();
        Bundle bundleD=new Bundle();
        bundle.putInt(KEY_INDEX,index);
     //   bundle.putBoolean(KEY_IS_INGREDIENTS,false);
        directionsFragment.setArguments(bundleD);

        ViewPager viewPager= (ViewPager) view.findViewById(R.id.viewPage);
        viewPager.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                if(position==0){
                    return ingredientsFragment;
                }else {
                    return directionsFragment;
                }
            }
            //add tab have to override getPageTitle
            @Override
            public CharSequence getPageTitle(int position) {
                return position==0?"ingredients":"directions";
            }

            @Override
            public int getCount() {
                return 2;
            }
        });
        TabLayout tabLayout= (TabLayout) view.findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);
        return view;
    }

    @Override
    public void onStop() {
        super.onStop();
        getActivity().setTitle(getResources().getString(R.string.app_name));
    }
}