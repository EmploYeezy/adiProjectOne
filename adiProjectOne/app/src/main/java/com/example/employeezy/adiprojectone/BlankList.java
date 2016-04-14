package com.example.employeezy.adiprojectone;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class BlankList extends AppCompatActivity {

    Button listAddButton;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blank_list);

        listAddButton = (Button) findViewById(R.id.addToList);

        final EditText iListInput = (EditText) findViewById(R.id.listInput);

        ListView iListItems = (ListView) findViewById(R.id.listItems);

        final ArrayList itemsInTheArray = new ArrayList<>();

        final ArrayAdapter blankListAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, itemsInTheArray);
        iListItems.setAdapter(blankListAdapter);

        //Takes a list input puts it in the array
        View.OnClickListener blankListInputClickListener = new View.OnClickListener() {
            public void onClick(View v) {
                //System.out.println("Guacamolly");
                itemsInTheArray.add(iListInput.getText().toString());
                iListInput.setText("");
                blankListAdapter.notifyDataSetChanged();
                ArrayList sublist = new ArrayList<>();
            }
        };

        iListItems.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), ListViewer.class);
                String name = ((TextView) view).getText().toString();
                intent.putExtra("index", position);
                intent.putExtra("name", name);
                startActivity(intent);
            }
        });

        listAddButton.setOnClickListener(blankListInputClickListener);
    }
}
