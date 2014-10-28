package org.android.modern.app.controller;

import org.android.modern.app.data.SampleObjectAccess;
import org.android.modern.app.service.SampleService;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;

/**
 * @author amin rahimi farzin
 * @version 1.0
 */
@EBean
public class SampleController {

    @Bean
    SampleObjectAccess sampleObjectAccess;

    @Bean
    SampleService sampleService;

    public void doSample() {
        sampleObjectAccess.SampleInsert();
    }
}
