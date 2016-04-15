package com.example.employeezy.adiprojectone;

import android.content.Context;
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
import android.widget.Toast;

import java.util.ArrayList;

public class ListViewer extends AppCompatActivity {

    Button addToSubList;
    ArrayAdapter subArrayAdapter;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_viewer);

        addToSubList = (Button) findViewById(R.id.addToSubList);
        ListView subListView = (ListView) findViewById(R.id.subListItems);

        final EditText subListInput = (EditText) findViewById(R.id.subListInput);

        //Pulls the title from Blank list
        Intent intent = getIntent();
        String title1 = intent.getStringExtra("title");
        TextView messageTextView= (TextView) findViewById(R.id.madeIt);
        messageTextView.setText(title1);

        //initiates the array for user input
        final ArrayList theSubArray = new ArrayList<>();
        final ArrayAdapter subListAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, theSubArray);
        subListView.setAdapter(subListAdapter);
        subArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, theSubArray);

        //Creating toast "Mamba Out"
        Context context = getApplicationContext();
        CharSequence text = "Mamba. Out.";
        int duration = Toast.LENGTH_SHORT;
        final Toast toast = Toast.makeText(context, text, duration);

        //Adds stuff to the array from user input on click of And One button.
        View.OnClickListener sublistClickListener = new View.OnClickListener() {
            public void onClick(View v) {
                theSubArray.add(subListInput.getText().toString());
                subListInput.setText("");
                subListAdapter.notifyDataSetChanged();
            }
        };

        //deletes items from the array and displays the Mamba Out toast.
        subListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent,View view, int position, long id) {
                theSubArray.remove(position);
                subListAdapter.notifyDataSetChanged();
                toast.show();
                return false;
            }
        });

        addToSubList.setOnClickListener(sublistClickListener);






    //<<<<<<<----NOTHING TO SEE HERE---->>>>>>> A BUNCH OF RANDOM NOTES AND TESTS

//        A bunch of random notes.
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

