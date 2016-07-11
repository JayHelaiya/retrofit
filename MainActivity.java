package com.example.rahul.retrofituserexanple;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

        public static String URL1 = "http://matrubharti.com/mb_au_ws/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getUsers();
    }

    public void getUsers() {

        final ProgressDialog mLoader = new ProgressDialog(MainActivity.this);
        mLoader.setMessage("Loading");
        mLoader.setCancelable(false);
        mLoader.show();

/*

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.HEADERS);
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder client = new OkHttpClient.Builder();
        client.readTimeout(10000, TimeUnit.MILLISECONDS);
        client.addInterceptor(logging);

        OkHttpClient okHttpClient= client.build();
*/

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL1)
                .addConverterFactory(GsonConverterFactory.create())
                //.client(okHttpClient)
                .build();

        Api api = retrofit.create(Api.class);

        Call<Books> call = api.getBooks("1");
        call.enqueue(new Callback<Books>() {
            @Override
            public void onResponse(Call<Books> call, Response<Books> response) {
                if(mLoader.isShowing()) mLoader.dismiss();

                if(response.isSuccessful()) {
                    Log.e("HELLOOOOOOO ", response.body().toString());
                    Log.e("HELLOOOOOOO ", response.body().getMessage());
                    Log.e("HELLOOOOOOO ", response.body().getData().get(0).getEbook_title_eng());
                } else {
                    Toast.makeText(getApplicationContext(),"ERROR",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Books> call, Throwable t) {
                if(mLoader.isShowing()) mLoader.dismiss();
                Log.e("HELLOOOOO", t.toString());
                t.printStackTrace();
            }
        });

    }
}
