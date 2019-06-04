package com.example.dalellegamlek_admin.Adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dalellegamlek_admin.R;
import com.example.dalellegamlek_admin.model.Apiclient_home;
import com.example.dalellegamlek_admin.model.apiinterface_home;
import com.example.dalellegamlek_admin.model.content_event;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RecyclerAdapter_pull_event extends RecyclerView.Adapter<RecyclerAdapter_pull_event.MyViewHolder> {
    Typeface myTypeface;
    private Context context;
    List<content_event> contactslist;
     apiinterface_home apiinterface;
    public RecyclerAdapter_pull_event(Context context, List<content_event> contactslist){
        this.contactslist=contactslist;
        this.context=context;


    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_event_pull,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {

       holder.id_sender.setText(contactslist.get(position).getId_sender()+"");
       holder.id_recever.setText(contactslist.get(position).getId_recevier()+"");
       holder.point.setText(contactslist.get(position).getPoint()+"");
       holder.itemView.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

           }
       });
    }
    @Override
    public int getItemCount() {
        return contactslist.size();
    }

public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView id_sender ,id_recever,point;
        ImageView image;

        ImageView delete;
    public MyViewHolder(View itemView) {
        super(itemView);
        id_sender=(TextView)itemView.findViewById(R.id.id);

        id_recever=itemView.findViewById(R.id.idd);
        point=itemView.findViewById(R.id.point);


    }
}
    public void fetchInfo(int id) {

        apiinterface= Apiclient_home.getapiClient().create(apiinterface_home.class);
        Call<ResponseBody> call = null;
        call=apiinterface.delete_first(id);



        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                Toast.makeText(context,"تم المسح",Toast.LENGTH_LONG).show();
                ((Activity)context).finish();
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });



    }
}