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

public class ListAdapter extends RecyclerView.Adapter {

    private final ListFragment.OnSelectedInterface mListener;

    public ListAdapter(ListFragment.OnSelectedInterface listener) {
        mListener=listener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.items,parent,false);
        return new ListViewHolder(view);
    }

    //update view and show the position on the screen
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((ListViewHolder)holder).bindView(position);
    }

    @Override
    public int getItemCount() {
        return Recipes.names.length;
    }

    private class ListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView mTextView;
        private ImageView mImageView;
        private int mIndex;

        public ListViewHolder(View itemView) {
            super(itemView);
            mTextView= (TextView) itemView.findViewById(R.id.textView);
            mImageView= (ImageView) itemView.findViewById(R.id.imageView);
            itemView.setOnClickListener(this);
        }

        public void bindView(int position){
            mIndex=position;
            mTextView.setText(Recipes.names[position]);
            mImageView.setImageResource(Recipes.resourceIds[position]);
        }

        @Override
        public void onClick(View v) {
            mListener.onListSelected(mIndex);
        }
    }
}
