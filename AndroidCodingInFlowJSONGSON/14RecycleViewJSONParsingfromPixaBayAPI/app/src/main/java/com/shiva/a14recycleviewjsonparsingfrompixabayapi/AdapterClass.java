package com.shiva.a14recycleviewjsonparsingfrompixabayapi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AdapterClass extends RecyclerView.Adapter {

    private Context context;
    private ArrayList<SingleItemCartView> singleItemCartViewArrayList;
    public TextView textViewCreator, textViewLikes;
    public ImageView imageView;

    public AdapterClass(Context context, ArrayList<SingleItemCartView> singleItemCartViewArrayList) {
        this.context = context;
        this.singleItemCartViewArrayList = singleItemCartViewArrayList;
    }

    public class AdapterViewHolder extends RecyclerView.ViewHolder {


        public AdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            textViewCreator = itemView.findViewById(R.id.textViewCreator);
            textViewLikes = itemView.findViewById(R.id.textViewLikes);
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.single_item_cartview, parent, false);
        return new AdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        SingleItemCartView singleItemCartView = singleItemCartViewArrayList.get(position);
        String imageUrl = singleItemCartView.getImageUrl();
        String creatorName = singleItemCartView.getCreator();
        int likes = singleItemCartView.getLikes();

        textViewCreator.setText("Name: "+creatorName);
        textViewLikes.setText("Likes: "+likes);
        imageView.setImageResource(Integer.parseInt(imageUrl));
        Picasso.get().load(imageUrl).fit().centerInside().into(imageView);
    }

    /*@Override
    public void onBindViewHolder(AdapterViewHolder holder, int position) {
        SingleItemCartView singleItemCartView = singleItemCartViewArrayList.get(position);
        String imageUrl = singleItemCartView.getImageUrl();
        String creatorName = singleItemCartView.getCreator();
        int likes = singleItemCartView.getLikes();

        holder.textViewCreator.setText("Name: "+creatorName);
        holder.textViewLikes.setText("Likes: "+likes);
        holder.imageView.setImageResource(Integer.parseInt(imageUrl));
    }*/

    @Override
    public int getItemCount() {
        return singleItemCartViewArrayList.size();
    }
}
