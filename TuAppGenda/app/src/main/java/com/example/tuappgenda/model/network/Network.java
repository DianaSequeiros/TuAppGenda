package com.example.tuappgenda.model.network;

import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.tuappgenda.model.Callback;
import com.example.tuappgenda.model.ErrorType;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Network implements INetwork {
    private NetworkDownloader downloader;

    public Network(NetworkDownloader downloader) {
        this.downloader = downloader;
    }


    @Override
    public void login(String user, String pass, Callback<Integer> callback) {
        //TODO: Hacer login
        String url = "https://private-f775a-dianasequeiros.apiary-mock.com/login";
        Map<String, String> params = new HashMap<>();
        params.put("user", user);
        params.put("pass", pass);

        JSONObject body = new JSONObject(params);

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.POST, url, body, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        Log.v("response", response.toString());
                        try {
                            callback.onSuccess(response.getInt("id"));
                        } catch (JSONException e) {
                            callback.onFailure(ErrorType.BAD_JSON);
                        }
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("error", error.toString());
                        callback.onFailure(ErrorType.OTHER);
                    }
                });
        downloader.execute(jsonObjectRequest);
    }
}
