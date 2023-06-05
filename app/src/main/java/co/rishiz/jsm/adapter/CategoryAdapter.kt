package co.rishiz.jsm.adapter

//import android.content.Context
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import co.rishiz.jsm.R
import co.rishiz.jsm.databinding.CategoryViewHolderBinding
import co.rishiz.jsm.model.CategoryModel
import com.bumptech.glide.Glide


class CategoryAdapter(var context: Context, private val list:ArrayList<CategoryModel>): RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {
    inner class CategoryViewHolder(view: View):RecyclerView.ViewHolder(view){
        var binding=CategoryViewHolderBinding.bind(view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
      return CategoryViewHolder(LayoutInflater.from(context).inflate(R.layout.category_view_holder,parent,false))
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
       holder.binding.txtTitle.text=list[position].cat
        Glide.with(holder.binding.img.context).load(list[position].img).into(holder.binding.img)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}