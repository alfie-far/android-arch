package org.android.modern.configuration;

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
    private static final String objectDbName = "hello";
    /*
    Singleton pattern for application class
     */
    private static Application applicationSingleInstance;
    final String COUCHBASE_TAG = "COUCHBASE";
    /////////////////////////////////////////////////////////////////
    /*
    Application class specific properties and methods
     */

    /**
     * CouchBase Manager Class
     */
    private Manager couchManager;
    private Database couchDatabase;

    public static Application getApplication() {
        return applicationSingleInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        applicationSingleInstance = this;
        configureCouchBase();
    }

    private void configureCouchBase() {

        // create a couchManager
        Log.d(COUCHBASE_TAG, "Begin Hello World App");
        Log.d(COUCHBASE_TAG, "End Hello World App");
        try {
            couchManager = new Manager(new AndroidContext(this), Manager.DEFAULT_OPTIONS);
            Log.d(COUCHBASE_TAG, "Manager created");
        } catch (IOException e) {
            Log.e(COUCHBASE_TAG, "Cannot create couchManager object");
            return;
        }

        // create a name for the couchDatabase and make sure the name is legal
        if (!Manager.isValidDatabaseName(objectDbName)) {
            Log.e(COUCHBASE_TAG, "Bad couchDatabase name");
        }
        // create a new couchDatabase
        try {
            couchDatabase = couchManager.getDatabase(objectDbName);
            Log.d(COUCHBASE_TAG, "Database created");
        } catch (CouchbaseLiteException e) {
            Log.e(COUCHBASE_TAG, "Cannot get couchDatabase");
        }
    }

    public Manager getCouchManager() {
        return couchManager;
    }

    public Database getCouchDatabase() {
        return couchDatabase;
    }
}