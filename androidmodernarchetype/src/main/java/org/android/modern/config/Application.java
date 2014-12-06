package org.android.modern.config;

import android.content.Intent;
import org.androidannotations.annotations.EApplication;

/**
 * @author amin rahimi farzin
 * @version 1.0
 */
@SuppressWarnings("UnusedDeclaration")
@EApplication
public class Application extends android.app.Application {

    @Override
    public void onCreate() {
        super.onCreate();
        triggerStartupEvent();
    }

    /**
     * Broadcasts application creation and startup event to
     * those broadcast listeners which are listening to
     * action intent
     * {@link org
     *        .android
     *        .modern
     *        .configuration
     *        .AvailableConstants
     *        .ApplicationStartup#APPLICATION_STARTUP_BROADCAST_ACTION}
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