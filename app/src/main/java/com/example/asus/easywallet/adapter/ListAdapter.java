package com.example.asus.easywallet.adapter;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.asus.easywallet.MainActivity;
import com.example.asus.easywallet.R;
import com.example.asus.easywallet.model.MoneyItem;


import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by ASUS on 12/10/2017.
 */

public class ListAdapter extends ArrayAdapter<MoneyItem>{

    private Context mContext;
    private int mLayoutResId;
    private ArrayList<MoneyItem> mMoneyItemList;

    public ListAdapter(@NonNull Context context, int layoutResId, @NonNull ArrayList<MoneyItem> moneyItemList) {
        super(context, layoutResId, moneyItemList);

        this.mContext = context;
        this.mLayoutResId = layoutResId;
        this.mMoneyItemList = moneyItemList;
    }



    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View itemLayout = inflater.inflate(mLayoutResId, null);

        MoneyItem item = mMoneyItemList.get(position);

        ImageView ImageView = itemLayout.findViewById(R.id.image_view);
        TextView TitleTextView = itemLayout.findViewById(R.id.title_edit_text);
        TextView NumberTextView = itemLayout.findViewById(R.id.detail_edit_text);

        TitleTextView.setText(item.title);
        NumberTextView.setText(item.detail);



        return itemLayout;
    }
}
