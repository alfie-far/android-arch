package org.android.modern.configuration.objectstore;

import android.util.Log;
import com.couchbase.lite.CouchbaseLiteException;
import com.couchbase.lite.Database;
import com.couchbase.lite.Manager;
import com.couchbase.lite.android.AndroidContext;
import org.android.modern.configuration.Application;
import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.App;
import org.androidannotations.annotations.EBean;

import java.io.IOException;

/**
 * @author amin rahimi farzin
 * @version 1.0
 * @since it-5
 */

@EBean(scope = EBean.Scope.Singleton)
public class CouchBaseAccessProvider {
    private static final String OBJECT_DB_NAME = "application_object_db_name";
    private static final String COUCHBASE_TAG = "COUCHBASE";

    @App
    Application application;
    /**
     * CouchBase Manager Class in order to manage database instances.
     * ( It's Rare to control multiple database instances in an android application. )
     */
    private Manager mCouchManager;
    /**
     * Couchbase
     */
    private Database mCouchDatabase;

    public CouchBaseAccessProvider() {

    }

    @AfterInject
    void AbstractObjectAccessAfterInject() {
        configureCouchBase();
    }

    private void configureCouchBase() {

        // create a mCouchManager
        Log.d(COUCHBASE_TAG, "Begin Hello World App");
        Log.d(COUCHBASE_TAG, "End Hello World App");
        try {
            mCouchManager = new Manager(new AndroidContext(application), Manager.DEFAULT_OPTIONS);
            Log.d(COUCHBASE_TAG, "Manager created");
        } catch (IOException e) {
            Log.e(COUCHBASE_TAG, "Cannot create mCouchManager object");
            return;
        }

        // create a name for the mCouchDatabase and make sure the name is legal
        if (!Manager.isValidDatabaseName(OBJECT_DB_NAME)) {
            Log.e(COUCHBASE_TAG, "Bad mCouchDatabase name");
        }
        // create a new mCouchDatabase
        try {
            mCouchDatabase = mCouchManager.getDatabase(OBJECT_DB_NAME);
            Log.d(COUCHBASE_TAG, "Database created");
        } catch (CouchbaseLiteException e) {
            Log.e(COUCHBASE_TAG, "Cannot get mCouchDatabase");
        } catch (Error error) {
            Log.e(COUCHBASE_TAG, "Cannot get mCouchDatabase");
        }
    }

    public Manager getCouchManager() {
        return mCouchManager;
    }

    public Database getCouchDatabase() {
        return mCouchDatabase;
    }
}
