package com.example.hp.contactsmanager;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by HP on 06-08-2016.
 */
public class menu_contactlist extends AppCompatActivity {
    Button b1,b2,b3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_contactlist);

        b1 = (Button) findViewById(R.id.button1);
        b2=(Button) findViewById(R.id.button2);
        findViewById(R.id.button3).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent i1 = new Intent(menu_contactlist.this,MainActivity.class);
                startActivity(i1);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                Intent is = new Intent(menu_contactlist.this, show_data.class);
                startActivity(is);
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                Intent imenu = new Intent(menu_contactlist.this, create_contactlist.class);
                startActivity(imenu);
            }
        });
    }



}

