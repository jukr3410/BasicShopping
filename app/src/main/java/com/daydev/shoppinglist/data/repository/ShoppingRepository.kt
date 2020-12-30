package com.daydev.shoppinglist.data.repository

import com.daydev.shoppinglist.data.db.ShoppingDatabase
import com.daydev.shoppinglist.data.db.entities.ShoppingItem

class ShoppingRepository (private val db: ShoppingDatabase){

    suspend fun insert(item: ShoppingItem) = db.getShoppingDao().insert(item)

    suspend fun delete(item: ShoppingItem) = db.getShoppingDao().delete(item)

    fun getAllItem() = db.getShoppingDao().getAllItem()
}