package com.example.asus.easywallet;


import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.example.asus.easywallet.adapter.ListAdapter;
import com.example.asus.easywallet.db.DbHelper;
import com.example.asus.easywallet.model.MoneyItem;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity  {

    Button mIncome_button;
    Button mChange_button;

    private final Random mRandom = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mIncome_button = (Button) findViewById(R.id.income_button);
        mChange_button = (Button) findViewById(R.id.change_button);


        mIncome_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.activity_income);
                Intent intent = new Intent(MainActivity.this, income.class);//(context.คลาสปลายทางที่จะรัน)
                startActivity(intent);
            }
        });

        mChange_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.activity_change);
                Intent intent = new Intent(MainActivity.this, Change.class);//(context.คลาสปลายทางที่จะรัน)
                startActivity(intent);
            }
        });


//----------------------------------------------------------------------------------------


         DbHelper mHelper;
         SQLiteDatabase mDb;

         ArrayList<MoneyItem> mMoneyItemList = new ArrayList<>();
         ListAdapter mAdapter;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mHelper = new DbHelper(this);
        mDb = mHelper.getReadableDatabase();

        loadDataFromDb();

        mAdapter = new ListAdapter(
                this,
                R.layout.activity_money_item,
                mMoneyItemList
        );

        ListView lv = (ListView) findViewById(R.id.list_view);
        lv.setAdapter(mAdapter);


    }

    private void loadDataFromDb() {
        Cursor cursor = mDb.query(
                DbHelper.TABLE_NAME,
                null,
                null,
                null,
                null,
                null,
                null
        );



    }

}



