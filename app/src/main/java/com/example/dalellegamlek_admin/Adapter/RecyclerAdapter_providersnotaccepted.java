package com.example.dalellegamlek_admin.Adapter;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.dalellegamlek_admin.R;
import com.example.dalellegamlek_admin.model.Apiclient_home;
import com.example.dalellegamlek_admin.model.apiinterface_home;
import com.example.dalellegamlek_admin.model.contact_users;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RecyclerAdapter_providersnotaccepted extends RecyclerView.Adapter<RecyclerAdapter_providersnotaccepted.MyViewHolder> {
    Typeface myTypeface;
    private Context context;
    List<contact_users> contactslist;
     apiinterface_home apiinterface;
    public RecyclerAdapter_providersnotaccepted(Context context, List<contact_users> contactslist){
        this.contactslist=contactslist;
        this.context=context;


    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {


    holder.Name.setText(contactslist.get(position).getName());
    holder.phone.setText(contactslist.get(position).getPhone());
    holder.address.setText(contactslist.get(position).getAddresss());
    holder.id.setText("ID :" + contactslist.get(position).getId());
        Glide.with(context).load(contactslist.get(position).getImage()).error(R.drawable.logoo).into(holder.image);
       holder.itemView.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               new AlertDialog.Builder(context)
                       .setTitle("دللي جمالك")
                       .setMessage("هل تريد قبوله كا مقدم خدمة جديد ؟")
                       .setIcon(android.R.drawable.ic_dialog_alert)
                       .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {

                           public void onClick(DialogInterface dialog, int whichButton) {
                               int id=contactslist.get(position).getId();
                               fetchInfo(id);
                           }})
                       .setNegativeButton(android.R.string.no, null).show();
           }
       });
    }
    @Override
    public int getItemCount() {
        return contactslist.size();
    }

public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView Name ,address,id,phone;
        ImageView image;

        ImageView delete;
    public MyViewHolder(View itemView) {
        super(itemView);
        Name=(TextView)itemView.findViewById(R.id.name);
        image=(ImageView)itemView.findViewById(R.id.image);
        phone=itemView.findViewById(R.id.numtext);
        id=itemView.findViewById(R.id.idtext);
        address=itemView.findViewById(R.id.countrytext);


    }
}
    public void fetchInfo(int id) {

        apiinterface= Apiclient_home.getapiClient().create(apiinterface_home.class);
        Call<ResponseBody> call = null;
        call=apiinterface.accept_provider(id);



        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                Toast.makeText(context,"تم قبوله",Toast.LENGTH_LONG).show();
                ((Activity)context).finish();
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });



    }
}