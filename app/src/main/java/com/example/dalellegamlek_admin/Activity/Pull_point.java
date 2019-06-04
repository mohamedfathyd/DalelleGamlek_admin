package com.example.dalellegamlek_admin.Activity;



import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.dalellegamlek_admin.Adapter.RecyclerAdapter_charge_event;
import com.example.dalellegamlek_admin.Adapter.RecyclerAdapter_deletefirst;
import com.example.dalellegamlek_admin.Adapter.RecyclerAdapter_pull_event;
import com.example.dalellegamlek_admin.Adapter.RecyclerAdapter_users;
import com.example.dalellegamlek_admin.R;
import com.example.dalellegamlek_admin.model.Apiclient_home;
import com.example.dalellegamlek_admin.model.User;
import com.example.dalellegamlek_admin.model.apiinterface_home;
import com.example.dalellegamlek_admin.model.contact_category;
import com.example.dalellegamlek_admin.model.content_event;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Pull_point extends AppCompatActivity {
    Toolbar toolbar;
    ProgressBar progressBar;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerAdapter_pull_event recyclerAdapter_secondry;
    private List<content_event> contactList;
    private apiinterface_home apiinterface;
    int id = 0;
    String name;
    int sec_id;
    Typeface myTypeface;
    Intent intent;
    TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pull_point);
        progressBar = (ProgressBar) findViewById(R.id.progressBar_subject);
        textView = (TextView) findViewById(R.id.toolbar_title);
        progressBar.setVisibility(View.VISIBLE);
        toolbar = (Toolbar) findViewById(R.id.app_bar);
        intent = getIntent();

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

        recyclerView = (RecyclerView) findViewById(R.id.review);
        progressBar = (ProgressBar) findViewById(R.id.progressBar_subject);
        progressBar.setVisibility(View.VISIBLE);
        layoutManager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        fetchInfo();
    }

    public void fetchInfo() {
        apiinterface = Apiclient_home.getapiClient().create(apiinterface_home.class);
        Call<List<content_event>> call = apiinterface.getcontacts_pull();
        call.enqueue(new Callback<List<content_event>>() {
            @Override
            public void onResponse(Call<List<content_event>> call, Response<List<content_event>> response) {
                contactList = response.body();
                progressBar.setVisibility(View.GONE);
                recyclerAdapter_secondry = new RecyclerAdapter_pull_event(Pull_point.this, contactList);
                recyclerView.setAdapter(recyclerAdapter_secondry);


            }

            @Override
            public void onFailure(Call<List<content_event>> call, Throwable t) {

            }
        });
    }
}