package com.example.employeezy.adiprojectone;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collection;

public class BlankList extends AppCompatActivity {

    Button listNameButton;
    Button listAddButton;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blank_list);

        listNameButton = (Button) findViewById(R.id.saveListButton);
        listAddButton = (Button) findViewById(R.id.addToList);

        //pulls information from input fields from blank_list.xml
        final EditText iListName = (EditText) findViewById(R.id.listName);
        final EditText iListInput = (EditText) findViewById(R.id.listInput);

        ListView iListItems = (ListView) findViewById(R.id.listItems);

        final ArrayList itemsInTheArray = new ArrayList<String>();
        final ArrayAdapter blankListAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, itemsInTheArray);
        iListItems.setAdapter(blankListAdapter);

        //Takes a List Name
        View.OnClickListener blankListNameClickListener = new View.OnClickListener() {
            public void onClick(View v) {
                savedInstanceState.getStringArrayList(itemsInTheArray.addAll( ));
            }
        };

        //Takes a list input puts it in the array
        View.OnClickListener blankListInputClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               //System.out.println("Guacamolly");
                itemsInTheArray.add(iListInput.getText().toString());
                iListInput.setText("");
                blankListAdapter.notifyDataSetChanged();
            }
        };

        listNameButton.setOnClickListener(blankListNameClickListener);
        listAddButton.setOnClickListener(blankListInputClickListener);
    }
}
