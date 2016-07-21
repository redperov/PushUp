package com.example.danny.myapplication;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

public class MyIntentService extends IntentService {

    private static final String TAG="com.example.danny.myapplication";

    public MyIntentService() {
        super("IntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        //This is what the service does
       // Log.i(TAG,"The service has now started"); the TAG is too long

    }
}
