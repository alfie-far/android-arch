package org.android.modern.configuration;

import android.content.Intent;
import android.util.Log;
import com.couchbase.lite.CouchbaseLiteException;
import com.couchbase.lite.Database;
import com.couchbase.lite.Manager;
import com.couchbase.lite.android.AndroidContext;
import org.androidannotations.annotations.EApplication;

import java.io.IOException;

/**
 * @author amin rahimi farzin
 * @version 1.0
 */
@SuppressWarnings("UnusedDeclaration")
@EApplication
public class Application extends android.app.Application {

    /*
    Singleton pattern for application class
     */
    private static Application applicationSingleInstance;
    public static Application getApplication() {
        return applicationSingleInstance;
    }
    /*
    // //////////////////////////////////////////////////////////////


    /*
    Application class specific properties and methods
     */

    @Override
    public void onCreate() {
        super.onCreate();
        applicationSingleInstance = this;
        triggerStartupEvent();
    }

    /**
     * Broadcasts application creation and startup event to
     * those broadcast listeners which are listening to
     * action intent #AvailableConstants.ApplicationStartup.APPLICATION_STARTUP_BROADCAST_ACTION
     */
    private void triggerStartupEvent() {
        Intent startupBroadcastIntent = new Intent(
                /* Intent action string */
                        AvailableConstants
                        .ApplicationStartup
                        .APPLICATION_STARTUP_BROADCAST_ACTION
        );
        sendBroadcast(startupBroadcastIntent);
    }


}