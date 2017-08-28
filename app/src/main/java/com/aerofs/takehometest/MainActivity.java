package com.aerofs.takehometest;


import android.app.LoaderManager;
import android.app.LoaderManager.LoaderCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.Loader;
import android.net.ConnectivityManager;
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
import android.app.SearchManager;
import android.widget.SearchView;
import android.widget.SearchView.OnQueryTextListener;


import com.android.volley.RequestQueue;


public class MainActivity extends AppCompatActivity implements LoaderCallbacks<List<RepoListItem>> {


    SearchView searchView;
    //ListView repoListView;
    String userName;

    private final static String REPOS_BASE_URL = "https://api.github.com/users/";
    private final static String REPOS_URL_POSTFIX = "/repos";

    private final static int LOADER_ID = 1;


    private RepoListAdapter adapter;

    private TextView defaultTextView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Adding action bar in main layout
        addActionbar();

        ListView repoListView = (ListView) findViewById(R.id.repoList);

        defaultTextView = (TextView) findViewById(R.id.default_view);

        //setting default view if the list is empty
        repoListView.setEmptyView(defaultTextView);

        //creating an adapter with an empty list of repos
        adapter = new RepoListAdapter(this, new ArrayList<RepoListItem>());

        repoListView.setAdapter(adapter);


        //searchview query listener for reading user input
        searchView = (SearchView) findViewById(R.id.search_bar);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                userName = query;
                System.out.println("Username Entered:" + userName);
                if(userName != null){
                    initLoader();
                }
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        //display Bio data for username
        injectUserBio();

    }

    public  void initLoader(){
        ConnectivityManager mgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        
    }


    /*
     * Helper method to add user bio layout to activity_main
     */
    public void injectUserBio(){

        LayoutInflater vi = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = vi.inflate(R.layout.user_bio, null);


        TextView textView = (TextView) v.findViewById(R.id.name);
        textView.setText("Gurpreet Singh");


        // insert into main view
        ViewGroup insertPoint = (ViewGroup) findViewById(R.id.user_bio_view);
        insertPoint.addView(v, 0, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.FILL_PARENT));


    }



    /*
     * Helper method to add action bar to top of main activity
     */
    public void addActionbar(){
        //adding icon to action bar
        ActionBar ab = getSupportActionBar();
        ab.setDisplayShowHomeEnabled(true);
        ab.setIcon(R.mipmap.github_logo);
        ab.setDisplayUseLogoEnabled(true);
        ab.setTitle(R.string.app_name);
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


    @Override
    public Loader<List<RepoListItem>> onCreateLoader(int i, Bundle bundle) {
        return null;
    }

    @Override
    public void onLoadFinished(Loader<List<RepoListItem>> loader, List<RepoListItem> repoListItems) {

    }

    @Override
    public void onLoaderReset(Loader<List<RepoListItem>> loader) {

    }
}
