package com.example.joanna.fragmentpractice;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ListFragment extends Fragment {
    public interface  OnSelectedInterface{
        void onListSelected(int index);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        OnSelectedInterface listener= (OnSelectedInterface) getActivity();
        View view=inflater.inflate(R.layout.fragment_list,container,false);
        RecyclerView recyclerView= (RecyclerView) view.findViewById(R.id.listRecycleView);
        ListAdapter listAdapter=new ListAdapter(listener);
        recyclerView.setAdapter(listAdapter);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        return view;
    }
}
