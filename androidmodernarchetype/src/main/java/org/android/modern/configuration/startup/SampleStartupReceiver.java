package org.android.modern.configuration.startup;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class SampleStartupReceiver extends BroadcastReceiver {
    private static final String TAG = SampleStartupReceiver.class.getName();

    public SampleStartupReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        Log.i(TAG, "Sample startup listener called");
    }
}
