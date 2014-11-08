package org.android.modern.configuration.objectstore;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.couchbase.lite.Database;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EReceiver;

@EReceiver
public class CouchbaseStartupInitializer extends BroadcastReceiver {
    private static final String TAG = CouchbaseStartupInitializer.class.getName();

    @Bean
    CouchBaseAccessProvider couchBaseAccessProvider;

    public CouchbaseStartupInitializer() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        // initialize couchbase database

        Log.i(TAG, "implicit initialization of couchbase object db");
        Database couchDatabase = couchBaseAccessProvider.getCouchDatabase();
    }
}
