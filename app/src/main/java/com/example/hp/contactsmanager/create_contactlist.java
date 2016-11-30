package com.example.hp.contactsmanager;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by HP on 06-08-2016.
 */
public class create_contactlist extends AppCompatActivity {
    Button b1, b2;
    EditText e1, e2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_contactlist);


        e1 = (EditText) findViewById(R.id.editText1);
        e2 = (EditText) findViewById(R.id.editText2);

        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent ishowdata = new Intent(create_contactlist.this, show_data.class);
                startActivity(ishowdata);
            }
        });

        b1 = (Button) findViewById(R.id.button1);
        b1.setOnClickListener(new View.OnClickListener() {


            public void onClick(View arg0) {
                String name, phone;
                name = e1.getText().toString();
                phone = e2.getText().toString();

                // TODO Auto-generated method stub
                SQLiteDatabase obj = openOrCreateDatabase("db1", MODE_PRIVATE, null);
                obj.execSQL("Create table if not exists contact(uname varchar(100),ucontact varchar(22));");
                obj.execSQL("insert into contact values('" + name + "','" + phone + "');");
                obj.close();

                Toast.makeText(getApplicationContext(), "DATA SaVED", Toast.LENGTH_LONG).show();
                e1.setText("");
                e2.setText("");
                e1.requestFocus();
                Intent icontact = new Intent(create_contactlist.this, show_data.class);
                startActivity(icontact);
            }
        });
        b2 = (Button) findViewById(R.id.button2);
        b2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                Intent ic = new Intent(create_contactlist.this, menu_contactlist.class);
                startActivity(ic);
            }
        });

    }
}