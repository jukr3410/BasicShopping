package com.daydev.shoppinglist.ui.shoppinglist

import androidx.lifecycle.ViewModel
import com.daydev.shoppinglist.data.db.entities.ShoppingItem
import com.daydev.shoppinglist.data.repository.ShoppingRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class ShoppingViewModel(private val repository: ShoppingRepository): ViewModel() {

    //call fun that defined in repository.
    //
    fun update(item: ShoppingItem) = CoroutineScope(Dispatchers.Main).launch {
        repository.insert(item)
    }

    fun delete(item: ShoppingItem) = CoroutineScope(Dispatchers.Main).launch {
        repository.delete(item)
    }

    fun getAllItem() = repository.getAllItem()
}