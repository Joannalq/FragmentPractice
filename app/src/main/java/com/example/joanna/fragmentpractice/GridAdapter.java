package com.example.joanna.fragmentpractice;


public class GridAdapter extends RecyclerAdapter {

    private final GridFragment.OnSelectedInterface mListener;

    public GridAdapter(GridFragment.OnSelectedInterface listener) {
        mListener=listener;
    }

    @Override
    protected int getLayoutId(){
        return R.layout.items;
    }
    @Override
    protected void onRecipeSelected(int index) {
        mListener.onGridSelected(index);
    }
}

