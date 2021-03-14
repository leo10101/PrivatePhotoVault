package com.example.privatephotovault;

import java.util.ArrayList;

public class AlbumList {

    private String album_title;
    ArrayList<Integer> imageIDs = new ArrayList<>();

    public int getCoverID() {
        return imageIDs.get(0);
    }




    public ArrayList<Integer> getImageIDs() {
        return imageIDs;
    }


    public void setImageIDs(ArrayList<Integer> imageIDs) {
        this.imageIDs = imageIDs;
    }


    public String getImage_title() {
        return album_title;
    }

    public void setImage_title(String android_version_name) {
        this.album_title = android_version_name;
    }


}

