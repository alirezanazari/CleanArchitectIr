package iran.alirezanazari.data.manager.net;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.concurrent.TimeUnit;

import iran.alirezanazari.data.BuildConfig;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiConfig {

    private Retrofit mRetrofit;
    private RestApi  mRestApi ;

    public ApiConfig() {
        this.mRetrofit = new Retrofit.Builder()
                .baseUrl(BuildConfig.apiBaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(new OkHttpClient.Builder().readTimeout(10 , TimeUnit.SECONDS).connectTimeout(16 , TimeUnit.SECONDS).build())
                .build();
        mRestApi = mRetrofit.create(RestApi.class);
    }

    public RestApi getApi(){
        return mRestApi;
    }
}
