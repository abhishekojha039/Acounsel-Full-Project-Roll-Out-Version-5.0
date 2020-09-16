package com.edge.examfinder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.request.RequestOptions;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class notificationAdapter extends RecyclerView.Adapter<notificationAdapter.ExampleViewHolder>{

    private Context mContext;
    RequestOptions options;
    private ArrayList<mathRecyclerView> mlist;
    private OnIteamClickListner mListner;

    public  interface OnIteamClickListner{
        void   onItemClick(int position);
    }
    public  void setOnIteamClickListner(OnIteamClickListner listner)
    {
        mListner=listner;
    }
    public notificationAdapter(Context context,ArrayList<mathRecyclerView> list)
    {
        mContext=context;
        mlist=list;
        // options=new RequestOptions().centerCrop().placeholder(R.drawable.logo_image).error(R.drawable.logo_image);
    }

    @NonNull
    @Override
    public ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(mContext).inflate(R.layout.notify_layout,parent,false);
        return new ExampleViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ExampleViewHolder holder, int position) {
        mathRecyclerView currentItem=mlist.get(position);
        String imageurl=currentItem.getImage();
        String text=currentItem.getText();
        Picasso.get().load(imageurl).fit().centerInside().into(holder.image);
        // Picasso.get().load(imageurl).centerInside().into(holder.image);
        //  Glide.with(mContext).load(imageurl).apply(options).into(holder.image);
        holder.txt1.setText(text);
    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }

    public class ExampleViewHolder extends RecyclerView.ViewHolder{
        public ImageView image;
        public TextView txt1;
        public ExampleViewHolder(@NonNull View itemView) {
            super(itemView);
            image=itemView.findViewById(R.id.imageMath);
            txt1=itemView.findViewById(R.id.txtMath);
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
