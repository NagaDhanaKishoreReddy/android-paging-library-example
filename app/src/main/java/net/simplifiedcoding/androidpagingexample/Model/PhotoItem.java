package net.simplifiedcoding.androidpagingexample.Model;

import com.google.gson.annotations.SerializedName;

public class PhotoItem {

    @SerializedName("owner")
    private String owner;

    @SerializedName("server")
    private String server;

    @SerializedName("ispublic")
    private int ispublic;

    @SerializedName("isfriend")
    private int isfriend;

    @SerializedName("farm")
    private int farm;

    @SerializedName("id")
    private String id;

    @SerializedName("secret")
    private String secret;

    @SerializedName("title")
    private String title;

    @SerializedName("isfamily")
    private int isfamily;

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public int getIspublic() {
        return ispublic;
    }

    public void setIspublic(int ispublic) {
        this.ispublic = ispublic;
    }

    public int getIsfriend() {
        return isfriend;
    }

    public void setIsfriend(int isfriend) {
        this.isfriend = isfriend;
    }

    public int getFarm() {
        return farm;
    }

    public void setFarm(int farm) {
        this.farm = farm;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getIsfamily() {
        return isfamily;
    }

    public void setIsfamily(int isfamily) {
        this.isfamily = isfamily;
    }

    @Override
    public String toString() {
        return
                "PhotoItem{" +
                        "owner = '" + owner + '\'' +
                        ",server = '" + server + '\'' +
                        ",ispublic = '" + ispublic + '\'' +
                        ",isfriend = '" + isfriend + '\'' +
                        ",farm = '" + farm + '\'' +
                        ",id = '" + id + '\'' +
                        ",secret = '" + secret + '\'' +
                        ",title = '" + title + '\'' +
                        ",isfamily = '" + isfamily + '\'' +
                        "}";
    }
}