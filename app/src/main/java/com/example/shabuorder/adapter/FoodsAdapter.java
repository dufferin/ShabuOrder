package com.example.shabuorder.adapter;
import com.example.shabuorder.R;

import com.example.shabuorder.db.FoodDB;
import com.example.shabuorder.model.Foods;

import android.content.ContentValues;
import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.widget.ArrayAdapter;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Locale;



/**
 * Created by Dell on 1/12/2560.
 */

public class FoodsAdapter extends ArrayAdapter<Foods> {

    private Context mContext;
    private ArrayList<Foods> mFoodsList;
    private int mLayoutResId;


    public FoodsAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull ArrayList<Foods> objects) {
        super(context, resource, objects);

        this.mContext = context;
        this.mLayoutResId = resource;
        this.mFoodsList = objects;
    }

    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View itemLayout = inflater.inflate(mLayoutResId, null);

        Foods item = mFoodsList.get(position);


        final ImageView FoodImageImageView = itemLayout.findViewById(R.id.image_food);
        final TextView FoodTitleTextView = itemLayout.findViewById(R.id.text_name);
        final TextView FoodPriceTextView = itemLayout.findViewById(R.id.text_price);
        final TextView FoodAmountTextView = itemLayout.findViewById(R.id.text_amount);


        FoodTitleTextView.setText(item.foodsName);
        FoodPriceTextView.setText(item.foodsPrice);
        FoodAmountTextView.setText("0");





        Button bUP = itemLayout.findViewById(R.id.button_up);
        Button bDOWN = itemLayout.findViewById(R.id.button_down);
        bUP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int number = Integer.parseInt(FoodAmountTextView.getText().toString());
                number+=1;
                FoodAmountTextView.setText(String.valueOf(number));
            }
        });
        bDOWN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int number = Integer.parseInt(FoodAmountTextView.getText().toString());
                if(number>0)
                    number-=1;
                FoodAmountTextView.setText(String.valueOf(number));
            }
        });


        String pictureFileName = item.foodsImage;
        AssetManager am = mContext.getAssets();
        try {
            InputStream stream = am.open(pictureFileName);
            Drawable drawable = Drawable.createFromStream(stream, null);
            FoodImageImageView.setImageDrawable(drawable);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return itemLayout;
    }


}
