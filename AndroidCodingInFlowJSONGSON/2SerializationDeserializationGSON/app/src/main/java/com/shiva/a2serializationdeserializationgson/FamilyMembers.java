package com.shiva.a2serializationdeserializationgson;

import com.google.gson.annotations.SerializedName;

public class FamilyMembers {
    // Here @SerializedName annotation is used to match the variable name in the class and key name in the Json.
    @SerializedName("role")
    String mRole;
    @SerializedName("age")
    int mAge;

    FamilyMembers(String role, int age) {
        mRole = role;
        mAge = age;
    }
}
