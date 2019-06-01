package com.example.dalellegamlek_admin.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.example.dalellegamlek_admin.R;

public class Tracks extends AppCompatActivity {
Toolbar toolbar;
    Button pull_point,chargepoint;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tracks);
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
        pull_point=findViewById(R.id.pull_point);

        chargepoint=findViewById(R.id.charge_point);
        pull_point.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Tracks.this,Pull_point.class));
            }
        });
        chargepoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Tracks.this,Charge_point_from_provider.class));
            }
        });
    }
}
