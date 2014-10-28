package org.android.modern.app.data;

import android.util.Log;
import com.couchbase.lite.CouchbaseLiteException;
import com.couchbase.lite.Document;
import org.androidannotations.annotations.EBean;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

/**
 * @author amin rahimi farzin
 * @version 1.0
 */
@EBean
public class SampleObjectAccess extends AbstractObjectAccess {

    public void SampleInsert() {
        // get the current date and time
        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        Calendar calendar = GregorianCalendar.getInstance();
        String currentTimeString = dateFormatter.format(calendar.getTime());
        // create an object that contains data for a document
        Map<String, Object> docContent = new HashMap<String, Object>();
        docContent.put("message", "Hello Couchbase Lite");
        docContent.put("creationDate", currentTimeString);
        // display the data for the new document
        Log.d("", "docContent=" + String.valueOf(docContent));
        // create an empty document
        Document document = objectDatabase.createDocument();
        // add content to document and write the document to the database
        try {
            document.putProperties(docContent);
            Log.d("", "Document written to database named " + objectDatabase.getName() + " with ID = " + document.getId());
        } catch (CouchbaseLiteException e) {
            Log.e("", "Cannot write document to database", e);
        }
        // save the ID of the new document
        String docID = document.getId();
    }
}
