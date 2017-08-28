package com.aerofs.takehometest;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.media.Image;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by gurpreet on 8/26/17.
 */

public class RepoListAdapter extends ArrayAdapter<RepoListItem> {

    /**
     * custom constructor for array adapter
     * @param context app context
     * @param repos list of public repos for a user
     */
    public RepoListAdapter(Context context, List<RepoListItem> repos) {
        super(context, 0, repos);
    }



    @Override
    public View getView(int position, View convertView,  ViewGroup parent) {


        View listItemView = convertView;

        //if view item exists use it for current repo item
        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.repo_list_item, parent,  false);
        }

        //get new repo item from the list
        RepoListItem repo = getItem(position);

        //setting list item attributes for current list item
        TextView lastUpdateView = (TextView) listItemView.findViewById(R.id.last_updated);
        lastUpdateView.setText(repo.getLastUpdate());

        TextView numStarsView = (TextView) listItemView.findViewById(R.id.num_stars);
        numStarsView.setText(repo.getNumStars());

        TextView numForksView = (TextView) listItemView.findViewById(R.id.num_forks);
        numForksView.setText(repo.getNumForks());

        TextView numWatchersView = (TextView) listItemView.findViewById(R.id.num_watchers);
        numWatchersView.setText(repo.getNumWatchers());

        TextView numContributorsView = (TextView) listItemView.findViewById(R.id.num_contributors);
        numContributorsView.setText(repo.getNumContributors());

        TextView languageView = (TextView) listItemView.findViewById(R.id.prog_lang);
        languageView.setText(repo.getLanguage());

        ImageView langColorView = (ImageView) listItemView.findViewById(R.id.lang_color);

        GradientDrawable colorCode = (GradientDrawable) langColorView.getBackground();
        int color = R.color.java;
        colorCode.setColor(ContextCompat.getColor(getContext(), color));


        return listItemView;
    }
}
