package com.aerofs.takehometest;
import java.util.*;
import java.io.*;
/**
 * Created by gurpreet on 8/26/17.
 */

public class RepoListItem {
    private String repoName;

    public String getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    private String lastUpdate;
    private int numStars;
    private int numForks;
    private int numWatchers;
    private int numContributors;
    private String language;


    public RepoListItem(String repoName, String lastUpdate, int numStars, int numForks, int numWatchers, int numContributors, String language){
        this.repoName = repoName;
        this.lastUpdate = lastUpdate;
        this.numStars = numStars;
        this.numForks = numForks;
        this.numWatchers = numWatchers;
        this.numContributors = numContributors;
        this.language = language;
    }

    public String getRepoName() {
        return repoName;
    }

    public void setRepoName(String repoName) {
        this.repoName = repoName;
    }

    public int getNumStars() {
        return numStars;
    }

    public void setNumStars(int numStars) {
        this.numStars = numStars;
    }

    public int getNumForks() {
        return numForks;
    }

    public void setNumForks(int numForks) {
        this.numForks = numForks;
    }

    public int getNumWatchers() {
        return numWatchers;
    }

    public void setNumWatchers(int numWatchers) {
        this.numWatchers = numWatchers;
    }

    public int getnumContributors() {
        return numContributors;
    }

    public void setnumContributors(int numContributors) {
        this.numContributors = numContributors;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
