package org.android.modern.app.util;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.*;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.Toast;
import org.android.R;

/**
 * @author amin rahimi farzin
 * @version 1.0
 */
// This is a utility class
@SuppressWarnings("UnusedDeclaration")
public class ApplicationUtils {

    private static final String LOG_TAG = "ApplicationUtils";

    /**
     * Get the application version code.
     *
     * @param context The current context.
     * @return The application version code.
     */
    public static int getApplicationVersionCode(Context context) {
        int result;
        try {
            PackageManager manager = context.getPackageManager();
            PackageInfo info = manager.getPackageInfo(context.getPackageName(), 0);
            result = info.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            Log.w(LOG_TAG, "Unable to get application version: " + e.getMessage());
            result = -1;
        }
        return result;
    }

    /**
     * Copy a text to the clipboard.
     *
     * @param context      The current context.
     * @param text         The text to copy.
     * @param toastMessage The message to show in a Toast notification. If empty or null, does not display notification.
     */
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static void copyTextToClipboard(Context context, String text, String toastMessage) {
        ClipboardManager clipboard = (ClipboardManager) context.getSystemService(Activity.CLIPBOARD_SERVICE);
        clipboard.setPrimaryClip(ClipData.newPlainText(text, text));
        if ((toastMessage != null) &&
                (toastMessage.length() > 0)) {
            Toast.makeText(context, toastMessage, Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Display a standard yes / no dialog.
     *
     * @param context The current context.
     * @param icon    The dialog icon.
     * @param title   The dialog title.
     * @param message The dialog message.
     * @param onYes   The dialog listener for the yes button.
     */
    public static void showYesNoDialog(Context context, int icon, int title, int message, DialogInterface.OnClickListener onYes) {
        showYesNoDialog(context,
                icon,
                title,
                context.getResources().getString(message),
                onYes);
    }

    /**
     * Display a standard yes / no dialog.
     *
     * @param context The current context.
     * @param icon    The dialog icon.
     * @param title   The dialog title.
     * @param message The dialog message.
     * @param onYes   The dialog listener for the yes button.
     */
    public static void showYesNoDialog(Context context, int icon, int title, String message, DialogInterface.OnClickListener onYes) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setCancelable(true);
        builder.setIcon(icon);
        builder.setTitle(context.getResources().getString(title));
        builder.setMessage(message);
        builder.setInverseBackgroundForced(true);
        builder.setPositiveButton(context.getResources().getString(R.string.yes), onYes);
        builder.setNegativeButton(context.getResources().getString(R.string.no), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }

    public static void showErrorDialog(Context context, String title, String message) {
        new AlertDialog.Builder(context)
                .setTitle(title)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setMessage(message)
                .setPositiveButton(R.string.ok, null)
                .show();
    }

    public static void showMessageDialog(Context context, String title, String message) {
        new AlertDialog.Builder(context)
                .setTitle(title)
                .setIcon(android.R.drawable.ic_dialog_info)
                .setMessage(message)
                .setPositiveButton(R.string.ok, null)
                .show();
    }
}
