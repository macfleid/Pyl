package com.mcfly.pyl.view.model;

/**
 * Created by mcfly on 08/01/2015.
 */
public class PlaylistUiModel {

    private String title;
    private String sharedBy;
    private String date;
    private int averageRating;
    private int nbSongs;

    public PlaylistUiModel(String title, String sharedBy, String date, int averageRating, int nbSongs) {
        this.title = title;
        this.sharedBy = sharedBy;
        this.date = date;
        this.averageRating = averageRating;
        this.nbSongs = nbSongs;
    }

    public PlaylistUiModel() {}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSharedBy() {
        return sharedBy;
    }

    public void setSharedBy(String sharedBy) {
        this.sharedBy = sharedBy;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(int averageRating) {
        this.averageRating = averageRating;
    }
}
