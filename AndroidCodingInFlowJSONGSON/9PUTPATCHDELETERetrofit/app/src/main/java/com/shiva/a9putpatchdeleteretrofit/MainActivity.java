package com.shiva.a9putpatchdeleteretrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

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

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create(gson)) // Remove the gson object and try playing the code.
                .build();
        jsonHolderInterface = retrofit.create(JsonHolderInterface.class);

        putPostMethod();
//        patchPostMethod();
//        deletePostMethod();
    }

    private void putPostMethod() {
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
                temp += "Title: " + postClass1.getTitle() + "\n";
                temp += "Text: " + postClass1.getText() + "\n\n";

                textView.append(temp);
            }

            @Override
            public void onFailure(Call<PostClass> call, Throwable t) {
                textView.setText("onFailure method: " + t.getLocalizedMessage());
            }
        });
    }

    private void patchPostMethod(){
        final PostClass postClass = new PostClass(9, null, "This is text from patch");
        Call<PostClass> postClassCall = jsonHolderInterface.patchPost(6, postClass);
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
                temp += "Title: " + postClass1.getTitle() + "\n";
                temp += "Text: " + postClass1.getText() + "\n\n";

                textView.append(temp);
            }

            @Override
            public void onFailure(Call<PostClass> call, Throwable t) {
                textView.setText("onFailure method: " + t.getLocalizedMessage());
            }
        });
    }
    private void deletePostMethod(){

        Call<Void> voidCall = jsonHolderInterface.deletePost(6);
        voidCall.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                textView.setText("onResponse: " + response.code());
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                textView.setText("onFailure method: " + t.getLocalizedMessage());
            }
        });
    }
}
