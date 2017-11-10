package com.devforbest.movieapp.network;

import com.devforbest.movieapp.BuildConfig;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class ApiPro {


    private static final ApiPro ourInstance = new ApiPro();

    private ApiPro() {
    }

    static ApiPro getInstance() {
        return ourInstance;
    }

    /***
     * This method return a instance of Retrofit object with basich auth
     *
     * @param serviceClass the diferent servers with his own methods and paths
     */

    public static <S> S createService(Class<S> serviceClass) {
        //   int cacheSize = 10 * 1024 * 1024; // 10 MB
        //  Cache cache = new Cache(Environment.getDownloadCacheDirectory(), cacheSize);
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
//                .cache(cache);
        Retrofit.Builder builder =
                new Retrofit.Builder()
                        .baseUrl(BuildConfig.API_URL)
                        .addConverterFactory(GsonConverterFactory.create());
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        httpClient.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request original = chain.request();
                Request.Builder requestBuilder = original.newBuilder()
                        .header("Accept", "application/json")
                        .method(original.method(), original.body());

                Request request = requestBuilder.build();
                return chain.proceed(request);
            }
        })
                .addInterceptor(loggingInterceptor);


        OkHttpClient client = httpClient.build();
        Retrofit retrofit = builder.client(client).build();
        return retrofit.create(serviceClass);
    }


}
