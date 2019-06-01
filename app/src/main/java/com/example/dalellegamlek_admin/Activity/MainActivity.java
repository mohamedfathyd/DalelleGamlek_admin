package com.example.dalellegamlek_admin.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.dalellegamlek_admin.R;

public class MainActivity extends AppCompatActivity {
  Button addannonce,deleteannonce,addcategory,deletecategory;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Initializer();
        addcategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Add_category.class));
            }
        });
        deletecategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Delete_category.class));
            }
        });
        addannonce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Add_annonce.class));
            }
        });
        deleteannonce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Delete_annonce.class));
            }
        });
    }
    public void Initializer(){
        addannonce=findViewById(R.id.add_annonce);
        addcategory=findViewById(R.id.add_category);
        deleteannonce=findViewById(R.id.delete_annonce);
        deletecategory=findViewById(R.id.delete_category);
    }
}
