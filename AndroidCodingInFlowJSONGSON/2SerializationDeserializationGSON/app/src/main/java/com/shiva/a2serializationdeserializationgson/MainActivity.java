package com.shiva.a2serializationdeserializationgson;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Gson gson = new Gson();
        Adddress address = new Adddress("India", "Hyderabad");

        List<FamilyMembers> familyMembersList = new ArrayList<>();
        familyMembersList.add(new FamilyMembers("mother", 51));
        familyMembersList.add(new FamilyMembers("father", 56));

        // Serialization
        Employee employee = new Employee("shiva", 28, "shashishiva9@gmail.com", address, familyMembersList);
        String json = gson.toJson(employee);
        System.out.println("Printing JSON: "+json);

        // Deserialization
        String json2 = "{\"address\":{\"city\":\"Hyderabad\",\"country\":\"India\"},\"age\":28,\"email\":\"shashishiva9@gmail.com\",\"familyMembersList\":[{\"age\":51,\"role\":\"mother\"},{\"age\":56,\"role\":\"father\"}],\"name\":\"shiva\"}";
        Employee employee2 = gson.fromJson(json2, Employee.class);

        String json3 = "[{\"age\":51,\"role\":\"mother\"},{\"age\":56,\"role\":\"father\"}]";
//        FamilyMembers[] familyMembers = gson.fromJson(json3, FamilyMembers[].class);
        Type type = new TypeToken<ArrayList<FamilyMembers>>() {
        }.getType();
        ArrayList<FamilyMembers> familyMembers = gson.fromJson(json3, type);
        Log.w("JSON", String.valueOf(familyMembers));

    }
}