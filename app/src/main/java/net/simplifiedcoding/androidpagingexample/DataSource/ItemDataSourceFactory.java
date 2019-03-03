package net.simplifiedcoding.androidpagingexample.DataSource;

import android.arch.lifecycle.MutableLiveData;
import android.arch.paging.DataSource;
import android.arch.paging.PageKeyedDataSource;

import net.simplifiedcoding.androidpagingexample.Model.PhotoItem;

public class ItemDataSourceFactory extends DataSource.Factory {

    private MutableLiveData<PageKeyedDataSource<Integer, PhotoItem>> itemLiveDataSource = new MutableLiveData<>();


    @Override
    public DataSource<Integer, PhotoItem> create() {
        ItemDataSource itemDataSource = new ItemDataSource();
        itemLiveDataSource.postValue(itemDataSource);
        return itemDataSource;
    }

    public MutableLiveData<PageKeyedDataSource<Integer, PhotoItem>> getItemLiveDataSource() {
        return itemLiveDataSource;
    }
}
