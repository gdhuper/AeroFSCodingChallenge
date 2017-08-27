package com.aerofs.takehometest;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import java.util.*;
import java.io.*;

import com.android.volley.RequestQueue;


public class MainActivity extends AppCompatActivity {
    /*
     * Helper method to add user bio layout to activity_main
     */
    public void injectUserBio(){

        LayoutInflater vi = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = vi.inflate(R.layout.user_bio, null);

//// fill in any details dynamically here
        TextView textView = (TextView) v.findViewById(R.id.name);
        textView.setText("Gurpreet Singh");


// insert into main view
        ViewGroup insertPoint = (ViewGroup) findViewById(R.id.user_bio_view);
        insertPoint.addView(v, 0, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.FILL_PARENT));

//
    }

    public void addActionbar(){
        //adding icon to action bar
        ActionBar ab = getSupportActionBar();
        ab.setDisplayShowHomeEnabled(true);
        ab.setIcon(R.mipmap.github_logo);
        ab.setDisplayUseLogoEnabled(true);
        ab.setTitle(R.string.app_name);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Adding action bar in main layout
        addActionbar();

        injectUserBio();

        ArrayList<String> list = new ArrayList<>();
        list.add("San Francisco");
        list.add("London");
        list.add("Tokyo");
        list.add("Mexico City");
        list.add("Moscow");
        list.add("Rio de Janeiro");
        list.add("Paris");
        list.add("Mexico City");
        list.add("Moscow");
        list.add("Rio de Janeiro");
        list.add("Paris");

        ListView lv = (ListView) findViewById(R.id.repoList);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1, list);
        lv.setAdapter(adapter);

    }





    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if(id == R.id.home){
            startActivity(new Intent(this, MainActivity.class));
        }

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            System.exit(0);
        }

        return super.onOptionsItemSelected(item);
    }


}
