package com.example.shabuorder;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.app.AlertDialog;
import java.util.ArrayList;

import com.example.shabuorder.adapter.FoodsAdapter;
import com.example.shabuorder.db.FoodDB;
import com.example.shabuorder.model.Foods;
public class MainActivity extends AppCompatActivity {

    private Button Order,Bill;
    private FoodDB mHelper;
    private SQLiteDatabase mDb;
    int number = 0;
    private ArrayList<Foods> mFoodItemList = new ArrayList<>();
    private FoodsAdapter mAdapter;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mHelper = new FoodDB(this);
        mDb = mHelper.getReadableDatabase();


        loadDataFromDb();
        mAdapter = new FoodsAdapter(
                this,
                R.layout.item,
                mFoodItemList
        );

        ListView lv = findViewById(R.id.list_view);
        lv.setAdapter(mAdapter);



        Bill = (Button) findViewById(R.id.check);



        Bill.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                ListView lv = findViewById(R.id.list_view);
                int total = 0;
                int sum = 0;
                int status = 1;

                for (int i = 0 ; i<mFoodItemList.size();i++) {
                    TextView im = (TextView) lv.getChildAt(i).findViewById(R.id.image_food);
                    TextView a = (TextView) lv.getChildAt(i).findViewById(R.id.text_amount);
                    TextView p = (TextView) lv.getChildAt(i).findViewById(R.id.text_price);
                    TextView n = (TextView) lv.getChildAt(i).findViewById(R.id.text_name);
                    int x =  Integer.parseInt(a.getText().toString());
                    int y = Integer.parseInt(mAdapter.getItem(i).foodsAmount);

                    if(x>y) {

                        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                        builder.setMessage(n.getText().toString()+" มีเพียง"+ y + "เท่านั้น")
                                .setCancelable(false)
                                .setNegativeButton("OK น๊ะค๊ะ", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int i) {
                                        dialog.cancel();
                                    }
                                });
                        AlertDialog alert = builder.create();
                        alert.show();
                        status = 0 ;

                    }else {
                        int price = Integer.parseInt(p.getText().toString());
                        int amount = Integer.parseInt(a.getText().toString());

                        sum = price * amount;
                        total += sum;

                    }

                }
                if (status == 1){
                    String text = String.valueOf(total);
                    Intent intent = new Intent(MainActivity.this, CheckBillActivity.class);
                    intent.putExtra("total_value", text);
                    startActivity(intent);
                }







              /* AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage("Are you sure to check bill ?")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent intent = new Intent(getApplicationContext(),CheckBillActivity.class);
                                startActivity(intent);
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int i) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alert = builder.create();
                alert.show();
*/


            }
        });



    }



    private void loadDataFromDb() {
        Cursor cursor = mDb.query(
                FoodDB.TABLE_NAME,
                null,
                null,
                null,
                null,
                null,
                null
        );

        mFoodItemList.clear();

        while (cursor.moveToNext()) {
            int id = cursor.getInt(cursor.getColumnIndex(FoodDB.COL_ID));
            String image = cursor.getString(cursor.getColumnIndex(FoodDB.COL_IMAGE));
            String title = cursor.getString(cursor.getColumnIndex(FoodDB.COL_TITLE));
            String price = cursor.getString(cursor.getColumnIndex(FoodDB.COL_PRICE));
            String amount = cursor.getString(cursor.getColumnIndex(FoodDB.COL_AMOUNT));

            Foods item= new Foods(id,image, title, price, amount);
            mFoodItemList.add(item);
        }
    }

    private View getViewByPosition(int pos, ListView listView) {
        final int firstListItemPosition = listView.getFirstVisiblePosition();
        final int lastListItemPosition = firstListItemPosition + listView.getChildCount() - 1;

        if (pos < firstListItemPosition || pos > lastListItemPosition ) {
            return listView.getAdapter().getView(pos, null, listView);
        } else {
            final int childIndex = pos - firstListItemPosition;
            return listView.getChildAt(childIndex);
        }
    }



}
