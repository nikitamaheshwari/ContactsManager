package com.example.hp.contactsmanager;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button b1 ,b2;
    EditText e1,e2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        e1=(EditText) findViewById(R.id.editText1);
        e2=(EditText) findViewById(R.id.editText2);
        b1=(Button) findViewById(R.id.button1);
        b1.setOnClickListener(new A());
        b2 = (Button) findViewById(R.id.button2);
        b2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                if (e1.getText().toString().equals("ni") &&
                        e2.getText().toString().equals("123")) {

                    Toast.makeText(getApplicationContext(), "login successful", Toast.LENGTH_LONG).show();

                    Intent intent = new Intent(MainActivity.this, menu_contactlist.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), "invalid username or p/w", Toast.LENGTH_LONG).show();
                }
            }
        });

    }
    class A implements View.OnClickListener {

        @Override
        public void onClick(View arg0) {
            // TODO Auto-generated method stub
            String uid,pwd;
            uid=e1.getText().toString();
            pwd=e2.getText().toString();
            SQLiteDatabase d1 = openOrCreateDatabase("db", MODE_PRIVATE, null);
            d1.execSQL("Create table if not exists contact(uid varchar(60),pwd varchar(8));");
            d1.execSQL("insert into contact values('"+uid+"','"+pwd+"');");
            d1.close();

            Toast.makeText(MainActivity.this, "Data saved", Toast.LENGTH_LONG).show();
            e1.setText("");
            e2.setText("");
            e1.requestFocus();


        }

    }



}

