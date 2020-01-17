package com.example.darazreplica.adapter;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.StrictMode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.darazreplica.R;
import com.example.darazreplica.Url.Url;
import com.example.darazreplica.model.Item;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.itemAdapterViewHolder> {

    private Context context;
    private List<Item> itemList;

    public ItemAdapter(Context context, List<Item> itemList) {
        this.context = context;
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public itemAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,null);
        return new itemAdapterViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull itemAdapterViewHolder holder, int position) {

        final Item item=itemList.get(position);
        holder.tvItemName.setText(item.getProductName());
        holder.tvItemPrice.setText("Rs" +item.getPrice());
//        Picasso.get().load(Url.base_url_image+itemList.get(position).getImgName()).into(holder.imgItem);
        final String imgPath = Url.base_url + "uploads/" + item.getImgName();
//        imagePath = imgPath;
        StrictMode();
        try {
            java.net.URL url = new java.net.URL(imgPath);
            holder.imgItem.setImageBitmap(BitmapFactory.decodeStream((InputStream) url.getContent()));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public int getItemCount() {
        return itemList.size();
//        return 0;
    }

    public class itemAdapterViewHolder extends RecyclerView.ViewHolder{

        ImageView imgItem;
        TextView tvItemName,tvItemPrice;

        public itemAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            this.imgItem=itemView.findViewById(R.id.imgItem);
            this.tvItemName=itemView.findViewById(R.id.tvItemName);
            this.tvItemPrice=itemView.findViewById(R.id.tvItemPrice);
        }
    }

    private void StrictMode(){
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
    }

}

