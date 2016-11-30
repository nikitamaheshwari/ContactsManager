package com.example.hp.contactsmanager;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.internal.widget.AdapterViewCompat;
import android.widget.AdapterView.OnItemClickListener;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by HP on 06-08-2016.
 */
public class show_data extends AppCompatActivity {
    int itemposition=-1;
    ListView lst;
    Button b1;
    String phone="",name="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_data);
        lst = (ListView) findViewById(R.id.listView1);
        b1 = (Button) findViewById(R.id.button1);
        nikita();


        lst.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int pos,long id) {
                // TODO Auto-generated method stub
                int i,j,k;

                itemposition=pos;
                String str = (String) lst.getItemAtPosition(itemposition);
                i=str.indexOf("(");
                j=str.indexOf(")");
                name=str.substring(0,i);
                phone=str.substring(i+1, j);
                lst.setSelection(pos);

            }
        });

        b1 = (Button) findViewById(R.id.button1);
        b1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                Intent i = new Intent(show_data.this,create_contactlist.class);
                startActivity(i);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // TODO Auto-generated method stub
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_show, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // TODO Auto-generated method stub
        super.onOptionsItemSelected(item);
        if(item.getItemId()==R.id.item1){
            SQLiteDatabase obj = openOrCreateDatabase("db1", MODE_PRIVATE, null);
            obj.execSQL("Delete from contact where uname='"+name+"' AND ucontact='"+phone+"';");
            obj.close();
            Toast.makeText(getApplicationContext(), "Deleted", Toast.LENGTH_LONG).show();
            nikita();

        }
        if (item.getItemId()==R.id.item2) {


            Intent i = new Intent(show_data.this,updte.class);
            i.putExtra("st1",name);
            i.putExtra("st2", phone);
            startActivity(i);

        }
        return false;
    }

    private void nikita(){
        SQLiteDatabase obj = openOrCreateDatabase("db1",MODE_PRIVATE, null);
        Cursor c = obj.rawQuery("select * from contact;",null);
        int n = c.getCount();
        String names[] = new String[n];
        int i=0;

        for(c.moveToFirst();!c.isAfterLast();c.moveToNext()){
            String name,phone;

            name = c.getString(c.getColumnIndex("uname"));
            phone = c.getString(c.getColumnIndex("ucontact"));

            names[i++] = name+"("+phone+")";
        }

        obj.close();

        ArrayAdapter<String> ad = new ArrayAdapter(show_data.this,
                android.R.layout.simple_list_item_1,android.R.id.text1,names);
        lst.setAdapter(ad);
    }
};



