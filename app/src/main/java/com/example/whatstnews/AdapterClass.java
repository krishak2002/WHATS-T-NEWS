package com.example.whatstnews;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class AdapterClass extends RecyclerView.Adapter<AdapterClass.viewHolder> {
Context context ;
ArrayList<modelclass>modelclassArrayList;

    public AdapterClass(Context context, ArrayList<modelclass> modelclassArrayList) {
        this.context = context;
        this.modelclassArrayList = modelclassArrayList;
    }

    @NonNull

    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_item,null,false);
        return new viewHolder(view);


    }

    @Override
    public void onBindViewHolder(@NonNull  AdapterClass.viewHolder holder, int position) {

     holder.mtime.setText("Publishet At:-"+modelclassArrayList.get(position).getPublishedAt());
        holder.mauthor.setText(modelclassArrayList.get(position).getAuthor());
        holder.mheading.setText(modelclassArrayList.get(position).getTitle());
        holder.mcontent.setText(modelclassArrayList.get(position).getDescription());
        Glide.with(context).load(modelclassArrayList.get(position).getUrlToImage()).into(holder.imageView);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context,webView.class);
                intent.putExtra("url",modelclassArrayList.get(position).getUrl());
                context.startActivity(intent);

            }
        });

    }




    @Override
    public int getItemCount() {
        return modelclassArrayList.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        TextView mheading,mcontent,mauthor,mtime;
        CardView cardView;
        ImageView imageView;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            mheading=itemView.findViewById(R.id.mainheading);
            mcontent=itemView.findViewById(R.id.content);
            mauthor=itemView.findViewById(R.id.author);
            mtime=itemView.findViewById(R.id.time);
            imageView=itemView.findViewById(R.id.imageview);
            cardView=itemView.findViewById(R.id.card);
        }


    }
}
