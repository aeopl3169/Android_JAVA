package com.shiva.a10loghttprequestjson;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    JsonHolderInterface jsonHolderInterface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);

        // To accept/serialize null values in PATCH too.
        Gson gson = new GsonBuilder().serializeNulls().create();

        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .build();

/*
        Request request = new Request.Builder()
                .url("http://www.publicobject.com/helloworld.txt")
                .header("User-Agent", "OkHttp Example")
                .build();
        Response response = client.newCall(request).execute();
        response.body().close();
*/

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create(gson)) // Remove the gson object and try playing the code.
                .client(okHttpClient) //Adding okHpptClient interceptor to view out transactions in log.
                .build();
        jsonHolderInterface = retrofit.create(JsonHolderInterface.class);

        putPostMethod();
    }
    private void putPostMethod(){
        final PostClass postClass = new PostClass(18, null, "This is text");
        Call<PostClass> postClassCall = jsonHolderInterface.putPost(5, postClass);
        postClassCall.enqueue(new Callback<PostClass>() {
            @Override
            public void onResponse(Call<PostClass> call, Response<PostClass> response) {
                if (!response.isSuccessful()) {
                    textView.setText(response.code());
                }
                PostClass postClass1 = response.body();
                String temp = "";
                temp += "Code:" + response.code() + "\n";
                temp += "Id: " + postClass1.getId() + "\n";
                temp += "UserId: " + postClass1.getUserId() + "\n";
                temp += "Title: " + postClass1.getTitl() + "\n";
                temp += "Text: " + postClass1.getText() + "\n\n";

                textView.append(temp);
            }

            @Override
            public void onFailure(Call<PostClass> call, Throwable t) {
                textView.setText("onFailure method: " + t.getLocalizedMessage());
            }
        });
    }
}
