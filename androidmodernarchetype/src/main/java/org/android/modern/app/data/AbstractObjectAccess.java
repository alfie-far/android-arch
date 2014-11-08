package org.android.modern.app.data;

import com.couchbase.lite.Database;
import com.couchbase.lite.Manager;
import org.android.modern.configuration.Application;
import org.android.modern.configuration.objectstore.CouchBaseAccessProvider;
import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.App;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;

/**
 * @author amin rahimi farzin
 * @version 1.0
 */
@EBean
public abstract class AbstractObjectAccess {

    protected Manager objectAccessManager;

    protected Database objectDatabase;

    @App
    Application applicationContext;

    @Bean
    CouchBaseAccessProvider couchBaseAccessProvider;

    public AbstractObjectAccess() {
    }

    @AfterInject
    public void AbstractObjectAccessAfterInject() {
        objectDatabase = couchBaseAccessProvider.getCouchDatabase();
        objectAccessManager = couchBaseAccessProvider.getCouchManager();
    }
}
