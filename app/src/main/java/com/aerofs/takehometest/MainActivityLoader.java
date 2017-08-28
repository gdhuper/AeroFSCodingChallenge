package com.aerofs.takehometest;

import android.content.AsyncTaskLoader;
import android.content.Context;

import java.util.List;

/**
 * Created by gurpreet on 8/28/17.
 */

public class MainActivityLoader extends AsyncTaskLoader<List<RepoListItem>> {

    private String url;

    public MainActivityLoader(Context context, String url){
        super(context);
        this.url = url;
    }

    @Override
    public List<RepoListItem> loadInBackground() {
        return null;
    }
}
