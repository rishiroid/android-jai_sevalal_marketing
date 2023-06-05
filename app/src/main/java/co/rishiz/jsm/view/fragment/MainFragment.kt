package co.rishiz.jsm.view.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import co.rishiz.jsm.adapter.CategoryAdapter
import co.rishiz.jsm.adapter.ProductAdapter
import co.rishiz.jsm.databinding.FragmentMainBinding
import co.rishiz.jsm.model.ProductModel
import co.rishiz.jsm.model.CategoryModel
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class MainFragment:Fragment() {
    private lateinit var binding:FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding=FragmentMainBinding.inflate(layoutInflater)
        getCategories()
        getProducts()

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    private fun getProducts() {
        val list=ArrayList<ProductModel>()
        Firebase.firestore.collection("products")
            .get().addOnSuccessListener {
                list.clear()
                for(doc in it.documents){
                    val data=doc.toObject(ProductModel::class.java)
                    list.add(data!!)
                }
                binding.productRecyclerView.adapter= ProductAdapter(requireContext(),list)
            }
    }

    private fun getCategories() {
        val list=ArrayList<CategoryModel>()
        binding.categoryRecyclerView.layoutManager=LinearLayoutManager(requireContext())

        Firebase.firestore.collection("categories")
            .get().addOnSuccessListener {
                list.clear()
                for(doc in it.documents){
                    val data=doc.toObject(CategoryModel::class.java)
                    Log.d("Data","cat"+data?.cat)
                    list.add(data!!)
                }
                binding.categoryRecyclerView.adapter= CategoryAdapter(requireContext(),list)
            }

    }

}
