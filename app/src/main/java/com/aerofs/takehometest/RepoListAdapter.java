package com.aerofs.takehometest;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

/**
 * Created by gurpreet on 8/26/17.
 */

public class RepoListAdapter extends ArrayAdapter<RepoListItem> {


    public RepoListAdapter(@NonNull Context context, @LayoutRes int resource) {
        super(context, resource);
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;

        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.repo_list_item, parent,  false);
        }


        return listItemView;
    }
}
