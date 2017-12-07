package com.example.shabuorder.model;

/**
 * Created by Dell on 1/12/2560.
 */

public class Foods {

    public final int id;
    public final String foodsImage;
    public final String foodsName;
    public final String foodsPrice;
    public final String foodsAmount;

    public Foods(int id,String foodsImage,String foodsName,String foodsPrice,String foodsAmount){
        this.id = id;
        this.foodsImage = foodsImage;
        this.foodsAmount = foodsAmount;
        this.foodsName = foodsName;
        this.foodsPrice = foodsPrice;
    }
}
