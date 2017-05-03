package com.example.elyervesson.aulaandroid_fcm;

import android.content.Intent;
import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

/**
 * Created by elyervesson on 02/05/17.
 */

public class MyFirebaseInstanceIDService extends FirebaseInstanceIdService {

    public static final String TOKEN_BROADCAST = "tokenBroadcast";

    @Override
    public void onTokenRefresh() {
        // Get updated InstanceID token.
        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
        Log.d("Firebase", "Firebase token(MyFirebaseInstanceIDService): " + refreshedToken);

        getApplicationContext().sendBroadcast(new Intent(TOKEN_BROADCAST));

        // If you want to send messages to this application instance or
        // manage this apps subscriptions on the server side, send the
        // Instance ID token to your app server.
        //sendRegistrationToServer(refreshedToken);
        storeToken(refreshedToken);
    }

    private void storeToken(String token) {
        SharedPreferenceManager.getInstance(getApplicationContext()).storeToken(token);
    }
}
