package com.daydev.shoppinglist.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.daydev.shoppinglist.data.db.entities.ShoppingItem

@Database(
    entities = [ShoppingItem::class],
    version = 1
)
abstract class ShoppingDatabase: RoomDatabase() {

    abstract fun getShoppingDao(): ShoppingDao

    // companion object's like static in java
    companion object{
        @Volatile       //not on cache, only on main memory. make sure that value in instance is right
        private var instance: ShoppingDatabase?= null
        private val LOCK = Any()

        //for call when create instance. if instance is null will call synchronized block - no other threats can set instance that time when it execute
        operator fun invoke(context: Context) = instance ?: synchronized(LOCK){
            instance ?: createDatabase(context).also { instance = it }   //for create db and also instance is result of was called method
        }

        private fun createDatabase(context: Context) =
            Room.databaseBuilder(context.applicationContext,
                ShoppingDatabase::class.java, "ShoppingDB.db").build()

    }


}