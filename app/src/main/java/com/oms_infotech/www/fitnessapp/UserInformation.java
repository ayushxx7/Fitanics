package com.oms_infotech.www.fitnessapp;

/**
 * Created by Himanshu on 3/21/2017.
 */

public class UserInformation {
    String name;
    String phoneno;
    String weight,heightft,heightin;

    public UserInformation(){}

    public UserInformation(String name, String phoneno,String weight,String heightft,String heightin) {
        this.name = name;
        this.phoneno = phoneno;
        this.weight=weight;
        this.heightft=heightft;
        this.heightin=heightin;


    }
}
