package com.example.employeezy.adiprojectone;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class BlankList extends AppCompatActivity {

    Button listAddButton;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blank_list);

        listAddButton = (Button) findViewById(R.id.addToList);

        //pulls information from input fields from blank_list.xml
        //final EditText iListName = (EditText) findViewById(R.id.listName);
        final EditText iListInput = (EditText) findViewById(R.id.listInput);

        ListView iListItems = (ListView) findViewById(R.id.listItems);

        final ArrayList itemsInTheArray = new ArrayList<>();
        itemsInTheArray.add("SuperCool List");
        itemsInTheArray.add("Cool List");
        itemsInTheArray.add("Kinda not Cool List");

        final ArrayAdapter blankListAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, itemsInTheArray);
        iListItems.setAdapter(blankListAdapter);

        //Takes a list input puts it in the array
        View.OnClickListener blankListInputClickListener = new View.OnClickListener() {
            public void onClick(View v) {
                //System.out.println("Guacamolly");
                itemsInTheArray.add(iListInput.getText().toString());
                iListInput.setText("");
                blankListAdapter.notifyDataSetChanged();
            }
        };

        View.OnTouchListener goToListViewerTouchListener = new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Intent listViewer = new Intent(BlankList.this, ListViewer.class);
                listViewer.putStringArrayListExtra("stuffInTheArray", itemsInTheArray);
                startActivity(listViewer);
                return true;
            }
        };

        //listNameButton.setOnClickListener(blankListNameClickListener);
        listAddButton.setOnClickListener(blankListInputClickListener);
        iListItems.setOnTouchListener(goToListViewerTouchListener);
    }
}
