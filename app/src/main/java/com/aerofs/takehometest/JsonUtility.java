package com.aerofs.takehometest;

import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.StringBuilderPrinter;
import android.widget.ArrayAdapter;

import org.json.*;
import org.w3c.dom.Text;

import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;


import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.*;
import java.io.*;

import retrofit2.http.POST;
import retrofit2.http.Url;

/**
 * Created by gurpreet on 8/27/17.
 */

public class JsonUtility {

    private final static String REPOS_BASE_URL = "https://api.github.com/users/";
    private final static String REPOS_URL_POSTFIX = "/repos";

    private static String fullRepoUrl;


    //private static ArrayList<RepoListItem> repoList = null;

    private  static final String colorCodes = "";


    /**
     * Private constructor to prevent from instantiating this utility class
     */
    private JsonUtility(){

    }





    public static ArrayList<RepoListItem> getRepos(String userName){

        fullRepoUrl =  REPOS_BASE_URL + userName + REPOS_URL_POSTFIX;
        System.out.println("full url: "+ fullRepoUrl);

        //validating API Url
        URL url = generateValidUrl(fullRepoUrl);

        String jsonResponse = null;

        try {
            System.out.println("making http Request userName: " + userName);
            jsonResponse = callHttpApi(url);
        }catch (IOException e){
            Log.e("JsonUtilit", "API request Failed");
        }

        ArrayList<RepoListItem> repoList = parseJsonResponse(jsonResponse);

        return repoList;
    }


    public  static  URL generateValidUrl(String stringUrl){
        URL url = null;
        try {
            url = new URL(stringUrl);
        } catch (MalformedURLException e) {
            Log.e("JsonUtility", "Malformed API URL!");
        }
        return url;
    }


    public static String callHttpApi(URL url) throws  IOException{
        String jsonResponse = "";

        if(url == null){
            return jsonResponse;
        }
        HttpURLConnection connection = null;
        InputStream inStream = null;

        try {
            connection = (HttpURLConnection) url.openConnection();
            connection.setReadTimeout(10000 );
            connection.setConnectTimeout(14000);
            connection.setRequestMethod("GET");
            connection.connect();

            if(connection.getResponseCode() == 200){
                inStream = connection.getInputStream();
                jsonResponse = processInputStream(inStream);
            }else{
                Log.e("JsonUtility", connection.getResponseCode() + "");
            }
        }catch (IOException e){
            Log.e("JSonUTility", "Error Calling API");
        }finally {
            if(connection != null)
            {
                connection.disconnect();
            }
            if(inStream != null){
                inStream.close();
            }
        }

        return jsonResponse;
    }

    /**
     * Read input stream from http request and convert to String for parsing
     * @param stream
     * @return string object for response
     * @throws IOException
     */
    public static String processInputStream(InputStream stream) throws IOException{
        StringBuilder sb = new StringBuilder();
        if(stream != null) {
            InputStreamReader isr = new InputStreamReader(stream, Charset.forName("UTF-8"));
            BufferedReader br = new BufferedReader(isr);
            String line = br.readLine();
            while (line != null) {
                sb.append(line);
                line = br.readLine();
            }

        }
        return sb.toString();
    }


    public static ArrayList<RepoListItem> parseJsonResponse(String jsonResponse){

        if(TextUtils.isEmpty(jsonResponse)) return null;

        ArrayList<RepoListItem> list = new ArrayList<>();
        System.out.println("Reponse" + jsonResponse);

        try {
            JSONArray jsonArr = new JSONArray(jsonResponse);

            for (int i = 0; i < jsonArr.length(); i++) {
                JSONObject obj = jsonArr.getJSONObject(i);
                JSONObject useBio = obj.getJSONObject("owner");

                String repoName = obj.getString("name");

                String userName = useBio.getString("login");



                String avatarUrl = useBio.getString("avatar_url");


                String htmlUrl = useBio.getString("html_url");

                String lastUpdate = obj.getString("updated_at");

                String numWatcher = obj.getString("watchers_count");

                String lang = obj.getString("language");

                String numForks = obj.getString("forks_count");

                String numStars = obj.getString("stargazers_count");

                //  String colorCode  = colorObj.getString(lang);

                RepoListItem item = new RepoListItem(repoName, lastUpdate, numStars, numForks, numWatcher, "", lang, "");
                list.add(item);

            }
        }
        catch (JSONException e) {
            Log.e("JsonUtility", "API Response could not be parsed", e);
        }

        return list;

    }


    public static String getHexCode(String color){
        return "#b07219";
    }

    public static UserBioActivity getUserBio(String userName) {
        UserBioActivity uBio = null;



        return uBio;
    }
}
