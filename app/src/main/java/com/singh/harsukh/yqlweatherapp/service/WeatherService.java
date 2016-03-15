package com.singh.harsukh.yqlweatherapp.service;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.google.gson.Gson;
import com.singh.harsukh.yqlweatherapp.data.Condition;
import com.singh.harsukh.yqlweatherapp.data.QueryResult;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by harsukh on 3/13/16.
 */
public class WeatherService extends IntentService {

    public WeatherService() {
        super("name");
    }


    @Override
    protected void onHandleIntent(Intent intent) {
        //do rest service request here
        ServiceGenerator.WeatherClient service = ServiceGenerator.createService(ServiceGenerator.WeatherClient.class);
        final Gson gson = new Gson();
        Call<QueryResult> call = service.getQuery("select%20wind%2C%20atmosphere%2C%20astronomy%2C%20item%2C%20description%20from%20weather.forecast%20where%20location="+zip, "json");
        call.enqueue(new Callback<QueryResult>() {
            @Override
            public void onResponse(Call<QueryResult> call, Response<QueryResult> response) {
                int status_code = response.code();
                Log.e("WeatherService", "" + status_code);
                QueryResult result = response.body(); //have this class implement parcelable so it can be passed to other objects
            }

            @Override
            public void onFailure(Call<QueryResult> call, Throwable t) {
                Log.e("WeatherService", "failure in response");
            }
        });
    }

    private String zip;
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e("WeatherService","Service Started");
        zip = intent.getStringExtra("zip"); //retrieve stuff intent passed
        return super.onStartCommand(intent, flags, startId);
    }

    public static Intent getIntent(Context context)
    {
        return new Intent(context, WeatherService.class);
    }

}
