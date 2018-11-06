package com.shoedazzle.m.horizontalstaggeredgridview;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder>  {

    ArrayList personName;
    ArrayList personImage;
    Context context;

    public CustomAdapter(Context context, ArrayList personName, ArrayList personImage) {

        this.context = context;
        this.personName = personName;
        this.personImage = personImage;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        // infalte the item Layout
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.rowlayout,viewGroup,false);
        // set the view's size, margins, paddings and layout parameters
        MyViewHolder myViewHolder = new MyViewHolder(v); // pass the view to View Holder
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, final int i) {

        // set the data in items
        myViewHolder.name.setText(""+personName.get(i));
        myViewHolder.image.setImageResource((Integer) personImage.get(i));

        myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // open another activity on item click
                Intent intent = new Intent(context,SecondActivity.class);
                intent.putExtra("image",(Integer) personImage.get(i)); // put image data in Intent
                context.startActivity(intent); // start Intent
            }
        });
    }

    @Override
    public int getItemCount() {
        return personName.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView name;
        ImageView image;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            image = itemView.findViewById(R.id.image);
        }
    }



}
