package org.android.modern.app.service.remote;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.internal.bind.DateTypeAdapter;
import dagger.Module;
import dagger.Provides;
import org.android.modern.app.service.SampleService;
import org.android.modern.configuration.ApplicationProviderModule;
import retrofit.ErrorHandler;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.converter.GsonConverter;

import javax.inject.Singleton;
import java.util.Date;

/**
 * @author amin rahimi farzin
 * @version 1.0
 * @since it-5
 */
@Module(
        includes = {
                ApplicationProviderModule.class
        } ,
        injects = {
                SampleService.class
        },
        complete = false

)
public class RESTProviderModule {

    private final String SERVICE_ENDPOINT = "https://api.github.com";

    @Provides
    @Singleton
    public SampleServiceClient provideSampleService() {
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .registerTypeAdapter(Date.class, new DateTypeAdapter())
                .create();
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(SERVICE_ENDPOINT)
                .setConverter(new GsonConverter(gson))
                .setErrorHandler(new ErrorHandler() {
                    @Override
                    public Throwable handleError(RetrofitError cause) {
                        return new RuntimeException(cause.getMessage());
                    }
                })
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build();
        return restAdapter.create(SampleServiceClient.class);
    }
}
