package org.android.modern.app.service.remote;

import android.database.Observable;
import retrofit.Callback;
import retrofit.client.Response;
import retrofit.http.*;
import retrofit.mime.TypedFile;
import retrofit.mime.TypedString;

import java.util.List;
import java.util.Map;

/**
 * @author amin rahimi farzin
 * @version 1.0
 * @since it-5
 */
public interface SampleServiceClient {

    @GET("/users/{user}/repos")
    List<Object> listUserReps(@Path("user") String user);

    @GET("/users/list?sort=desc")
    List<Object> listSomething();

    @GET("/group/{id}/users")
    List<Object> groupList(@Path("id") int groupId);

    @GET("/group/{id}/users")
    List<Object> groupList(@Path("id") int groupId, @Query("sort") String sort);

    @GET("/group/{id}/users")
    List<Object> groupList(@Path("id") int groupId, @QueryMap Map<String, String> options);

    @POST("/users/new")
    void createUser(@Body Object user, Callback<Object> cb);

    @FormUrlEncoded
    @POST("/user/edit")
    Object updateUser(@Field("first_name") String first, @Field("last_name") String last);

    @Multipart
    @PUT("/user/photo")
    Object updateUser(@Part("photo") TypedFile photo, @Part("description") TypedString description);

    @Headers({
            "Accept: application/vnd.github.v3.full+json",
            "User-Agent: Retrofit-Sample-App"
    })
    @GET("/users/{username}")
    Object getUser(@Path("username") String username);

    @GET("/users/list")
    Response userList();

    @GET("/users/list")
    void userList(Callback<Response> cb);

    @GET("/users/list")
    Observable<Response> userListObserved();
}
