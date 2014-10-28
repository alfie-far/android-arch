package org.android.modern.app.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.ViewGroup;
import butterknife.ButterKnife;

/**
 * @author amin rahimi farzin
 * @version 1.0
 */
public class InjectableActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    /**
     * Set the activity content from a layout resource.  The resource will be
     * inflated, adding all top-level views to the activity.
     *
     * @param layoutResID Resource ID to be inflated.
     * @see #setContentView(android.view.View)
     * @see #setContentView(android.view.View, android.view.ViewGroup.LayoutParams)
     */
    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        ButterKnife.inject(this);
    }

    /**
     * Set the activity content to an explicit view.  This view is placed
     * directly into the activity's view hierarchy.  It can itself be a complex
     * view hierarchy.  When calling this method, the layout parameters of the
     * specified view are ignored.  Both the width and the height of the view are
     * set by default to {@link ViewGroup.LayoutParams#MATCH_PARENT}. To use
     * your own layout parameters, invoke
     * {@link #setContentView(android.view.View, android.view.ViewGroup.LayoutParams)}
     * instead.
     *
     * @param view The desired content to display.
     * @see #setContentView(int)
     * @see #setContentView(android.view.View, android.view.ViewGroup.LayoutParams)
     */
    @Override
    public void setContentView(View view) {
        super.setContentView(view);
        ButterKnife.inject(this);
    }

    /**
     * Set the activity content to an explicit view.  This view is placed
     * directly into the activity's view hierarchy.  It can itself be a complex
     * view hierarchy.
     *
     * @param view   The desired content to display.
     * @param params Layout parameters for the view.
     * @see #setContentView(android.view.View)
     * @see #setContentView(int)
     */
    @Override
    public void setContentView(View view, ViewGroup.LayoutParams params) {
        super.setContentView(view, params);
        ButterKnife.inject(this);
    }
}
