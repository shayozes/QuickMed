package com.shayo.quickmed;

import android.webkit.ValueCallback;

public class CallbackLogger implements ValueCallback<String> {

    private static CallbackLogger instance;

    private CallbackLogger() {
    }

    public static CallbackLogger getInstance() {
        if (instance == null) {
            instance = new CallbackLogger();
        }

        return instance;
    }

    @Override
    public void onReceiveValue(String value) {
//        Log.i("Callback", value);
    }
}
