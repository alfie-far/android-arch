package org.android.modern.app.preferences;

import org.androidannotations.annotations.sharedpreferences.DefaultString;
import org.androidannotations.annotations.sharedpreferences.SharedPref;

/**
 * @author amin rahimi farzin
 */
@SharedPref
public interface SamplePreference {

    @DefaultString("Coward")
    String nickName();
}
