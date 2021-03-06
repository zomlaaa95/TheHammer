package com.example.kiki.thehammer.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kiki.thehammer.R;
import com.example.kiki.thehammer.activities.ItemActivity;
import com.example.kiki.thehammer.helpers.ImageHelper;
import com.example.kiki.thehammer.model.Item;

import java.util.List;

/**
 * Created by Kiki on 29-Dec-17.
 */

public class ItemsAdapter extends RecyclerView.Adapter<ItemsAdapter.ViewHolder> {

    private Context context;
    private List<Item> items;

    public ItemsAdapter(Context context, List<Item> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_item_item,parent,false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.item = items.get(position);
        ImageHelper.loadImage(holder.item.getPicture(), context, holder.image, 0);
        holder.name.setText(holder.item.getName());
        if(holder.item.getDescription().length() > 32) holder.description.setText(holder.item.getDescription().substring(0, 30) + "...");
        else holder.description.setText(holder.item.getDescription());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private Item item;
        private ImageView image;
        private TextView name;
        private TextView description;

        public ViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            name = itemView.findViewById(R.id.name);
            description = itemView.findViewById(R.id.description);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, ItemActivity.class);
                    intent.putExtra("id", item.getId());
                    intent.putExtra("name", item.getName());
                    intent.putExtra("description", item.getDescription());
                    intent.putExtra("image", item.getPicture());
                    context.startActivity(intent);
                }
            });
        }
    }
}
