package com.example.hp.contactsmanager;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by HP on 06-08-2016.
 */
public class updte extends AppCompatActivity {
    EditText e1,e2;
    Button b1,b2;
    TextView tv;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update);
        tv=(TextView) findViewById(R.id.textView1);

        b1 = (Button) findViewById(R.id.button1);
        b2 = (Button) findViewById(R.id.button2);
        e1 = (EditText) findViewById(R.id.editText1);
        e2 = (EditText) findViewById(R.id.editText2);
        final String d1 = getIntent().getExtras().getString("st1");
        final String d2 = getIntent().getExtras().getString("st2");


        e1.setText("d1");
        e2.setText("d2");

        Toast.makeText(getApplicationContext(), "Updated", Toast.LENGTH_LONG).show();
        b2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                Intent iup = new Intent(updte.this,show_data.class);
                startActivity(iup);

            }



        });
        b1.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub

                String name,phone;
                String nm,phn;
                nm = getIntent().getExtras().getString("st1");
                phn = getIntent().getExtras().getString("st2");

                name=e2.getText().toString();
                phone = e1.getText().toString();
                SQLiteDatabase obj = openOrCreateDatabase("db1", MODE_PRIVATE, null);
                obj.execSQL("update contact SET uname='"+name+"',ucontact = '"+phone+"' WHERE uname='"+nm+"' AND ucontact = '"+phn+"';");
                obj.close();

                Toast.makeText(getApplicationContext(), "Updated", Toast.LENGTH_LONG).show();
                e1.setText("");
                e2.setText("");
                e1.requestFocus();
                Intent iupdt = new Intent(updte.this,show_data.class);
                startActivity(iupdt);


            }
        });
    }

}
