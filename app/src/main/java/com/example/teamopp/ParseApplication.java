package com.example.teamopp;

import android.app.Application;

import com.parse.Parse;

public class ParseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("Di0OU1Sgn6V6nFc6hhJ9hiW0gMSGK2VMLSU4E3LU")
                .clientKey("T2JNDOkbM6q59XJXMFlcu45HTx52R2AulpChPxQn")
                .server("https://parseapi.back4app.com")
                .build()
        );
    }
}
