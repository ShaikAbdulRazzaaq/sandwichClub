package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {
        try {
            JSONObject mainObject = new JSONObject(json);
            JSONObject name = mainObject.getJSONObject("name");
            JSONArray alsoKnowAs = name.getJSONArray("alsoKnownAs");
            JSONArray ingredients = mainObject.getJSONArray("ingredients");

            ArrayList<String> alsoKnowAsList = new ArrayList<>();
            for (int i = 0; i < alsoKnowAs.length(); i++) {
                alsoKnowAsList.add(alsoKnowAs.getString(i));
            }

            ArrayList<String> ingredientsList = new ArrayList<>();
            for (int i = 0; i < ingredients.length(); i++) {
                ingredientsList.add(ingredients.getString(i));
            }

            String mainName = name.getString("mainName");
            String placeOfOrigin = mainObject.getString("placeOfOrigin");
            String description = mainObject.getString("description");
            String image = mainObject.getString("image");

            return new Sandwich(mainName, alsoKnowAsList, placeOfOrigin, description, image, ingredientsList);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}
