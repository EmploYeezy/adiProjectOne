package com.example.employeezy.adiprojectone;

//The order of these imports in no way infers their importance to this application.
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

public class BlankList extends AppCompatActivity {

    //Instantiation
    Button listAddButton;
    ArrayList itemsInTheArray;
    EditText iListInput;
    ArrayAdapter blankListAdapter;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blank_list);

        listAddButton = (Button) findViewById(R.id.addToList);

        iListInput = (EditText) findViewById(R.id.listInput);

        ListView iListItems = (ListView) findViewById(R.id.listItems);

        itemsInTheArray = new ArrayList<>();

        blankListAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, itemsInTheArray);

        iListItems.setAdapter(blankListAdapter);

        //Creating Toast "Mamba Out"
        Context context = getApplicationContext();
        CharSequence text = "Mamba. Out.";
        int duration = Toast.LENGTH_SHORT;
        final Toast toast = Toast.makeText(context, text, duration);

        //Takes an input from the user and puts it in the array
        View.OnClickListener blankListInputClickListener = new View.OnClickListener() {
            public void onClick(View v) {
                itemsInTheArray.add(iListInput.getText().toString());
                iListInput.setText("");
                blankListAdapter.notifyDataSetChanged();
            }
        };

        //Opens a blank array with the name of the list from the user. Send it to ListViewer
        iListItems.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), ListViewer.class);
                String title = ((TextView) view).getText().toString();
                //intent.putExtra("position", position); <--- would have pulled number of the index number of the array
                intent.putExtra("title", title);
                startActivity(intent);
            }
        });

        //Long click to delete items from the array. Also adds a super clever Mamba Out toast
        iListItems.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                itemsInTheArray.remove(position);
                blankListAdapter.notifyDataSetChanged();
                toast.show();
                return false;
            }
        });

        listAddButton.setOnClickListener(blankListInputClickListener);
    }
}
