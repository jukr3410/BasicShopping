package com.daydev.shoppinglist.ui.shoppinglist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.daydev.shoppinglist.R
import com.daydev.shoppinglist.data.db.ShoppingDatabase
import com.daydev.shoppinglist.data.db.entities.ShoppingItem
import com.daydev.shoppinglist.data.repository.ShoppingRepository
import com.daydev.shoppinglist.other.ShoppingItemAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ShoppingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping)

        val database = ShoppingDatabase(this)
        val repository = ShoppingRepository(database)
        val factory = ShoppingViewModelFactory(repository)

        val viewModel = ViewModelProvider(this,factory).get(ShoppingViewModel::class.java)

        val adapter = ShoppingItemAdapter(listOf(), viewModel)

        val recycleViewItems = findViewById<RecyclerView>(R.id.recycleView_items)
        val buttonAdd = findViewById<FloatingActionButton>(R.id.button_add)

        recycleViewItems.layoutManager = LinearLayoutManager(this)
        recycleViewItems.adapter = adapter

        viewModel.getAllItem().observe(this, Observer {
            adapter.items =it
            adapter.notifyDataSetChanged()
        })

        buttonAdd.setOnClickListener{
            AddItemDialog(this, object : AddDialogListener{
                override fun onAddButtonClicked(item: ShoppingItem) {
                    viewModel.update(item)
                }

            }).show()
        }

    }
}