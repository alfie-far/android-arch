package org.android.modern.app.activity;

import android.app.NotificationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import butterknife.InjectView;
import butterknife.OnClick;
import org.android.R;
import org.android.modern.app.controller.SampleController;
import org.android.modern.configuration.Application;
import org.androidannotations.annotations.App;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.SystemService;

import javax.inject.Inject;

@EActivity(R.layout.activity_main)
public class MainActivity extends InjectableActivity {

    @App
    Application application;


    @Bean
    SampleController sampleController;

    @InjectView(R.id.greeting)
    TextView greetingTextView;

    @InjectView(R.id.greeting_action)
    Button greetingButton;

    @SystemService
    NotificationManager notificationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @OnClick(R.id.greeting_action)
    public void changeGreetingText(View view) {
        greetingTextView.setText("greeting text changed");
    }

    @OnClick(R.id.sample_nosql_action)
    public void insertSomething() {
        sampleController.doSample();
        greetingTextView.setText("inserted Successfully");
    }
}
