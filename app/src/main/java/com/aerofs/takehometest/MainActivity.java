package com.aerofs.takehometest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    SearchView search = (SearchView) item.getActionView();
    search.setLayoutParams(new ActionBar.LayoutParams(Gravity.RIGHT));
}
