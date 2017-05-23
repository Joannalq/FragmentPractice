package com.example.joanna.fragmentpractice;

import android.app.*;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.*;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements ListFragment.OnSelectedInterface {
    public static final String LIST="list_fragment";
    public static final String VIEW="view_fragment";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ListFragment savedFrag= (ListFragment) getSupportFragmentManager().findFragmentById(R.id.placeHolder);
        ListFragment savedFrag= (ListFragment) getSupportFragmentManager().findFragmentByTag(LIST);
        if(savedFrag==null) {
            ListFragment fragment = new ListFragment();
            android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
            android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            //fragmentTransaction.add(R.id.placeHolder, fragment);
            fragmentTransaction.add(R.id.placeHolder, fragment,LIST);
            fragmentTransaction.commit();
        }
    }

    @Override
    public void onListSelected(int index) {
        Toast.makeText(MainActivity.this,Recipes.names[index],Toast.LENGTH_SHORT).show();
        ViewPagerFragment fragment = new ViewPagerFragment();
        Bundle bundle=new Bundle();
        bundle.putInt(ViewPagerFragment.KEY_INDEX,index);
        fragment.setArguments(bundle);
        android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        //fragmentTransaction.replace(R.id.placeHolder, fragment);
        fragmentTransaction.replace(R.id.placeHolder, fragment,VIEW);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
