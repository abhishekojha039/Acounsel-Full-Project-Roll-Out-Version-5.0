package com.edge.examfinder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class myAdapter extends RecyclerView.Adapter<myAdapter.ViewHolder> {
    LayoutInflater inflater;
    List <recycler> stream;
    private myAdapter.OnIteamClickListner mListner;

    public  interface OnIteamClickListner{
        void   onItemClick(int position);
    }
    public  void setOnIteamClickListner(myAdapter.OnIteamClickListner listner)
    {
        mListner=listner;
    }

    public myAdapter(Context ctx,List<recycler> stream)
    {
        this.inflater=LayoutInflater.from(ctx);
        this.stream=stream;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=inflater.inflate(R.layout.custom_math,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.text1.setText(stream.get(position).getStream());
        holder.text2.setText(stream.get(position).getEligibility());
        holder.text3.setText(stream.get(position).getSelection());
       // holder.text4.setText(stream.get(position).getArea());
        holder.text5.setText(stream.get(position).getJob());
        holder.text6.setText(stream.get(position).getPackage1());
        holder.text7.setText(stream.get(position).getExamination());
        holder.text8.setText(stream.get(position).getUrl());
        holder.text9.setText(stream.get(position).getNote());



    }

    @Override
    public int getItemCount() {
        return stream.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView text1,text2,text3,text4,text5,text6,text7,text8,text9;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            text1=itemView.findViewById(R.id.text1);
            text2=itemView.findViewById(R.id.text2);
            text3=itemView.findViewById(R.id.text3);
            text4=itemView.findViewById(R.id.text4);
            text5=itemView.findViewById(R.id.text5);
            text6=itemView.findViewById(R.id.text6);
            text7=itemView.findViewById(R.id.text7);
            text8=itemView.findViewById(R.id.text8);
            text9=itemView.findViewById(R.id.text9);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(mListner!=null)
                    {
                        int position=getAdapterPosition();
                        if(position!=RecyclerView.NO_POSITION)
                        {
                            mListner.onItemClick(position);
                        }
                    }
                }
            });
        }
    }
}
