package com.example.employeezy.adiprojectone;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class ListViewer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_viewer);

        Intent infoFromBlankList = getIntent();
        infoFromBlankList.getExtras(infoFromBlankList);

        int myImportantData = infoFromBlankList.getIntExtra("moreInfo", 0);
        ArrayList arrayOfArrays = new ArrayList<String>();
        ArrayAdapter arrayListAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayOfArrays);
        listOfLists.setAdapter(arrayListAdapter);

        arrayOfArrays.add(myImportantData);
    }
}
