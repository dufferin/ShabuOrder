package com.example.shabuorder;
import com.example.shabuorder.model.Foods;
import java.util.ArrayList;

/**
 * Created by Dell on 1/12/2560.
 */

public class FoodData {
    private static FoodData sInstance;

    public ArrayList<Foods> foodsList;
    public static FoodData getsInstance(){
        if(sInstance == null){
            sInstance = new FoodData();
        }

        return  sInstance;
    }
}
