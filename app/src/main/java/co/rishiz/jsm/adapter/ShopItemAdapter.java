package co.rishiz.jsm.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import co.rishiz.jsm.R;

public class ShopItemAdapter extends RecyclerView.Adapter<ShopItemAdapter.ItemHolder> {
    List<ShopItem> data;
    public ShopItemAdapter(List<ShopItem> data){
        this.data=data;
    }
    @NonNull
    @Override
    public ShopItemAdapter.ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View view=layoutInflater.inflate(R.layout.shop_item_holder,parent,false);
        return new ItemHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ShopItemAdapter.ItemHolder holder, int position) {
        holder.img.setImageResource(data.get(position).getImg());
        holder.txt.setText(data.get(position).getName());

    }

    @Override
    public int getItemCount() {
        return 0;
    }
    static class ItemHolder extends RecyclerView.ViewHolder{
     ImageView img;
     TextView txt;
        public ItemHolder(@NonNull View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.img);
            txt=itemView.findViewById(R.id.txt);

        }
    }
}
