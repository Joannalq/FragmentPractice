package com.example.joanna.fragmentpractice;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class GridFragment extends Fragment {
    public interface  OnSelectedInterface{
        void onGridSelected(int index);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

       OnSelectedInterface listener= (OnSelectedInterface) getActivity();
        View view=inflater.inflate(R.layout.fragment_recyclerview,container,false);
        RecyclerView recyclerView= (RecyclerView) view.findViewById(R.id.recycleView);
        GridAdapter gridAdapter=new GridAdapter(listener);
        recyclerView.setAdapter(gridAdapter);
        //using for grid
        DisplayMetrics displayMetrics=getResources().getDisplayMetrics();
        float dpwidth=displayMetrics.widthPixels/displayMetrics.density;
        int colomnsNum= (int) (dpwidth/200);

        RecyclerView.LayoutManager layoutManager=new GridLayoutManager(getActivity(),colomnsNum);
        recyclerView.setLayoutManager(layoutManager);
        return view;
    }
}

