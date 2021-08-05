package com.coolweather.android.gson;

import com.google.gson.annotations.SerializedName;

public class Suggestion {

    @SerializedName("comf")
    public Comf comfort   ;
    @SerializedName("cw")
    public CarWash  carWash ;
    @SerializedName("sport")
    public Sport sport   ;

    public class Comf{
        @SerializedName("txt")
        public String info;
    }
    public class CarWash{
        @SerializedName("txt")
        public String info;
    }public class Sport{
        @SerializedName("txt")
        public String info;
    }
}
