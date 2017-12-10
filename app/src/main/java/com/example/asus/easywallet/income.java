package com.example.asus.easywallet;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.asus.easywallet.db.DbHelper;

public class income extends AppCompatActivity implements View.OnClickListener {

    private EditText mTitleEditText, mDetailEditText;
    private ImageView mImageView;
    private Button mSaveButton;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTitleEditText = (EditText) findViewById(R.id.title_edit_text);
        mDetailEditText = (EditText) findViewById(R.id.detail_edit_text);
        mImageView = (ImageView) findViewById(R.id.image_income);
        mSaveButton = (Button) findViewById(R.id.save_button);

        mSaveButton.setOnClickListener(this);

    }


    private void saveDataToDb() {
        String phoneTitle = mTitleEditText.getText().toString();
        String phoneNumber = mDetailEditText.getText().toString();

        ContentValues cv = new ContentValues();
        cv.put(DbHelper.COL_TITLE, phoneTitle);
        cv.put(DbHelper.COL_DETAIL, phoneNumber);


        DbHelper dbHelper = new DbHelper(this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        long result = db.insert(DbHelper.TABLE_NAME, null, cv);
        if (result == -1) {
        }
    }

    @Override
    public void onClick(View view) {
        saveDataToDb();
    }
}
