package com.example.tuappgenda.model.network;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class NetworkDownloader {
    private static NetworkDownloader instance;
    private RequestQueue requestQueue;
    private static Context ctx;

    private NetworkDownloader(Context context) {
        NetworkDownloader.ctx = context;
        requestQueue = getRequestQueue();
    }

    public static synchronized NetworkDownloader getInstance(Context context) {
        if (instance == null) {
            instance = new NetworkDownloader(context);
        }
        return instance;
    }

    public RequestQueue getRequestQueue() {
        if (requestQueue == null) {
            requestQueue = Volley.newRequestQueue(ctx.getApplicationContext());
        }
        return requestQueue;
    }

    public <T> void execute(Request<T> req) {
        getRequestQueue().add(req);
    }
}
