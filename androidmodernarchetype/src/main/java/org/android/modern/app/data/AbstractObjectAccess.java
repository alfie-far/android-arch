package org.android.modern.app.data;

import com.couchbase.lite.Database;
import com.couchbase.lite.Manager;
import org.android.modern.configuration.Application;
import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.App;
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

    public AbstractObjectAccess() {
    }

    @AfterInject
    public void AbstractObjectAccessAfterInject() {
        objectDatabase = applicationContext.getCouchDatabase();
        objectAccessManager = applicationContext.getCouchManager();
    }
}
