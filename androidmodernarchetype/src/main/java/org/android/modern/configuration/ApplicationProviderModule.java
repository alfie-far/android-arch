package org.android.modern.configuration;

import dagger.Module;
import dagger.Provides;
import org.android.modern.app.activity.InjectableActivity;
import org.android.modern.app.activity.MainActivity;

import javax.inject.Singleton;

/**
 * @author amin rahimi farzin
 * @version 1.0
 */
@Module(
        injects = {
                InjectableActivity.class,
                MainActivity.class
        }
)
public class ApplicationProviderModule {

    @Provides
    @Singleton
    public Application provideApplicationContext() {
        return Application.getApplication();
    }
}
