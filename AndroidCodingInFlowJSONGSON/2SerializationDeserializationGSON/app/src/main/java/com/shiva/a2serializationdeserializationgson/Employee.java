package com.shiva.a2serializationdeserializationgson;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Employee {
    String name;
    int age;
    String email;
    Adddress address;
    // Here @SerializedName annotation is used to match the variable name in the class and key in the Json.
    @SerializedName("familyMembersList")
    List<FamilyMembers> mFamilyMembersList;

    Employee(String name, int age, String email, Adddress adddress, List<FamilyMembers> familyMembersList) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.address = adddress;
        mFamilyMembersList = familyMembersList;
    }
}

class Adddress {
    @SerializedName("country")
    String mCountry;
    String city;

    Adddress(String country, String city) {
        this.mCountry = country;
        this.city = city;
    }

}