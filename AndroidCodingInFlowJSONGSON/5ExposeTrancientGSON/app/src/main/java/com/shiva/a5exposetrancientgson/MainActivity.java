package com.shiva.a5exposetrancientgson;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();

        Person person = new Person("shiva", 28, "shashishiva9@gmail.com", "nutting");
        String json = gson.toJson(person);

        String jsonString = "{\"age\":28,\"email\":\"shashishiva9@gmail.com\",\"name\":\"shiva\",\"password\":\"yes\"}";
        Person person1 = gson.fromJson(jsonString, Person.class);
    }
}
