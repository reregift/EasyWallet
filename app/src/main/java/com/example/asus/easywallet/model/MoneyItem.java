package com.example.asus.easywallet.model;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.asus.easywallet.R;

public class MoneyItem {

    public final int id;
    public final String title;
    public final String detail;


    public MoneyItem(int id, String title, String detail) {
        this.id = id;
        this.title = title;
        this.detail = detail;

    }

    @Override
    public String toString() {
        return title;
    }
}


