package com.singh.harsukh.yqlweatherapp.service;

import com.singh.harsukh.yqlweatherapp.data.Astronomy;
import com.singh.harsukh.yqlweatherapp.data.Atmosphere;
import com.singh.harsukh.yqlweatherapp.data.Condition;
import com.singh.harsukh.yqlweatherapp.data.Forecast;
import com.singh.harsukh.yqlweatherapp.data.QueryResult;
import com.singh.harsukh.yqlweatherapp.data.Wind;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by harsukh on 3/12/16.
 */
public class ServiceGenerator {
    public static final String BASE_URL = "http://query.yahooapis.com/v1/public/";
    static OkHttpClient buildLogger()
    {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
        return new OkHttpClient.Builder().addInterceptor(interceptor).build();
    }
    private static Retrofit.Builder builder = new Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create());
    private static Retrofit retrofit = null;
    public static <S> S createService(Class<S> serviceClass) {
        if(retrofit == null) {
            retrofit = builder.client(buildLogger()).build();
        }
        return retrofit.create(serviceClass);
    }
    public interface WeatherClient {
        //https://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20weather.forecast%20where%20location%3D20770&format=json&diagnostics=true&callback=
        @GET("yql")
        Call<QueryResult> getQuery(@Query(value = "q", encoded = true) String query, @Query(value = "format", encoded = true)String form);
    }
}
