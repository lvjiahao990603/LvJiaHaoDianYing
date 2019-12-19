package com.bw.movie.utils;

import com.bw.movie.app.Api;
import com.bw.movie.app.ApiServer;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitUtils {
    //单例
    private static ApiServer apiServer;
    private Retrofit retrofit;
    private OkHttpClient okHttpClient;

    private RetrofitUtils(){}
    public static ApiServer getApiServer(){
        if (apiServer == null) {
            synchronized (ApiServer.class){
                if (apiServer == null) {
                    apiServer =new RetrofitUtils().getRetrofit();
                }
            }
        }
        return apiServer;
    }


    private ApiServer getRetrofit() {
        ApiServer apiServer = initRetrofit(initOKHttp()).create(ApiServer.class);
        return apiServer;
    }
    public Retrofit initRetrofit(OkHttpClient client){
        retrofit = new Retrofit.Builder()
                .client(client)
                .baseUrl(Api.STUDENT_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }
    public OkHttpClient initOKHttp(){

        okHttpClient = new OkHttpClient().newBuilder()
                .readTimeout(Api.TIME, TimeUnit.SECONDS)
                .connectTimeout(Api.TIME, TimeUnit.SECONDS)
                .writeTimeout(Api.TIME, TimeUnit.SECONDS)
                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .retryOnConnectionFailure(true)
                .build();
        return okHttpClient;
    }
    public <T> T initData(Class<T>  clz){
        return  retrofit.create(clz);
    }
}
