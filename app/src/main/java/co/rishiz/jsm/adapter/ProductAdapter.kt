package co.rishiz.jsm.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import co.rishiz.jsm.databinding.ProductViewHolderBinding

import co.rishiz.jsm.model.ProductModel
import com.bumptech.glide.Glide


class ProductAdapter(val context: Context, private val list :ArrayList<ProductModel>):
    RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {
    inner class ProductViewHolder(val binding:ProductViewHolderBinding):RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val binding=ProductViewHolderBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ProductViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val data=list[position]
        Glide.with(context).load(data.productCoverImg).into(holder.binding.img)
        holder.binding.productName.text=data.productName
        holder.binding.mrp.text=data.productMrp
        holder.binding.Sp.text=data.productSp
    }

    override fun getItemCount(): Int {
        return list.size
    }

}