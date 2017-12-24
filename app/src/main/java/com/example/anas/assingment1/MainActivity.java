package com.example.anas.assingment1;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.anas.assingment1.adapters.ContactsAdapter;
import com.example.anas.assingment1.models.Contacts;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button callButton;
    private int contact_list;
    ArrayList<Contacts> contactList = new ArrayList<Contacts>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final ListView recyclerView = (ListView) findViewById(R.id.Contact_list);



        for (int i = 1; i < 1000; i++) {
            String gender;
            if (i % 2 == 0) {
                gender = "male";
            } else {
                gender = "female";
            }
            Contacts n = new Contacts(i, "This is name " + i, "0308436777" + i, gender);
            contactList.add(n);
        }

        ContactsAdapter contactsAdapter = new ContactsAdapter(this, contactList);

        recyclerView.setAdapter(contactsAdapter);


    }

    public void call(View view) {
        callButton = (Button) findViewById(R.id.Call);
        TextView textView = (TextView)  ((View) view.getParent()).findViewById(R.id.Phone);
        String number = textView.getText().toString();
        Intent i = new Intent(Intent.ACTION_CALL);
        final String uriString = "tel: " + number;
        i.setData(Uri.parse(uriString));
        if (ActivityCompat.checkSelfPermission(MainActivity.this,
                Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        startActivity(i);
    }
}
