package com.daydev.shoppinglist.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.daydev.shoppinglist.data.db.entities.ShoppingItem

@Dao                    //@ for manage room db
interface ShoppingDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)    //@ form insert method and specify that if data already to have then replace it
    suspend fun insert(item: ShoppingItem)   //suspend fun of coroutines that like a threads make fun to asynchronous. it'll don't block main thread

    @Delete
    suspend fun delete(item: ShoppingItem)

    @Query("SELECT * FROM items")
    fun getAllItem(): LiveData<List<ShoppingItem>>
    //Test
}