package com.example.employeezy.adiprojectone;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button newListButton;
    //Button viewListsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        newListButton = (Button) findViewById(R.id.newList);
        //viewListsButton = (Button) findViewById(R.id.viewLists);


        OnClickListener newListClickListener = new OnClickListener() {
            public void onClick(View v) {
                Intent listAdd = new Intent(MainActivity.this, BlankList.class);
                startActivity(listAdd);
            }
        };

//
       newListButton.setOnClickListener(newListClickListener);
//        viewListsButton.setOnClickListener(viewListsClickListener);

    }
}

