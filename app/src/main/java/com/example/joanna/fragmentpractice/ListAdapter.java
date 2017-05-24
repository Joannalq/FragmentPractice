package com.example.joanna.fragmentpractice;


import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class ListAdapter extends RecyclerAdapter {

    private final ListFragment.OnSelectedInterface mListener;

    public ListAdapter(ListFragment.OnSelectedInterface listener) {
        mListener=listener;
    }

    @Override
    protected int getLayoutId(){
        return R.layout.items;
    }
    @Override
    protected void onRecipeSelected(int index) {
        mListener.onListSelected(index);
    }
}
