package net.simplifiedcoding.androidpagingexample.DataSource;

import android.arch.paging.PageKeyedDataSource;
import android.support.annotation.NonNull;
import android.util.Log;

import net.simplifiedcoding.androidpagingexample.Model.PhotoItem;
import net.simplifiedcoding.androidpagingexample.Model.PhotosResponse;
import net.simplifiedcoding.androidpagingexample.network.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ItemDataSource extends PageKeyedDataSource<Integer, PhotoItem> {

    public static final int PAGE_SIZE = 25;
    private static final int FIRST_PAGE = 1;
    private static final String METHOD_VALUE = "flickr.interestingness.getList";
    private static final String API_KEY = "9f89151d82e427401680cd48dd2d5cf5";
    private static final String DATA_FORMAT = "json";
    private static final int CALLBACK_VALUE = 1;

    @Override
    public void loadInitial(@NonNull final LoadInitialParams<Integer> params, @NonNull final LoadInitialCallback<Integer, PhotoItem> callback) {
        RetrofitClient.getInstance()
                .getApi().getImageList(METHOD_VALUE, API_KEY,
                PAGE_SIZE, FIRST_PAGE, DATA_FORMAT, CALLBACK_VALUE)
                .enqueue(new Callback<PhotosResponse>() {
                    @Override
                    public void onResponse(Call<PhotosResponse> call, Response<PhotosResponse> response) {
                        if (response.body() != null) {
                            callback.onResult(response.body().getPhotos().getPhoto(), null, FIRST_PAGE + 1);
                            Log.e("loadInitial", "loadInitial " + FIRST_PAGE);
                            Log.e("loadInitialparams", "loadInitialparams " + params.toString());
                        }
                    }

                    @Override
                    public void onFailure(Call<PhotosResponse> call, Throwable t) {

                    }
                });
    }

    @Override
    public void loadBefore(@NonNull final LoadParams<Integer> params, @NonNull final LoadCallback<Integer, PhotoItem> callback) {
        RetrofitClient.getInstance()
                .getApi().getImageList(METHOD_VALUE, API_KEY,
                PAGE_SIZE, FIRST_PAGE, DATA_FORMAT, CALLBACK_VALUE)
                .enqueue(new Callback<PhotosResponse>() {
                    @Override
                    public void onResponse(Call<PhotosResponse> call, Response<PhotosResponse> response) {
                        Log.e("loadBeforeparams", "loadBeforeparams " + params.key);
                        Integer adjacentKey = (params.key > 1) ? params.key - 1 : null;
                        Log.e("BeforeadjacentKey", "BeforeadjacentKey " + adjacentKey);
                        Log.e("loadBefore", "loadBefore " + FIRST_PAGE);
                        if (response.body() != null) {
                            callback.onResult(response.body().getPhotos().getPhoto(), adjacentKey);

                        }
                    }

                    @Override
                    public void onFailure(Call<PhotosResponse> call, Throwable t) {

                    }
                });
    }

    @Override
    public void loadAfter(@NonNull final LoadParams<Integer> params, @NonNull final LoadCallback<Integer, PhotoItem> callback) {
        RetrofitClient.getInstance()
                .getApi().getImageList(METHOD_VALUE, API_KEY,
                PAGE_SIZE, FIRST_PAGE, DATA_FORMAT, CALLBACK_VALUE)
                .enqueue(new Callback<PhotosResponse>() {
                    @Override
                    public void onResponse(Call<PhotosResponse> call, Response<PhotosResponse> response) {
                        Log.e("loadAfter", "loadAfter ");
                        Log.e("loadAfterpage", "loadAfterpage " + FIRST_PAGE);
                        //Log.e("loadAfterloadAfter","loadAfterloadAfter "+ response.body().has_more);
                        if (response.body() != null) {
                            callback.onResult(response.body().getPhotos().getPhoto(), params.key + 1);
                        }
                    }
                    @Override
                    public void onFailure(Call<PhotosResponse> call, Throwable t) {

                    }
                });
    }
}
