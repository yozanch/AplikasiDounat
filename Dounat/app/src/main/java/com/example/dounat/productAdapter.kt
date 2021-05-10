package com.example.dounat

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_product.view.*
import java.security.AccessControlContext

class productAdapter (val context: Context) :
                        RecyclerView.Adapter<productAdapter.viewHolder>(),Filterable {
    var arrayList = ArrayList<product_model>()
    var ProductListFilter = ArrayList<product_model>()

    fun setData(arrayList: ArrayList<product_model>) {
        this.arrayList = arrayList
        this.ProductListFilter = arrayList
        notifyDataSetChanged()
    }


    class viewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


        fun bindItems(model1: product_model) {

            itemView.NamaProduct.text   = model1.nmproduct
            itemView.deskripsi.text     = model1.dsproduct
            itemView.price.text         = model1.priceproduct.toString()
            itemView.imgProduct.setImageResource(model1.picproduct)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val v = LayoutInflater.from(parent.context).
        inflate(R.layout.activity_product,parent,false)
        return productAdapter.viewHolder(v)
    }

    override fun getItemCount(): Int {
       return arrayList.size
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        holder.bindItems(arrayList[position])
        holder.itemView.setOnClickListener() {
            val model = arrayList.get(position)

            var gProduct: String = model.nmproduct
            var gDesc: String = model.dsproduct
            var gPrice: Int = model.priceproduct.toString().toInt()
            var gImg: Int = model.picproduct

            val intent = Intent(context, order_product::class.java)
            intent.putExtra("pProduct", gProduct)
            intent.putExtra("pDesc", gDesc)
            intent.putExtra("pPrice", gPrice)
            intent.putExtra("pImg", gImg)

            context.startActivity(intent)

        }
    }

    override fun getFilter(): Filter {
        return object  : Filter(){
            override fun performFiltering(charSequence : CharSequence?): FilterResults {
                val filterResults = FilterResults()
                if (charSequence == null || charSequence.length <0){
                    filterResults.count = ProductListFilter.size
                    filterResults.values = ProductListFilter
                }else{
                    var searchCh = charSequence.toString().toString()
                    val productSearch = ArrayList<product_model>()
                    for (item in ProductListFilter){
                        if (item.nmproduct.toLowerCase().contains(searchCh)){
                            productSearch.add(item)
                        }
                    }
                    filterResults.count = productSearch.size
                    filterResults.values = productSearch
                }
                return filterResults
            }

            override fun publishResults(p0: CharSequence?, filterResults : FilterResults?) {
                arrayList = filterResults!!.values as ArrayList<product_model>
                notifyDataSetChanged()
            }

        }
    }

}
