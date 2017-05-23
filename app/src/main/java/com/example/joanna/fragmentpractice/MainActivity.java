package com.example.joanna.fragmentpractice;

import android.app.*;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends LoggingActivity implements ListFragment.OnSelectedInterface {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListFragment savedFrag= (ListFragment) getFragmentManager().findFragmentById(R.id.placeHolder);
        if(savedFrag==null) {
            ListFragment fragment = new ListFragment();
            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.add(R.id.placeHolder, fragment);
            fragmentTransaction.commit();
        }
    }

    @Override
    public void onListSelected(int index) {
        Toast.makeText(MainActivity.this,Recipes.names[index],Toast.LENGTH_SHORT).show();
    }
}
