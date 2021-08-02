package com.coolweather.android.util;

import android.text.TextUtils;

import com.coolweather.android.db.City;
import com.coolweather.android.db.County;
import com.coolweather.android.db.Province;
import com.google.gson.JsonArray;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Utility {
    /*
    * 解析处理服务器返回的省级数据
    *
    * */

    public static boolean handleProvinceResponse(String response){
        if(!TextUtils.isEmpty(response)){
            try{
                //JSONArray变成一个个的 JSONObject
                JSONArray allProvinces= new JSONArray(response);
                for (int i=0;i<allProvinces.length();i++){
                    JSONObject proviceObject=allProvinces.getJSONObject(i);
                    Province province=new   Province();
                    province.setProvinceName(proviceObject.getString("name"));
                    province.setProvinceCode(proviceObject.getInt("id"));
                    province.save();
                }
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /*
    * 解析处理服务器返回的市级数据
    * */
    public static boolean handleCityResponse(String response,int provinceId){
        if(!TextUtils.isEmpty(response)){
            try{
                //JSONArray变成一个个的 JSONObject
                JSONArray allCities= new JSONArray(response);
                for (int i=0;i<allCities.length();i++){
                    JSONObject CityObject=allCities.getJSONObject(i);
                    City city=new City();
                    city.setCityName(CityObject.getString("name"));
                    city.setCityCode(CityObject.getInt("id"));
                    city.setProvinceId(provinceId);
                    city.save();
                }
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /*
     * 解析处理服务器返回的县级数据
     * */
    public static boolean handleCountyResponse(String response,int cityId){
        if(!TextUtils.isEmpty(response)){
            try{
                //JSONArray变成一个个的 JSONObject
                JSONArray allCounties= new JSONArray(response);
                for (int i=0;i<allCounties.length();i++){
                    JSONObject countyObject=allCounties.getJSONObject(i);
                    County county=new County();
                    county.setCountyName(countyObject.getString("name"));
                    county.setCityId(cityId);
                    county.setWeatherId(countyObject.getString("weather_id"));
                    county.save();
                }
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
