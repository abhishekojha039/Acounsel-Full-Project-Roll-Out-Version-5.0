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

public class notification2Adapter extends RecyclerView.Adapter<notification2Adapter.ExampleViewHolder>{

    private Context mContext;
    RequestOptions options;
    private ArrayList<notificationRecycler> mlist;
    private OnIteamClickListner mListner;

    public  interface OnIteamClickListner{
        void   onItemClick(int position);
    }
    public  void setOnIteamClickListner(OnIteamClickListner listner)
    {
        mListner=listner;
    }
    public notification2Adapter(Context context,ArrayList<notificationRecycler> list)
    {
        mContext=context;
        mlist=list;
        // options=new RequestOptions().centerCrop().placeholder(R.drawable.logo_image).error(R.drawable.logo_image);
    }

    @NonNull
    @Override
    public ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(mContext).inflate(R.layout.notification_layout,parent,false);
        return new ExampleViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ExampleViewHolder holder, int position) {
        notificationRecycler currentItem=mlist.get(position);
        String imageurl=currentItem.getImage();
        String text1=currentItem.getTitle();
        String text2=currentItem.getUrl();
        String text3=currentItem.getDescription();
        Picasso.get().load(imageurl).fit().centerInside().into(holder.image);
        // Picasso.get().load(imageurl).centerInside().into(holder.image);
        //  Glide.with(mContext).load(imageurl).apply(options).into(holder.image);
        holder.txt1.setText(text1);
        holder.txt2.setText(text2);
        holder.txt3.setText(text3);

    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }

    public class ExampleViewHolder extends RecyclerView.ViewHolder{
        public ImageView image;
        public TextView txt1,txt2,txt3;
        public ExampleViewHolder(@NonNull View itemView) {
            super(itemView);
            image=itemView.findViewById(R.id.img1);
            txt1=itemView.findViewById(R.id.txt1);
            txt2=itemView.findViewById(R.id.txt2);
            txt3=itemView.findViewById(R.id.txt3);
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