package net.simplifiedcoding.androidpagingexample.network;

import net.simplifiedcoding.androidpagingexample.Model.PhotosResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {

    @GET("rest/")
    Call<PhotosResponse> getImageList(@Query("method") String methodValue, @Query("api_key") String apKeyValue, @Query("per_page") int perPage,
                                      @Query("page") int page, @Query("format") String format, @Query("nojsoncallback") int callbackValue);


}
