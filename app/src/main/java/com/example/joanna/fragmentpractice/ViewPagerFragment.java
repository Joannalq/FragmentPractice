package com.example.joanna.fragmentpractice;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class ViewPagerFragment extends Fragment {
    public static final String KEY_INDEX="recipt index";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        int index=getArguments().getInt(KEY_INDEX);
       // Toast.makeText(getActivity(),Recipes.names[index],Toast.LENGTH_SHORT).show();
        getActivity().setTitle(Recipes.names[index]);
        View view=inflater.inflate(R.layout.fragment_viewpage,container,false);
        return view;
    }

    @Override
    public void onStop() {
        super.onStop();
        getActivity().setTitle(getResources().getString(R.string.app_name));
    }
}