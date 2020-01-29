package com.shiva.a8postrequestretrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    JSONHolderInterface jsonHolderInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        jsonHolderInterface = retrofit.create(JSONHolderInterface.class);

        postMethod1();
//        postMehtod2();
//        postMehtod3();
//        postMethod4();
//        postMethod5();    // Doesn't work
    }

    private void postMethod1() {
        PostClass post = new PostClass(23, "New Title1", "New Text1");
        Call<PostClass> postClassCall = jsonHolderInterface.createPost1(post);
        postClassCall.enqueue(new Callback<PostClass>() {
            @Override
            public void onResponse(Call<PostClass> call, Response<PostClass> response) {
                Log.d("JSON","Response: "+response);
                if (!response.isSuccessful()) {
                    textView.setText("Code: " + response.code());
                    return;
                }

                PostClass postClass = response.body();
                Log.d("JSON","Response body: "+postClass);
                String temp = "";
                temp += "Code: " + response.code() + "\n";
                temp += "Id: " + postClass.getId() + "\n";
                temp += "PostId: " + postClass.getUserId() + "\n";
                temp += "nam: " + postClass.getTitle() + "\n";
                temp += "txt: " + postClass.getBody() + "\n\n";

                textView.append(temp);
            }

            @Override
            public void onFailure(Call<PostClass> call, Throwable t) {
                textView.setText("onFailure called: " + t.getMessage());
            }
        });
    }

    private void postMehtod2() {
        Call<PostClass> postClassCall = jsonHolderInterface.createPost2(23, "New Title1", "New Text1");
        postClassCall.enqueue(new Callback<PostClass>() {
            @Override
            public void onResponse(Call<PostClass> call, Response<PostClass> response) {
                if (!response.isSuccessful()) {
                    textView.setText("Code: " + response.code());
                    return;
                }

                PostClass postClass = response.body();
                String temp = "";
                temp += "Code: " + response.code() + "\n";
                temp += "Id: " + postClass.getId() + "\n";
                temp += "PostId: " + postClass.getUserId() + "\n";
                temp += "nam: " + postClass.getTitle() + "\n";
                temp += "txt: " + postClass.getBody() + "\n\n";

                textView.append(temp);
            }

            @Override
            public void onFailure(Call<PostClass> call, Throwable t) {
                textView.setText("onFailure called: " + t.getMessage());
            }
        });
    }

    private void postMehtod3() {
        Map<String, String> fields = new HashMap<>();
        fields.put("userId","25");
        fields.put("title","Title new");
        fields.put("body","This is body.");
        Call<PostClass> postClassCall = jsonHolderInterface.createPost3(fields);
        postClassCall.enqueue(new Callback<PostClass>() {
            @Override
            public void onResponse(Call<PostClass> call, Response<PostClass> response) {
                if (!response.isSuccessful()) {
                    textView.setText("Code: " + response.code());
                    return;
                }

                PostClass postClass = response.body();
                String temp = "";
                temp += "Code: " + response.code() + "\n";
                temp += "Id: " + postClass.getId() + "\n";
                temp += "PostId: " + postClass.getUserId() + "\n";
                temp += "nam: " + postClass.getTitle() + "\n";
                temp += "txt: " + postClass.getBody() + "\n\n";

                textView.append(temp);
            }

            @Override
            public void onFailure(Call<PostClass> call, Throwable t) {
                textView.setText("onFailure called: " + t.getMessage());
            }
        });
    }

    private void postMethod4() {
        Call<List<PostClass>> postClassCall = jsonHolderInterface.createPost4();
        postClassCall.enqueue(new Callback<List<PostClass>>() {
            @Override
            public void onResponse(Call<List<PostClass>> call, Response<List<PostClass>> response) {
                Log.d("JSON","Response: "+response);
                if (!response.isSuccessful()) {
                    textView.setText("Code: " + response.code());
                    Log.w("JSON","Throwable: "+response.code());
                    return;
                }

                List<PostClass> postClassList = response.body();
                Log.d("JSON","Response body: "+postClassList);
                for (PostClass postClass : postClassList) {
                    String temp = "";
//                    temp += "Code: " + response.code() + "\n";
                    temp += "Id: " + postClass.getId() + "\n";
                    temp += "PostId: " + postClass.getUserId() + "\n";
                    temp += "nam: " + postClass.getTitle() + "\n";
                    temp += "txt: " + postClass.getBody() + "\n\n";

                    textView.append(temp);
                }
            }

            @Override
            public void onFailure(Call<List<PostClass>> call, Throwable t) {
                textView.setText("onFailure called: " + t.getMessage());
                Log.e("JSON","Throwable"+t);
            }
        });
    }

    // Doesn't work
    private void postMethod5() {
        Map<String, String> fields = new HashMap<>();
        fields.put("userId","25");
        fields.put("title","Title new");
        fields.put("body","This is body.");
        Call<List<PostClass>> postClassCall = jsonHolderInterface.createPost5(fields);
        postClassCall.enqueue(new Callback<List<PostClass>>() {
            @Override
            public void onResponse(Call<List<PostClass>> call, Response<List<PostClass>> response) {
                if (!response.isSuccessful()) {
                    textView.setText("Code: " + response.code());
                    Log.w("JSON","Throwable: "+response.code());
                    return;
                }

                List<PostClass> postClassList = response.body();
                String temp = "";
                for (PostClass postClass1: postClassList) {
                    temp += "Code: " + response.code() + "\n";
                    temp += "Id: " + postClass1.getId() + "\n";
                    temp += "PostId: " + postClass1.getUserId() + "\n";
                    temp += "nam: " + postClass1.getTitle() + "\n";
                    temp += "txt: " + postClass1.getBody() + "\n\n";

                    textView.append(temp);
                }
            }

            @Override
            public void onFailure(Call<List<PostClass>> call, Throwable t) {
                textView.setText("onFailure called: " + t.getMessage());
                Log.e("JSON","Throwable: "+t);
            }
        });
    }
}
