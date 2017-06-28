package com.example.shobojit.networkingpractise.Json_parsing_jakir_01;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SHOBOJIT on 12/29/2016.
 */

public class Processing  {
    public static List<Food> System (String content){

        try {
            JSONArray array = new JSONArray(content);
            List<Food> foodlist = new ArrayList<>();
            for (int i = 0 ; i<array.length();i++){
                JSONObject jsob =array.getJSONObject(i);
                Food food = new Food();
                food.setName(jsob.getString("name"));
                food.setPrice(jsob.getString("price"));
                food.setDescription(jsob.getString("description"));
                foodlist.add(food);
            }
            return  foodlist;

        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }

    }
}
