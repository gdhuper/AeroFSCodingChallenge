package com.aerofs.takehometest;

import android.os.AsyncTask;

/**
 * Created by gurpreet on 8/24/17.
 */

public class APIRequestTask extends AsyncTask<String, Void, String> {

    private String url;

    public APIRequestTask(String url){
        this.url = url;
    }

    @Override
    protected String doInBackground(String... strings) {
        return null;
    }
}
