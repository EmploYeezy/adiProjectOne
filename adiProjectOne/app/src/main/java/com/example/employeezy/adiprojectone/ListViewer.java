package com.example.employeezy.adiprojectone;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class ListViewer extends AppCompatActivity {

    Button addToSubList;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_viewer);

        addToSubList = (Button) findViewById(R.id.addToSubList);
        ListView subListView = (ListView) findViewById(R.id.subListItems);

        final EditText subListInput = (EditText) findViewById(R.id.subListInput);

        final ArrayList theSubArray = new ArrayList<>();

        final ArrayAdapter subListAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, theSubArray);
        subListView.setAdapter(subListAdapter);

        //Takes a list input puts it in the array
        View.OnClickListener sublistClickListener = new View.OnClickListener() {
            public void onClick(View v) {
                //System.out.println("Guacamolly");
                theSubArray.add(subListInput.getText().toString());
                subListInput.setText("");
                subListAdapter.notifyDataSetChanged();
            }
        };

        addToSubList.setOnClickListener(sublistClickListener);

//        ArrayList<String> arrayOfArrays = new ArrayList<>();
//        ArrayAdapter<String> arrayListAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arrayOfArrays);
//        finalListView.setAdapter(arrayListAdapter);

//        Intent intent = getIntent();
//        ArrayList<String> test = intent.getStringArrayListExtra("stuffInTheArray");
//        //arrayOfArrays.add(test);
//
//        ArrayList<ArrayList<String>> arrayOfArrays = new ArrayList<>();
//        ArrayAdapter<String> arrayListAdadpter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,test);
//        finalListView.setAdapter(arrayListAdadpter);
//



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

