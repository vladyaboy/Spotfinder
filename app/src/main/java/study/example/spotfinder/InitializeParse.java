package study.example.spotfinder;

import android.app.Application;
import android.util.Log;

import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.SaveCallback;

public class InitializeParse extends Application {

    @Override
    public void onCreate() {
        super.onCreate();


        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("679d0bc41f567e4c08c1485dfb80c4ef4214be83")
                .clientKey("344c83fb8448093d31fe0002c37abcac21f8f822")
                .server("http://52.14.170.8:80/parse/")
                .build());

        ParseObject object = new ParseObject("ExampleObject");
        object.put("myNumber", "123");
        object.put("myString", "vlad");

        object.saveInBackground(new SaveCallback() {
            @Override
            public void done(ParseException e) {
                if(e == null) {
                    Log.i("Parse Result", "OK!");
                } else {
                    Log.i("Parse result", "FAILED!");
                }
            }
        });
    }
}
