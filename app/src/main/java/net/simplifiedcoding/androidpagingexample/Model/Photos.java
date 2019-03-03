package net.simplifiedcoding.androidpagingexample.Model;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class Photos {

    @SerializedName("perpage")
    private int perpage;

    @SerializedName("total")
    private int total;

    @SerializedName("pages")
    private int pages;

    @SerializedName("photo")
    private List<PhotoItem> photo;

    @SerializedName("page")
    private int page;

    public int getPerpage() {
        return perpage;
    }

    public void setPerpage(int perpage) {
        this.perpage = perpage;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public List<PhotoItem> getPhoto() {
        return photo;
    }

    public void setPhoto(List<PhotoItem> photo) {
        this.photo = photo;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    @Override
    public String toString() {
        return
                "Photos{" +
                        "perpage = '" + perpage + '\'' +
                        ",total = '" + total + '\'' +
                        ",pages = '" + pages + '\'' +
                        ",photo = '" + photo + '\'' +
                        ",page = '" + page + '\'' +
                        "}";
    }
}