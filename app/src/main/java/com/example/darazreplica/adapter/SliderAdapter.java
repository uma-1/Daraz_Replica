package com.example.darazreplica.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.darazreplica.R;
import com.smarteist.autoimageslider.SliderViewAdapter;

public class SliderAdapter extends SliderViewAdapter<SliderAdapter.SliderAdapterVH> {
    private Context context;
    private int count;

    public SliderAdapter(Context context) {
        this.context = context;
    }

    public void setCount(int count) {
        this.count = count;
    }


    @Override
    public SliderAdapterVH onCreateViewHolder(ViewGroup parent) {
       View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_slider_layout,null);
       return new SliderAdapterVH(inflate);
    }

    @Override
    public void onBindViewHolder(SliderAdapterVH viewHolder,final int position) {

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Item" + position, Toast.LENGTH_SHORT).show();
            }
        });

        switch (position){
            case 0:
                Glide.with(viewHolder.itemView).load(R.drawable.dashain).into(viewHolder.imageSlidebackground);
                break;
            case 1:
                Glide.with(viewHolder.itemView).load(R.drawable.sale).into(viewHolder.imageSlidebackground);
                break;
            case 2:
                Glide.with(viewHolder.itemView).load(R.drawable.sales).into(viewHolder.imageSlidebackground);
                break;
            case 3:
                Glide.with(viewHolder.itemView).load(R.drawable.offer).into(viewHolder.imageSlidebackground);
                break;
            default:
                Glide.with(viewHolder.itemView).load(R.drawable.dashain).into(viewHolder.imageSlidebackground);
                break;

        }

    }

    @Override
    public int getCount() {
        return count;
    }

    class SliderAdapterVH extends SliderViewAdapter.ViewHolder{
        View itemView;
        ImageView imageSlidebackground;

        public SliderAdapterVH(View itemView){
            super(itemView);
            imageSlidebackground=itemView.findViewById(R.id.iv_image_slider);
            this.itemView=itemView;
        }

    }

}
