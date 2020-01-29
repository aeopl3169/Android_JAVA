package com.shiva.a6getreadrequestretrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    JsonPlaceHolderApi jsonPlaceHolderApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);
        getPostMethod();
    }

    private void getPostMethod() {
        Call<List<PostGettors>> listCall = jsonPlaceHolderApi.getPost();
        listCall.enqueue(new Callback<List<PostGettors>>() {
            @Override
            public void onResponse(Call<List<PostGettors>> call, Response<List<PostGettors>> response) {
                Log.i("JSON", "Response header: "+response.headers().toString());
                if (!response.isSuccessful()) {
                    textView.setText("Code: " + response.code());
                    return;
                }
                Log.e("JSON response: ", response.toString());
                List<PostGettors> postGettorsList = response.body();
//                textView.setText(postGettorsList.toString()); // try removing this comments and see the o/p
                Log.w("JSON response body: ", postGettorsList.toString());
                for (PostGettors postGettors : postGettorsList) {
                    String content = "";
                    content += "ID: " + postGettors.getId() + "\n";
                    content += "User ID: " + postGettors.getUserId() + "\n";
                    content += "Title: " + postGettors.getTitle() + "\n";
                    content += "Text: " + postGettors.getText() + "\n\n";

                    textView.append(content);
                }
            }

            @Override
            public void onFailure(Call<List<PostGettors>> call, Throwable t) {
                textView.setText("onFailure method called: " + t.getMessage());
            }
        });
    }
}