package com.example.dalellegamlek_admin.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.example.dalellegamlek_admin.R;

import java.security.Provider;

public class Providers extends AppCompatActivity {
Button newprovider,deleteprovider,chargepoint;
Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_providers);
        toolbar = (Toolbar) findViewById(R.id.app_bar);

        this.setTitle("");
        toolbar.setNavigationIcon(R.drawable.ic_keyboard_arrow_left_black_24dp);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
                    }
                }
        );
        newprovider=findViewById(R.id.add_new_provider);
        deleteprovider=findViewById(R.id.delete_provider);
        chargepoint=findViewById(R.id.charge_point);
        newprovider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Providers.this,New_provider.class));
            }
        });
        chargepoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Providers.this,Charge_point.class));
            }
        });
        deleteprovider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Providers.this,Delete_porvider.class));
            }
        });
    }
}
