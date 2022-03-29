package uk.ac.tees.MAD.W9560777.coviddiary;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class Class_Adapter extends RecyclerView.Adapter<Class_Adapter.ViewHolder> {

    ArrayList<Class_Model> modelClass_ArrayList;
    Context context;

    public Class_Adapter(ArrayList<Class_Model> modelClass_ArrayList, Context context) {
        this.modelClass_ArrayList = modelClass_ArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public Class_Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view1 = LayoutInflater.from(context).inflate(R.layout.items, null, false);
        return new ViewHolder(view1);
    }

    @Override
    public void onBindViewHolder(@NonNull Class_Adapter.ViewHolder holder, int position) {

        holder.view_Card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, View_Web.class);
                intent.putExtra("URL", modelClass_ArrayList.get(position).getUrl());
                context.startActivity(intent);
            }
        });

        holder.s_Time.setText("Published At: " + modelClass_ArrayList.get(position).getPublishedAt());

        holder.s_Author.setText(modelClass_ArrayList.get(position).getAuthor());

        Glide.with(context).load(modelClass_ArrayList.get(position).getUrlToImage()).into(holder.imageView);

        holder.s_Head.setText(modelClass_ArrayList.get(position).getTitle());

        holder.s_Content.setText(modelClass_ArrayList.get(position).getDescription());


    }

    @Override
    public int getItemCount() {
        return modelClass_ArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView s_Head, s_Content;
        CardView view_Card;
        TextView s_Author;
        TextView s_Time;



        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            s_Head = itemView.findViewById(R.id.main_heading);
            s_Author = itemView.findViewById(R.id.author);
            s_Content = itemView.findViewById(R.id.contentPanel);
            s_Time = itemView.findViewById(R.id.time);
            view_Card = itemView.findViewById(R.id.view_Card);
            imageView = itemView.findViewById(R.id.image);
        }
    }
}
