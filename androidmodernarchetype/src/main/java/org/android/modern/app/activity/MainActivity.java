package org.android.modern.app.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import butterknife.InjectView;
import butterknife.OnClick;
import org.android.R;
import org.android.modern.configuration.Application;

import javax.inject.Inject;

public class MainActivity extends InjectableActivity {

    @Inject
    Application application;

    @InjectView(R.id.greeting)
    TextView greetingTextView;

    @InjectView(R.id.greeting_action)
    Button greetingButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        application.getApplicationContext();
    }

    @OnClick(R.id.greeting_action)
    public void changeGreetingText(View view) {
        greetingTextView.setText("greeting text changed");
    }
}
