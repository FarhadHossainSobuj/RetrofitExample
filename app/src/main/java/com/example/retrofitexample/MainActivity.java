package com.example.retrofitexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ApiServices apiServices = ApiClient.getInstance().create(ApiServices.class);

        apiServices.getData().enqueue(new Callback<Example2>() {
            @Override
            public void onResponse(Call<Example2> call, Response<Example2> response) {

                List<Record> list=response.body().getRecords();

                Log.d("response",""+list.get(0).getName());
            }

            @Override
            public void onFailure(Call<Example2> call, Throwable t) {

            }
        });

    }
}
