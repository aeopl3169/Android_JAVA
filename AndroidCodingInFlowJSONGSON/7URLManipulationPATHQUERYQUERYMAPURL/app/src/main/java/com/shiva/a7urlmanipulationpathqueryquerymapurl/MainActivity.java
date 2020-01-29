package com.shiva.a7urlmanipulationpathqueryquerymapurl;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    JSONPlaceHolderApiInterface jsonPlaceHolderApiInterface;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
//        Gson gson = new Gson();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        jsonPlaceHolderApiInterface = retrofit.create(JSONPlaceHolderApiInterface.class);

//        getCommentsMethod();
//        getCommentsMethod2();
//        getCommentsMethod3();
//        getPostMethod();
//        getPostMethod2();
//        getPostMethod3();
        getPostMehtod4();
    }

    private void getCommentsMethod() {
        Call<List<CommentsGetters>> listCall = jsonPlaceHolderApiInterface.getComments();

        listCall.enqueue(new Callback<List<CommentsGetters>>() {
            @Override
            public void onResponse(Call<List<CommentsGetters>> call, Response<List<CommentsGetters>> response) {
//                textView.setText(response.body().toString());
                if (!response.isSuccessful()) {
                    textView.setText("Code: " + response.code());
                }
                List<CommentsGetters> commentsGettersList = response.body();
                for (CommentsGetters commentsGetters : commentsGettersList) {
                    String temp = "";
                    temp += "Id: " + commentsGetters.getId() + "\n";
                    temp += "PostId: " + commentsGetters.getUserId() + "\n";
                    temp += "name: " + commentsGetters.getName() + "\n";
                    temp += "email: " + commentsGetters.getEmail() + "\n";
                    temp += "txt: " + commentsGetters.getText() + "\n\n";

                    textView.append(temp);
                }
            }

            @Override
            public void onFailure(Call<List<CommentsGetters>> call, Throwable t) {
                textView.setText("onFailure method called: " + t.getMessage());
            }
        });
    }

    private void getCommentsMethod2() {
        Call<List<CommentsGetters>> listCall = jsonPlaceHolderApiInterface.getComments(3);
        listCall.enqueue(new Callback<List<CommentsGetters>>() {
            @Override
            public void onResponse(Call<List<CommentsGetters>> call, Response<List<CommentsGetters>> response) {
//                textView.setText(response.body().toString());
                if (!response.isSuccessful()) {
                    textView.setText("Code: " + response.code());
                }
                List<CommentsGetters> commentsGettersList = response.body();
                for (CommentsGetters commentsGetters : commentsGettersList) {
                    String temp = "";
                    temp += "Id: " + commentsGetters.getId() + "\n";
                    temp += "PostId: " + commentsGetters.getUserId() + "\n";
                    temp += "name: " + commentsGetters.getName() + "\n";
                    temp += "email: " + commentsGetters.getEmail() + "\n";
                    temp += "txt: " + commentsGetters.getText() + "\n\n";

                    textView.append(temp);
                }
            }

            @Override
            public void onFailure(Call<List<CommentsGetters>> call, Throwable t) {
                textView.setText("onFailure method called: " + t.getMessage());
            }
        });
    }

    private void getCommentsMethod3(){
        Call<List<CommentsGetters>> listCall = jsonPlaceHolderApiInterface
                .getComments("posts/3/comments");
        // We can also pass full url below here.
//        Call<List<CommentsGetters>> listCall = jsonPlaceHolderApiInterface
//                .getComments("posts/3/comments");
        listCall.enqueue(new Callback<List<CommentsGetters>>() {
            @Override
            public void onResponse(Call<List<CommentsGetters>> call, Response<List<CommentsGetters>> response) {
//                textView.setText(response.body().toString());
                if (!response.isSuccessful()) {
                    textView.setText("Code: " + response.code());
                }
                List<CommentsGetters> commentsGettersList = response.body();
                for (CommentsGetters commentsGetters : commentsGettersList) {
                    String temp = "";
                    temp += "Id: " + commentsGetters.getId() + "\n";
                    temp += "PostId: " + commentsGetters.getUserId() + "\n";
                    temp += "name: " + commentsGetters.getName() + "\n";
                    temp += "email: " + commentsGetters.getEmail() + "\n";
                    temp += "txt: " + commentsGetters.getText() + "\n\n";

                    textView.append(temp);
                }
            }

            @Override
            public void onFailure(Call<List<CommentsGetters>> call, Throwable t) {
                textView.setText("onFailure method called: " + t.getMessage());
            }
        });
    }

    private void getPostMethod() {
        Call<List<PostsGettors>> listCall = jsonPlaceHolderApiInterface.getPosts();
        listCall.enqueue(new Callback<List<PostsGettors>>() {
            @Override
            public void onResponse(Call<List<PostsGettors>> call, Response<List<PostsGettors>> response) {
                if (!response.isSuccessful()) {
                    textView.setText("Code: " + response.code());
                }
                List<PostsGettors> postsGettorsList = response.body();
                for (PostsGettors postsGettors : postsGettorsList) {
                    String temp = "";
                    temp += "Id: " + postsGettors.getId() + "\n";
                    temp += "UserId: " + postsGettors.getUserId() + "\n";
                    temp += "Title: " + postsGettors.getTitle() + "\n";
                    temp += "Text: " + postsGettors.getText() + "\n\n";

                    textView.append(temp);
                }
            }

            @Override
            public void onFailure(Call<List<PostsGettors>> call, Throwable t) {
                textView.setText("onFailure method called: " + t.getLocalizedMessage());
            }
        });
    }

    private void getPostMethod2() {
        Call<List<PostsGettors>> listCall = jsonPlaceHolderApiInterface.getPosts(1, 2, "id", "desc");
        listCall.enqueue(new Callback<List<PostsGettors>>() {
            @Override
            public void onResponse(Call<List<PostsGettors>> call, Response<List<PostsGettors>> response) {
                if (!response.isSuccessful()) {
                    textView.setText("Code: " + response.code());
                }
                List<PostsGettors> postsGettorsList = response.body();
                for (PostsGettors postsGettors : postsGettorsList) {
                    String temp = "";
                    temp += "Id: " + postsGettors.getId() + "\n";
                    temp += "UserId: " + postsGettors.getUserId() + "\n";
                    temp += "Title: " + postsGettors.getTitle() + "\n";
                    temp += "Text: " + postsGettors.getText() + "\n\n";

                    textView.append(temp);
                }
            }

            @Override
            public void onFailure(Call<List<PostsGettors>> call, Throwable t) {
                textView.setText("onFailure method called: " + t.getLocalizedMessage());
            }
        });
    }

    private void getPostMethod3() {
        Call<List<PostsGettors>> listCall = jsonPlaceHolderApiInterface.getPosts(new Integer[]{1, 5, 4}, null, null);
        listCall.enqueue(new Callback<List<PostsGettors>>() {
            @Override
            public void onResponse(Call<List<PostsGettors>> call, Response<List<PostsGettors>> response) {
                if (!response.isSuccessful()) {
                    textView.setText("Code: " + response.code());
                }
                List<PostsGettors> postsGettorsList = response.body();
                for (PostsGettors postsGettors : postsGettorsList) {
                    String temp = "";
                    temp += "Id: " + postsGettors.getId() + "\n";
                    temp += "UserId: " + postsGettors.getUserId() + "\n";
                    temp += "Title: " + postsGettors.getTitle() + "\n";
                    temp += "Text: " + postsGettors.getText() + "\n\n";

                    textView.append(temp);
                }
            }

            @Override
            public void onFailure(Call<List<PostsGettors>> call, Throwable t) {
                textView.setText("onFailure method called: " + t.getLocalizedMessage());
            }
        });
    }

    private void getPostMehtod4() {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("userId", "1");
//        parameters.put("userId", "3");
        parameters.put("_sort", "id");
        parameters.put("_order", "desc");
        Call<List<PostsGettors>> listCall = jsonPlaceHolderApiInterface.getPosts(parameters);
        listCall.enqueue(new Callback<List<PostsGettors>>() {
            @Override
            public void onResponse(Call<List<PostsGettors>> call, Response<List<PostsGettors>> response) {
                if (!response.isSuccessful()) {
                    textView.setText("Code: " + response.code());
                }
                List<PostsGettors> postsGettorsList = response.body();
                for (PostsGettors postsGettors : postsGettorsList) {
                    String temp = "";
                    temp += "Id: " + postsGettors.getId() + "\n";
                    temp += "UserId: " + postsGettors.getUserId() + "\n";
                    temp += "Title: " + postsGettors.getTitle() + "\n";
                    temp += "Text: " + postsGettors.getText() + "\n\n";

                    textView.append(temp);
                }
            }

            @Override
            public void onFailure(Call<List<PostsGettors>> call, Throwable t) {
                textView.setText("onFailure method called: " + t.getLocalizedMessage());
            }
        });
    }
}