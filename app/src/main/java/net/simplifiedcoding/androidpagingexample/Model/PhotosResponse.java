package net.simplifiedcoding.androidpagingexample.Model;


import com.google.gson.annotations.SerializedName;

public class PhotosResponse {

    @SerializedName("stat")
    private String stat;

    @SerializedName("photos")
    private Photos photos;

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }

    public Photos getPhotos() {
        return photos;
    }

    public void setPhotos(Photos photos) {
        this.photos = photos;
    }

    @Override
    public String toString() {
        return
                "PhotosResponse{" +
                        "stat = '" + stat + '\'' +
                        ",photos = '" + photos + '\'' +
                        "}";
    }
}