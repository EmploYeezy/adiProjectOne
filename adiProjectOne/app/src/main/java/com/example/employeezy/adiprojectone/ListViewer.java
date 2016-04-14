package com.example.employeezy.adiprojectone;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ListViewer extends AppCompatActivity {

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_viewer);

        ListView finalListView = (ListView) findViewById(R.id.listViewer);
//        ArrayList<String> arrayOfArrays = new ArrayList<>();
//        ArrayAdapter<String> arrayListAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arrayOfArrays);
//        finalListView.setAdapter(arrayListAdapter);


        ArrayList<String> arrayOfArrays = new ArrayList<>();
        ArrayAdapter<String> arrayListAdadpter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, arrayOfArrays);
        finalListView.setAdapter(arrayListAdadpter);

        ArrayList<String> stuffFromBlank = new ArrayList<>();


        Intent intent = getIntent();
        intent.getStringArrayListExtra("stuffInTheArray");
        arrayOfArrays.toArray();

//
//
//
// ArrayList itemsInList = new ArrayList<>();
//        final ArrayAdapter listViewerAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, itemsInList);
//        listView.setAdapter(listViewerAdapter);
//        itemsInList.add(stuffFromBlank.toString());





//    public static void dataStays(){
//
//        ListView.OnClickListener
//
//                int dataStays = 5;
//

    }
}

