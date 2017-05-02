package com.example.elyervesson.aulaandroid_fcm;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by elyervesson on 02/05/17.
 */

public class SharedPreferenceManager {

    private static final String SHARED_PREFERENCE_NAME = "sharedPreference";
    private static final String KEY_ACCESS_TOKEN = "token";

    private static Context appContext;
    private static SharedPreferenceManager manager;

    private SharedPreferenceManager (Context context){
        appContext = context;
    }

    // Metodo que retorna a instancia dessa classe
    public static synchronized SharedPreferenceManager getInstance(Context context) {
        if (manager == null) {
            manager = new SharedPreferenceManager(context);
        }
        return manager;
    }

    public String getToken() {
        SharedPreferences sharedPreferences = appContext.getSharedPreferences(SHARED_PREFERENCE_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_ACCESS_TOKEN, null);
    }

    public boolean storeToken(String token) {
        SharedPreferences sharedPreferences = appContext.getSharedPreferences(SHARED_PREFERENCE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(KEY_ACCESS_TOKEN, token);
        editor.apply();
        return true;
    }

}
