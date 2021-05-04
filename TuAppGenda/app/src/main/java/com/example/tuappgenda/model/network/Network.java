package com.example.tuappgenda.model.network;

import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.tuappgenda.model.Callback;
import com.example.tuappgenda.model.ErrorType;
import com.example.tuappgenda.model.entities.Profile;
import com.example.tuappgenda.model.entities.Subject;
import com.example.tuappgenda.model.entities.Teacher;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Network implements INetwork {
    private NetworkDownloader downloader;

    final String url = "https://private-f775a-dianasequeiros.apiary-mock.com";
    final String urlPro = "http://192.168.0.16:8080";

    public Network(NetworkDownloader downloader) {
        this.downloader = downloader;
    }


    @Override
    public void login(String user, String pass, Callback<Profile> callback) {
        String url = this.urlPro+"/login";
        Map<String, String> params = new HashMap<>();
        params.put("user", user);
        params.put("pass", pass);

        StringRequest jsonObjectRequest = new StringRequest
                (Request.Method.POST, url, new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {
                        Log.v("response", response);
                        Gson gson = new GsonBuilder().create();
                        try {
                            Profile profile = gson.fromJson(response, Profile.class);
                            callback.onSuccess(profile);
                        } catch (Exception e) {
                            callback.onFailure(ErrorType.BAD_JSON);
                        }
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("error", error.toString());
                        callback.onFailure(ErrorType.OTHER);
                    }
                }){
            @Override
            public String getBodyContentType() {
                return "application/x-www-form-urlencoded";
            }

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("user", user);
                params.put("pass", pass);
                return params;
            }
        };
        downloader.execute(jsonObjectRequest);
    }

    @Override
    public void getSubjects(int idSession, Callback<ArrayList<Subject>> callback) {
        String url = this.urlPro+"/subject"+"?"+"id="+idSession;

        StringRequest jsonArrayRequest = new StringRequest
                (Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.v("response", response);
                Gson gson = new GsonBuilder().create();
                try {
                    ArrayList<Subject> subjectList = gson.fromJson(response, new TypeToken<List<Subject>>(){}.getType());
                    callback.onSuccess(subjectList);
                } catch (Exception e) {
                    callback.onFailure(ErrorType.BAD_JSON);
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("error", error.toString());
                callback.onFailure(ErrorType.OTHER);
            }
        }) {
            @Override
            public String getBodyContentType() {
                return "application/x-www-form-urlencoded";
            }
        };

        downloader.execute(jsonArrayRequest);
    }

    @Override
    public void getTeachers(int idSession, Callback<ArrayList<Teacher>> callback) {
        String url = this.urlPro+"/teacher"+"?"+"id="+idSession;

        StringRequest jsonArrayRequest = new StringRequest
                (Request.Method.GET, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.v("response", response);
                        Gson gson = new GsonBuilder().create();
                        try {
                            ArrayList<Teacher> teacherList = gson.fromJson(response, new TypeToken<List<Teacher>>(){}.getType());
                            callback.onSuccess(teacherList);
                        } catch (Exception e) {
                            callback.onFailure(ErrorType.BAD_JSON);
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("error", error.toString());
                        callback.onFailure(ErrorType.OTHER);
                    }
                }) {
                    @Override
                    public String getBodyContentType() {
                return "application/x-www-form-urlencoded";
            }
        };
        downloader.execute(jsonArrayRequest);
    }

    @Override
    public void editProfile(int idSession, Profile profileToEdit, Callback<Profile> callback) {
        String url = this.urlPro+"/editProfile";

        StringRequest jsonArrayRequest = new StringRequest
                (Request.Method.POST, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.v("response", response);
                        Gson gson = new GsonBuilder().create();
                        try {
                            Profile profile = gson.fromJson(response, Profile.class);
                            callback.onSuccess(profile);
                        } catch (Exception e) {
                            callback.onFailure(ErrorType.BAD_JSON);
                        }

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("error", error.toString());
                        callback.onFailure(ErrorType.OTHER);
                    }
                }) {
            @Override
            public String getBodyContentType() {
                return "application/x-www-form-urlencoded";
            }

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("id", ""+idSession);
                params.put("name", profileToEdit.getName());
                params.put("surname", profileToEdit.getSurname());
                params.put("email", profileToEdit.getEmail());
                params.put("dni", profileToEdit.getDni());
                params.put("course", profileToEdit.getCourse());
                params.put("year", profileToEdit.getYear());
                return params;
            }
        };

        downloader.execute(jsonArrayRequest);
    }
}
