package org.android.modern.app.service;

import android.database.Observable;
import org.android.modern.app.service.remote.SampleServiceClient;
import retrofit.Callback;
import retrofit.client.Response;
import retrofit.http.Path;
import retrofit.http.Query;
import retrofit.mime.TypedFile;
import retrofit.mime.TypedString;

import javax.inject.Inject;
import java.util.List;
import java.util.Map;

/**
 * @author amin rahimi farzin
 * @version 1.0
 * @since it-5
 */
public class SampleService implements SampleServiceClient {

    @Inject
    SampleServiceClient sampleServiceClient;

    @Override
    public List<Object> listUserReps(@Path("user") String user) {
        return sampleServiceClient.listUserReps(user);
    }

    @Override

    public List<Object> listSomething() {
        return sampleServiceClient.listSomething();
    }

    @Override

    public List<Object> groupList(@Path("id") int groupId) {
        return sampleServiceClient.groupList(groupId);
    }

    @Override

    public List<Object> groupList(@Path("id") int groupId, @Query("sort") String sort) {
        return sampleServiceClient.groupList(groupId, sort);
    }

    @Override
    public List<Object> groupList(int groupId, Map<String, String> options) {
        return sampleServiceClient.groupList(groupId, options);
    }

    @Override
    public void createUser(Object user, Callback<Object> cb) {
        sampleServiceClient.createUser(user, cb);
    }

    @Override
    public Object updateUser(String first, String last) {
        return sampleServiceClient.updateUser(first, last);
    }

    @Override
    public Object updateUser(TypedFile photo, TypedString description) {
        return sampleServiceClient.updateUser(photo, description);
    }

    @Override

    public Object getUser(String username) {
        return sampleServiceClient.getUser(username);
    }

    @Override

    public Response userList() {
        return sampleServiceClient.userList();
    }

    @Override

    public void userList(Callback<Response> cb) {
        sampleServiceClient.userList(cb);
    }

    @Override

    public Observable<Response> userListObserved() {
        return sampleServiceClient.userListObserved();
    }
}
