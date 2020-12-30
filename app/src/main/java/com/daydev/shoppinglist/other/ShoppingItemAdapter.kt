package com.daydev.shoppinglist.other


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.daydev.shoppinglist.R
import com.daydev.shoppinglist.data.db.entities.ShoppingItem
import com.daydev.shoppinglist.ui.shoppinglist.ShoppingViewModel


class ShoppingItemAdapter (var items: List<ShoppingItem>,private val viewModel: ShoppingViewModel): RecyclerView.Adapter<ShoppingItemAdapter.ShoppingViewHolder>(){

    inner class ShoppingViewHolder (itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.shopping_item, parent, false)
        return ShoppingViewHolder(view)
    }

    override fun onBindViewHolder(holder: ShoppingViewHolder, position: Int) {
        val currentItem = items[position]

        holder.itemView.findViewById<TextView>(R.id.text_name).text = currentItem.name
        holder.itemView.findViewById<TextView>(R.id.text_amount).text = "${currentItem.amount}"

        holder.itemView.findViewById<ImageView>(R.id.delete_item).setOnClickListener{
            viewModel.delete(currentItem)
        }

        holder.itemView.findViewById<ImageView>(R.id.plus_item).setOnClickListener{
            currentItem.amount++
            viewModel.update(currentItem)
        }

        holder.itemView.findViewById<ImageView>(R.id.minus_item).setOnClickListener{
            if(currentItem.amount>0){
                currentItem.amount--
                viewModel.update(currentItem)
            }
        }

    }

    override fun getItemCount(): Int {
        return items.size
    }


}