package com.chaoli.testmixdemo;

import android.app.Application;

import com.tencent.bugly.crashreport.CrashReport;
import com.tencent.rtmp.TXLiveBase;


public class DemoApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        //集成bugly
        CrashReport.UserStrategy strategy = new CrashReport.UserStrategy(getApplicationContext());
        strategy.setAppVersion(TXLiveBase.getSDKVersionStr());
        CrashReport.initCrashReport(getApplicationContext(), "6e3737e3a0", true, strategy);


    }
}




