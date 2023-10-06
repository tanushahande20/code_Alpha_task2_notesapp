package com.example.notes_app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Rd_adapter extends RecyclerView.Adapter<Rd_adapter.MyViewHolder> {
    Context context;
    AdapterListener listener ;
    List<PojoOne> arrayList;

    public Rd_adapter(Context context, AdapterListener listener) {
        this.context = context;
        this.listener = listener;
        arrayList = new ArrayList<>();
    }
    public void addUser(PojoOne pojo){
        arrayList.add(pojo);
        notifyDataSetChanged();
    }
public void clearData( ){
        arrayList.clear();
        notifyDataSetChanged();
}
public void removeUser(int position)
{
    arrayList.remove(position);
    notifyDataSetChanged();
}
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.rd_singlerow,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
        int newPos = position;

        if(arrayList.get(position).getName()!=null && arrayList.get(position).getEmail()!=null){
            holder.name.setText(arrayList.get(position).getName().toString());
            holder.email.setText(arrayList.get(position).getEmail().toString());

            holder.edit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.OnUpdate(arrayList.get(position));
                }
            });

            holder.delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.OnDelete(arrayList.get(position).getId(),position);
                }
            });
        }



    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name , email;
        ImageView edit , delete;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.text8);
            email = itemView.findViewById(R.id.text9);
            edit = itemView.findViewById(R.id.icon1);
            delete = itemView.findViewById(R.id.icon2);
        }
    }
}
